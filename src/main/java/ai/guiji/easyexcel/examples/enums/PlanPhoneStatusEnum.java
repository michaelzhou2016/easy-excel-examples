package ai.guiji.easyexcel.examples.enums;

public enum PlanPhoneStatusEnum {

    WAITING(0, "未开始"),//初始化,导入成功

    DOING(1, "进行中"),//已经推给V2.0中心

    FINISH(2, "已完成"),//呼叫中心已经回调

    SUSPEND(3, "暂停"),

    STOP(4, "停止"),

    FAIL(5, "失败"),

    FORCE_STOP(6, "特殊情况终止"),

    ;
    private Integer status;

    private String message;

    private PlanPhoneStatusEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
