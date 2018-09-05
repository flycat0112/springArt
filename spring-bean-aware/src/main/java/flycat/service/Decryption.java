package flycat.service;

import java.security.Key;

/**
 * @Title: <p>Decryption</p>
 * @Description: <p></p>
 * @Company: <p></p>
 * @Author <p>zengqiang</p>
 * @Date <p>18-9-5</p>
 * <p>============================</p>
 * @Copyright <p>Information</p>
 *
 * <p>============================</p>
 */
public interface Decryption {

    String decryption(String orginj, Key key) throws Exception;
}
