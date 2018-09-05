package flycat.service.impl;

import flycat.service.Cryptions;
import flycat.service.Decryption;
import flycat.service.Encryption;
import flycat.service.Password;
import flycat.utils.Hex;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;


/**
 * @FileName: <p>AESDecryption</p>
 * @Description: <p>加密解密操作的实现，加密算法AES</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 * <p>============================</p>
 * @Company: <p></p>
 * @Copyright: <p></p>
 *
 * <p>============================</p>
 */
@Component
public class AES implements Decryption, Encryption, BeanNameAware {


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
    public String decryption(String orgin, Key key) throws Exception{

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5padding");

        //解密
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] result = cipher.doFinal(Hex.hexString2Bytes(orgin));
        return new String(result);
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
    public Password encryption(String orgin) throws Exception {
        //生成key
        KeyGenerator keyGenerator = null;

        keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
        secureRandom.setSeed(orgin.getBytes());
        keyGenerator.init(secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] key1 = secretKey.getEncoded();

        //key转换为密钥
        Key key2 = new SecretKeySpec(key1, "AES");

        //加密
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5padding");
        cipher.init(Cipher.ENCRYPT_MODE, key2);
        byte[] result = cipher.doFinal(orgin.getBytes());
        Password password = new Password(Hex.bytes2HexString(result), key2);
        return password;
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
        Cryptions.AES = name;
    }
}
