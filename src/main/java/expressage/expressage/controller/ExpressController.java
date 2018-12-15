package expressage.expressage.controller;

import expressage.expressage.bean.Express;
import expressage.expressage.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/express")
public class ExpressController {

    @Autowired
    ExpressService expressService;

    @PostMapping("/add")
    public int addExpress(Express express){
        return expressService.addExpress(express);
    }

    @RequestMapping("/findByPhone/{userPhone}")
    public List<Express> findByPhone(@PathVariable String userPhone){
        return expressService.getByUserPhone(userPhone);
    }

    @RequestMapping("/findByExpId/{expId}")
    public Express findById(@PathVariable Long expId){
        return expressService.getByExpId(expId);
    }

    @PostMapping("/cancel")
    public int cancelExpress(@RequestParam Long expId){
        return expressService.changeOrderStatus(expId,5);
    }
}
