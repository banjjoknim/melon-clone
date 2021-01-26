package shop.rp2.colt.src.music.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GetMusicRes {

    private Long musicId;
    private String musicTitle;
    private String albumTitle;
    private String albumImage;
    private String singerName;
    private String singerImage;
    private String genreName;
    private String soundQuality;
    private Long likedUserCount;
    private Long replyCount;
    private GetMusicLyricsRes getMusicLyricsRes; // 가사 메뉴가 가진 데이터
    private GetMusicInfoRes getMusicInfoRes; // 상세정보 메뉴가 가진 데이터
    private GetMusicReplyRes getMusicReplyRes; // 댓글 메뉴가 가진 데이터

    @QueryProjection
    public GetMusicRes(Long musicId, String musicTitle, String albumTitle, String albumImage, String singerName, String singerImage, String genreName, String soundQuality, Long likedUserCount, Long replyCount) {
        this.musicId = musicId;
        this.musicTitle = musicTitle;
        this.albumTitle = albumTitle;
        this.albumImage = albumImage;
        this.singerName = singerName;
        this.singerImage = singerImage;
        this.genreName = genreName;
        this.soundQuality = soundQuality;
        this.likedUserCount = likedUserCount;
        this.replyCount = replyCount;
    }
}
