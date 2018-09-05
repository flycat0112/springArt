package flycat.utils;

/**
 * @FileName: <p>Hex</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 */
public class Hex {

    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static char[] bytes2HexChars(byte[] bytes){
        char[] buf = new char[bytes.length * 2];
        int index = 0;
        for(byte b : bytes) { // 利用位运算进行转换，可以看作方法一的变种
            buf[index++] = HEX_CHAR[b & 0xf];
            buf[index++] = HEX_CHAR[b >> 4 & 0xf];
        }
        return buf;
    }

    public static String bytes2HexString(byte[] bytes){
        return new String(bytes2HexChars(bytes));
    }

    /**
     * @Description <p> 将16进制的字符数组转换成对应的byte数组 </p>
     * @FunName <p></p>
     * @ProjectName <p> * <p>@Param {null}</p></p>
     * @Exception <p> </p>
     * @Return <p>{}</p>
     * <p>==============================</p>
     * @Author <p>flycat</p>
     * @Create <p>18-9-5</p>
     */

    public static byte[] hexChars2Bytes(char[] orgins){
        int ocl = orgins.length, bl = ocl / 2 + (ocl % 2 != 0 ? 1 : 0);
        byte[] bytes = new byte[bl];

        //单数的字符数组转换成byte的时候，最后一个高4位需要0填充
        if(ocl % 2 != 0){
            ocl--;
            bytes[--bl] = (byte) 0;
        }
        for(int val;ocl > 0;){
            if(ocl%2 == 0){
                if(orgins[--ocl] >=  '0' && orgins[ocl] <= '9'){
                    val = (orgins[ocl] - '0');
                } else if(orgins[ocl] >= 'a' && orgins[ocl] <= 'f'){
                    val = (orgins[ocl] - 'a')  + 10;
                } else if(orgins[ocl] >= 'A' && orgins[ocl] <= 'F'){
                    val = (orgins[ocl] - 'A')  + 10;
                } else {
                    throw  new RuntimeException("传入字符不在16进制范围内");
                }
                bytes[--bl] = (byte) (val << 4); //填充byte的高4位
            } else {
                //填充byte的低4位
                if(orgins[--ocl] >=  '0' && orgins[ocl] <= '9'){
                    bytes[bl] |= (byte)( (orgins[ocl] - '0'));
                } else if(orgins[ocl] >= 'a' && orgins[ocl] <= 'f'){
                    bytes[bl] |= (byte)( (orgins[ocl] - 'a') + 10);
                } else if(orgins[ocl] >= 'A' && orgins[ocl] <= 'F'){
                    bytes[bl] |= (byte)( (orgins[ocl] - 'A') + 10);
                } else {
                    throw  new RuntimeException("传入字符不在16进制范围内");
                }
            }
        }
        return bytes;
    }

    public static byte[] hexString2Bytes(String orgin){

        return orgin != null ? hexChars2Bytes(orgin.toCharArray()) : new byte[0];
    }
}
