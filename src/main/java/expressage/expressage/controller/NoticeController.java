package expressage.expressage.controller;

import expressage.expressage.bean.Notice;
import expressage.expressage.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping("/")
    private List<Notice> getAllNotice() {
        return noticeService.getAllNotice();
    }

    @PostMapping("/add")
    private int addNotice(Notice notice, String publisher) {
        return noticeService.addNotice(notice, publisher);
    }

    @PostMapping("/del/{noticeId}")
    private int delNotice(@PathVariable long noticeId) {
        return noticeService.delNotice(noticeId);
    }

    @PostMapping("top/{noticeId}")
    private int topNotice(@PathVariable long noticeId) {
        return noticeService.topNotice(noticeId);
    }

    @PostMapping("cancel/{noticeId}")
    private int cancelTopNotice(@PathVariable long noticeId) {
        return noticeService.cancelTopNotice(noticeId);
    }
}
