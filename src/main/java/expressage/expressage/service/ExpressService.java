package expressage.expressage.service;

import expressage.expressage.bean.Express;

import java.util.List;

public interface ExpressService {
    int addExpress(Express express);
    List<Express> getByUserPhone(String userPhone);
}
