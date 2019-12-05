package ai.guiji.easyexcel.examples.mapper;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanCallPhoneMapper {

    int addPlanPhoneBatch(@Param("list") List<PlanCallPhone> list);
}