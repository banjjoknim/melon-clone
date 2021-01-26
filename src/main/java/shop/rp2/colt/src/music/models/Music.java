package shop.rp2.colt.src.music.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;
import shop.rp2.colt.config.BaseTimeEntity;
import shop.rp2.colt.config.FlagYN;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;


@NoArgsConstructor
@DynamicInsert
@Getter
@Entity
@Table(name = "MUSIC")
public class Music extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_id")
    private Long musicId;

    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "music_title")
    private String musicTitle;

    @Column(name = "lyrics")
    private String lyrics;

    @Column(name = "playtime") // todo: 시간간격을 표현하는 방법 찾을 것
    private String playtime;

    @Column(name = "is_deleted")
    @Enumerated(EnumType.STRING)
    private FlagYN isDeleted;

    @Column(name = "is_public")
    @Enumerated(EnumType.STRING)
    private FlagYN isPublic;

    public Music(Long albumId, String musicTitle, String lyrics, String playtime, FlagYN isDeleted, FlagYN isPublic) {
        this.albumId = albumId;
        this.musicTitle = musicTitle;
        this.lyrics = lyrics;
        this.playtime = playtime;
        this.isDeleted = isDeleted;
        this.isPublic = isPublic;
    }
}
