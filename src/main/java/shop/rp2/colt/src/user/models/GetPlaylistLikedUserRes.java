package shop.rp2.colt.src.user.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GetPlaylistLikedUserRes {

    private Long playlistId;
    private Long userId;
    private String userImage;
    private String nickname;
    private Long hasPlaylistCount;

    @QueryProjection
    public GetPlaylistLikedUserRes(Long playlistId, Long userId, String userImage, String nickname, Long hasPlaylistCount) {
        this.playlistId = playlistId;
        this.userId = userId;
        this.userImage = userImage;
        this.nickname = nickname;
        this.hasPlaylistCount = hasPlaylistCount;
    }
}
