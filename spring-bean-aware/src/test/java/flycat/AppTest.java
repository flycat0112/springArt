package flycat;

import static org.junit.Assert.assertTrue;

import flycat.core.aware.ApplicationContextAwareImpl;
import flycat.service.Cryptions;
import flycat.service.Password;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    Logger logger = LoggerFactory.getLogger(AppTest.class);
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        String password = "123456789";
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("spring-smartLifecycleTest.xml");
        context.registerShutdownHook();
        ApplicationContextAwareImpl impl= context.getBean(ApplicationContextAwareImpl.class);
        try {
            Password newPasswor = impl.encryption(password, Cryptions.AES);
            logger.info("加密结果：" + newPasswor.getPassword());
            logger.info("解密结果：" + impl.decryption(newPasswor.getPassword(), newPasswor.getKey(),  Cryptions.AES));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
