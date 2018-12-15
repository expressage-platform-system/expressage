package expressage.expressage.controller;

import expressage.expressage.bean.Admins;
import expressage.expressage.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminsService adminsService;

    @PostMapping("login")
    public int appLogin(@RequestParam String adminNum, @RequestParam String adminPasswd){
        Admins admins = adminsService.appLogin(adminNum);
        if (admins != null && admins.getAdminPasswd().equals(adminPasswd)){
            return 1;
        }
        return 0;
    }
}
