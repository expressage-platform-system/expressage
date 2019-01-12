package expressage.expressage.controller;

import expressage.expressage.bean.Express;
import expressage.expressage.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/express")
public class ExpressController {

    private Sort sort = new Sort(Sort.Direction.DESC,"expId");
    final static int size = 10;

    @Autowired
    ExpressService expressService;

    @RequestMapping("/11")
    public String ss(){
        return "nihao";
    }

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
    public int cancelExpress(@RequestParam Long expId,String adminNum){
        if (adminNum!=null){
            return expressService.changeOrderStatus(expId,5, adminNum);
        }else {
            return expressService.changeOrderStatus(expId,5,"0");
        }
    }

    @PostMapping("/accept")
    public int accept(@RequestParam Long expId,@RequestParam String adminNum){
        return expressService.changeOrderStatus(expId,1,adminNum);
    }

    @PostMapping("/delivery")
    public int delivery(@RequestParam Long expId){
        Express express = expressService.getByExpId(expId);
        if (express.getOrderStatus()==2){
            express.setOrderStatus(3);
            return expressService.toSave(express);
        }
        return 0;
    }

    @PostMapping("/finish")
    public int finish(@RequestParam Long expId){
        Express express = expressService.getByExpId(expId);
        if (express.getOrderStatus()==3){
            express.setOrderStatus(4);
            return expressService.toSave(express);
        }
        return 0;
    }

    @RequestMapping("/all")
    public Map getAll(@RequestParam Integer page){
        Map map = new TreeMap();
        Pageable pageable = new PageRequest(page,size,sort);
        Page<Express> expresses = expressService.getAll(pageable);
        map.put("express",expresses.getContent());
        map.put("total",expresses.getTotalElements());
        map.put("totalPage",expresses.getTotalPages());
        return map;
    }

    @RequestMapping("/allDq")
    public Map getAllDq(@RequestParam Integer page, @RequestParam String adminNum){
        Map map = new TreeMap();
        Pageable pageable = new PageRequest(page,size,sort);
        Page<Express> expresses = expressService.getAllDq(pageable, adminNum);
        map.put("express",expresses.getContent());
        map.put("totalPage",expresses.getTotalPages());
        map.put("total",expresses.getTotalElements());
        return map;
    }

    @RequestMapping("/allDs")
    public Map getAllDs(@RequestParam Integer page, @RequestParam String adminNum){
        Map map = new TreeMap();
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Express> expresses = expressService.getAllDs(pageable ,adminNum);
        map.put("express",expresses.getContent());
        map.put("totalPage",expresses.getTotalPages());
        map.put("total",expresses.getTotalElements());
        return map;
    }

    @RequestMapping("/allDf")
    public Map getAllDf(@RequestParam Integer page, @RequestParam String adminNum){
        Map map = new TreeMap();
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Express> expresses = expressService.getAllDf(pageable ,adminNum);
        map.put("express",expresses.getContent());
        map.put("totalPage",expresses.getTotalPages());
        map.put("total",expresses.getTotalElements());
        return map;
    }

    @RequestMapping("/allFinish")
    public Map getAllFinish(@RequestParam Integer page, @RequestParam String adminNum){
        Map map = new TreeMap();
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Express> expresses = expressService.getAllFinish(pageable ,adminNum);
        map.put("express",expresses.getContent());
        map.put("totalPage",expresses.getTotalPages());
        map.put("total",expresses.getTotalElements());
        map.put("money",expressService.getOneTotal(adminNum));
        return map;
    }

    @RequestMapping("/allDqByCompany")
    public Map getAllDqByCom(@RequestParam Integer page, @RequestParam String adminNum, @RequestParam String expCompany){
        Map map = new TreeMap();
        Pageable pageable = new PageRequest(page,size,sort);
        Page<Express> expresses = expressService.getDqByCompany(pageable,adminNum,expCompany);
        map.put("express",expresses.getContent());
        map.put("totalPage",expresses.getTotalPages());
        map.put("total",expresses.getTotalElements());
        return map;
    }

    @RequestMapping("/allDfByAddress")
    public Map getAllDfByCom(@RequestParam Integer page, @RequestParam String adminNum, @RequestParam String dorm, @RequestParam String dormNum){
        Map map = new TreeMap();
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Express> expresses = expressService.getDfByAddress(pageable,adminNum,dorm,dormNum);
        map.put("express",expresses.getContent());
        map.put("totalPage",expresses.getTotalPages());
        map.put("total",expresses.getTotalElements());
        return map;
    }

    @RequestMapping("/allDsByAddress")
    public Map getAllDsByAddress(@RequestParam Integer page, @RequestParam String adminNum, @RequestParam String dorm, @RequestParam String dormNum){
        Map map = new TreeMap();
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Express> expresses = expressService.getDsByAddress(pageable,adminNum,dorm,dormNum);
        map.put("express",expresses.getContent());
        map.put("totalPage",expresses.getTotalPages());
        map.put("total",expresses.getTotalElements());
        return map;
    }

    @PostMapping("/accepted")
    public int accepted(@RequestParam Long expId, @RequestParam String money, @RequestParam String time){
        Express express = expressService.getByExpId(expId);
        BigDecimal decimal = new BigDecimal(money);
        decimal.setScale(2,RoundingMode.HALF_UP);
        express.setOrderStatus(2);
        express.setMoney(decimal);
        express.setAmPm(time);
        return expressService.toSave(express);
    }

    @PostMapping("/massage")
    public int massage(@RequestParam Long expId, @RequestParam String massage){
        Express express = expressService.getByExpId(expId);
        express.setMassage(massage);
        return expressService.toSave(express);
    }
}
