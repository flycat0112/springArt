package flycat.core.aware;

import flycat.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Map;

/**
 * @FileName: <p>ApplicationContextAwareImpl</p>
 * @Description: <p>这儿使用ApplicationContextAware这个接口，所有Bean初始化完成的时候，读取容器里面所有单列的Bean</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-4</p>
 * <p>============================</p>
 * @Company: <p></p>
 * @Copyright: <p></p>
 *
 * <p>============================</p>
 */
@Component
public class ApplicationContextAwareImpl implements ApplicationContextAware , DecryptionProcessor, EncryptionProcessor {
    Logger logger = LoggerFactory.getLogger(ApplicationContextAwareImpl.class);
    private ApplicationContext applicationContext;
    private Map<String, Decryption> decryptionImpls;
    private Map<String, Encryption> encryptionImpls;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        decryptionImpls = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, Decryption.class);
        encryptionImpls = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, Encryption.class);

    }


    @Override
    /**
     * @Description <p> 通过传递的type值决定使用那种加密方式 </p>
     * @FunName <p>decryption</p>
     * @ProjectName <p> * <p>@Param {orgin}</p>
     * <p>@Param {type}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-5</p>
     */
    public Password encryption(String orgin, String type) throws Exception {
        Encryption encryption = encryptionImpls.get(type);
        return encryption.encryption(orgin);
    }

    @Override
    /**
     * @Description <p> 通过传递的type值决定使用那种解密方式 </p>
     * @FunName <p>decryption</p>
     * @ProjectName <p> * <p>@Param {orgin}</p>
     * <p>@Param {type}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-5</p>
     */

    public String decryption(String orgin, Key key, String type) throws Exception {
        Decryption decryption = decryptionImpls.get(type);
        return decryption.decryption(orgin, key);
    }
}
