package flycat;


import flycat.proxy.cglib.LogCglibImpl;
import flycat.proxy.domain.ILogin;
import flycat.proxy.domain.impl.Login;
import flycat.proxy.jdk.LogJdkImpl;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    /**
     * @Description <p> </p>
     * @FunName <p>cglibTest</p>
     * @ProjectName <p>实验cglib实现代理，加强类的功能</p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-8</p>
     */

    public void cglibTest()
    {
        ILogin login = new Login();
        LogCglibImpl logCglib = new LogCglibImpl();
        ILogin login1 = (ILogin) logCglib.getInstance(login);
        login1.validateUserSatus();
    }


    @Test
    /**
     * @Description <p> 通过jdk的代理实现功能加强。 </p>
     * @FunName <p>jdkTest</p>
     * @ProjectName <p> * <p>@Param {}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-8</p>
     */

    public void jdkTest()
    {
        ILogin login = LogJdkImpl.getProxy(ILogin.class, Login.class);
        login.validateUserSatus();
    }
}
