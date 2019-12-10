package ai.guiji.easyexcel.examples.dto;

public class PlanFileErrorRecord {

    private static final long serialVersionUID = -313413290600956370L;

    private Integer planId;

    private String planName;

    /**
     * 号码
     */
    private String phone;

    /**
     * TTS参数
     */
    private String ttsParams;

    /**
     * 变量参数
     */
    private String params;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 客户所属单位
     */
    private String custCompany;

    /**
     * 导入文件记录ID
     */
    private Integer fileRecordsId;

    /**
     * 错误类型，1-机器人合成失败，2-机器人参数校验失败，3-号码重复，4-未知，5-号码不合法
     */
    private Integer errorType;

    /**
     * 0页面数据，1第三方数据
     */
    private Integer dataType;

    /**
     * 呼叫类型
     */
    private Integer callType;

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

    public Integer getFileRecordsId() {
        return fileRecordsId;
    }

    public void setFileRecordsId(Integer fileRecordsId) {
        this.fileRecordsId = fileRecordsId;
    }

    public Integer getErrorType() {
        return errorType;
    }

    public void setErrorType(Integer errorType) {
        this.errorType = errorType;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Integer getCallType() {
        return callType;
    }

    public void setCallType(Integer callType) {
        this.callType = callType;
    }
}
