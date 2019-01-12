package expressage.expressage.service.impl;

import expressage.expressage.bean.Notice;
import expressage.expressage.repository.NoticeRepository;
import expressage.expressage.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeRepository noticeRepository;

    @Transactional
    @Override
    public int addNotice(Notice notice) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        notice.setReleaseTime(timestamp);
        noticeRepository.save(notice);
        return 1;
    }

    @Transactional
    @Override
    public int delNotice(long noticeId) {

        Notice notice = noticeRepository.findByNoticeId(noticeId);

        notice.setDelStatus(1);
        noticeRepository.save(notice);

        return 1;
    }

    @Transactional
    @Override
    public int topNotice(long noticeId) {

        List<Notice> noticeList = noticeRepository.findByPriority();
        System.out.println(noticeList.size());

        if (noticeList.isEmpty()||noticeList.size() < 2) {
            Notice notice = noticeRepository.findByNoticeId(noticeId);

            notice.setPriority(1);
            noticeRepository.save(notice);

            return 1;
        } else {
            return 0;
        }
    }

    @Transactional
    @Override
    public int cancelTopNotice(long noticeId) {

        Notice notice = noticeRepository.findByNoticeId(noticeId);

        notice.setPriority(0);
        noticeRepository.save(notice);

        return 1;
    }

    @Override
    public List<Notice> getAllNotice() {
        return noticeRepository.findByDelStatus();
    }

    @Override
    public Notice getOne(Long noticeId) {
        return noticeRepository.findByNoticeId(noticeId);
    }
}
