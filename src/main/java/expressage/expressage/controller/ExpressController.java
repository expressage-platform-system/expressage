package expressage.expressage.controller;

import expressage.expressage.bean.Express;
import expressage.expressage.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/express")
public class ExpressController {

    @Autowired
    ExpressService expressService;
    @PostMapping("/add")
    public int addExpressags(Express express){
        return expressService.addExpress(express);
    }
    @RequestMapping("/findByPhone/{userPhone}")
    public List<Express> findByPhone(@PathVariable String userPhone){
        return expressService.getByUserPhone(userPhone);
    }
}
