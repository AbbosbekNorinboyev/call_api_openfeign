package uz.pdp.call_api_openfeign_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CallApiRestTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallApiRestTemplateApplication.class, args);
    }
}
