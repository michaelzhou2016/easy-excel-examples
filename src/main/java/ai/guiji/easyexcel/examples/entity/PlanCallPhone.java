package ai.guiji.easyexcel.examples.entity;

import java.util.Date;

/**
 *
 * 任务计划号码表
 * @author zhouliliang
 * @date   2019/12/09
 */
public class PlanCallPhone {
    /**
     * 任务UUID;任务全局唯一ID
     */
    private Long seqId;

    /**
     * 批次任务ID
     */
    private Integer planId;

    /**
     * 子批次ID
     */
    private Long planSubId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * TTS参数
     */
    private String ttsParams;

    /**
     * 参数变量
     */
    private String params;

    /**
     * 计划状态;0-未计划(等待中)、1-计划中(拨打中，已推送至V2.0)、2-计划完成、3-暂停计划、4-停止计划、5-失败
     */
    private Integer statusCall;

    /**
     * 流程状态，可以记录流程节点，0-未计划(等待中)、1-计划中、2-计划完成、3-暂停计划、4-停止计划、5-失败
     */
    private Integer statusFlow;

    /**
     * 呼出结果
     */
    private String result;

    /**
     * 归属地区码
     */
    private String regionCode;

    /**
     * 归属地区名称
     */
    private String regionName;

    /**
     * 实际拨打线路ID
     */
    private String lineId;

    /**
     * 备注描述
     */
    private String remark;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 客户所属单位
     */
    private String custCompany;

    /**
     * 用户ID，创建批次用户ID
     */
    private Integer userId;

    /**
     * 组织ID，用于分区
     */
    private Integer orgId;

    /**
     * 加入用户ID
     */
    private Integer joinUser;

    /**
     * 新增时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updTime;

    /**
     * 删除标志 0-正常 1-删除,入回收站 2-删除,永久删除
     */
    private Integer delFlag;

    /**
     * 呼叫ID
     */
    private String callId;

    /**
     * 拨打时间
     */
    private Date callStartTime;

    /**
     * 挂断时间
     */
    private Date hangupTime;

    /**
     * 接听时间
     */
    private Date answerTime;

    /**
     * 拨打时长，单位：秒S
     */
    private Integer duration;

    /**
     * 接听时长
     */
    private Integer billSec;

    /**
     * 挂断类型，0-机器人挂断、1-客户挂断
     */
    private Integer hangupType;

    /**
     * 意向备注
     */
    private String reason;

    /**
     * 1:占线，2:无人接听,3:主叫停机,4:被叫停机,5:空号,6:关机,7:呼叫限制,8:用户拒接,9:无效号码,10:拒接
     */
    private Integer fReason;

    /**
     * 对话轮次
     */
    private Integer dialogueRound;

    /**
     * 是否已读：0-未读、1-已读
     */
    private Integer isRead;

    /**
     * 通话轮次
     */
    private Integer recallNum;

    /**
     * 已拨次数
     */
    private Integer alreadyNum;

    /**
     * 回调时间
     */
    private Date callbackTime;

    /**
     * 删除时间
     */
    private Date delTime;

    /**
     * 删除人
     */
    private Integer delUser;

    public Long getSeqId() {
        return seqId;
    }

    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Long getPlanSubId() {
        return planSubId;
    }

    public void setPlanSubId(Long planSubId) {
        this.planSubId = planSubId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTtsParams() {
        return ttsParams;
    }

    public void setTtsParams(String ttsParams) {
        this.ttsParams = ttsParams;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Integer getStatusCall() {
        return statusCall;
    }

    public void setStatusCall(Integer statusCall) {
        this.statusCall = statusCall;
    }

    public Integer getStatusFlow() {
        return statusFlow;
    }

    public void setStatusFlow(Integer statusFlow) {
        this.statusFlow = statusFlow;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCompany() {
        return custCompany;
    }

    public void setCustCompany(String custCompany) {
        this.custCompany = custCompany;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getJoinUser() {
        return joinUser;
    }

    public void setJoinUser(Integer joinUser) {
        this.joinUser = joinUser;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public Date getCallStartTime() {
        return callStartTime;
    }

    public void setCallStartTime(Date callStartTime) {
        this.callStartTime = callStartTime;
    }

    public Date getHangupTime() {
        return hangupTime;
    }

    public void setHangupTime(Date hangupTime) {
        this.hangupTime = hangupTime;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getBillSec() {
        return billSec;
    }

    public void setBillSec(Integer billSec) {
        this.billSec = billSec;
    }

    public Integer getHangupType() {
        return hangupType;
    }

    public void setHangupType(Integer hangupType) {
        this.hangupType = hangupType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getfReason() {
        return fReason;
    }

    public void setfReason(Integer fReason) {
        this.fReason = fReason;
    }

    public Integer getDialogueRound() {
        return dialogueRound;
    }

    public void setDialogueRound(Integer dialogueRound) {
        this.dialogueRound = dialogueRound;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getRecallNum() {
        return recallNum;
    }

    public void setRecallNum(Integer recallNum) {
        this.recallNum = recallNum;
    }

    public Integer getAlreadyNum() {
        return alreadyNum;
    }

    public void setAlreadyNum(Integer alreadyNum) {
        this.alreadyNum = alreadyNum;
    }

    public Date getCallbackTime() {
        return callbackTime;
    }

    public void setCallbackTime(Date callbackTime) {
        this.callbackTime = callbackTime;
    }

    public Date getDelTime() {
        return delTime;
    }

    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

    public Integer getDelUser() {
        return delUser;
    }

    public void setDelUser(Integer delUser) {
        this.delUser = delUser;
    }
}