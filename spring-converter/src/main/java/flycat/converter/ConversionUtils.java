package flycat.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * 复制的spring的代码，因为源的是保护的，我这儿访问不了，所以代码复制过来，和flycat.converter.ArrayToCollectionConverter一起使用
 */
abstract class ConversionUtils {

    @Nullable
    public static Object invokeConverter(GenericConverter converter, @Nullable Object source,
                                         TypeDescriptor sourceType, TypeDescriptor targetType) {

        try {
            return converter.convert(source, sourceType, targetType);
        }
        catch (ConversionFailedException ex) {
            throw ex;
        }
        catch (Throwable ex) {
            throw new ConversionFailedException(sourceType, targetType, source, ex);
        }
    }

    public static boolean canConvertElements(@Nullable TypeDescriptor sourceElementType,
                                             @Nullable TypeDescriptor targetElementType, ConversionService conversionService) {

        if (targetElementType == null) {
            // yes
            return true;
        }
        if (sourceElementType == null) {
            // maybe
            return true;
        }
        if (conversionService.canConvert(sourceElementType, targetElementType)) {
            // yes
            return true;
        }
        if (sourceElementType.getType().isAssignableFrom(targetElementType.getType())) {
            // maybe
            return true;
        }
        // no
        return false;
    }

    public static Class<?> getEnumType(Class<?> targetType) {
        Class<?> enumType = targetType;
        while (enumType != null && !enumType.isEnum()) {
            enumType = enumType.getSuperclass();
        }
        Assert.notNull(enumType, () -> "The target type " + targetType.getName() + " does not refer to an enum");
        return enumType;
    }

}
