package flycat.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @FileName: <p>AopBeforeAdvice</p>
 * @Description: <p>before切点增强</p>
 * @See spring-aop-aspectj
 * @Author <p>flycat</p>
 * @Date <p>18-9-8</p>
 */
@Component
public class AopBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before切点增强的方法调用了");
    }
}
