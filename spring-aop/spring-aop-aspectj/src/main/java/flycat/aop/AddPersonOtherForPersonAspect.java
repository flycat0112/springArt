package flycat.aop;

import flycat.domain.IPersonOther;
import flycat.domain.PersonOther;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.Ordered;

import javax.annotation.ManagedBean;

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
