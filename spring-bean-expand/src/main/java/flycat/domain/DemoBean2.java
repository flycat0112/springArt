package flycat.domain;

import org.springframework.stereotype.Component;

/**
 * @FileName: <p>DemoBean2</p>
 * @Description: <p>用来测试org.springframework.beans.factory.config.BeanFactoryPostProcessor接口的Bean</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 */
@Component
public class DemoBean2 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
