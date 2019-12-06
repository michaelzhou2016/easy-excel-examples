package ai.guiji.easyexcel.examples.service;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import com.github.pagehelper.PageInfo;
import org.redisson.api.RBlockingDeque;

import java.util.List;

public interface PhoneService {

    void batchAdd(List<PlanCallPhone> phoneList);

    void batchAddAsync(RBlockingDeque<PlanCallPhone> deque);

    PageInfo<PlanCallPhone> selectPage(int pageNo, int pageSize);
}
