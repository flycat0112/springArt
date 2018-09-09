该内容来子csdn博客内容：
<url>https://blog.csdn.net/zq1994520/article/details/82498615</url>
1）spring aop方式

aspectj的@DeclareParents注解可以让代码非侵入式的方式扩展类的方法，而spring AOP提供的是通过IntroductionAdvisor设置那些需要功能增强，保存IntroductionInterceptor的实现（里面理解调用的时候有个“拦截器”，该拦截器判断当前调用的方法是否是增强的接口的方法，调用代理的方法，如果不是，通过委托调用目标类的方法。）

pointcut    切点（通常针对的对象是方法级别的）

advice  增强（就会对原有的功能进行添加）,如果事实应用中没有和pointcut进行绑定，相当于拦截器的作用。

advisor   代表的切面（里面包含一个advice）

Interceptor   拦截器 （源代码里面继承自advice）


advisor中有IntroductionAdvisor和PointcutAdvisor两种。

IntroductionAdvisor 针对的是对类里面的功能增强，通过接口在类中增加方法，但是它是通过advice隐士增强的，不是通过cglib，而是jdk的代理实现，原有的类没有发生改变。想要实现需要和IntroductionInterceptor配合使用。

PointcutAdvisor  切点增强，主要是针对的方法级别，该接口继承advisor，另外多了pointcut方法，一个PointcutAdvisor里面只有一个pointcut和一个advice。pointcut是为了筛选那些类，那些方法。advice里面有around，before，afterReturn，afterThrowing表示侵入方法那个位置。

ps：spring aop中和around环绕通过MethodInterceptor实现，aspectj中afterThrowing在spring aop中是ThrowsAdvice是不同的，它的接口没有定义一个方法，但是spring源码里面是通过反射会调用，你必须手动打这些方法。after么

afterThrowing([Method, args, target], subclassOfThrowable)


