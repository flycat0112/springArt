package flycat.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @FileName: <p>BeanFactoryPostProcessorImpl</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 */
@Component
public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {

    private static String reg = "^\\$\\{(\\S+)\\}$";
    private static String  configProperties = "config.properties";


    @SuppressWarnings("rawtypes")
    @Nullable
    protected String getValue(@Nullable Object value) {
        if (value instanceof TypedStringValue) {
            TypedStringValue typedStringValue = (TypedStringValue) value;
            String stringValue = typedStringValue.getValue();
            return stringValue;
        }
        else if (value instanceof String) {
            return (String) value;
        }
        return (String) value;
    }
    @Override
    /**
     * @Description <p> 通过beanFactory对象可以修改从配置文件里面读取出来的bean配置信息，它是一个bean容器。 </p>
     * @FunName <p>postProcessBeanFactory</p>
     * @ProjectName <p> @Param {beanFactory：保存了实例化bean的所有配置信息}</p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-5</p>
     */
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //读取参数文件
        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(configProperties), "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] strings = beanFactory.getBeanDefinitionNames();
        for (String curBeanName : strings){
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(curBeanName);
            MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
            List<PropertyValue> propertyValueList = mutablePropertyValues.getPropertyValueList();
            for(PropertyValue propertyValue : propertyValueList){
                String className = getValue( propertyValue.getValue()); // 这儿获取的值有许多类型，需要单独每个进行处理，我着这儿简单处理。
                Pattern pattern = Pattern.compile(reg);
                Matcher matcher = pattern.matcher(className);
                //获取${}里面的值

                if(matcher.find()){
                    className = matcher.group(1);
                    System.out.println("className:" + className);

                    for(String proName : properties.stringPropertyNames()){

                        if(proName!= null &&
                                (proName == className || proName.equals(className))){
                            //如果和上面的属性值相等，就替换该值
                            mutablePropertyValues.add(propertyValue.getName(), properties.getProperty(proName));
                        }
                    }
                }else {
                    continue;
                }
            }
        }
        System.out.println("BeanFactory结束");
    }
}
