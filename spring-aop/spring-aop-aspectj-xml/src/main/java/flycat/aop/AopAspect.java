package flycat.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @FileName: <p>NotVeryUsefulAspect</p>
 * @Description: <p>测试每个调用的时间段</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-6</p>
 */

/**
 * before : 在调用方法之前调用
 * After : 在before执行后，方法体执行完成后，afterReturning和afterThrowing执行前。
 * AfterReturning ： 和afterThrowing执行的互斥的，当方法体执行完成并且没有抛出异常的时候执行
 * AfterThrowing : 和afterReturning执行的互斥的，当方法体执行完成并且有抛出异常的时候执行
 *
 * Around : 环绕是特殊的，它可以拦截该方法调用，还可以对执行的结果值进行处理，还可以选择是否抛出异常与否
 * ps ： Around的执行顺序也是特别的，它进入在before切点前面执行，因为它有可以选择是否执行该方法，
 * 但是方法体执行完成的后，它是在after切点的前面，因此，方法体内部是否处理异常会改变AfterReturning或者AfterThrowing两个，那个切点执行。
 */
public class AopAspect {

    public AopAspect() {
        System.out.println("初始化了！");
    }



    public void aspectBefore3(){
        System.out.println("代理对象的getName方法调用了！");
    }

    public void aspectBefore(){
        System.out.println("切面Before调用了!setName");
    }

    public void aspectBefore1(){
        System.out.println("切面Before调用了!setSex");
    }


    public void aspectSetName(){
        System.out.println("切面After调用了有异常的方法!");
    }
    public void aspectSetName1(){
        System.out.println("切面After调用了无异常的方法!");
    }


    public void aspectAfterReturning(){
        System.out.println("切面AfterReturning调用了有异常的方法!");
    }
    public void aspectAfterReturning1(){
        System.out.println("切面AfterReturning调用了无异常的方法!");
    }

    public void aspectAfterThrowing(){
        System.out.println("切面AfterThrowing调用了有异常的方法!");
    }

    public void aspectAfterThrowing1(){
        System.out.println("切面AfterThrowing调用了没有异常的方法!");
    }



    public Object aspectAround(ProceedingJoinPoint pjp, boolean name){
        Object[] obj = {name};
        System.out.println("切面Around调用了有异常的方法!");
        try {
            Object o = pjp.proceed(obj);
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("fasdfasdf");
            return null;
        }
    }

    public Object aspectAround1(ProceedingJoinPoint pjp, String name){
        Object[] obj = {name};
        System.out.println("切面Around调用了无异常的方法!");
        try {
            Object o = pjp.proceed(obj);
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("sdfasdfasd");
            return null;
        }
    }
}
