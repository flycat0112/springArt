package flycat.action;

import flycat.domain.IPerson;
import flycat.domain.IPersonOther;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

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

    @Inject
    IPerson person;

    @GetMapping(value = "/{id}")
    public ModelAndView performance(@PathVariable("id") String id){
        person.setName(id);
        person.setSex(true);// 这儿第一次执行传入false就会发生错误，传入true不会发生错误
        person.getName();
        ((IPersonOther)person).isBoli();  //用来测试target和this的区别(target会有表现，会拦截，this却不会)
        return new ModelAndView("index");
    }

}
