package flycat.converter;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Set;

/**
 * @FileName: <p>GenericConverterImpl</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-24</p>
 */
public class GenericConverterImpl implements GenericConverter {

    private Set<ConvertiblePair> convertiblePairs;


    public GenericConverterImpl(Set<ConvertiblePair> convertiblePairs) {
        this.convertiblePairs = convertiblePairs;
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return this.convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {

        return null;
    }
}
