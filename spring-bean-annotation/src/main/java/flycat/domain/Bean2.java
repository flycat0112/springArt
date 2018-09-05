package flycat.domain;

import flycat.Format;
import flycat.MovieQualifier;
import org.springframework.stereotype.Component;

/**
 * @FileName: <p>Bean2</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 */
@Component
@MovieQualifier(format = Format.BLURAY ,genre = "Bean2")
public class Bean2 extends Bean {
}
