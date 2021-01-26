package shop.rp2.colt.src.album.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.rp2.colt.config.BaseTimeEntity;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "ALBUM_LIKED_USER")
public class AlbumLikedUser extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_liked_user_id")
    private Long albumLikedUserId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "album_id")
    private Long albumId;

    public AlbumLikedUser(Long userId, Long albumId) {
        this.userId = userId;
        this.albumId = albumId;
    }
}
