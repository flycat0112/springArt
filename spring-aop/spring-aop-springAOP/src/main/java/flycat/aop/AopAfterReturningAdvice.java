package flycat.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @FileName: <p>AopAfterReturningAdvice</p>
 * @Description: <p>方法after时期功能增强</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-8</p>
 */
@Component
public class AopAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("afterReturning切点增强方法执行了");
    }
}
