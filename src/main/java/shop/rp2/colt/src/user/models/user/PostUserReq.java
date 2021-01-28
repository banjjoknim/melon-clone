package shop.rp2.colt.src.user.models.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.rp2.colt.config.Gender;

@NoArgsConstructor
@Getter
public class PostUserReq {

    private String userIdName;
    private String password;
    private String passwordCheck;
    private String userName;
    private Gender gender;
    private String birthday;
    private String email;
    private String cellPhone;
    private String nickname;
    private String userImage;

}
