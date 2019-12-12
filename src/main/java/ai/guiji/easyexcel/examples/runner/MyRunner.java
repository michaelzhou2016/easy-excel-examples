package ai.guiji.easyexcel.examples.runner;

import ai.guiji.easyexcel.examples.service.ImportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * author: zhouliliang
 * Date: 2019/12/6 15:38
 * Description:
 */
@Slf4j
@Component
public class MyRunner implements ApplicationRunner {
    @Autowired
    private ImportService importService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        new Thread(() -> {
            importService.consumerImportPlanBatch();
        }).start();
    }
}
