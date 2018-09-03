package flycat.domain;

import org.springframework.context.SmartLifecycle;

/**
 * @FileName: <p>LifecycleImpl</p>
 * @Description:
 * <p>这个使为了检测生命周期，对比SmartLifecycle的功能</p>
 * <p>SmartLifecycle是在容器ApplicationContent开启和结束的时候才会触发该功能</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-3</p>
 */
public class SmartLifecycleImpl implements SmartLifecycle {
    protected int phase = 0;

    public SmartLifecycleImpl() {
        this.phase = 1;
    }

    @Override
    /**
     * @Description <p> 设置是否手动启动Bean，如果使false表示手动启动 </p>
     * @FunName <p>isAutoStartup</p>
     * @ProjectName <p> * <p>@Param {}</p></p>
     * <p>==============================</p>
     * @Author <p>zengqiang</p>
     * @Create <p>18-9-3</p>
     */
    public boolean isAutoStartup() {
        return false;
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
    public void stop(Runnable runnable) {
        System.out.println(this.getClass() + "：回调函数执行前运行！");
        runnable.run();
        System.out.println(this.getClass() + "：回调函数执行完后运行！");
    }

    @Override
    /**
     * @Description <p> 这个方法来自Lifecycle父接口 </p>
     * @FunName <p>start</p>
     * @ProjectName <p> * <p>@Param {}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-3</p>
     */
    public void start() {
        System.out.println(this.getClass() + "：Lifecycle接口方法start方法调用开始");
    }

    @Override
    /**
     * @Description <p> </p>
     * @FunName <p>stop</p>
     * @ProjectName <p> * <p>@Param {}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-3</p>
     */
    
    public void stop() {
        System.out.println(this.getClass() + ":Lifecycle接口方法stop方法调用停止");
    }

    @Override
    /**
     * @Description <p>判断当前bean是否在运行中的状态 </p>
     * @FunName <p>isRunning</p>
     * @ProjectName <p> * <p>@Param {}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-3</p>
     */
    public boolean isRunning() {
        System.out.println(this.getClass() + "：Lifecycle接口方法isRunning");
        return false;
    }

    @Override
    /**
     * @Description <p> 通过该方法来判断所有实现SmartLifecycle接口的类，
     * 调用start方法的先后和调用stop方法的先后，值越小，start越最先 </p>
     * @FunName <p>getPhase</p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-3</p>
     */
    public int getPhase() {
        System.out.println(this.getClass() + ": Phased接口的方法，返回的值是" + phase);
        return phase;
    }
}
