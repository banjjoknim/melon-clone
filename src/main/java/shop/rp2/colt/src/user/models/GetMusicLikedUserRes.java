package shop.rp2.colt.src.user.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GetMusicLikedUserRes {

    private Long userId;
    private String userImage;
    private String nickname;
    private Long hasPlaylistCount;

    @QueryProjection
    public GetMusicLikedUserRes(Long userId, String userImage, String nickname) {
        this.userId = userId;
        this.userImage = userImage;
        this.nickname = nickname;
    }
}
