package ai.guiji.easyexcel.examples.service;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;

import java.util.List;

public interface IPlanCallPhoneBatchService {

    void addPlanPhoneBatch(List<PlanCallPhone> phoneList, String importKey);
}
