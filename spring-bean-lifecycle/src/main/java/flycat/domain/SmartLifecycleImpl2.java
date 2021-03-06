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
public class SmartLifecycleImpl2 extends SmartLifecycleImpl{

    public SmartLifecycleImpl2() {
        this.phase = 2;
        System.out.println(this.getClass() + "对象创建了，phase=" + phase);
    }
}
