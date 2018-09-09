package flycat.domain;

import flycat.Format;
import flycat.MovieQualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

/**
 * @FileName: <p>Bean</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-5</p>
 */
@Component
@MovieQualifier(format = Format.BLURAY ,genre = "Bean")
@ImportResource("classpath:/properties-config.xml")
public class Bean {
    @Value("${bean.name}")
    private String name;
}
