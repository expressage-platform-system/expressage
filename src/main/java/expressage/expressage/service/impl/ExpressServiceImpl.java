package expressage.expressage.service.impl;

import expressage.expressage.bean.Express;
import expressage.expressage.repository.ExpressRepository;
import expressage.expressage.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    ExpressRepository expressRepository;
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
}
