package expressage.expressage.service.impl;

import expressage.expressage.bean.Admins;
import expressage.expressage.repository.AdminsRepository;
import expressage.expressage.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminsServiceImpl implements AdminsService {

    @Autowired
    AdminsRepository adminsRepository;

    @Override
    public Admins appLogin(String adminNum) {
        return adminsRepository.findByAdminNum(adminNum);
    }
}
