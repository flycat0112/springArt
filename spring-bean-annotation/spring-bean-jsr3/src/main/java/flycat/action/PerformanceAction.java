package flycat.action;

import flycat.domain.Bean;
import flycat.domain.Bean2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

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
    @Named("Bean")
    private Bean service;
    @Inject
    @Named("Bean1")
    private Bean service1;
    @Inject
    @Named("Bean2")
    private Bean2 service2;

    @GetMapping(value = "/{id}")
    public ModelAndView performance(@PathVariable("id") String id){
        return new ModelAndView("index");
    }

}
