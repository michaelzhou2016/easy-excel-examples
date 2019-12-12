package ai.guiji.easyexcel.examples.service.impl;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import ai.guiji.easyexcel.examples.service.IPlanCallPhoneBatchService;
import ai.guiji.easyexcel.examples.service.ImportService;
import ai.guiji.easyexcel.examples.service.PhoneService;
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
import static ai.guiji.easyexcel.examples.constant.MapConstant.STOP_WATCH_MAP;

@Service
public class ImportServiceImpl implements ImportService {

    @Autowired
    private PhoneService phoneService;

    @Override
    public void consumerImportPlanBatch() {
        int loopSize = 100000;
        int batchSize = 100;
        while (true) {
            Set<String> importKeys = IMPORT_QUEUE.keySet();
            if (CollectionUtils.isNotEmpty(importKeys)) {
                importKeys.forEach(importKey -> {
                    if (ATOMIC_LONG_MAP.get(importKey + "_consume_num") == 0L) {
                        String consumeKey = importKey + "_consume";
                        STOP_WATCH_MAP.putIfAbsent(consumeKey, new StopWatch(consumeKey));
                        if (!STOP_WATCH_MAP.get(consumeKey).isRunning()) {
                            STOP_WATCH_MAP.get(consumeKey).start("消费号码队列数据");
                        }
                    }

                    ConcurrentLinkedQueue<PlanCallPhone> importQueue = IMPORT_QUEUE.get(importKey);
                    if (CollectionUtils.isNotEmpty(importQueue)) {
                        List<PlanCallPhone> phoneList = new ArrayList<>(batchSize);

                        for (int i = 0; i < loopSize; i++) {
                            if (phoneList.size() >= batchSize) {
                                ATOMIC_LONG_MAP.addAndGet(importKey + "_consume_num", phoneList.size());
                                phoneService.importBatch(importKey, phoneList);
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
                });
            }
        }
    }
}
