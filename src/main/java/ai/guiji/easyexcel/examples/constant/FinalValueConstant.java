package ai.guiji.easyexcel.examples.constant;

public class FinalValueConstant {

    public static interface alarmValue{
        final static int stop_plan_time_out = 100;//超过100分钟，终止任务    单位：分钟

        final static int alarm_plan_time_interval = 30; //第一次告警后，间隔时间再次告警   单位：分钟
    }

    public final static int AI_CALL_TYPE = 0;  //0:AI外呼

    public final static int ARTIFICIAL_CALL_TYPE = 1;  //1:人工外呼

}
