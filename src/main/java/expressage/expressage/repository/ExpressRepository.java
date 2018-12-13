package expressage.expressage.repository;

import expressage.expressage.bean.Express;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpressRepository extends JpaRepository<Express,Long> {
    @Query("select e from Express e where e.orderStatus<4 and e.userPhone=?1")
    List<Express> findByUserPhone(String userPhone);
}
