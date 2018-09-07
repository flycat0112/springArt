package flycat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App
{
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        SpringApplication.run(App.class, args);

    }

}
