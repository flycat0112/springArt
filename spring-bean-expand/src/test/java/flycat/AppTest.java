package flycat;

import flycat.domain.DemoBean2;
import flycat.domain.DemoBean3;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    /**
     * @Description <p> 这儿验证org.springframework.beans.factory.config.BeanPostProcessor接口的功能
     * 和org.springframework.beans.factory.FactoryBean接口
     * 和org.springframework.beans.factory.config.BeanFactoryPostProcessor接口的功能 </p>
     * @FunName <p>factoryBeanTest</p>
     * @ProjectName <p> * <p>@Param {}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-5</p>
     */
    public void factoryBeanTest()
    {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.registerShutdownHook();
        System.out.println(context.getBean(DemoBean2.class).getName());
        DemoBean3 demoBean3 = context.getBean(DemoBean3.class);
    }
}
