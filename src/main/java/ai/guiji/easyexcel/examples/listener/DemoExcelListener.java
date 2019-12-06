package ai.guiji.easyexcel.examples.listener;

import ai.guiji.easyexcel.examples.dto.DemoExcelTemp;
import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import ai.guiji.easyexcel.examples.service.PhoneService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RedissonClient;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class DemoExcelListener extends AnalysisEventListener<DemoExcelTemp> {
    private static final int BATCH_COUNT = 100;
    private List<PlanCallPhone> phoneList = new ArrayList<>(BATCH_COUNT);

    private StopWatch stopWatch;

    private PhoneService phoneService;

    private RedissonClient redissonClient;

    public DemoExcelListener() {
    }

    public DemoExcelListener(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        stopWatch.start("解析Excel");
//        log.info("解析到一条头数据:{}", JSON.toJSONString(headMap));
    }

    /**
     * 每解析一行数据
     *
     * @param execlObj
     * @param context
     */
    @Override
    public void invoke(DemoExcelTemp execlObj, AnalysisContext context) {
//        log.info("解析到一条数据:{}", JSON.toJSONString(execlObj));
//        phoneList.add(new PlanCallPhone(execlObj.getPhone(), execlObj.getCustName(), execlObj.getCustCompany()));
//        if (phoneList.size() >= BATCH_COUNT) {
//            phoneService.batchAdd(phoneList);
//            phoneList.clear();
//        }

        RBlockingDeque<PlanCallPhone> deque = redissonClient.getBlockingDeque("phoneDeque");
        deque.offerLast(new PlanCallPhone(execlObj.getPhone(), execlObj.getCustName(), execlObj.getCustCompany()));
    }

    /**
     * 解析完所有Excel数据
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        stopWatch.stop();
//        log.info(stopWatch.prettyPrint());
//        if (CollectionUtils.isNotEmpty(phoneList)) {
//            phoneService.batchAdd(phoneList);
//            phoneList.clear();
//        }
        log.info("{}ms", stopWatch.getTotalTimeMillis());
//        log.info("所有数据解析完成！");
    }

    public StopWatch getStopWatch() {
        return stopWatch;
    }

    public void setStopWatch(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }

    public PhoneService getPhoneService() {
        return phoneService;
    }

    public void setPhoneService(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    public RedissonClient getRedissonClient() {
        return redissonClient;
    }

    public void setRedissonClient(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }
}
