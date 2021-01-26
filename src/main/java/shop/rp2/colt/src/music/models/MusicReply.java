package shop.rp2.colt.src.music.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import shop.rp2.colt.config.BaseTimeEntity;

import javax.persistence.*;

@NoArgsConstructor
@DynamicInsert
@Getter
@Entity
@Table(name = "MUSIC_REPLY")
public class MusicReply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long replyId;

    @Column(name = "music_id")
    private Long musicId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "reply_comment")
    private String replyComment;

    @Column(name = "belong_to_reply_id")
    private Long belongToReplyId;

    public MusicReply(Long musicId, Long userId, String replyCommnet, Long belongToReplyId) {
        this.musicId = musicId;
        this.userId = userId;
        this.replyComment = replyCommnet;
        this.belongToReplyId = belongToReplyId;
    }

    public MusicReply(Long musicId, Long userId, String replyComment) {
        this.musicId = musicId;
        this.userId = userId;
        this.replyComment = replyComment;
    }

}
