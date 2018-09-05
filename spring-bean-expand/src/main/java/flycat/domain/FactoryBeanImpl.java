package flycat.domain;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @FileName: <p>FactoryBeanImpl</p>
 * @Description: <p>这儿我不希望容器自动给我创建对象，因为它的创建是复杂的
 * ，所以这儿我实现FactoryBean接口来创建</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 */
@Component
public class FactoryBeanImpl implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new DemoBean3();
    }

    @Override
    public Class<?> getObjectType() {
        return DemoBean3.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
