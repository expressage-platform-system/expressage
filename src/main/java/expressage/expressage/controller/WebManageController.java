package expressage.expressage.controller;

import expressage.expressage.bean.Admins;
import expressage.expressage.bean.Express;
import expressage.expressage.service.AdminsService;
import expressage.expressage.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class WebManageController {
    private static final Integer size = 10;
    private static final Sort sort1 = new Sort(Sort.Direction.ASC,"adminId");
    private static final Sort sort2 = new Sort(Sort.Direction.DESC,"expId");

    @Autowired
    AdminsService adminsService;
    @Autowired
    ExpressService expressService;

    @RequestMapping("index")
    public String index(ModelMap modelMap, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int error){
        Page<Admins> admins = adminsService.getAll(new PageRequest(page,size,sort1));
        if (error==1){
            modelMap.put("error","确保该管理员已经处理完进行中的订单，再删除");
        }
        modelMap.put("number",page);
        modelMap.put("userList",admins.getContent());
        modelMap.put("totalPages",admins.getTotalPages());
        modelMap.put("totalNum",admins.getTotalElements());
        return "index";
    }

    @RequestMapping("deleteUser/{adminNum}")
    public String deleteUser(@PathVariable String adminNum){
        if (adminsService.deleteUser(adminNum)==1){
            return "redirect:/index";
        }
        return "redirect:/index?error=1";
    }
    @PostMapping("addUser")
    public String addUser(Admins admins){
        adminsService.addUser(admins);
        return "redirect:/index";
    }

    @PostMapping("changePasswd")
    public String changePassword(@RequestParam String adminNum,@RequestParam String adminPasswd){
        adminsService.changePassword(adminNum,adminPasswd);
        return "redirect:/index";
    }

    @RequestMapping("login")
    public String login(ModelMap modelMap){
        return "login";
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        modelMap.put("msg","请重新登录");
        return "login";
    }

    @PostMapping("checkOne")
    @ResponseBody
    public int checkOne(@RequestParam String adminNum){
        if (adminsService.getByAdminNum(adminNum)!=null) {
            return 0;
        }
        return 1;
    }

    @RequestMapping("allExpress")
    public String allExpress(ModelMap modelMap,@RequestParam(defaultValue = "0") int page){
        Page<Express> expresses = expressService.getAllExp(new PageRequest(page,size,sort2));
        modelMap.put("number",page);
        modelMap.put("express",expresses.getContent());
        modelMap.put("totalPages",expresses.getTotalPages());
        modelMap.put("totalNum",expresses.getTotalElements());
        return "information";
    }

    @RequestMapping("allDjExpress")
    public String allDjExpress(ModelMap modelMap,@RequestParam(defaultValue = "0") int page){
        Page<Express> expresses = expressService.getAll(new PageRequest(page,size,sort2));
        modelMap.put("number",page);
        modelMap.put("express",expresses.getContent());
        modelMap.put("totalPages",expresses.getTotalPages());
        modelMap.put("totalNum",expresses.getTotalElements());
        return "information1";
    }

    @RequestMapping("allDsExpress")
    public String allDsExpress(ModelMap modelMap,@RequestParam(defaultValue = "0") int page){
        Page<Express> expresses = expressService.getAllExpressByStatus(new PageRequest(page,size,sort2),2);
        modelMap.put("number",page);
        modelMap.put("express",expresses.getContent());
        modelMap.put("totalPages",expresses.getTotalPages());
        modelMap.put("totalNum",expresses.getTotalElements());
        return "information2";
    }

    @RequestMapping("allDfExpress")
    public String allDfExpress(ModelMap modelMap,@RequestParam(defaultValue = "0") int page){
        Page<Express> expresses = expressService.getAllExpressByStatus(new PageRequest(page,size,sort2),3);
        modelMap.put("number",page);
        modelMap.put("express",expresses.getContent());
        modelMap.put("totalPages",expresses.getTotalPages());
        modelMap.put("totalNum",expresses.getTotalElements());
        return "information3";
    }

    @RequestMapping("allFinishExpress")
    public String allFinishExpress(ModelMap modelMap,@RequestParam(defaultValue = "0") int page){
        Page<Express> expresses = expressService.getAllExpressByStatus(new PageRequest(page,size,sort2),4);
        modelMap.put("number",page);
        modelMap.put("express",expresses.getContent());
        modelMap.put("totalPages",expresses.getTotalPages());
        modelMap.put("totalNum",expresses.getTotalElements());
        return "information4";
    }

    @RequestMapping("allCancelExpress")
    public String allCancelExpress(ModelMap modelMap,@RequestParam(defaultValue = "0") int page){
        Page<Express> expresses = expressService.getAllExpressByStatus(new PageRequest(page,size,sort2),5);
        modelMap.put("number",page);
        modelMap.put("express",expresses.getContent());
        modelMap.put("totalPages",expresses.getTotalPages());
        modelMap.put("totalNum",expresses.getTotalElements());
        return "information5";
    }

    @RequestMapping("chart")
    public String chart(ModelMap modelMap){
        return "charts";
    }
}
