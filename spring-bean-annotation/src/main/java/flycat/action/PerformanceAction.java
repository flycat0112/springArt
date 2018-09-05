package flycat.action;

import flycat.Format;
import flycat.MovieQualifier;
import flycat.domain.Bean;
import flycat.domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @FileName: <p></p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-4</p>
 */
@RestController
@RequestMapping("/springArt")
@RequestScope
public class PerformanceAction {

    @Autowired
    @MovieQualifier(format = Format.BLURAY ,genre = "Bean2")
    private Bean service;
    @Autowired
    private Store<String> stringStore;  //通过范型来确认对象。
    @Autowired
    private Store<Integer> integerStore;  //通过范型来确认对象。

    @Resource() //默认通过变量名称来查找，如果变量是bean3，这儿找不到对象，报错
    private Bean bean2;

    @GetMapping(value = "/{id}")
    public ModelAndView performance(@PathVariable("id") String id){
        return new ModelAndView("index");
    }

}
