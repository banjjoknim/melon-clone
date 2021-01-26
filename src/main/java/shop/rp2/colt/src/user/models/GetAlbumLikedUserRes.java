package shop.rp2.colt.src.user.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GetAlbumLikedUserRes {

    private Long albumId;
    private Long userId;
    private String userImage;
    private String nickname;
    private Long hasPlaylistCount;

    @QueryProjection
    public GetAlbumLikedUserRes(Long albumId, Long userId, String userImage, String nickname, Long hasPlaylistCount) {
        this.albumId = albumId;
        this.userId = userId;
        this.userImage = userImage;
        this.nickname = nickname;
        this.hasPlaylistCount = hasPlaylistCount;
    }
}
