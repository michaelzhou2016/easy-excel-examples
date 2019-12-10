package ai.guiji.easyexcel.examples.service;

import ai.guiji.easyexcel.examples.dto.PlanImportExeclTemp;
import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PhoneService {

    void processPlanPhoneProcBatch(List<PlanImportExeclTemp> phoneList, String importKey, String key, String planName, Integer fileId);

    /*void batchAddAsync(RBlockingDeque<PlanCallPhone> deque);*/

    PageInfo<PlanCallPhone> selectPage(int pageNo, int pageSize);
}
