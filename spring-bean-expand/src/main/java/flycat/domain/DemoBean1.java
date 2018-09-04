package flycat.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @FileName: <p>DemoBean1</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-3</p>
 * <p>============================</p>
 * @Company: <p></p>
 * @Copyright: <p></p>
 *
 * <p>============================</p>
 */
public class DemoBean1 extends SmartLifecycleImpl implements InitializingBean, DisposableBean {

    public DemoBean1() {
        this.phase = 5;
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
