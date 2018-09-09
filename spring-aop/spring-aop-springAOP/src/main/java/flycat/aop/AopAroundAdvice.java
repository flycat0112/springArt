package flycat.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @FileName: <p>AopAroundAdvice</p>
 * @Description: <p>环绕的实现，详细描述请看aspect的</p>
 * @See spring-aop-aspectj
 * @Author <p>flycat</p>
 * @Date <p>18-9-8</p>
 */
@Component
public class AopAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //这儿是环绕，可以选择是否执行目标对象的方法
        System.out.println("执行环绕方法了");
        Object obj = invocation.proceed();
        System.out.println("执行环绕方法完成");
        return obj;
    }

}
