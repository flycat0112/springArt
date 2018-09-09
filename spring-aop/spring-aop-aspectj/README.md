该内容来子csdn博客内容：
<url>https://blog.csdn.net/zq1994520/article/details/82498615</url>

1) 在spring中开启AspectJ

在@Configuration配置中添加@EnableAutoConfiguration注解开启。

@Configuration
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@ComponentScan
public class App
{
    public static void main(String... args) {
        SpringApplication.run(App.class, args);
    }

}

[点击并拖拽以移动]

2) 声明切入类：

在类上面使用@Aspect注解。

3) 定义切入点：（通用的advice切入点定义，自己只能被advice来触发，自己单独不能存在）

在无参方法上面标记@Pointcut注解。

4) 定义advice：（可以使用已经定义好的切入点对象，也可以直接写表达式）

注解有:

   @Before       在调用方法之前调用

   @After             在before执行后，方法体执行完成后，afterReturning和afterThrowing执行前。

   @AfterReturning           和afterThrowing执行的互斥的，当方法体执行完成并且没有抛出异常的时候执行

   @AfterThrowing           和afterReturning执行的互斥的，当方法体执行完成并且有抛出异常的时候执行

   @Around             环绕是特殊的，它可以拦截该方法调用，还可以对执行的结果值进行处理，还可以选择是否抛出异常与否

ps : Around的执行顺序也是特别的，它进入在before切点前面执行，因为它有可以选择是否执行该方法，  *但是方法体执行完成的后，它是在after切点的前面，因此，方法体内部是否处理异常会改变AfterReturning或者AfterThrowing两个，那个切点执行。

 实例Demo部分代码：

IPerson.java

public interface IPerson {

    String getName();

    void setName(String name);

    boolean isSex();

    void  setSex(boolean sex);
}

Person.java


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

AopAspect.java


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
@ManagedBean
@Aspect
public class AopAspect {

    public AopAspect() {
        System.out.println("初始化了！");
    }

    @Pointcut("execution(* flycat.domain.IPerson.getName(*))")
    public void getName(){
    }
    @Pointcut("execution(* flycat.domain.Person.setName(*))")
    public void setName(){

    }
    @Pointcut("execution(* flycat.domain.Person.setSex(*))")
    public void setSex(){
    }

    @Before("getName()")
    public void aspectBefore3(){
        System.out.println("代理对象的getName方法调用了！");
    }

    @Before("setName()")
    public void aspectBefore(){
        System.out.println("切面Before调用了!setName");
    }

    @Before("setSex()")
    public void aspectBefore1(){
        System.out.println("切面Before调用了!setSex");
    }

    @AfterReturning("setSex()")
    public void aspectAfterReturning(){
        System.out.println("切面AfterReturning调用了有异常的方法!");
    }
    @AfterReturning("setName()")
    public void aspectAfterReturning1(){
        System.out.println("切面AfterReturning调用了无异常的方法!");
    }

    @AfterThrowing("setSex()")
    public void aspectAfterThrowing(){
        System.out.println("切面AfterThrowing调用了有异常的方法!");
    }

    @AfterThrowing("setName()")
    public void aspectAfterThrowing1(){
        System.out.println("切面AfterThrowing调用了没有异常的方法!");
    }

    @After("setSex()")
    public void aspectSetName(){
        System.out.println("切面After调用了有异常的方法!");
    }
    @After("setName()")
    public void aspectSetName1(){
        System.out.println("切面After调用了无异常的方法!");
    }


    @Around("setSex() && args(name,..) && target(flycat.domain.IPerson) && this(flycat.domain.IPerson)")
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

    @Around(value = "setName() && args(name,..) && target(flycat.domain.IPersonOther) && this(flycat.domain.IPerson)")
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

[点击并拖拽以移动]

5)  Spring AOP支持以下AspectJ切入点指示符（PCD）用于切入点表达式：

execution :     对于匹配方法执行连接点，这是您在使用Spring AOP时将使用的主要切入点指示符

within :       限制匹配某些类型中的连接点（只是在使用Spring AOP时执行在匹配类型中声明的方法）

this :     限制匹配连接点（使用Spring AOP时执行方法），其中bean引用（Spring AOP代理）是给定类型的实例，(表示生成的代理对象)

target :    限制匹配到连接点（使用Spring AOP时执行方法），其中目标对象（被代理的应用程序对象）是给定类型的实例（表示原目标对象）
args :     限制匹配连接点（使用Spring AOP时执行方法），其中参数是给定类型的实例

@target :  限制匹配连接点（使用Spring AOP时执行方法），其中执行对象的类具有给定类型的注释

@args :   限制匹配到连接点（使用Spring AOP时执行方法），其中传递的实际参数的运行时类型具有给定类型的注释

@within :  限制匹配以连接具有给定注释的类型中的点（使用Spring AOP时在具有给定注释的类型中声明的方法的执行）

@annotation : 限制匹配到连接点的主题，其中连接点的主题（在Spring AOP中执行的方法）具有给定的注释


ps :

1、代理目标内部方法调用是无法感知的,有时候我们需要内部方法调用代理对象能够感知，可以通过从AopContext中获取代理对象的上下文获取当强的代理对象来调用相应的方法。其实就是内部调用不会经过代理对象，通过AopContext获取代理对象就是让内部调用经过代理对象，虽然这样设计性能下降，但是代码维护很好。这儿需要注意,设置允许暴露代理对象，可以让AopContext获取。@EnableAspectJAutoProxy(exposeProxy = true)

2、target和this分别表示“目标对象”和“代理对象”，他们的功能只是为了限制匹配的对象，想要体现出他们的不同必须要目标对象是通过代理织入另一个接口，不能是简单的实现。

通过代理的demo代码：(从上面新增的类)

IPersonOther.java

/**
 * @Title: <p>IPersonOther</p>
 * @Description: <p>这个来区别target和this的区别</p>
 * @Company: <p></p>
 * @Author <p>zengqiang</p>
 * @Date <p>18-9-7</p>
 */
public interface IPersonOther {
    void isBoli();
}

[点击并拖拽以移动]

PersonOther.java

/**
 * @FileName: <p>PersonOther</p>
 * @Description: <p>这个来区别target和this的区别,</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-7</p>
 */
public class PersonOther implements IPersonOther{
    @Override
    public void isBoli() {
        System.out.println("使用了isBoli方法，你是玻璃！");
    }
}

AddPersonOtherForPersonAspect.java


/**
 * @FileName: <p>AddPersonOtherForPersonAspect</p>
 * @Description: <p>通过代理的方式方Person实现IPersonOther接口,这儿是为了区别target和this</p>
 * <p> 因为这儿是通过代理的方式，target代表的是目标,这儿的目标代表的是IPersonOther接口，所以target就会把它过滤掉
 * ，this代表的代理对象，属于IPersonOther和IPerson两个接口的结合，所以this就不会被过滤掉 </p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-7</p>
 */
@ManagedBean
@Aspect
public class AddPersonOtherForPersonAspect implements Ordered {
    @DeclareParents(value = "flycat.domain.Person", defaultImpl = PersonOther.class)
    IPersonOther iPersonOther;

    @Override
    public int getOrder() {
        return 2;
    }
}

AopAspect1.java

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

PerformanceAction.java

@RestController
@RequestMapping("/springArt")
@RequestScope
public class PerformanceAction {

    @Inject
    IPerson person;

    @GetMapping(value = "/{id}")
    public ModelAndView performance(@PathVariable("id") String id){
        person.setName(id);
        person.setSex(true);// 这儿第一次执行传入false就会发生错误，传入true不会发生错误
        person.getName();
        ((IPersonOther)person).isBoli();  //用来测试target和this的区别(target会有表现，会拦截，this却不会)
        return new ModelAndView("index");
    }

}

最后执行完打印信息是：


该切点属于IPerson和IPersonOther并且是This(代理对象)
该切点属于IPersonOther并且是This（代理对象）
执行了setName
该切点属于IPerson和IPersonOther并且是This(代理对象)
该切点属于IPersonOther并且是This（代理对象）
该切点属于IPerson和IPersonOther并且是This(代理对象)
该切点属于IPersonOther并且是This（代理对象）
执行了isSex
执行了setSex
该切点属于IPerson和IPersonOther并且是This(代理对象)
该切点属于IPersonOther并且是This（代理对象）
执行了getName
该切点属于IPersonOther并且是Target（目标对象）
该切点属于IPersonOther并且是This（代理对象）
使用了isBoli方法，你是玻璃！

结论： 通过代理的方式实现IPerson接口，
并且target代表的是目标,这儿的目标代表的是IPersonOther接口，
由@DeclareParents注释下方变量声明，
本列子是IPersonOther, 
所以target就会把它过滤掉，
this代表的代理对象，
属于IPersonOther和IPerson两个接口的结合，
所以this就不会被过滤掉 。