package expressage.expressage.service;

import expressage.expressage.bean.Notice;

import java.util.List;

public interface NoticeService {

    int addNotice(Notice notice);
    int delNotice(long noticeId);
    int topNotice(long noticeId);
    int cancelTopNotice(long noticeId);
    List<Notice> getAllNotice();
    Notice getOne(Long noticeId);
}
