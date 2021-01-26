package shop.rp2.colt.src.music.models;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetMusicsRes {
    private Long musicId;
    private String musicTitle;
    private String singerName;
    private String albumImage;
    private String country;
    private LocalDateTime registedDate;

    @QueryProjection
    public GetMusicsRes(Long musicId, String musicTitle, String singerName, String albumImage, String country, LocalDateTime registedDate) {
        this.musicId = musicId;
        this.musicTitle = musicTitle;
        this.singerName = singerName;
        this.albumImage = albumImage;
        this.country = country;
        this.registedDate = registedDate;
    }
}
