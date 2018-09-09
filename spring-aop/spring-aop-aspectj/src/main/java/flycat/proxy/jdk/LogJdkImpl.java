package flycat.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @FileName: <p>LogProxyImpl</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-8</p>
 */
public class LogJdkImpl {


    public static void before(){
        System.out.println("代理前");
    }

    public static void after(){
        System.out.println("代理后");
    }

    public static <T> T getProxy(final Class<T> serviceInterface, Class<? extends T> u){
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class[]{serviceInterface},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        before();
                        Object obj = method.invoke(u.getConstructor().newInstance(), args);
                        after();
                        return obj;
                    }
                });
    }

}
