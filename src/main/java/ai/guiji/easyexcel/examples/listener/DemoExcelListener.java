package ai.guiji.easyexcel.examples.listener;

import ai.guiji.easyexcel.examples.IdGenerator.SnowflakeIdWorker;
import ai.guiji.easyexcel.examples.dto.PlanImportExeclTemp;
import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import ai.guiji.easyexcel.examples.enums.PlanPhoneStatusEnum;
import ai.guiji.easyexcel.examples.service.PhoneService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.*;

import static ai.guiji.easyexcel.examples.constant.MapConstant.*;

@Slf4j
public class DemoExcelListener extends AnalysisEventListener<PlanImportExeclTemp> {
    private static final int BATCH_COUNT = 5000;

    private StopWatch stopWatch;

    private PhoneService phoneService;

    private ExecutorService executor;

    public DemoExcelListener() {
    }

    public DemoExcelListener(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
        PHONE_MAP_MAP.put("414_17827081833349376", new ConcurrentHashMap<>());
//        this.executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, 500,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
//        EXECUTOR_MAP.put("414_17827081833349376", executor);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
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
        long total = ATOMIC_LONG_MAP.incrementAndGet("414_17827081833349376" + "_batch_num");
        if (total == BATCH_COUNT) {
            String consumeKey = "414_17827081833349376" + "_consume";
            StopWatch stopWatch = STOP_WATCH_MAP.get(consumeKey);
            if (Objects.nonNull(stopWatch)) {
                stopWatch.start("消费导入数据");
            }
        }
        String key = "414_17827081833349376_" + (total / BATCH_COUNT + (total % BATCH_COUNT > 0 ? 1 : 0));
//        log.info("key:{}", key);
        if (Objects.isNull(PHONE_LIST_MAP.get(key))) {
            synchronized (this) {
                if (Objects.isNull(PHONE_LIST_MAP.get(key))) {
                    PHONE_LIST_MAP.put(key, new ArrayList<>(BATCH_COUNT));
                }
            }
        }
        PHONE_LIST_MAP.get(key).add(execlObj);
        if (PHONE_LIST_MAP.get(key).size() >= BATCH_COUNT) {
            phoneService.processPlanPhoneProcBatch(PHONE_LIST_MAP.get(key), "414_17827081833349376", key, "测试", 123);
        }
//        List<PlanCallPhone> list = PHONE_LIST_MAP.get(key);
//        if (CollectionUtils.isNotEmpty(list)) {
//            log.info("list:{}", list);
//        }
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
        phoneData.setPlanId(414);
        phoneData.setPlanSubId(17827081833349376L);
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
        String importKey = "414_17827081833349376";
        STOP_WATCH_MAP.get(importKey).stop();
        long allAnalysed = ATOMIC_LONG_MAP.incrementAndGet(importKey + "_all_analysed");
        log.info("importKey:{}, excel全部解析完成:{}!", importKey, allAnalysed);
        log.info("解析Excel:{}ms", STOP_WATCH_MAP.get(importKey).getTotalTimeMillis());
        STOP_WATCH_MAP.remove(importKey);
        long totalNum = ATOMIC_LONG_MAP.get(importKey + "_batch_num");
        if (totalNum % BATCH_COUNT > 0L) {
            phoneService.processPlanPhoneProcBatch(PHONE_LIST_MAP.get(importKey + "_" + (totalNum / BATCH_COUNT + (totalNum % BATCH_COUNT > 0 ? 1 : 0))), importKey, importKey + "_" + (totalNum / BATCH_COUNT + (totalNum % BATCH_COUNT > 0 ? 1 : 0)), "测试", 123);
        }
//        if (CollectionUtils.isNotEmpty(phoneList)) {
//            phoneService.batchAdd(phoneList);
//            phoneList.clear();
//        }
//        log.info("{}ms", stopWatch.getTotalTimeMillis());
//        log.info("所有数据解析完成！");
    }

    public StopWatch getStopWatch() {
        return stopWatch;
    }

    public void setStopWatch(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }

    public PhoneService getPhoneService() {
        return phoneService;
    }

    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }
}
