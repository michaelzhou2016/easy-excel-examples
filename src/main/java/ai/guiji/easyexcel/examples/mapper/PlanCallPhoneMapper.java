package ai.guiji.easyexcel.examples.mapper;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import ai.guiji.easyexcel.examples.entity.PlanCallPhoneExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PlanCallPhoneMapper {
    long countByExample(PlanCallPhoneExample example);

    int deleteByExample(PlanCallPhoneExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PlanCallPhone record);

    int insertSelective(PlanCallPhone record);

    List<PlanCallPhone> selectByExample(PlanCallPhoneExample example);

    PlanCallPhone selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PlanCallPhone record, @Param("example") PlanCallPhoneExample example);

    int updateByExample(@Param("record") PlanCallPhone record, @Param("example") PlanCallPhoneExample example);

    int updateByPrimaryKeySelective(PlanCallPhone record);

    int updateByPrimaryKey(PlanCallPhone record);

    int addPlanPhoneBatch(@Param("list") List<PlanCallPhone> list);

    List<PlanCallPhone> selectAll();
}