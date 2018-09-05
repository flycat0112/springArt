package flycat.service;

/**
 * @FileName: <p>EncryptionProcessor</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 */
public interface EncryptionProcessor{
    Password encryption(String orgin, String type) throws Exception;
}
