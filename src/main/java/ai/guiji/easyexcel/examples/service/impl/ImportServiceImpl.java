package ai.guiji.easyexcel.examples.service.impl;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import ai.guiji.easyexcel.examples.service.ImportService;
import ai.guiji.easyexcel.examples.service.PhoneService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import static ai.guiji.easyexcel.examples.constant.MapConstant.*;

@Slf4j
@Service
public class ImportServiceImpl implements ImportService {

    @Autowired
    private PhoneService phoneService;

    @Override
    public void consumerImportPlan() {
        while (true) {
            int limit = 100;
            Set<String> importKeys = IMPORT_QUEUE_MAP.keySet();
            for (String importKey : importKeys) {
                //        logger.info("导入队列keys:{},importKey:{}", JsonUtils.bean2Json(importKeys), importKey);
                String[] keys = importKey.split("_");
                String planId = keys[0];
                String planSubId = keys[1];
                ConcurrentLinkedQueue<PlanCallPhone> importQueue = IMPORT_QUEUE_MAP.get(importKey);
                if (null != importQueue && !importQueue.isEmpty()) {
                    for (int i = 0; i < limit; i++) {
                        PlanCallPhone phoneData = importQueue.poll();
                        log.info("导入planSubId队列key:{},数据:{}", importKey, JSON.toJSONString(phoneData));
                        if (null != phoneData) {
                            phoneService.importPlanPhoneProc(phoneData, importKey);
                        }
                    }
                } else {
                    /*
                    try {
                        Thread.sleep(10 * 1000);//停10s
                        //再次查看导入队列中是否有数据
                        ConcurrentLinkedQueue<PlanCallPhone> currentImportQueue = planImportQueueService.getImportQueue(planId, planSubId);
                        if(!currentImportQueue.isEmpty()){//如果有数据，则重新回到循环队列
                            continue;
                        }

                        //删除队列
                        QueueConstant.planImportQueue.remove(importKey);

                        //获取任务
                        PlanCallBean planCall = planCallService.queryPlanCallById(Integer.valueOf(planId));

                        //更新批次数量、总数、错误数量、更新批次状态
                        Long batch_num = mapCache.get(importKey + "_batch_num");
                        batch_num = null != batch_num?batch_num:0L;
                        Long plan_num = mapCache.get(importKey + "_plan_num");
                        plan_num = null != plan_num?plan_num:0L;
                        Long error_num = mapCache.get(importKey + "_error_num");
                        error_num = null != error_num?error_num:0L;

                        if(plan_num > 10000){//如果大于10000条，停5s再执行导入完成变更
                            Thread.sleep(5 * 1000);
                        }

                        logger.info("批次总数量:{},导入任务数量:{},失败数量:{}", batch_num, plan_num, error_num);
                        logger.info("主任务:{},子任务ID:{},导入完成!", planId, planSubId);

                        //判断总批次状态
                        //如果总任务处于"未开始"、则不变；如果总任务处于"调度中"、则不变；如果任务处于


                        //更新导入数据
                        boolean bool = planCallService.finishPlanCallImport(planCall.getPlanId(), PlanOpStatusEnum.IMPORT_FINISH.getStatus(),
                                batch_num, batch_num, plan_num, error_num);
                        //如果是文件导入则更新、非文件导入则没有数据更新
                        bool = planFileService.updPlanSubFileRecordCount(Long.valueOf(planSubId), 1, batch_num, plan_num, error_num);
                        if(plan_num > 0L){//导入成功数量大于0，则新增子任务记录
                            planCallPhoneService.updPlanSubRelStatus(Long.valueOf(planSubId), PlanSubStatusEnum.IMPORT_FINISH.getStatus());
                        }else{//没有数据导入、则删除子任务
                            planCallPhoneService.delPlanSubRel(Long.valueOf(planSubId));
                        }

                        mapCache.del(importKey + "_batch_num");
                        mapCache.del(importKey + "_plan_num");
                        mapCache.del(importKey + "_error_num");

                    }catch(Exception ef){
                        logger.error("完成导入执行异常", ef);
                    }
                    */
                }
            }

        }
    }

    @Override
    public void consumerImportPlanBatch() {
        int loopSize = 100000;
        int batchSize = 50;
        while (true) {
            Set<String> importKeys = IMPORT_QUEUE_MAP.keySet();
            if (CollectionUtils.isNotEmpty(importKeys)) {
                for (String importKey : importKeys) {
                    if (ATOMIC_LONG_MAP.get(importKey + "_consume_num") == 0L) {
                        String consumeKey = importKey + "_consume";
                        STOP_WATCH_MAP.putIfAbsent(consumeKey, new StopWatch(consumeKey));
                        if (!STOP_WATCH_MAP.get(consumeKey).isRunning()) {
                            STOP_WATCH_MAP.get(consumeKey).start("消费号码队列数据");
                        }
                    }

                    ConcurrentLinkedQueue<PlanCallPhone> importQueue = IMPORT_QUEUE_MAP.get(importKey);
                    if (CollectionUtils.isNotEmpty(importQueue)) {
                        List<PlanCallPhone> phoneList = new ArrayList<>(batchSize);

                        for (int i = 0; i < loopSize; i++) {
                            if (phoneList.size() >= batchSize) {
                                break;
                            }

                            PlanCallPhone callPhone = importQueue.poll();
                            if (Objects.nonNull(callPhone)) {
                                phoneList.add(callPhone);
                            }
                        }

                        if (CollectionUtils.isNotEmpty(phoneList)) {
                            ATOMIC_LONG_MAP.addAndGet(importKey + "_consume_num", phoneList.size());
                            phoneService.importBatch(importKey, phoneList);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void consumeImportPlanBatchV2() {
        while (true) {
            Set<String> importKeys = IMPORT_QUEUE_MAP.keySet();
            for (String importKey : importKeys) {
                ConcurrentLinkedQueue<PlanCallPhone> importQueue = IMPORT_QUEUE_MAP.get(importKey);
                if (null != importQueue && !importQueue.isEmpty()) {

                    phoneService.importPlanPhoneProcBatch(importKey, importQueue, 100);
                }

            }
        }
    }
}
