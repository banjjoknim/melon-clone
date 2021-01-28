package shop.rp2.colt.src.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.rp2.colt.src.music.models.MusicReplyLikedUser;

import javax.transaction.Transactional;

@Repository
public interface MusicReplyLikedUserRepository extends JpaRepository<MusicReplyLikedUser, Long> {

    @Transactional
    Integer deleteMusicReplyLikedUserByReplyIdAndUserIdAndLiked(Long replyId, Long userId, String liked);

    boolean existsMusicReplyLikedUserByReplyIdAndAndUserIdAndLiked(Long replyId, Long userId, String liked);

    boolean existsMusicReplyLikedUserByReplyIdAndUserId(Long replyId, Long userId);

}
