package flycat.controller;

import flycat.domain.DemoBean3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

/**
 * @FileName: <p>这儿验证通过FantoryBean接口，手动创建的对象是否可以通过注解的方式设置值</p>
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
    DemoBean3 service;

    @GetMapping(value = "/{id}")
    public ModelAndView performance(@PathVariable("id") String id){
        return new ModelAndView("index");
    }

}
