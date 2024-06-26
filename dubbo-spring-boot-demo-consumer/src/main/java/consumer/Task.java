package consumer;

import demo.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.protocol.tri.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author hyn
 * @version 1.0.0
 * @description
 * @date 2023/11/13
 */
@Component
public class Task implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(Task.class);

    @DubboReference
    private DemoService demoService;

    @Override
    public void run(String... args) throws Exception {
        String result = demoService.sayHello("world");
        System.out.println("Receive result ======> " + result);

        new Thread(()-> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(new Date() + " Receive result ======> " + demoService.sayHello("world"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //Thread.currentThread().interrupt();
                    logger.error(ExceptionUtils.getStackTrace(e));
                }catch (Exception e2){
                    logger.error(ExceptionUtils.getStackTrace(e2));
                }
            }
        }).start();
    }
}
