package flycat.domain;


import org.springframework.stereotype.Component;

/**
 * @FileName: <p>LifecycleImpl</p>
 * @Description:
 * <p>这个使为了检测生命周期，对比SmartLifecycle的功能</p>
 * <p>SmartLifecycle是在容器ApplicationContent开启和结束的时候才会触发该功能</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-3</p>
 */


@Component
public class SmartLifecycleImplStopConcurrent extends SmartLifecycleImpl{

    public SmartLifecycleImplStopConcurrent() {

        this.phase = 3;
        System.out.println(this.getClass() + "对象创建了，phase=" + phase);
    }

    @Override
    /**
     * @Description <p> 该接口来自SmartLifecycle自己定义的方法 </p>
     * @FunName <p>stop</p>
     * @ProjectName <p> * <p>@Param {runnable}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-3</p>
     */
    public void stop(final Runnable runnable) {
        isRunning.compareAndSet(true, false);
        System.out.println(this.getClass() + "：回调函数执行前运行！，phase=" + phase);

        System.out.println(this.getClass() + "：回调函数执行完后运行！，phase=" + phase);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("并发执行");
                runnable.run();
            }
        });
        thread.start();
    }
}
