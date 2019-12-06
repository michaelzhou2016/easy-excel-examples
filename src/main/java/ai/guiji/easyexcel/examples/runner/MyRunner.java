package ai.guiji.easyexcel.examples.runner;

import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * author: zhouliliang
 * Date: 2019/12/6 15:38
 * Description:
 */
@Slf4j
@Component
public class MyRunner implements ApplicationRunner {
    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (true) {
            RBlockingDeque<PlanCallPhone> deque = redissonClient.getBlockingDeque("phoneDeque");
            PlanCallPhone planCallPhone = deque.pollFirst();
            if (Objects.nonNull(planCallPhone)) {
                log.info(planCallPhone.getPhone());
            }
        }
    }
}
