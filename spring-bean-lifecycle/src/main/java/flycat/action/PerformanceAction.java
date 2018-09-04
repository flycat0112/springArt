package flycat.action;

import flycat.domain.DemoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.DefaultLifecycleProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @FileName: <p>这儿进行验证smartLIfecycle接口，只有ApplicationContext启动或者关闭的时候才会调用,区别@PostConstruct</p>
 * @Description: <p></p>
 * @Author <p>flycat</p>
 * @Date <p>18-9-4</p>
 * <p>============================</p>
 * @Company: <p></p>
 * @Copyright: <p></p>
 *
 * <p>============================</p>
 */
@RestController
@RequestMapping("/springArt")
@RequestScope
public class PerformanceAction {

    @Autowired
    DemoBean service;

    @GetMapping(value = "/{id}")
    public ModelAndView performance(@PathVariable("id") String id){
        return new ModelAndView("index");
    }

}
