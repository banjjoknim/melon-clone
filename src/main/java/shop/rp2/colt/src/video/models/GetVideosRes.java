package shop.rp2.colt.src.video.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class GetVideosRes {

    private Long videoId;
    private String videoTitle;
    private String singerName;
    private String videoImage;
    private LocalTime playtime;
    private Long viewCount;
    private LocalDateTime releaseDate;

    @QueryProjection
    public GetVideosRes(Long videoId, String videoTitle, String singerName, String videoImage, LocalTime playtime, Long viewCount, LocalDateTime releaseDate) {
        this.videoId = videoId;
        this.videoTitle = videoTitle;
        this.singerName = singerName;
        this.videoImage = videoImage;
        this.playtime = playtime;
        this.viewCount = viewCount;
        this.releaseDate = releaseDate;
    }
}
