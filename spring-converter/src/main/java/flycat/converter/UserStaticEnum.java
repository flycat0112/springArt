package flycat.converter;

/**
 * @FileName: <p>UserStaticEnum</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-24</p>
 */
public enum UserStaticEnum {
    LOGINING(0)
    ;
    private int value;

    UserStaticEnum(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
