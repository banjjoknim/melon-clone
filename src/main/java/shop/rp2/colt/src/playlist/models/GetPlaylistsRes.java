package shop.rp2.colt.src.playlist.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPlaylistsRes {

    private Long playlistId;
    private String playlistName;
    private String playlistImage;
    private Long musicsInPlaylistCount;

    @QueryProjection
    public GetPlaylistsRes(Long playlistId, String playlistName, String playlistImage, Long musicsInPlaylistCount) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.playlistImage = playlistImage;
        this.musicsInPlaylistCount = musicsInPlaylistCount;
    }
}
