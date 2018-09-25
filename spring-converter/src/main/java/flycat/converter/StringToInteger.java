package flycat.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * @FileName: <p>StringToInteger</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-24</p>
 */
public class StringToInteger implements Converter<String, Integer> {

    @Override
    public Integer convert(String source) {
        return source != null ? Integer.valueOf(source.trim()) : 0;
    }
}
