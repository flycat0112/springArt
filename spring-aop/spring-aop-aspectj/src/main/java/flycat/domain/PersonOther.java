package flycat.domain;

/**
 * @FileName: <p>PersonOther</p>
 * @Description: <p>这个来区别target和this的区别,</p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-7</p>
 */
public class PersonOther implements IPersonOther{
    @Override
    public void isBoli() {
        System.out.println("使用了isBoli方法，你是玻璃！");
    }
}
