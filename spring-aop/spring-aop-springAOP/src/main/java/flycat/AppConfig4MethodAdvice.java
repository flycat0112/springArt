package flycat;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @FileName: <p>AppConfig</p>
 * @Description: <p>只加强特定方法的功能</p>
 * @See flycat.aop.AopAfterReturningAdvice
 * @See flycat.aop.AopAfterThrowingAdvice
 * @See flycat.aop.AopAroundAdvice
 * @See flycat.aop.AopBeforeAdvice
 * @Author <p>flycat</p>
 * @Date <p>18-9-8</p>
 */
@ImportResource(locations = "classpath:spring-aop-methedAdvice.xml")
public class AppConfig4MethodAdvice {
}
