package shop.rp2.colt.src.album.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import shop.rp2.colt.config.BaseTimeEntity;

import javax.persistence.*;

@NoArgsConstructor
@DynamicInsert
@Getter
@Entity
@Table(name = "ALBUM_REPLY")
public class AlbumReply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long replyId;

    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "reply_comment")
    private String replyComment;

    @Column(name = "belong_to_reply_id")
    private Long belongToReplyId;
}
