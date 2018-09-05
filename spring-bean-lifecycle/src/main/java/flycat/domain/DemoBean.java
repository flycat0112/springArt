package flycat.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @FileName: <p>DemoBean</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-4</p>
 */
@Service
@Scope("prototype")
public class DemoBean extends SmartLifecycleImpl {

    @PostConstruct
    public void postConstruct(){
        System.out.println(this.getClass() + "使用了注解@PostConstruct，phase=" + phase);
    }

    @PreDestroy
    public void preDestory(){
        System.out.println(this.getClass() + "使用了注解@PreDestroy，phase=" + phase);
    }

}
