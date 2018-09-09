package flycat;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @FileName: <p>AppConfig</p>
 * @Description: <p>同时加强方法和类的功能</p>
 * @See flycat.aop.AopAfterReturningAdvice
 * @See flycat.aop.AopAfterThrowingAdvice
 * @See flycat.aop.AopAroundAdvice
 * @See flycat.aop.AopBeforeAdvice
 * @See flycat.aop.AopIntroductionImpl
 * @See flycat.aop.advisor.AdvisorIntroductionImpl
 * @Author <p>flycat</p>
 * @Date <p>18-9-8</p>
 */
@ImportResource(locations = "classpath:spring-aop-methedAndClassAdvice.xml")
public class AppConfig4ClassAndMethodAdvice {
}
