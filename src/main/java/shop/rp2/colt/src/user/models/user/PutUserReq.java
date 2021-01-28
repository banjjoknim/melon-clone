package shop.rp2.colt.src.user.models.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PutUserReq {

    private Long userId;
    private String password;
    private String email;
    private String cellPhone;
    private String nickname;
    private String userImage;
}
