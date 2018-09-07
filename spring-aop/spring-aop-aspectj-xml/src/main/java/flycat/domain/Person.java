package flycat.domain;

import org.springframework.aop.framework.AopContext;

import javax.annotation.ManagedBean;

/**
 * @FileName: <p>Person</p>
 * @Description: <p>IPerson接口的实现</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-7</p>
 */
@ManagedBean
public class Person implements IPerson{
    private String name;
    private boolean sex;


    @Override
    public String getName() {
        System.out.println("执行了getName");
        return this.name;
    }
    @Override
    public void setName(String name) {
        System.out.println("执行了setName");
        this.name = name;
    }
    @Override
    public boolean isSex() {

        System.out.println("执行了isSex");
        return sex;
    }


    @Override
    public void setSex(boolean sex) {
        //判断当强值是否和设置值相同，如果相同抛出异常
        //代理目标内部方法调用是无法感知的
        //通过从AopContext中获取代理对象的上下文获取当强的代理对象来调用isSex方法。
        //这儿需要注意,设置允许暴露代理对象，可以让AopContext获取。@EnableAspectJAutoProxy(exposeProxy = true)
        if(null != AopContext.currentProxy()
                && sex == ((Person)AopContext.currentProxy()).isSex()){
            throw new RuntimeException("值已经存在！");
        }
        this.sex = sex;
        System.out.println("执行了setSex");
    }

}
