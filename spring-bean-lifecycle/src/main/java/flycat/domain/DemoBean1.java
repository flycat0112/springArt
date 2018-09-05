package flycat.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @FileName: <p>DemoBean1</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-3</p>
 */
@Component
public class DemoBean1 extends SmartLifecycleImpl implements InitializingBean, DisposableBean {

    public DemoBean1() {
        this.phase = 4;
        System.out.println(this.getClass() + "对象创建了，phase=" + phase);
    }


    @PostConstruct
    public void postConstruct(){
        System.out.println(this.getClass() + "使用了注解@PostConstruct，phase=" + phase);
    }

    @PreDestroy
    public void preDestory(){
        System.out.println(this.getClass() + "使用了注解@PreDestroy，phase=" + phase);
    }

    @Override
    public void destroy(){
        System.out.println(this.getClass() + "使用接口DisposableBean，phase=" + phase);
    }

    @Override
    public void afterPropertiesSet(){
        System.out.println(this.getClass() + "使用接口InitializingBean，phase=" + phase);

    }

    public void init(){
        System.out.println(this.getClass() + "通过配置中Beans的default-init-method属性来进行配置的，phase=" + phase);
    }

    public void destory(){
        System.out.println(this.getClass() + "通过配置中Benas标签的default-destroy-method属性来进行配置，phase=" + phase);
    }
}
