package ai.guiji.easyexcel.examples.service.impl;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import ai.guiji.easyexcel.examples.mapper.PlanCallPhoneMapper;
import ai.guiji.easyexcel.examples.service.IPlanCallPhoneBatchService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static ai.guiji.easyexcel.examples.constant.MapConstant.ATOMIC_LONG_MAP;

@Slf4j
@Service
public class PlanCallPhoneBatchServiceImpl implements IPlanCallPhoneBatchService {
    @Autowired
    private PlanCallPhoneMapper planCallPhoneMapper;


    @Override
    @Transactional
    public void addPlanPhoneBatch(List<PlanCallPhone> phoneList, String importKey) {
        int num = planCallPhoneMapper.addPlanPhoneBatch(phoneList);
        long totalNum = ATOMIC_LONG_MAP.addAndGet(importKey + "_inserted_num", num);
        log.info("importKey:{}, 此次批量插入条数:{}, 已经插入到数据库总条数:{}", importKey, num, totalNum);
    }
}
