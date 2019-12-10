package ai.guiji.easyexcel.examples.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanCallPhoneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlanCallPhoneExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSeqIdIsNull() {
            addCriterion("seq_id is null");
            return (Criteria) this;
        }

        public Criteria andSeqIdIsNotNull() {
            addCriterion("seq_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeqIdEqualTo(Long value) {
            addCriterion("seq_id =", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotEqualTo(Long value) {
            addCriterion("seq_id <>", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThan(Long value) {
            addCriterion("seq_id >", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThanOrEqualTo(Long value) {
            addCriterion("seq_id >=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThan(Long value) {
            addCriterion("seq_id <", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThanOrEqualTo(Long value) {
            addCriterion("seq_id <=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdIn(List<Long> values) {
            addCriterion("seq_id in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotIn(List<Long> values) {
            addCriterion("seq_id not in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdBetween(Long value1, Long value2) {
            addCriterion("seq_id between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotBetween(Long value1, Long value2) {
            addCriterion("seq_id not between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Integer value) {
            addCriterion("plan_id =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Integer value) {
            addCriterion("plan_id <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Integer value) {
            addCriterion("plan_id >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("plan_id >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Integer value) {
            addCriterion("plan_id <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Integer value) {
            addCriterion("plan_id <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Integer> values) {
            addCriterion("plan_id in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Integer> values) {
            addCriterion("plan_id not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Integer value1, Integer value2) {
            addCriterion("plan_id between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("plan_id not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdIsNull() {
            addCriterion("plan_sub_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdIsNotNull() {
            addCriterion("plan_sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdEqualTo(Long value) {
            addCriterion("plan_sub_id =", value, "planSubId");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdNotEqualTo(Long value) {
            addCriterion("plan_sub_id <>", value, "planSubId");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdGreaterThan(Long value) {
            addCriterion("plan_sub_id >", value, "planSubId");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdGreaterThanOrEqualTo(Long value) {
            addCriterion("plan_sub_id >=", value, "planSubId");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdLessThan(Long value) {
            addCriterion("plan_sub_id <", value, "planSubId");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdLessThanOrEqualTo(Long value) {
            addCriterion("plan_sub_id <=", value, "planSubId");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdIn(List<Long> values) {
            addCriterion("plan_sub_id in", values, "planSubId");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdNotIn(List<Long> values) {
            addCriterion("plan_sub_id not in", values, "planSubId");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdBetween(Long value1, Long value2) {
            addCriterion("plan_sub_id between", value1, value2, "planSubId");
            return (Criteria) this;
        }

        public Criteria andPlanSubIdNotBetween(Long value1, Long value2) {
            addCriterion("plan_sub_id not between", value1, value2, "planSubId");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andTtsParamsIsNull() {
            addCriterion("tts_params is null");
            return (Criteria) this;
        }

        public Criteria andTtsParamsIsNotNull() {
            addCriterion("tts_params is not null");
            return (Criteria) this;
        }

        public Criteria andTtsParamsEqualTo(String value) {
            addCriterion("tts_params =", value, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andTtsParamsNotEqualTo(String value) {
            addCriterion("tts_params <>", value, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andTtsParamsGreaterThan(String value) {
            addCriterion("tts_params >", value, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andTtsParamsGreaterThanOrEqualTo(String value) {
            addCriterion("tts_params >=", value, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andTtsParamsLessThan(String value) {
            addCriterion("tts_params <", value, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andTtsParamsLessThanOrEqualTo(String value) {
            addCriterion("tts_params <=", value, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andTtsParamsLike(String value) {
            addCriterion("tts_params like", value, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andTtsParamsNotLike(String value) {
            addCriterion("tts_params not like", value, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andTtsParamsIn(List<String> values) {
            addCriterion("tts_params in", values, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andTtsParamsNotIn(List<String> values) {
            addCriterion("tts_params not in", values, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andTtsParamsBetween(String value1, String value2) {
            addCriterion("tts_params between", value1, value2, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andTtsParamsNotBetween(String value1, String value2) {
            addCriterion("tts_params not between", value1, value2, "ttsParams");
            return (Criteria) this;
        }

        public Criteria andParamsIsNull() {
            addCriterion("params is null");
            return (Criteria) this;
        }

        public Criteria andParamsIsNotNull() {
            addCriterion("params is not null");
            return (Criteria) this;
        }

        public Criteria andParamsEqualTo(String value) {
            addCriterion("params =", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotEqualTo(String value) {
            addCriterion("params <>", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThan(String value) {
            addCriterion("params >", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThanOrEqualTo(String value) {
            addCriterion("params >=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThan(String value) {
            addCriterion("params <", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThanOrEqualTo(String value) {
            addCriterion("params <=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLike(String value) {
            addCriterion("params like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotLike(String value) {
            addCriterion("params not like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsIn(List<String> values) {
            addCriterion("params in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotIn(List<String> values) {
            addCriterion("params not in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsBetween(String value1, String value2) {
            addCriterion("params between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotBetween(String value1, String value2) {
            addCriterion("params not between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andStatusCallIsNull() {
            addCriterion("status_call is null");
            return (Criteria) this;
        }

        public Criteria andStatusCallIsNotNull() {
            addCriterion("status_call is not null");
            return (Criteria) this;
        }

        public Criteria andStatusCallEqualTo(Integer value) {
            addCriterion("status_call =", value, "statusCall");
            return (Criteria) this;
        }

        public Criteria andStatusCallNotEqualTo(Integer value) {
            addCriterion("status_call <>", value, "statusCall");
            return (Criteria) this;
        }

        public Criteria andStatusCallGreaterThan(Integer value) {
            addCriterion("status_call >", value, "statusCall");
            return (Criteria) this;
        }

        public Criteria andStatusCallGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_call >=", value, "statusCall");
            return (Criteria) this;
        }

        public Criteria andStatusCallLessThan(Integer value) {
            addCriterion("status_call <", value, "statusCall");
            return (Criteria) this;
        }

        public Criteria andStatusCallLessThanOrEqualTo(Integer value) {
            addCriterion("status_call <=", value, "statusCall");
            return (Criteria) this;
        }

        public Criteria andStatusCallIn(List<Integer> values) {
            addCriterion("status_call in", values, "statusCall");
            return (Criteria) this;
        }

        public Criteria andStatusCallNotIn(List<Integer> values) {
            addCriterion("status_call not in", values, "statusCall");
            return (Criteria) this;
        }

        public Criteria andStatusCallBetween(Integer value1, Integer value2) {
            addCriterion("status_call between", value1, value2, "statusCall");
            return (Criteria) this;
        }

        public Criteria andStatusCallNotBetween(Integer value1, Integer value2) {
            addCriterion("status_call not between", value1, value2, "statusCall");
            return (Criteria) this;
        }

        public Criteria andStatusFlowIsNull() {
            addCriterion("status_flow is null");
            return (Criteria) this;
        }

        public Criteria andStatusFlowIsNotNull() {
            addCriterion("status_flow is not null");
            return (Criteria) this;
        }

        public Criteria andStatusFlowEqualTo(Integer value) {
            addCriterion("status_flow =", value, "statusFlow");
            return (Criteria) this;
        }

        public Criteria andStatusFlowNotEqualTo(Integer value) {
            addCriterion("status_flow <>", value, "statusFlow");
            return (Criteria) this;
        }

        public Criteria andStatusFlowGreaterThan(Integer value) {
            addCriterion("status_flow >", value, "statusFlow");
            return (Criteria) this;
        }

        public Criteria andStatusFlowGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_flow >=", value, "statusFlow");
            return (Criteria) this;
        }

        public Criteria andStatusFlowLessThan(Integer value) {
            addCriterion("status_flow <", value, "statusFlow");
            return (Criteria) this;
        }

        public Criteria andStatusFlowLessThanOrEqualTo(Integer value) {
            addCriterion("status_flow <=", value, "statusFlow");
            return (Criteria) this;
        }

        public Criteria andStatusFlowIn(List<Integer> values) {
            addCriterion("status_flow in", values, "statusFlow");
            return (Criteria) this;
        }

        public Criteria andStatusFlowNotIn(List<Integer> values) {
            addCriterion("status_flow not in", values, "statusFlow");
            return (Criteria) this;
        }

        public Criteria andStatusFlowBetween(Integer value1, Integer value2) {
            addCriterion("status_flow between", value1, value2, "statusFlow");
            return (Criteria) this;
        }

        public Criteria andStatusFlowNotBetween(Integer value1, Integer value2) {
            addCriterion("status_flow not between", value1, value2, "statusFlow");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNull() {
            addCriterion("region_code is null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNotNull() {
            addCriterion("region_code is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeEqualTo(String value) {
            addCriterion("region_code =", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotEqualTo(String value) {
            addCriterion("region_code <>", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThan(String value) {
            addCriterion("region_code >", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("region_code >=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThan(String value) {
            addCriterion("region_code <", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("region_code <=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLike(String value) {
            addCriterion("region_code like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotLike(String value) {
            addCriterion("region_code not like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIn(List<String> values) {
            addCriterion("region_code in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotIn(List<String> values) {
            addCriterion("region_code not in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeBetween(String value1, String value2) {
            addCriterion("region_code between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotBetween(String value1, String value2) {
            addCriterion("region_code not between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNull() {
            addCriterion("region_name is null");
            return (Criteria) this;
        }

        public Criteria andRegionNameIsNotNull() {
            addCriterion("region_name is not null");
            return (Criteria) this;
        }

        public Criteria andRegionNameEqualTo(String value) {
            addCriterion("region_name =", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotEqualTo(String value) {
            addCriterion("region_name <>", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThan(String value) {
            addCriterion("region_name >", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameGreaterThanOrEqualTo(String value) {
            addCriterion("region_name >=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThan(String value) {
            addCriterion("region_name <", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLessThanOrEqualTo(String value) {
            addCriterion("region_name <=", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameLike(String value) {
            addCriterion("region_name like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotLike(String value) {
            addCriterion("region_name not like", value, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameIn(List<String> values) {
            addCriterion("region_name in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotIn(List<String> values) {
            addCriterion("region_name not in", values, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameBetween(String value1, String value2) {
            addCriterion("region_name between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andRegionNameNotBetween(String value1, String value2) {
            addCriterion("region_name not between", value1, value2, "regionName");
            return (Criteria) this;
        }

        public Criteria andLineIdIsNull() {
            addCriterion("line_id is null");
            return (Criteria) this;
        }

        public Criteria andLineIdIsNotNull() {
            addCriterion("line_id is not null");
            return (Criteria) this;
        }

        public Criteria andLineIdEqualTo(String value) {
            addCriterion("line_id =", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotEqualTo(String value) {
            addCriterion("line_id <>", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdGreaterThan(String value) {
            addCriterion("line_id >", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdGreaterThanOrEqualTo(String value) {
            addCriterion("line_id >=", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLessThan(String value) {
            addCriterion("line_id <", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLessThanOrEqualTo(String value) {
            addCriterion("line_id <=", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdLike(String value) {
            addCriterion("line_id like", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotLike(String value) {
            addCriterion("line_id not like", value, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdIn(List<String> values) {
            addCriterion("line_id in", values, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotIn(List<String> values) {
            addCriterion("line_id not in", values, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdBetween(String value1, String value2) {
            addCriterion("line_id between", value1, value2, "lineId");
            return (Criteria) this;
        }

        public Criteria andLineIdNotBetween(String value1, String value2) {
            addCriterion("line_id not between", value1, value2, "lineId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustCompanyIsNull() {
            addCriterion("cust_company is null");
            return (Criteria) this;
        }

        public Criteria andCustCompanyIsNotNull() {
            addCriterion("cust_company is not null");
            return (Criteria) this;
        }

        public Criteria andCustCompanyEqualTo(String value) {
            addCriterion("cust_company =", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyNotEqualTo(String value) {
            addCriterion("cust_company <>", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyGreaterThan(String value) {
            addCriterion("cust_company >", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("cust_company >=", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyLessThan(String value) {
            addCriterion("cust_company <", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyLessThanOrEqualTo(String value) {
            addCriterion("cust_company <=", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyLike(String value) {
            addCriterion("cust_company like", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyNotLike(String value) {
            addCriterion("cust_company not like", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyIn(List<String> values) {
            addCriterion("cust_company in", values, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyNotIn(List<String> values) {
            addCriterion("cust_company not in", values, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyBetween(String value1, String value2) {
            addCriterion("cust_company between", value1, value2, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyNotBetween(String value1, String value2) {
            addCriterion("cust_company not between", value1, value2, "custCompany");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andJoinUserIsNull() {
            addCriterion("join_user is null");
            return (Criteria) this;
        }

        public Criteria andJoinUserIsNotNull() {
            addCriterion("join_user is not null");
            return (Criteria) this;
        }

        public Criteria andJoinUserEqualTo(Integer value) {
            addCriterion("join_user =", value, "joinUser");
            return (Criteria) this;
        }

        public Criteria andJoinUserNotEqualTo(Integer value) {
            addCriterion("join_user <>", value, "joinUser");
            return (Criteria) this;
        }

        public Criteria andJoinUserGreaterThan(Integer value) {
            addCriterion("join_user >", value, "joinUser");
            return (Criteria) this;
        }

        public Criteria andJoinUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("join_user >=", value, "joinUser");
            return (Criteria) this;
        }

        public Criteria andJoinUserLessThan(Integer value) {
            addCriterion("join_user <", value, "joinUser");
            return (Criteria) this;
        }

        public Criteria andJoinUserLessThanOrEqualTo(Integer value) {
            addCriterion("join_user <=", value, "joinUser");
            return (Criteria) this;
        }

        public Criteria andJoinUserIn(List<Integer> values) {
            addCriterion("join_user in", values, "joinUser");
            return (Criteria) this;
        }

        public Criteria andJoinUserNotIn(List<Integer> values) {
            addCriterion("join_user not in", values, "joinUser");
            return (Criteria) this;
        }

        public Criteria andJoinUserBetween(Integer value1, Integer value2) {
            addCriterion("join_user between", value1, value2, "joinUser");
            return (Criteria) this;
        }

        public Criteria andJoinUserNotBetween(Integer value1, Integer value2) {
            addCriterion("join_user not between", value1, value2, "joinUser");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNull() {
            addCriterion("upd_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNotNull() {
            addCriterion("upd_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeEqualTo(Date value) {
            addCriterion("upd_time =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Date value) {
            addCriterion("upd_time <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Date value) {
            addCriterion("upd_time >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upd_time >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Date value) {
            addCriterion("upd_time <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("upd_time <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Date> values) {
            addCriterion("upd_time in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Date> values) {
            addCriterion("upd_time not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Date value1, Date value2) {
            addCriterion("upd_time between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("upd_time not between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andCallIdIsNull() {
            addCriterion("call_id is null");
            return (Criteria) this;
        }

        public Criteria andCallIdIsNotNull() {
            addCriterion("call_id is not null");
            return (Criteria) this;
        }

        public Criteria andCallIdEqualTo(String value) {
            addCriterion("call_id =", value, "callId");
            return (Criteria) this;
        }

        public Criteria andCallIdNotEqualTo(String value) {
            addCriterion("call_id <>", value, "callId");
            return (Criteria) this;
        }

        public Criteria andCallIdGreaterThan(String value) {
            addCriterion("call_id >", value, "callId");
            return (Criteria) this;
        }

        public Criteria andCallIdGreaterThanOrEqualTo(String value) {
            addCriterion("call_id >=", value, "callId");
            return (Criteria) this;
        }

        public Criteria andCallIdLessThan(String value) {
            addCriterion("call_id <", value, "callId");
            return (Criteria) this;
        }

        public Criteria andCallIdLessThanOrEqualTo(String value) {
            addCriterion("call_id <=", value, "callId");
            return (Criteria) this;
        }

        public Criteria andCallIdLike(String value) {
            addCriterion("call_id like", value, "callId");
            return (Criteria) this;
        }

        public Criteria andCallIdNotLike(String value) {
            addCriterion("call_id not like", value, "callId");
            return (Criteria) this;
        }

        public Criteria andCallIdIn(List<String> values) {
            addCriterion("call_id in", values, "callId");
            return (Criteria) this;
        }

        public Criteria andCallIdNotIn(List<String> values) {
            addCriterion("call_id not in", values, "callId");
            return (Criteria) this;
        }

        public Criteria andCallIdBetween(String value1, String value2) {
            addCriterion("call_id between", value1, value2, "callId");
            return (Criteria) this;
        }

        public Criteria andCallIdNotBetween(String value1, String value2) {
            addCriterion("call_id not between", value1, value2, "callId");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeIsNull() {
            addCriterion("call_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeIsNotNull() {
            addCriterion("call_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeEqualTo(Date value) {
            addCriterion("call_start_time =", value, "callStartTime");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeNotEqualTo(Date value) {
            addCriterion("call_start_time <>", value, "callStartTime");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeGreaterThan(Date value) {
            addCriterion("call_start_time >", value, "callStartTime");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("call_start_time >=", value, "callStartTime");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeLessThan(Date value) {
            addCriterion("call_start_time <", value, "callStartTime");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("call_start_time <=", value, "callStartTime");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeIn(List<Date> values) {
            addCriterion("call_start_time in", values, "callStartTime");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeNotIn(List<Date> values) {
            addCriterion("call_start_time not in", values, "callStartTime");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeBetween(Date value1, Date value2) {
            addCriterion("call_start_time between", value1, value2, "callStartTime");
            return (Criteria) this;
        }

        public Criteria andCallStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("call_start_time not between", value1, value2, "callStartTime");
            return (Criteria) this;
        }

        public Criteria andHangupTimeIsNull() {
            addCriterion("hangup_time is null");
            return (Criteria) this;
        }

        public Criteria andHangupTimeIsNotNull() {
            addCriterion("hangup_time is not null");
            return (Criteria) this;
        }

        public Criteria andHangupTimeEqualTo(Date value) {
            addCriterion("hangup_time =", value, "hangupTime");
            return (Criteria) this;
        }

        public Criteria andHangupTimeNotEqualTo(Date value) {
            addCriterion("hangup_time <>", value, "hangupTime");
            return (Criteria) this;
        }

        public Criteria andHangupTimeGreaterThan(Date value) {
            addCriterion("hangup_time >", value, "hangupTime");
            return (Criteria) this;
        }

        public Criteria andHangupTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hangup_time >=", value, "hangupTime");
            return (Criteria) this;
        }

        public Criteria andHangupTimeLessThan(Date value) {
            addCriterion("hangup_time <", value, "hangupTime");
            return (Criteria) this;
        }

        public Criteria andHangupTimeLessThanOrEqualTo(Date value) {
            addCriterion("hangup_time <=", value, "hangupTime");
            return (Criteria) this;
        }

        public Criteria andHangupTimeIn(List<Date> values) {
            addCriterion("hangup_time in", values, "hangupTime");
            return (Criteria) this;
        }

        public Criteria andHangupTimeNotIn(List<Date> values) {
            addCriterion("hangup_time not in", values, "hangupTime");
            return (Criteria) this;
        }

        public Criteria andHangupTimeBetween(Date value1, Date value2) {
            addCriterion("hangup_time between", value1, value2, "hangupTime");
            return (Criteria) this;
        }

        public Criteria andHangupTimeNotBetween(Date value1, Date value2) {
            addCriterion("hangup_time not between", value1, value2, "hangupTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeIsNull() {
            addCriterion("answer_time is null");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeIsNotNull() {
            addCriterion("answer_time is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeEqualTo(Date value) {
            addCriterion("answer_time =", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeNotEqualTo(Date value) {
            addCriterion("answer_time <>", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeGreaterThan(Date value) {
            addCriterion("answer_time >", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("answer_time >=", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeLessThan(Date value) {
            addCriterion("answer_time <", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeLessThanOrEqualTo(Date value) {
            addCriterion("answer_time <=", value, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeIn(List<Date> values) {
            addCriterion("answer_time in", values, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeNotIn(List<Date> values) {
            addCriterion("answer_time not in", values, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeBetween(Date value1, Date value2) {
            addCriterion("answer_time between", value1, value2, "answerTime");
            return (Criteria) this;
        }

        public Criteria andAnswerTimeNotBetween(Date value1, Date value2) {
            addCriterion("answer_time not between", value1, value2, "answerTime");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andBillSecIsNull() {
            addCriterion("bill_sec is null");
            return (Criteria) this;
        }

        public Criteria andBillSecIsNotNull() {
            addCriterion("bill_sec is not null");
            return (Criteria) this;
        }

        public Criteria andBillSecEqualTo(Integer value) {
            addCriterion("bill_sec =", value, "billSec");
            return (Criteria) this;
        }

        public Criteria andBillSecNotEqualTo(Integer value) {
            addCriterion("bill_sec <>", value, "billSec");
            return (Criteria) this;
        }

        public Criteria andBillSecGreaterThan(Integer value) {
            addCriterion("bill_sec >", value, "billSec");
            return (Criteria) this;
        }

        public Criteria andBillSecGreaterThanOrEqualTo(Integer value) {
            addCriterion("bill_sec >=", value, "billSec");
            return (Criteria) this;
        }

        public Criteria andBillSecLessThan(Integer value) {
            addCriterion("bill_sec <", value, "billSec");
            return (Criteria) this;
        }

        public Criteria andBillSecLessThanOrEqualTo(Integer value) {
            addCriterion("bill_sec <=", value, "billSec");
            return (Criteria) this;
        }

        public Criteria andBillSecIn(List<Integer> values) {
            addCriterion("bill_sec in", values, "billSec");
            return (Criteria) this;
        }

        public Criteria andBillSecNotIn(List<Integer> values) {
            addCriterion("bill_sec not in", values, "billSec");
            return (Criteria) this;
        }

        public Criteria andBillSecBetween(Integer value1, Integer value2) {
            addCriterion("bill_sec between", value1, value2, "billSec");
            return (Criteria) this;
        }

        public Criteria andBillSecNotBetween(Integer value1, Integer value2) {
            addCriterion("bill_sec not between", value1, value2, "billSec");
            return (Criteria) this;
        }

        public Criteria andHangupTypeIsNull() {
            addCriterion("hangup_type is null");
            return (Criteria) this;
        }

        public Criteria andHangupTypeIsNotNull() {
            addCriterion("hangup_type is not null");
            return (Criteria) this;
        }

        public Criteria andHangupTypeEqualTo(Integer value) {
            addCriterion("hangup_type =", value, "hangupType");
            return (Criteria) this;
        }

        public Criteria andHangupTypeNotEqualTo(Integer value) {
            addCriterion("hangup_type <>", value, "hangupType");
            return (Criteria) this;
        }

        public Criteria andHangupTypeGreaterThan(Integer value) {
            addCriterion("hangup_type >", value, "hangupType");
            return (Criteria) this;
        }

        public Criteria andHangupTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("hangup_type >=", value, "hangupType");
            return (Criteria) this;
        }

        public Criteria andHangupTypeLessThan(Integer value) {
            addCriterion("hangup_type <", value, "hangupType");
            return (Criteria) this;
        }

        public Criteria andHangupTypeLessThanOrEqualTo(Integer value) {
            addCriterion("hangup_type <=", value, "hangupType");
            return (Criteria) this;
        }

        public Criteria andHangupTypeIn(List<Integer> values) {
            addCriterion("hangup_type in", values, "hangupType");
            return (Criteria) this;
        }

        public Criteria andHangupTypeNotIn(List<Integer> values) {
            addCriterion("hangup_type not in", values, "hangupType");
            return (Criteria) this;
        }

        public Criteria andHangupTypeBetween(Integer value1, Integer value2) {
            addCriterion("hangup_type between", value1, value2, "hangupType");
            return (Criteria) this;
        }

        public Criteria andHangupTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("hangup_type not between", value1, value2, "hangupType");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andFReasonIsNull() {
            addCriterion("f_reason is null");
            return (Criteria) this;
        }

        public Criteria andFReasonIsNotNull() {
            addCriterion("f_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFReasonEqualTo(Integer value) {
            addCriterion("f_reason =", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonNotEqualTo(Integer value) {
            addCriterion("f_reason <>", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonGreaterThan(Integer value) {
            addCriterion("f_reason >", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_reason >=", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonLessThan(Integer value) {
            addCriterion("f_reason <", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonLessThanOrEqualTo(Integer value) {
            addCriterion("f_reason <=", value, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonIn(List<Integer> values) {
            addCriterion("f_reason in", values, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonNotIn(List<Integer> values) {
            addCriterion("f_reason not in", values, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonBetween(Integer value1, Integer value2) {
            addCriterion("f_reason between", value1, value2, "fReason");
            return (Criteria) this;
        }

        public Criteria andFReasonNotBetween(Integer value1, Integer value2) {
            addCriterion("f_reason not between", value1, value2, "fReason");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundIsNull() {
            addCriterion("dialogue_round is null");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundIsNotNull() {
            addCriterion("dialogue_round is not null");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundEqualTo(Integer value) {
            addCriterion("dialogue_round =", value, "dialogueRound");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundNotEqualTo(Integer value) {
            addCriterion("dialogue_round <>", value, "dialogueRound");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundGreaterThan(Integer value) {
            addCriterion("dialogue_round >", value, "dialogueRound");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundGreaterThanOrEqualTo(Integer value) {
            addCriterion("dialogue_round >=", value, "dialogueRound");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundLessThan(Integer value) {
            addCriterion("dialogue_round <", value, "dialogueRound");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundLessThanOrEqualTo(Integer value) {
            addCriterion("dialogue_round <=", value, "dialogueRound");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundIn(List<Integer> values) {
            addCriterion("dialogue_round in", values, "dialogueRound");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundNotIn(List<Integer> values) {
            addCriterion("dialogue_round not in", values, "dialogueRound");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundBetween(Integer value1, Integer value2) {
            addCriterion("dialogue_round between", value1, value2, "dialogueRound");
            return (Criteria) this;
        }

        public Criteria andDialogueRoundNotBetween(Integer value1, Integer value2) {
            addCriterion("dialogue_round not between", value1, value2, "dialogueRound");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNull() {
            addCriterion("is_read is null");
            return (Criteria) this;
        }

        public Criteria andIsReadIsNotNull() {
            addCriterion("is_read is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadEqualTo(Integer value) {
            addCriterion("is_read =", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotEqualTo(Integer value) {
            addCriterion("is_read <>", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThan(Integer value) {
            addCriterion("is_read >", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_read >=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThan(Integer value) {
            addCriterion("is_read <", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadLessThanOrEqualTo(Integer value) {
            addCriterion("is_read <=", value, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadIn(List<Integer> values) {
            addCriterion("is_read in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotIn(List<Integer> values) {
            addCriterion("is_read not in", values, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadBetween(Integer value1, Integer value2) {
            addCriterion("is_read between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andIsReadNotBetween(Integer value1, Integer value2) {
            addCriterion("is_read not between", value1, value2, "isRead");
            return (Criteria) this;
        }

        public Criteria andRecallNumIsNull() {
            addCriterion("recall_num is null");
            return (Criteria) this;
        }

        public Criteria andRecallNumIsNotNull() {
            addCriterion("recall_num is not null");
            return (Criteria) this;
        }

        public Criteria andRecallNumEqualTo(Integer value) {
            addCriterion("recall_num =", value, "recallNum");
            return (Criteria) this;
        }

        public Criteria andRecallNumNotEqualTo(Integer value) {
            addCriterion("recall_num <>", value, "recallNum");
            return (Criteria) this;
        }

        public Criteria andRecallNumGreaterThan(Integer value) {
            addCriterion("recall_num >", value, "recallNum");
            return (Criteria) this;
        }

        public Criteria andRecallNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("recall_num >=", value, "recallNum");
            return (Criteria) this;
        }

        public Criteria andRecallNumLessThan(Integer value) {
            addCriterion("recall_num <", value, "recallNum");
            return (Criteria) this;
        }

        public Criteria andRecallNumLessThanOrEqualTo(Integer value) {
            addCriterion("recall_num <=", value, "recallNum");
            return (Criteria) this;
        }

        public Criteria andRecallNumIn(List<Integer> values) {
            addCriterion("recall_num in", values, "recallNum");
            return (Criteria) this;
        }

        public Criteria andRecallNumNotIn(List<Integer> values) {
            addCriterion("recall_num not in", values, "recallNum");
            return (Criteria) this;
        }

        public Criteria andRecallNumBetween(Integer value1, Integer value2) {
            addCriterion("recall_num between", value1, value2, "recallNum");
            return (Criteria) this;
        }

        public Criteria andRecallNumNotBetween(Integer value1, Integer value2) {
            addCriterion("recall_num not between", value1, value2, "recallNum");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumIsNull() {
            addCriterion("already_num is null");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumIsNotNull() {
            addCriterion("already_num is not null");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumEqualTo(Integer value) {
            addCriterion("already_num =", value, "alreadyNum");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumNotEqualTo(Integer value) {
            addCriterion("already_num <>", value, "alreadyNum");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumGreaterThan(Integer value) {
            addCriterion("already_num >", value, "alreadyNum");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("already_num >=", value, "alreadyNum");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumLessThan(Integer value) {
            addCriterion("already_num <", value, "alreadyNum");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumLessThanOrEqualTo(Integer value) {
            addCriterion("already_num <=", value, "alreadyNum");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumIn(List<Integer> values) {
            addCriterion("already_num in", values, "alreadyNum");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumNotIn(List<Integer> values) {
            addCriterion("already_num not in", values, "alreadyNum");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumBetween(Integer value1, Integer value2) {
            addCriterion("already_num between", value1, value2, "alreadyNum");
            return (Criteria) this;
        }

        public Criteria andAlreadyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("already_num not between", value1, value2, "alreadyNum");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeIsNull() {
            addCriterion("callback_time is null");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeIsNotNull() {
            addCriterion("callback_time is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeEqualTo(Date value) {
            addCriterion("callback_time =", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeNotEqualTo(Date value) {
            addCriterion("callback_time <>", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeGreaterThan(Date value) {
            addCriterion("callback_time >", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("callback_time >=", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeLessThan(Date value) {
            addCriterion("callback_time <", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeLessThanOrEqualTo(Date value) {
            addCriterion("callback_time <=", value, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeIn(List<Date> values) {
            addCriterion("callback_time in", values, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeNotIn(List<Date> values) {
            addCriterion("callback_time not in", values, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeBetween(Date value1, Date value2) {
            addCriterion("callback_time between", value1, value2, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andCallbackTimeNotBetween(Date value1, Date value2) {
            addCriterion("callback_time not between", value1, value2, "callbackTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeIsNull() {
            addCriterion("del_time is null");
            return (Criteria) this;
        }

        public Criteria andDelTimeIsNotNull() {
            addCriterion("del_time is not null");
            return (Criteria) this;
        }

        public Criteria andDelTimeEqualTo(Date value) {
            addCriterion("del_time =", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeNotEqualTo(Date value) {
            addCriterion("del_time <>", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeGreaterThan(Date value) {
            addCriterion("del_time >", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("del_time >=", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeLessThan(Date value) {
            addCriterion("del_time <", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeLessThanOrEqualTo(Date value) {
            addCriterion("del_time <=", value, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeIn(List<Date> values) {
            addCriterion("del_time in", values, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeNotIn(List<Date> values) {
            addCriterion("del_time not in", values, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeBetween(Date value1, Date value2) {
            addCriterion("del_time between", value1, value2, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelTimeNotBetween(Date value1, Date value2) {
            addCriterion("del_time not between", value1, value2, "delTime");
            return (Criteria) this;
        }

        public Criteria andDelUserIsNull() {
            addCriterion("del_user is null");
            return (Criteria) this;
        }

        public Criteria andDelUserIsNotNull() {
            addCriterion("del_user is not null");
            return (Criteria) this;
        }

        public Criteria andDelUserEqualTo(Integer value) {
            addCriterion("del_user =", value, "delUser");
            return (Criteria) this;
        }

        public Criteria andDelUserNotEqualTo(Integer value) {
            addCriterion("del_user <>", value, "delUser");
            return (Criteria) this;
        }

        public Criteria andDelUserGreaterThan(Integer value) {
            addCriterion("del_user >", value, "delUser");
            return (Criteria) this;
        }

        public Criteria andDelUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_user >=", value, "delUser");
            return (Criteria) this;
        }

        public Criteria andDelUserLessThan(Integer value) {
            addCriterion("del_user <", value, "delUser");
            return (Criteria) this;
        }

        public Criteria andDelUserLessThanOrEqualTo(Integer value) {
            addCriterion("del_user <=", value, "delUser");
            return (Criteria) this;
        }

        public Criteria andDelUserIn(List<Integer> values) {
            addCriterion("del_user in", values, "delUser");
            return (Criteria) this;
        }

        public Criteria andDelUserNotIn(List<Integer> values) {
            addCriterion("del_user not in", values, "delUser");
            return (Criteria) this;
        }

        public Criteria andDelUserBetween(Integer value1, Integer value2) {
            addCriterion("del_user between", value1, value2, "delUser");
            return (Criteria) this;
        }

        public Criteria andDelUserNotBetween(Integer value1, Integer value2) {
            addCriterion("del_user not between", value1, value2, "delUser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}