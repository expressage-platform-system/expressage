package expressage.expressage.service.impl;

import expressage.expressage.bean.Express;
import expressage.expressage.repository.ExpressRepository;
import expressage.expressage.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    ExpressRepository expressRepository;

    @Transactional
    @Override
    public int addExpress(Express express) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String formatStr =formatter.format(new Date());
        express.setCommitTime(formatStr);
        express.setOrderStatus(0);
        if (express.getDorm().equals("安美")||express.getDorm().equals("安悦")||express.getDorm().equals("家属楼")){
            express.setRegion("东区");
        }
        else {
            express.setRegion("西区");
        }
        expressRepository.save(express);
        return 1;
    }

    @Override
    public List<Express> getByUserPhone(String userPhone) {
        return expressRepository.findByUserPhone(userPhone);
    }

    @Override
    public Express getByExpId(Long expId) {
        return expressRepository.findByExpId(expId);
    }

    @Transactional
    @Override
    public int changeOrderStatus(Long expId, int status, String adminNum) {
        Express express = expressRepository.findActiveExpressByExpId(expId);
        if (express != null){
            express.setAdminNum(adminNum);
            express.setOrderStatus(status);
            expressRepository.save(express);
            return 1;
        }
        return 0;
    }

    @Override
    public List<Express> getAllByDay() {
        List<Express> expressList = expressRepository.findAllFinishByTime();
        for (Express express : expressList){
            // TODO: 2019/1/2  
        }
        return null;
    }

    @Override
    public Page<Express> getAllExp(Pageable pageable) {
        return expressRepository.findAllExp(pageable);
    }

    @Override
    public Page<Express> getAll(Pageable pageable) {
        return expressRepository.findAll(pageable);
    }

    @Override
    public Page<Express> getAllDq(Pageable pageable, String adminNum) {
        return expressRepository.findAllDq(pageable,adminNum);
    }

    @Override
    public Page<Express> getDqByCompany(Pageable pageable, String adminNum, String expCompany) {
        return expressRepository.findDqByCompany(pageable,adminNum,expCompany);
    }

    @Override
    public Page<Express> getAllDs(Pageable pageable, String adminNum) {
        return expressRepository.findAllDs(pageable,adminNum);
    }

    @Override
    public Page<Express> getDsByAddress(Pageable pageable, String adminNum, String dorm, String dormNum) {
        return expressRepository.findDsByAddress(pageable,adminNum,dorm,dormNum);
    }

    @Override
    public Page<Express> getAllDf(Pageable pageable, String adminNum) {
        return expressRepository.findAllDf(pageable, adminNum);
    }

    @Override
    public Page<Express> getDfByAddress(Pageable pageable, String adminNum, String dorm, String dormNum) {
        return expressRepository.findDfByAddress(pageable, adminNum, dorm, dormNum);
    }

    @Override
    public Page<Express> getAllFinish(Pageable pageable, String adminNum) {
        return expressRepository.findAllFinish(pageable, adminNum);
    }

    @Override
    public Page<Express> getAllExpressByStatus(Pageable pageable, int orderStatus) {
        return expressRepository.findAllExpressByStatus(pageable,orderStatus);
    }

    @Transactional
    @Override
    public int toSave(Express express) {
        if (express!=null){
            expressRepository.save(express);
            return 1;
        }
        return 0;
    }

    @Override
    public BigDecimal getOneTotal(String userNum) {
        BigDecimal decimal = new BigDecimal(0);
        List<Express> expressList = expressRepository.findAllFinish(userNum);
        for (Express express : expressList){
            decimal = decimal.add(express.getMoney());
        }
        return decimal;
    }
}
