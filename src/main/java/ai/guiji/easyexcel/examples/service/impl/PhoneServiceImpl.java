package ai.guiji.easyexcel.examples.service.impl;

import ai.guiji.easyexcel.examples.IdGenerator.SnowflakeIdWorker;
import ai.guiji.easyexcel.examples.constant.FinalValueConstant;
import ai.guiji.easyexcel.examples.dto.PlanFileErrorRecord;
import ai.guiji.easyexcel.examples.dto.PlanImportExeclTemp;
import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import ai.guiji.easyexcel.examples.entity.PlanCallPhoneExample;
import ai.guiji.easyexcel.examples.enums.PlanPhoneStatusEnum;
import ai.guiji.easyexcel.examples.mapper.PlanCallPhoneMapper;
import ai.guiji.easyexcel.examples.service.IPlanCallPhoneBatchService;
import ai.guiji.easyexcel.examples.service.PhoneService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static ai.guiji.easyexcel.examples.constant.MapConstant.*;

/**
 * author: zhouliliang
 * Date: 2019/12/5 18:42
 * Description:
 */
@Slf4j
@Service
public class PhoneServiceImpl implements PhoneService {
    private Pattern phonePattern = Pattern.compile("^(?!11)\\d{11}$");

    @Autowired
    private PlanCallPhoneMapper planCallPhoneMapper;
    @Autowired
    private IPlanCallPhoneBatchService planCallPhoneBatchService;

    @Async
    @Override
    public void processPlanPhoneProcBatch(List<PlanImportExeclTemp> phoneList, String importKey, String key, String planName, Integer fileId) {
        try {

//            StopWatch stopWatch = new StopWatch(key);
//            String taskName = key + "校验号码";
//            stopWatch.start(key + "校验号码");
            Set<String> phoneSet = new HashSet<>(phoneList.size());
            List<PlanCallPhone> list = phoneList.stream()
                    .map(execlTemp -> this.filterPhone(execlTemp))
                    .filter(planCallPhone -> checkPhone(importKey, planCallPhone, planName, fileId, phoneSet))
                    .collect(Collectors.toList());
//            stopWatch.stop();
//            log.info("{}: {}ms", taskName, stopWatch.getTotalTimeMillis());

            if (CollectionUtils.isNotEmpty(list)) {
                Date currentTime = new Date();
                //校验黑名单(数量递减)

                //校验机器人(数量递减)

                list.forEach(callPhone -> callPhone.setAddTime(currentTime));

                //批量入库
//                String taskName = key + "入库";
//                StopWatch stopWatch = new StopWatch(taskName);
//                stopWatch.start(taskName);
                int num = planCallPhoneMapper.addPlanPhoneBatch(list);
//                stopWatch.stop();
//                log.info("{}:{}ms", taskName, stopWatch.getTotalTimeMillis());

                long totalNum = ATOMIC_LONG_MAP.addAndGet(importKey + "_inserted_num", list.size());

                PHONE_LIST_MAP.remove(key);

                if (ATOMIC_LONG_MAP.get(importKey + "_all_analysed") == 0L) {
                    return;
                }

                if (ATOMIC_LONG_MAP.get(importKey + "_plan_num") + ATOMIC_LONG_MAP.get(importKey + "_error_num") < ATOMIC_LONG_MAP.get(importKey + "_batch_num")) {
                    return;
                }

                if (ATOMIC_LONG_MAP.get(importKey + "_inserted_num") < ATOMIC_LONG_MAP.get(importKey + "_plan_num")) {
                    return;
                }

//                if (ATOMIC_LONG_MAP.get(importKey + "_all_analysed") == 1L
//                        && ATOMIC_LONG_MAP.get(importKey + "_plan_num") + ATOMIC_LONG_MAP.get(importKey + "_error_num") == ATOMIC_LONG_MAP.get(importKey + "_batch_num")
//                        && ATOMIC_LONG_MAP.get(importKey + "_inserted_num") == ATOMIC_LONG_MAP.get(importKey + "_plan_num")) {
//
//                }

//                IPlanImportService planImportService = applicationContext.getBean(IPlanImportService.class);
//
//                String[] split = importKey.split("_");
//                planImportService.finishImportPlan(Integer.valueOf(split[0]), Long.valueOf(split[1]));

                //更新批次数量、总数、错误数量、更新批次状态
                long batch_num = ATOMIC_LONG_MAP.get(importKey + "_batch_num");
                long plan_num = ATOMIC_LONG_MAP.get(importKey + "_plan_num");
                long error_num = ATOMIC_LONG_MAP.get(importKey + "_error_num");

                log.info("批次总数量:{},导入任务数量:{},失败数量:{}", batch_num, plan_num, error_num);
                log.info("importKey:{},导入完成!", importKey);

                String consumeKey = "414_17827081833349376" + "_consume";
                if (Objects.nonNull(STOP_WATCH_MAP.get(consumeKey))) {
                    if (STOP_WATCH_MAP.get(consumeKey).isRunning()) {
                        STOP_WATCH_MAP.get(consumeKey).stop();
                        log.info("{}ms", STOP_WATCH_MAP.get(consumeKey).getTotalTimeMillis());
                    }

                }
            }
        } catch (Exception e) {
            log.error("新增号码批量入库异常:", e);
            PHONE_LIST_MAP.put(key, phoneList);
        }
    }

    private boolean checkPhone(String importKey, PlanCallPhone phoneData, String planName, Integer fileId, Set<String> phoneSet) {

        String phone = phoneData.getPhone();
        if (StringUtils.isEmpty(phone)) {
            ATOMIC_LONG_MAP.incrementAndGet(importKey + "_error_num");
//            planFileService.addFileErrorRecord(this.fileFileErrorRecord(phoneData, -1, planName, fileId));
            return false;
        }

//        if (!isNumLegal(phone)) {
//            // 非手机号 导入失败,第 + (r + 1) + "行,电话号码格式不正确
//            ATOMIC_LONG_MAP.incrementAndGet(importKey + "_error_num");
//            planFileService.addFileErrorRecord(this.fileFileErrorRecord(phoneData, 5, planName, fileId));
//            return false;
//        }

        if (PHONE_MAP_MAP.get(importKey).containsKey(phone)) {
            //号码重复
            ATOMIC_LONG_MAP.incrementAndGet(importKey + "_error_num");
//            planFileService.addFileErrorRecord(this.fileFileErrorRecord(phoneData, 3, planName, fileId));
            return false;
        }

        ATOMIC_LONG_MAP.incrementAndGet(importKey + "_plan_num");
        PHONE_MAP_MAP.get(importKey).put(phone, "");

        return true;
    }

    private boolean isNumLegal(String str) {
        // String regExp =
        // "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Matcher m = phonePattern.matcher(str);
        return m.matches();
    }

    private PlanFileErrorRecord fileFileErrorRecord(PlanCallPhone phoneData, Integer errorType, String planName, Integer fileId) {
        PlanFileErrorRecord errorData = new PlanFileErrorRecord();
        errorData.setPlanId(phoneData.getPlanId());
        errorData.setPlanName(planName);
        errorData.setTtsParams(phoneData.getTtsParams());
        errorData.setParams(phoneData.getParams());
        errorData.setCustName(phoneData.getCustName());
        errorData.setCustCompany(phoneData.getCustCompany());
        errorData.setFileRecordsId(fileId);
        errorData.setDataType(0);
        errorData.setCallType(FinalValueConstant.AI_CALL_TYPE);
        errorData.setErrorType(errorType);
        return errorData;
    }

//    @Async
//    @Override
//    public void batchAddAsync(RBlockingDeque<PlanCallPhone> deque) {
//        List<PlanCallPhone> phoneList = new ArrayList<>(10);
//        int size = 0;
//        while (size < 10 && deque.size() > 0) {
//            PlanCallPhone planCallPhone = deque.pollFirst();
//            if (Objects.nonNull(planCallPhone)) {
//                phoneList.add(planCallPhone);
//                size++;
//            }
//        }
//
//        if (CollectionUtils.isNotEmpty(phoneList)) {
//            batchAdd(phoneList);
//        }
//    }

    @Override
    public PageInfo<PlanCallPhone> selectPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(planCallPhoneMapper.selectByExample(new PlanCallPhoneExample()));
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

    @Async
    @Override
    public void importPlanPhoneProcBatch(String importKey, ConcurrentLinkedQueue<PlanCallPhone> importQueue, int batchSize) {
        //一次最多批量插入batchSize条数据
        List<PlanCallPhone> phoneList = new ArrayList<>(batchSize);

        try {
            MutableInt mutableSize = new MutableInt(0);

            Instant startInstant = Instant.now();
            while (mutableSize.intValue() < batchSize && ATOMIC_LONG_MAP.get(importKey + "_all_analysed") == 0L) {
                pollAndAddToList(importKey, importQueue, phoneList, mutableSize);

                Instant endInstant = Instant.now();
                Duration duration = Duration.between(startInstant, endInstant);
                //最多等待10秒
                if (duration.getSeconds() > 10L) {
                    break;
                }
            }

            startInstant = Instant.now();
            while (mutableSize.intValue() < batchSize
                    && ATOMIC_LONG_MAP.get(importKey + "_consume_num") < ATOMIC_LONG_MAP.get(importKey + "_plan_num")) {
                pollAndAddToList(importKey, importQueue, phoneList, mutableSize);

                Instant endInstant = Instant.now();
                Duration duration = Duration.between(startInstant, endInstant);
                //最多等待10秒
                if (duration.getSeconds() > 10L) {
                    break;
                }
            }

            if (CollectionUtils.isNotEmpty(phoneList)) {
                Date currentTime = new Date();
                //校验黑名单(数量递减)

                //校验机器人(数量递减)

                phoneList.forEach(callPhone -> callPhone.setAddTime(currentTime));

                //批量入库
                planCallPhoneBatchService.addPlanPhoneBatch(phoneList, importKey);
            }
        } catch (Exception e) {
            log.error("新增号码批量入库异常:", e);
            phoneList.forEach(callPhone -> {
                IMPORT_QUEUE.get(importKey).offer(callPhone);
                ATOMIC_LONG_MAP.decrementAndGet(importKey + "_consume_num");
            });
        }
    }

    @Async
    @Override
    public void importBatch(String importKey, List<PlanCallPhone> phoneList) {
        try {
            //批量入库
            planCallPhoneBatchService.addPlanPhoneBatch(phoneList, importKey);
        } catch (Exception e) {
            log.error("新增号码批量入库异常:", e);
            phoneList.forEach(callPhone -> {
                IMPORT_QUEUE.get(importKey).offer(callPhone);
            });
        }
    }

    private void pollAndAddToList(String importKey, ConcurrentLinkedQueue<PlanCallPhone> importQueue, List<PlanCallPhone> phoneList, MutableInt mutableSize) {
        PlanCallPhone phoneData = importQueue.poll();
        if (Objects.nonNull(phoneData)) {
            phoneList.add(phoneData);
            if (ATOMIC_LONG_MAP.incrementAndGet(importKey + "_consume_num") == 1L) {
                String consumeKey = importKey + "_consume";
                STOP_WATCH_MAP.putIfAbsent(consumeKey, new StopWatch(consumeKey));
                STOP_WATCH_MAP.get(consumeKey).start("消费号码队列数据");
            }
            mutableSize.add(1);
        }
    }
}
