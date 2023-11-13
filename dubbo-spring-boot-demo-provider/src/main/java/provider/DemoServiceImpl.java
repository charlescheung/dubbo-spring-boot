package provider;

import demo.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author hyn
 * @version 1.0.0
 * @description 服务实现类
 * @date 2023/11/13
 */
@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "hello" + name;
    }
}
