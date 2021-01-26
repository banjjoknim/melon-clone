package shop.rp2.colt.src.music.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GetMusicInfoRes {

    private String singerName;
    private String lyricWriterName; // 작사가
    private String composerName; // 작곡가
    private String arrangerName; // 편곡가
    private String genreName;

    @QueryProjection
    public GetMusicInfoRes(String singerName, String lyricWriterName, String composerName, String arrangerName, String genreName) {
        this.singerName = singerName;
        this.lyricWriterName = lyricWriterName;
        this.composerName = composerName;
        this.arrangerName = arrangerName;
        this.genreName = genreName;
    }
}
