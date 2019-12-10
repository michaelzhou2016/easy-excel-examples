package ai.guiji.easyexcel.examples.dto;

import com.alibaba.excel.annotation.ExcelProperty;

public class PlanImportExeclTemp {

    @ExcelProperty(index = 0)
    private String custCompany;

    @ExcelProperty(index = 1)
    private String custName;

    @ExcelProperty(index = 2)
    private String phone;

    @ExcelProperty(index = 3)
    private String attach;

    @ExcelProperty(index = 4)
    private String ttsParams;

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

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getCustCompany() {
        return custCompany;
    }

    public void setCustCompany(String custCompany) {
        this.custCompany = custCompany;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
}
