package ai.guiji.easyexcel.examples.listener;

import ai.guiji.easyexcel.examples.IdGenerator.SnowflakeIdWorker;
import ai.guiji.easyexcel.examples.dto.PlanImportExeclTemp;
import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import ai.guiji.easyexcel.examples.enums.PlanPhoneStatusEnum;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ai.guiji.easyexcel.examples.constant.MapConstant.*;

@Slf4j
public class ImportExcelListener extends AnalysisEventListener<PlanImportExeclTemp> {
    private Integer planId;
    private Long planSubId;
    private String importKey;

    private Pattern phonePattern = Pattern.compile("^(?!11)\\d{11}$");
    private Set<String> phoneSet = new HashSet<>();

    public ImportExcelListener() {
    }

    public ImportExcelListener(Integer planId, Long planSubId) {
        this.planId = planId;
        this.planSubId = planSubId;
        this.importKey = planId + "_" + planSubId;
        IMPORT_QUEUE.put(importKey, new ConcurrentLinkedQueue<>());
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        STOP_WATCH_MAP.get(importKey).start("解析Excel");
        log.info("解析到一条头数据:{}", JSON.toJSONString(headMap));
    }

    /**
     * 每解析一行数据
     *
     * @param execlObj
     * @param context
     */
    @Override
    public void invoke(PlanImportExeclTemp execlObj, AnalysisContext context) {
//        log.info("解析到一条数据:{}", JSON.toJSONString(execlObj));
        long total = ATOMIC_LONG_MAP.incrementAndGet(importKey + "_batch_num");
        PlanCallPhone phoneData = this.filterPhone(execlObj);
        String phone = phoneData.getPhone();
        if (StringUtils.isEmpty(phone)) {
            ATOMIC_LONG_MAP.incrementAndGet(importKey + "_error_num");
//            planFileService.addFileErrorRecord(this.fileFileErrorRecord(phoneData, -1, planName, fileId));
            return;
        }

        if (!isNumLegal(phone)) {
            // 非手机号 导入失败,第 + (r + 1) + "行,电话号码格式不正确
            ATOMIC_LONG_MAP.incrementAndGet(importKey + "_error_num");
//            planFileService.addFileErrorRecord(this.fileFileErrorRecord(phoneData, 5, planName, fileId));
        }

        if (phoneSet.contains(phone)) {
            //号码重复
            ATOMIC_LONG_MAP.incrementAndGet(importKey + "_error_num");
//            planFileService.addFileErrorRecord(this.fileFileErrorRecord(phoneData, 3, planName, fileId));
            return;
        }

        IMPORT_QUEUE.get(importKey).offer(phoneData);
        ATOMIC_LONG_MAP.incrementAndGet(importKey + "_plan_num");
        phoneSet.add(phone);
    }

    private boolean isNumLegal(String str) {
        // String regExp =
        // "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Matcher m = phonePattern.matcher(str);
        return m.matches();
    }

    /**
     * 封装号码数据
     *
     * @param execlObj
     * @return
     */
    private PlanCallPhone filterPhone(PlanImportExeclTemp execlObj) {
        Integer orgId = 120;
        //生成seqId
        Long seqId = SnowflakeIdWorker.nextId(orgId);
        PlanCallPhone phoneData = new PlanCallPhone();
        phoneData.setPlanId(planId);
        phoneData.setPlanSubId(planSubId);
        phoneData.setSeqId(seqId);
        phoneData.setPhone(execlObj.getPhone());
        phoneData.setCustName(execlObj.getCustName());
        phoneData.setCustCompany(execlObj.getCustCompany());
        phoneData.setTtsParams(execlObj.getTtsParams());
        phoneData.setParams(execlObj.getAttach());
        phoneData.setStatusCall(PlanPhoneStatusEnum.WAITING.getStatus());
        phoneData.setStatusFlow(PlanPhoneStatusEnum.WAITING.getStatus());
        phoneData.setUserId(272);
        phoneData.setOrgId(orgId);
        phoneData.setJoinUser(272);
        phoneData.setAddTime(new Date());
        return phoneData;
    }

    /**
     * 解析完所有Excel数据
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        STOP_WATCH_MAP.get(importKey).stop();
        long allAnalysed = ATOMIC_LONG_MAP.incrementAndGet(importKey + "_all_analysed");
        log.info("importKey:{}, excel全部解析完成:{}!", importKey, allAnalysed);
        log.info("解析Excel:{}ms", STOP_WATCH_MAP.get(importKey).getTotalTimeMillis());
        STOP_WATCH_MAP.remove(importKey);

        long batch_num = ATOMIC_LONG_MAP.get(importKey + "_batch_num");
        long plan_num = ATOMIC_LONG_MAP.get(importKey + "_plan_num");
        long error_num = ATOMIC_LONG_MAP.get(importKey + "_error_num");

        log.info("批次总数量:{},导入任务数量:{},失败数量:{}", batch_num, plan_num, error_num);
        log.info("主任务:{},子任务ID:{},导入完成!", planId, planSubId);

        //从Excel解析完开始计时，如果以后Excel解析时间优化了，变得特别快，可以去掉下面计算超时时间duration的代码
        Instant startInstant = Instant.now();

        while (ATOMIC_LONG_MAP.get(importKey + "_inserted_num") < plan_num) {
            Instant endInstant = Instant.now();
            Duration duration = Duration.between(startInstant, endInstant);
            if (duration.getSeconds() > 10L) {
                break;
            }

            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String consumeKey = importKey + "_consume";
        if (Objects.nonNull(STOP_WATCH_MAP.get(consumeKey))) {
            if (STOP_WATCH_MAP.get(consumeKey).isRunning()) {
                STOP_WATCH_MAP.get(consumeKey).stop();
                log.info("消费号码队列数据, {}ms", STOP_WATCH_MAP.get(consumeKey).getTotalTimeMillis());
                STOP_WATCH_MAP.remove(consumeKey);
            }
        }

        ATOMIC_LONG_MAP.remove(importKey + "_batch_num");
        ATOMIC_LONG_MAP.remove(importKey + "_plan_num");
        ATOMIC_LONG_MAP.remove(importKey + "_error_num");
        ATOMIC_LONG_MAP.remove(importKey + "_consume_num");
        ATOMIC_LONG_MAP.remove(importKey + "_inserted_num");
        ATOMIC_LONG_MAP.remove(importKey + "_all_analysed");

        IMPORT_QUEUE.remove(importKey);
    }
}
