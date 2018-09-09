package flycat.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @FileName: <p>LogCglibImpl</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-8</p>
 */
public class LogCglibImpl implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("这儿使用了cglib代理");
        return methodProxy.invokeSuper(o, objects);
    }
}
