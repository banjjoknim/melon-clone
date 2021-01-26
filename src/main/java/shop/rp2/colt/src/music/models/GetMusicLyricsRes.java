package shop.rp2.colt.src.music.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GetMusicLyricsRes {

    private String lyrics;

    @QueryProjection
    public GetMusicLyricsRes(String lyrics) {
        this.lyrics = lyrics;
    }
}
