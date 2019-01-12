package expressage.expressage.service.impl;

import expressage.expressage.bean.Admins;
import expressage.expressage.bean.Express;
import expressage.expressage.repository.AdminsRepository;
import expressage.expressage.repository.ExpressRepository;
import expressage.expressage.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class AdminsServiceImpl implements AdminsService {

    @Autowired
    AdminsRepository adminsRepository;
    @Autowired
    ExpressRepository expressRepository;

    @Override
    public Admins appLogin(String adminNum) {
        return adminsRepository.findByAdminNum(adminNum);
    }

    @Override
    public Admins getById(Long adminId) {
        return adminsRepository.findByAdminId(adminId);
    }

    @Override
    public Page<Admins> getAll(Pageable pageable) {
        return adminsRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public int changePassword(String adminNum, String newPassword) {
        Admins admins = adminsRepository.findByAdminNum(adminNum);
        if (admins != null){
            admins.setAdminPasswd(newPassword);
            adminsRepository.save(admins);
            return 1;
        }
        return 0;
    }

    @Transactional
    @Override
    public int deleteUser(String adminNum) {
        Admins admins = adminsRepository.findByAdminNum(adminNum);
        List<Express> expressList = expressRepository.findIngNum(adminNum);
        if (admins != null && expressList.size()==0){
            admins.setDeleteStatus(1);
            adminsRepository.save(admins);
            return 1;
        }
        return 0;
    }

    @Transactional
    @Override
    public int addUser(Admins admins) {
        String password = "";
        Random random = new Random();
        for (int i=0;i<6;i++){
            password+=random.nextInt(10);
        }
        admins.setAdminPasswd(password);
        admins.setDeleteStatus(0);
        adminsRepository.save(admins);
        return 1;
    }

    @Override
    public Admins getByAdminNum(String adminNum) {
        return adminsRepository.findByAdminNum(adminNum);
    }
}
