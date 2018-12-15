package expressage.expressage.repository;

import expressage.expressage.bean.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("select n from Notice n where n.delStatus = 0")
    List<Notice> findByDelStatus();

    @Query("select n from Notice n where n.noticeId = ?1")
    Notice findByNoticeId(long noticeId);

    @Query("select n from Notice n where n.priority = 1")
    List<Notice> findByPriority();
}
