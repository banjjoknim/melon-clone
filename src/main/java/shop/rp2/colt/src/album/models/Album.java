package shop.rp2.colt.src.album.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;
import shop.rp2.colt.config.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@DynamicInsert
@Getter
@Entity
@Table(name = "ALBUM")
public class Album extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long albumId;

    @Column(name = "singer_id")
    private Long singerId;

    @Column(name = "album_image")
    private String albumImage;

    @Column(name = "album_title")
    private String albumTitle;

    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "album_intro")
    private String albumIntro;

    @Column(name = "sound_quality")
    private String soundQuality;

    @Column(name = "release_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime releaseDate;

    @Column(name = "total_score")
    private Double totalScore;

    @Column(name = "scored_user_count")
    private Long scoredUserCount;

    @Column(name = "is_public")
    private String isPublic;

    @Column(name = "is_deleted")
    private String isDeleted;
}
