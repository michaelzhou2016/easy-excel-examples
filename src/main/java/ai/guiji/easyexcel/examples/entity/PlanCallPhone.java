package ai.guiji.easyexcel.examples.entity;

import java.util.Date;

/**
 *
 * 任务计划号码表
 * @author zhouliliang
 * @date   2019/12/05
 */
public class PlanCallPhone {
    /**
     * ID
     */
    private Long id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 客户姓名
     */
    private String custName;

    /**
     * 客户所属单位
     */
    private String custCompany;

    /**
     * 新增时间
     */
    private Date addTime;

    public PlanCallPhone() {
    }

    public PlanCallPhone(String phone, String custName, String custCompany) {
        this.phone = phone;
        this.custName = custName;
        this.custCompany = custCompany;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}