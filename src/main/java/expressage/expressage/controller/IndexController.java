package expressage.expressage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String index(ModelMap modelMap){
        modelMap.put("title","hello world");
        return "index";
    }
}
