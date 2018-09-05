package flycat.domain;

/**
 * @FileName: <p>DemoBean3</p>
 * @Description: <p>这个Bean通过FactoryBean接口的实现类实例化一个对象</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 */
public class DemoBean3 {

    public DemoBean3() {
        System.out.println(this.getClass() + "对象创建");
    }
}
