package shop.rp2.colt.src.album.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GetAlbumRes {

    private Long albumId;
    private String albumTitle;
    private String albumImage;
    private String singerName;
    private String singerImage;
    private String soundQuality;
    private Long likedUserCount;
    private Long replyCount;

    @QueryProjection
    public GetAlbumRes(Long albumId, String albumTitle, String albumImage, String singerName, String singerImage, String soundQuality, Long likedUserCount, Long replyCount) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.albumImage = albumImage;
        this.singerName = singerName;
        this.singerImage = singerImage;
        this.soundQuality = soundQuality;
        this.likedUserCount = likedUserCount;
        this.replyCount = replyCount;
    }
}
