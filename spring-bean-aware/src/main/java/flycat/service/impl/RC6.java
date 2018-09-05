package flycat.service.impl;

import flycat.service.Cryptions;
import flycat.service.Decryption;
import flycat.service.Encryption;
import flycat.service.Password;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import java.security.Key;

/**
 * @FileName: <p>DecryptionImpl</p>
 * @Description: <p>加密解密操作的实现，加密算法RC6</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 * <p>============================</p>
 * @Company: <p></p>
 * @Copyright: <p></p>
 *
 * <p>============================</p>
 */
@Component
public class RC6  implements Decryption, Encryption, BeanNameAware {

    @Override
    /**
     * @Description <p> 解密 </p>
     * @FunName <p>decryption</p>
     * @ProjectName <p> * <p>@Param {}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-5</p>
     */
    public String decryption(String orgin, Key key) {
        System.out.println(this.getClass() + "decryption");
        return null;
    }

    @Override
    /**
     * @Description <p> 加密 </p>
     * @FunName <p>encryption</p>
     * @ProjectName <p> * <p>@Param {}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-5</p>
     */
    public Password encryption(String orgin) {
        System.out.println(this.getClass() + "encryption");
        return null;
    }

    private String beanName;
    @Override
    /**
     * @Description <p> 当该bean创建完成后，把该bean在容器里面对应的BeanName（key）传过来 </p>
     * @FunName <p>setBeanName</p>
     * @ProjectName <p> * <p>@Param {name}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-5</p>
     */

    public void setBeanName(String name) {
        this.beanName = name;
        Cryptions.RC6 = name;
    }
}
