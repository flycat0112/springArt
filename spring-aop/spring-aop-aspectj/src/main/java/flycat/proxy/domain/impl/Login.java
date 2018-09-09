package flycat.proxy.domain.impl;

import flycat.proxy.domain.ILogin;

/**
 * @FileName: <p>Login</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-8</p>
 */
public class Login implements ILogin {
    @Override
    public void validateUserSatus() {
        System.out.println("验证通过");
    }
}
