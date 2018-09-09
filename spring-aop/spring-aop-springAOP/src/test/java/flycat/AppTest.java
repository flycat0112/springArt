package flycat;

import static org.junit.Assert.assertTrue;

import flycat.domain.IPerson;
import flycat.domain.IPersonOther;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigRegistry;

/**
 * spring aop只能通过配置文件的方式
 */
public class AppTest 
{

    @Test
    public void springAopTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext (App.class);
        IPersonOther obj = (IPersonOther)context.getBean("person");
        IPerson ob = (IPerson)obj;
        ob.getName();
        obj.isBoli();
    }

    @Test
    /**
     * @Description <p> 加强类的测试</p>
     * @FunName <p>springAopClassMethodAdviceTest</p>
     * @See flycat.aop.AopIntroductionImpl
     * @See flycat.aop.advisor.AdvisorIntroductionImpl
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-9</p>
     */
    public void springAopClassAdviceTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (App.class, AppConfig4ClassAdvice.class);
        //加入配置文件
        IPersonOther obj = (IPersonOther)context.getBean("person");
        obj.isBoli();
    }
    @Test
    /**
     * @Description <p>  加强方法的测试</p>
     * @FunName <p>springAopClassMethodAdviceTest</p>
     * @See flycat.aop.AopAfterReturningAdvice
     * @See flycat.aop.AopAfterThrowingAdvice
     * @See flycat.aop.AopAroundAdvice
     * @See flycat.aop.AopBeforeAdvice
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-9</p>
     */
    public void springAopMethodAdviceTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (App.class, AppConfig4MethodAdvice.class);
        //加入配置文件
        IPerson obj = (IPerson)context.getBean("person");
        obj.getName();
    }

    @Test
    /**
     * @Description <p> 同时加强类和方法的测试 </p>
     * @FunName <p>springAopClassMethodAdviceTest</p>
     * @See flycat.aop.AopAfterReturningAdvice
     * @See flycat.aop.AopAfterThrowingAdvice
     * @See flycat.aop.AopAroundAdvice
     * @See flycat.aop.AopBeforeAdvice
     * @See flycat.aop.AopIntroductionImpl
     * @See flycat.aop.advisor.AdvisorIntroductionImpl
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-9</p>
     */
    public void springAopClassMethodAdviceTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (App.class,AppConfig4ClassAndMethodAdvice.class);
        //加入配置文件
        IPerson obj = (IPerson)context.getBean("person");
        obj.getName();
        IPersonOther iPersonOther = (IPersonOther) obj;
        iPersonOther.isBoli();
    }

}
