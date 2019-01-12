package expressage.expressage.repository;

import expressage.expressage.bean.Express;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpressRepository extends JpaRepository<Express,Long> {
    @Query("select e from Express e where e.orderStatus<4 and e.userPhone=?1")
    List<Express> findByUserPhone(String userPhone);

    @Query("select e from Express e where e.orderStatus<2 and e.expId=?1")
    Express findActiveExpressByExpId(Long expId);

    @Query("select e from Express e where e.orderStatus=0")
    Page<Express> findAll(Pageable pageable);

    @Query("select e from Express e")
    Page<Express> findAllExp(Pageable pageable);

    @Query("select e from Express e where e.orderStatus=1 and e.adminNum=?1")
    Page<Express> findAllDq(Pageable pageable, String adminNum);

    @Query("select e from Express e where e.orderStatus=1 and e.adminNum=?1 and e.expCompany=?2")
    Page<Express> findDqByCompany(Pageable pageable, String adminNum, String expCompany);

    @Query("select e from Express e where e.orderStatus=2 and e.adminNum=?1")
    Page<Express> findAllDs(Pageable pageable, String adminNum);

    @Query("select e from Express e where e.orderStatus=?1")
    Page<Express> findAllExpressByStatus(Pageable pageable,int orderStatus);

    @Query("select e from Express e where e.orderStatus=2 and e.adminNum=?1 and e.dorm=?2 and e.dormNum=?3")
    Page<Express> findDsByAddress(Pageable pageable, String adminNum, String dorm, String dormNum);

    @Query("select e from Express e where e.orderStatus=3 and e.adminNum=?1")
    Page<Express> findAllDf(Pageable pageable, String adminNum);

    @Query("select e from Express e where e.orderStatus=3 and e.adminNum=?1 and e.dorm=?2 and e.dormNum=?3")
    Page<Express> findDfByAddress(Pageable pageable, String adminNum, String dorm, String dormNum);

    @Query("select e from Express e where e.orderStatus=4 and e.adminNum=?1")
    Page<Express> findAllFinish(Pageable pageable, String adminNum);

    @Query("select e from Express e where e.orderStatus=4 and e.adminNum=?1")
    List<Express> findAllFinish(String adminNum);

    @Query("select e from Express e where e.orderStatus<4 and e.orderStatus>0 and e.adminNum=?1")
    List<Express> findIngNum(String adminNum);

    @Query("select e from Express e where e.orderStatus=4")
    List<Express> findAllFinishByTime();

    Express findByExpId(Long expId);
}
