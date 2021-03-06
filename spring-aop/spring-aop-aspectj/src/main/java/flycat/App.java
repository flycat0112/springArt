package flycat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@EnableAutoConfiguration
@EnableLoadTimeWeaving
@ComponentScan
public class App
{
    public static void main(String... args) {
        SpringApplication.run(App.class, args);
    }

}
