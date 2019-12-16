package ai.guiji.easyexcel.examples.mapper;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import ai.guiji.easyexcel.examples.entity.PlanCallPhoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanCallPhoneMapper {
    long countByExample(PlanCallPhoneExample example);

    int deleteByExample(PlanCallPhoneExample example);

    int insert(PlanCallPhone record);

    int insertSelective(PlanCallPhone record);

    List<PlanCallPhone> selectByExample(PlanCallPhoneExample example);

    int updateByExampleSelective(@Param("record") PlanCallPhone record, @Param("example") PlanCallPhoneExample example);

    int updateByExample(@Param("record") PlanCallPhone record, @Param("example") PlanCallPhoneExample example);

    int addPlanPhoneBatch(@Param("list") List<PlanCallPhone> list);

    //新增拨打号码
    int addPlanPhone(PlanCallPhone planPhone);
}