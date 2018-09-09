package flycat;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @FileName: <p>AppConfig</p>
 * @Description: <p> 只加强特定的类的功能，需要Introduction </p>
 * @See flycat.aop.AopIntroductionImpl
 * @See flycat.aop.advisor.AdvisorIntroductionImpl
 * @Author <p>flycat</p>
 * @Date <p>18-9-8</p>
 */
@ImportResource(locations = "classpath:spring-aop-classAdvice.xml")
public class AppConfig4ClassAdvice {
}
