package shop.rp2.colt.src.music.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.rp2.colt.config.BaseTimeEntity;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "MUSIC_REPLY_LIKED_USER")
public class MusicReplyLikedUser extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_reply_liked_user_id")
    private Long musicReplyLikedUserId;

    @Column(name = "REPLY_ID")
    private Long replyId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "liked")
    private String liked;

    @QueryProjection
    public MusicReplyLikedUser(Long replyId, Long userId, String liked) {
        this.replyId = replyId;
        this.userId = userId;
        this.liked = liked;
    }
}
