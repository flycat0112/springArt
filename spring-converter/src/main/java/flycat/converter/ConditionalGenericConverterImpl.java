package flycat.converter;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Set;

/**
 * @FileName: <p>ConditionalGenericConverterImpl</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-24</p>
 */
public class ConditionalGenericConverterImpl implements ConditionalGenericConverter {
    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return false;
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return null;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        return null;
    }
}
