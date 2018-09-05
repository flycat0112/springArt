package flycat.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @FileName: <p>BeanPostProcessorImpl</p>
 *
 * @Description: <p> 接口提供方法有postProcessBeforeInitialization，postProcessAfterInitialization两个。
 *  他们做操作是针对所有容器中的对象，不是只是针对本对象。
 *  ps: before方法在@PostConstruct、InitializingBean接口、init-method的对象执行之前
 *  ，after在之后。源码调用顺序如下（是执行顺序从）：
 *  BeanNameAware
 *  BeanClassLoaderAware
 *  BeanFactoryAware
 *  applyBeanPostProcessorsBeforeInitialization
 *  invokeInitMethods
 *  applyBeanPostProcessorsAfterInitialization
 * </p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>

 */
@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.toString() + ",beanName:" + beanName + ":之前");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.toString() + ",beanName:" + beanName + "之后");
        return bean;
    }
}
