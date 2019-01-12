package expressage.expressage.service;

import expressage.expressage.bean.Admins;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminsService {
    Admins appLogin(String adminNum);
    Admins getById(Long adminId);
    Page<Admins> getAll(Pageable pageable);
    int changePassword(String adminNum,String newPassword);
    int deleteUser(String adminNum);
    int addUser(Admins admins);
    Admins getByAdminNum(String adminNum);
}
