package flycat.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

import javax.annotation.ManagedBean;

/**
 * @FileName: <p>AopAspect1</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-7</p>
 */
@ManagedBean
@Aspect
public class AopAspect1  implements Ordered {

    @Pointcut("execution(* flycat.domain.IPerson.*(..))")
    public void executionFlag(){
    }


    @Pointcut("target(flycat.domain.IPersonOther)")
    public void targetFlag(){
    }

    @Pointcut("this(flycat.domain.IPersonOther)")
    public void thisFlag(){
    }

    @Before("executionFlag() && targetFlag()")
    public void getNameTarget(){
        System.out.println("该切点属于IPerson和IPersonOther并且是Target(目标对象)");
    }

    @Before("executionFlag() && thisFlag()")
    public void getNameThis(){
        System.out.println("该切点属于IPerson和IPersonOther并且是This(代理对象)");
    }
    @Before("targetFlag()")
    public void getNameTarget1(){
        System.out.println("该切点属于IPersonOther并且是Target（目标对象）");
    }

    @Before("thisFlag()")
    public void getNameThis1(){
        System.out.println("该切点属于IPersonOther并且是This（代理对象）");
    }


    @Override
    public int getOrder() {
        return 1;
    }
}
