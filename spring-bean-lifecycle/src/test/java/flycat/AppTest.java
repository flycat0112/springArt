package flycat;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{


    @Test
    public void smartLifecycleTest()
    {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring-smartLifecycleTest.xml");
        context.registerShutdownHook();
    }
}
