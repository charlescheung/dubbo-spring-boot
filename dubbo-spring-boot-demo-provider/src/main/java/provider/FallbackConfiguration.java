package provider;

import com.alibaba.csp.sentinel.adapter.dubbo.config.DubboAdapterGlobalConfig;
import org.apache.dubbo.rpc.AsyncRpcResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zhangyiting
 * @Description:
 * @CreateDate: Created in 2024/6/18 17:41
 * @Version: 1.0
 */
@Configuration
public class FallbackConfiguration {

    @Bean
    public void registryCustomFallback() {
        DubboAdapterGlobalConfig.setProviderFallback(
                (invoker, invocation, ex) -> AsyncRpcResult.newDefaultAsyncResult(new RuntimeException("请求限流"), invocation));
    }

}
