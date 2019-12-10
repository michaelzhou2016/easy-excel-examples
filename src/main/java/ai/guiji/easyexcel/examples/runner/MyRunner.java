//package ai.guiji.easyexcel.examples.runner;
//
//import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
//import ai.guiji.easyexcel.examples.service.PhoneService;
//import lombok.extern.slf4j.Slf4j;
//import org.redisson.api.RBlockingDeque;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Objects;
//
///**
// * author: zhouliliang
// * Date: 2019/12/6 15:38
// * Description:
// */
//@Slf4j
//@Component
//public class MyRunner implements ApplicationRunner {
//    @Autowired
//    private RedissonClient redissonClient;
//    @Autowired
//    private PhoneService phoneService;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        RBlockingDeque<PlanCallPhone> deque = redissonClient.getBlockingDeque("phoneDeque");
//        new Thread(() -> {
//            while (true) {
//                if (deque.size() > 0) {
//                    phoneService.batchAddAsync(deque);
//                }
//            }
//        }).start();
//    }
//}
