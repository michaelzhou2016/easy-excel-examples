package ai.guiji.easyexcel.examples.service.impl;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import ai.guiji.easyexcel.examples.mapper.PlanCallPhoneMapper;
import ai.guiji.easyexcel.examples.service.PhoneService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author: zhouliliang
 * Date: 2019/12/5 18:42
 * Description:
 */
@Slf4j
@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PlanCallPhoneMapper planCallPhoneMapper;

    @Transactional
    @Override
    public void batchAdd(List<PlanCallPhone> phoneList) {
        int num = planCallPhoneMapper.addPlanPhoneBatch(phoneList);
        log.info("insert num:{}", num);
    }

    @Override
    public PageInfo<PlanCallPhone> selectPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(planCallPhoneMapper.selectAll());
    }
}
