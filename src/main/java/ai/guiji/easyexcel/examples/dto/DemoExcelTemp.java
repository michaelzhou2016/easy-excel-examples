package ai.guiji.easyexcel.examples.dto;

import com.alibaba.excel.annotation.ExcelProperty;


public class DemoExcelTemp {

    @ExcelProperty(value = "客户所属单位", index = 0)
    private String custCompany;

    @ExcelProperty(value = "客户名称", index = 1)
    private String custName;

    @ExcelProperty(value = "手机号码", index = 2)
    private String phone;

    public DemoExcelTemp() {
    }

    public DemoExcelTemp(String custCompany, String custName, String phone) {
        this.custCompany = custCompany;
        this.custName = custName;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
