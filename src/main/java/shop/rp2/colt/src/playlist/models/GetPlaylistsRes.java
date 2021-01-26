package shop.rp2.colt.src.playlist.models;

import lombok.Getter;

@Getter
public class GetPlaylistsRes {

    private Long playlistId;
    private Long musicsInPlaylistCount;
    private String playlistName;
    private String playlistImage;
    private String nickname;

}
