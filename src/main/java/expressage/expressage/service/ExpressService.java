package expressage.expressage.service;

import expressage.expressage.bean.Express;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ExpressService {
    int addExpress(Express express);
    List<Express> getByUserPhone(String userPhone);
    Express getByExpId(Long expId);
    int changeOrderStatus(Long expId, int status, String adminNum);
    List<Express> getAllByDay();
    Page<Express> getAllExp(Pageable pageable);
    Page<Express> getAll(Pageable pageable);
    Page<Express> getAllDq(Pageable pageable, String adminNum);
    Page<Express> getDqByCompany(Pageable pageable, String adminNum, String expCompany);
    Page<Express> getAllDs(Pageable pageable, String adminNum);
    Page<Express> getDsByAddress(Pageable pageable, String adminNum, String dorm, String dormNum);
    Page<Express> getAllDf(Pageable pageable, String adminNum);
    Page<Express> getDfByAddress(Pageable pageable, String adminNum, String dorm, String dormNum);
    Page<Express> getAllFinish(Pageable pageable, String adminNum);
    Page<Express> getAllExpressByStatus(Pageable pageable, int orderStatus);
    int toSave(Express express);
    BigDecimal getOneTotal(String userNum);
}
