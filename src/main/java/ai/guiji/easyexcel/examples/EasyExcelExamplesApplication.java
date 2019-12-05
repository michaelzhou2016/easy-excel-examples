package ai.guiji.easyexcel.examples;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "ai.guiji.easyexcel.examples.mapper")
@SpringBootApplication
public class EasyExcelExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyExcelExamplesApplication.class, args);
    }

}
