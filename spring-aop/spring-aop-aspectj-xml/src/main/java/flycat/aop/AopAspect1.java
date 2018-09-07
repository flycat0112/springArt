package flycat.aop;

import org.springframework.core.Ordered;

import javax.annotation.ManagedBean;

/**
 * @FileName: <p>AopAspect1</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-7</p>
 */
public class AopAspect1 implements Ordered{

    private int order;

    public void getNameTarget(){
        System.out.println("该切点属于IPerson和IPersonOther并且是Target(目标对象)");
    }

    public void getNameThis(){
        System.out.println("该切点属于IPerson和IPersonOther并且是This(代理对象)");
    }
    public void getNameTarget1(){
        System.out.println("该切点属于IPersonOther并且是Target（目标对象）");
    }

    public void getNameThis1(){
        System.out.println("该切点属于IPersonOther并且是This（代理对象）");
    }


    @Override
    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
