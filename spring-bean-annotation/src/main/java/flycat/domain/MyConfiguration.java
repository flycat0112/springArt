package flycat.domain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @FileName: <p>MyConfiguration</p>
 * @Description: <p>通过方法里面@Bean注解向容器里面放入对象。</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 */
@Configuration
public class MyConfiguration {
    @org.springframework.context.annotation.Bean(name = "stringStore")
    @DependsOn(value = "integerStore")
    public Store<String> stringStore() {
        System.out.println("stringStore创建完成！");
        return new Store<String>();
    }

    @org.springframework.context.annotation.Bean(name = "integerStore")
    public Store<Integer> integerStore() {
        System.out.println("integerStore创建完成！");
        return new Store<Integer>();
    }
}
