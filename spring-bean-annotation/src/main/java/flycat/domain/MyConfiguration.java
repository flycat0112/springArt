package flycat.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @FileName: <p>MyConfiguration</p>
 * @Description: <p>通过方法里面@Bean注解向容器里面放入对象。</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 */
@Component
public class MyConfiguration {
    @org.springframework.context.annotation.Bean
    public Store<String> stringStore() {
        return new Store<String>();
    }

    @org.springframework.context.annotation.Bean
    public Store<Integer> integerStore() {
        return new Store<Integer>();
    }
}
