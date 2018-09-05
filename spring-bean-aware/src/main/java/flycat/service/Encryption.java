package flycat.service;

/**
 * @Title: <p>Encryption</p>
 * @Description: <p></p>
 * @Company: <p></p>
 * @Author <p>zengqiang</p>
 * @Date <p>18-9-5</p>
 * <p>============================</p>
 * @Copyright <p>Information</p>
 *
 * <p>============================</p>
 */
public interface Encryption {
    Password encryption(String orgin) throws Exception;
}
