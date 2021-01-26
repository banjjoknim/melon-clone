package shop.rp2.colt.src.playlist.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.rp2.colt.config.BaseTimeEntity;
import shop.rp2.colt.config.FlagYN;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "PLAYLIST")
public class Playlist extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")
    private Long playlistId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "playlist_name")
    private String playlistName;

    @Column(name = "is_public")
    @Enumerated(EnumType.STRING)
    private FlagYN isPublic;
}
