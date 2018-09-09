package flycat.aop;

import flycat.domain.IPersonOther;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * @FileName: <p>AopIntroductionImpl</p>
 * @Description: <p>这个接口实现了类功能增强，这儿增强了IPersonOther接口功能。</p>
 * @See AdvisorIntroductionImpl
 * @Author <p>flycat</p>
 * @Date <p>18-9-8</p>
 */
@Component
public class AopIntroductionImpl extends DelegatingIntroductionInterceptor implements IntroductionInterceptor, IPersonOther {

    @Override
    /**
     * @Description <p> 这儿通过通过拦截器的方式拦截需要增强的类的所有方法
     * ，使用的时候判断该方法是target的方法还是增强接口的方法 </p>
     * @FunName <p>invoke</p>
     * @ProjectName <p> </p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     */

    public Object invoke(MethodInvocation mi) throws Throwable {

        //判断当前执行的方法所属的接口是那个，如果是我们增强的接口，执行通过代理的方式执行
        if(implementsInterface(mi.getMethod().getDeclaringClass())){
            //这儿执行的this的方法
            return mi.getMethod().invoke(this, mi.getMethod().getParameters());
        }else {
            return mi.proceed(); //通过委托调用target的方法
        }
    }

    @Override
    /**
     * @Description <p> 判断执行的方法是否是实现接口里面的方法 </p>
     * @FunName <p>implementsInterface</p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-9</p>
     */

    public boolean implementsInterface(Class<?> intf) {
        return intf.isAssignableFrom(IPersonOther.class);
    }

    @Override
    /**
     * @Description <p> 对IPersonOther的接口实现</p>
     * @FunName <p>isBoli</p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     */
    public void isBoli() {
        System.out.println("hi，你是个玻璃！");
    }
}
