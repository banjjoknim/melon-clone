package shop.rp2.colt.src.user.models.user;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetUserProfilesRes {

    private String nickname;
    private String userImage;
    private Long followings;
    private Long followers;

    @QueryProjection
    public GetUserProfilesRes(String nickname, String userImage, Long followings, Long followers) {
        this.nickname = nickname;
        this.userImage = userImage;
        this.followings = followings;
        this.followers = followers;
    }
}
