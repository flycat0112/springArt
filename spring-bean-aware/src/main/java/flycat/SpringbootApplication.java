package flycat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Unit test for simple App.
 */
@SpringBootApplication
public class SpringbootApplication
{
    /**
     * @Description <p> 这儿进行验证smartLIfecycle接口，只有ApplicationContext启动或者关闭的时候才会调用 </p>
     * @FunName <p>smartLifeCycleTest</p>
     * @ProjectName <p> * <p>@Param {}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-4</p>
     */
    public static void main(String... args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
