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

    @GetMapping("/all")
    private List<Notice> getAllNotice() {
        return noticeService.getAllNotice();
    }

    @GetMapping("/getOne/{noticeId}")
    private Notice getOne(@PathVariable Long noticeId){
        Notice notice = noticeService.getOne(noticeId);
        return notice;
    }

    @PostMapping("/add")
    private int addNotice(Notice notice, String publisher) {
        return noticeService.addNotice(notice);
    }

    @PostMapping("/del")
    private int delNotice(@RequestParam long noticeId) {
        return noticeService.delNotice(noticeId);
    }

    @PostMapping("/top")
    private int topNotice(@RequestParam long noticeId) {
        return noticeService.topNotice(noticeId);
    }

    @PostMapping("/cancel")
    private int cancelTopNotice(@RequestParam long noticeId) {
        return noticeService.cancelTopNotice(noticeId);
    }
}
