package expressage.expressage.repository;

import expressage.expressage.bean.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminsRepository extends JpaRepository<Admins,Long> {
    @Query("select a from Admins a where a.deleteStatus=0 and a.adminNum=?1")
    Admins findByAdminNum(String adminNum);
}
