package shop.rp2.colt.src.music.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.rp2.colt.config.BaseTimeEntity;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "MUSIC_LIKED_USER")
public class MusicLikedUser extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_liked_user_id")
    private Long musicLikedUserId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "music_id")
    private Long musicId;

    public MusicLikedUser(Long userId, Long musicId) {
        this.userId = userId;
        this.musicId = musicId;
    }
}
