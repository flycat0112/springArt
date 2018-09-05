package flycat.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @FileName: <p>DemoBean1</p>
 * @Description: <p>这个Bean为了和org.springframework.beans.factory.config.BeanPostProcessor接口验证他们的执行顺序。</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-3</p>
 */
@Component
public class DemoBean1  implements InitializingBean, DisposableBean {

    public DemoBean1() {
        System.out.println(this.getClass() + "构造了");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println(this.getClass() + "使用了注解@PostConstruct");
    }

    @PreDestroy
    public void preDestory(){
        System.out.println(this.getClass() + "使用了注解@PreDestroy");
    }

    @Override
    public void destroy(){
        System.out.println(this.getClass() + "使用接口DisposableBean");
    }

    @Override
    public void afterPropertiesSet(){
        System.out.println(this.getClass() + "使用接口InitializingBean");

    }

    public void init(){
        System.out.println(this.getClass() + "通过配置中Beans的default-init-method属性来进行配置的");
    }

    public void destory(){
        System.out.println(this.getClass() + "通过配置中Benas标签的default-destroy-method属性来进行配置");
    }
}
