package ai.guiji.easyexcel.examples.service;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;

import java.util.List;

public interface PhoneService {

    void batchAdd(List<PlanCallPhone> phoneList);
}
