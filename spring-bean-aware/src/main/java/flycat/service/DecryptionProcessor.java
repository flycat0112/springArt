package flycat.service;

import java.security.Key;

/**
 * @FileName: <p>DecryptionProcessor</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 */
public interface DecryptionProcessor{
    String decryption(String orgin, Key key, String type) throws Exception;
}
