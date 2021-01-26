package shop.rp2.colt.src.video.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.rp2.colt.config.FlagYN;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "VIDEO")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private Long videoId;

    @Column(name = "music_id")
    private Long musicId;

    @Column(name = "video_title")
    private String videoTitle;

    @Column(name = "video_image")
    private String videoImage;

    @Column(name = "video_file")
    private String videoFile;

    @Column(name = "playtime")
    private LocalTime playtime;

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "is_deleted")
    @Enumerated(EnumType.STRING)
    private FlagYN isDeleted;

    @Column(name = "is_public")
    @Enumerated(EnumType.STRING)
    private FlagYN isPublic;
}
