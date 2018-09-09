package flycat.aop.advisor;

import flycat.aop.AopIntroductionImpl;
import flycat.domain.IPerson;
import flycat.domain.IPersonOther;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * @FileName: <p>AdvisorIntroductionImpl</p>
 * @Description: <p>想要对类的功能进行增强，必须是使用IntroductionAdvisor，对类的切面集性筛选</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-9</p>
 */
public class AdvisorIntroductionImpl extends DefaultIntroductionAdvisor {


    @Override
    /**
     * @Description <p> 默认的引言切面实现，
     * matches匹配的所有类，在web环境中会出问题，这儿需要对要加强的类对象进行筛选 </p>
     * @FunName <p>matches</p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     */

    public boolean matches(Class<?> clazz) {

        if(IPerson.class.isAssignableFrom(clazz)
                || IPersonOther.class.isAssignableFrom(clazz)){
            return super.matches(clazz);  //父类总是放回true。
        }else {
            return false;
        }
    }

    public AdvisorIntroductionImpl(AopIntroductionImpl aopIntroduction) {
        super(aopIntroduction, IPersonOther.class);
    }
}
