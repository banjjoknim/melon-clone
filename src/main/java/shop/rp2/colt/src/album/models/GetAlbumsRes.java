package shop.rp2.colt.src.album.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetAlbumsRes {

    private Long albumId;
    private String albumTitle;
    private String singerName;
    private String albumImage;
    private LocalDateTime releaseDate;
    private double rating;
    private Long scoredUserCount;

    @QueryProjection
    public GetAlbumsRes(Long albumId, String albumTitle, String singerName, String albumImage, LocalDateTime releaseDate, double rating, Long scoredUserCount) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.singerName = singerName;
        this.albumImage = albumImage;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.scoredUserCount = scoredUserCount;
    }
}
