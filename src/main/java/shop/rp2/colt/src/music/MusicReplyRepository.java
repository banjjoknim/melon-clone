package shop.rp2.colt.src.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.rp2.colt.src.music.models.MusicReply;

import javax.transaction.Transactional;

@Repository
public interface MusicReplyRepository extends JpaRepository<MusicReply, Long> {

    @Transactional
    @Modifying
    @Query(value = "update MusicReply mp set mp.replyComment = :comment where mp.replyId = :replyId")
    Integer updateMusicReply(@Param("replyId") Long replyId, @Param("comment") String comment);

    @Transactional
    Integer deleteByReplyId(Long replyId);
}
