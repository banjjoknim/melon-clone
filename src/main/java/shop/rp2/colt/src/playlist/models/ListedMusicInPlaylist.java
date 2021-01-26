package shop.rp2.colt.src.playlist.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.rp2.colt.config.BaseTimeEntity;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "LISTED_MUSIC_IN_PLAYLIST")
public class ListedMusicInPlaylist extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")
    private Long playlistId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "music_id")
    private Long musicId;
}
