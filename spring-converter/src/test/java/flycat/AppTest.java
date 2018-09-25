package flycat;

import flycat.converter.ArrayToCollectionConverter;
import flycat.converter.StringToEnumConverterFactory;
import flycat.converter.StringToInteger;
import flycat.converter.UserStaticEnum;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.Formatter;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.support.FormattingConversionService;

import java.text.ParseException;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void stringToTntegerTest()
    {
        Converter<String, Integer> integerConverter = new StringToInteger();
        System.out.println(integerConverter.convert("456"));
    }


    @Test
    public void stringToEnumConverterFactoryTest()
    {
        Converter<String, UserStaticEnum> enumConverter = new StringToEnumConverterFactory().getConverter(UserStaticEnum.class);
        System.out.println(enumConverter.convert("LOGINING"));
    }


    @Test
    public void arrayToCollectionConverterTest()
    {
        ConversionService service = new DefaultConversionService();
        ArrayToCollectionConverter arrayToCollectionConverter = new ArrayToCollectionConverter(service);
        String[] strs = {"123","123","456"};
        Set<Integer> setStr = (Set<Integer>) arrayToCollectionConverter.convert(strs,
                TypeDescriptor.forObject(strs), TypeDescriptor.collection(Set.class, TypeDescriptor.valueOf(Integer.class)));
        System.out.println(setStr.size());
    }

    @Test

    public void dateFormatterTest()
    {
        Formatter<Date> dateFormatter = new DateFormatter("yyyy-MM-dd HH:mm:ss");
        try {
            Date date  = dateFormatter.parse("2018-11-23 12:56:34", Locale.CHINA);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void formatterRegisteryTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        FormattingConversionService service = context.getBean(FormattingConversionService.class);
        Date date = (Date) service.convert("20180923", TypeDescriptor.valueOf(Date.class));
        Date date1 = (Date) service.convert(Calendar.getInstance(), TypeDescriptor.valueOf(Date.class));
        System.out.println(date);
        System.out.println(date1);
    }

}
