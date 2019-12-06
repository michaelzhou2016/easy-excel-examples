package ai.guiji.easyexcel.examples.service;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PhoneService {

    void batchAdd(List<PlanCallPhone> phoneList);

    PageInfo<PlanCallPhone> selectPage(int pageNo, int pageSize);
}
