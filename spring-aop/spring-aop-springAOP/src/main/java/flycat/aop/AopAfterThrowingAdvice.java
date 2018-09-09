package flycat.aop;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.lang.reflect.Method;

/**
 * @FileName: <p>AopAfterThrowingAdvice</p>
 * @Description: <p>方法异常时期功能增强</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-8</p>
 */
@Component
public class AopAfterThrowingAdvice implements ThrowsAdvice {

    public void afterThrowing(Method m, Object[] args, Object target, ServletException ex) {
        System.out.println("throwing切点增强发生异常了");
    }
}
