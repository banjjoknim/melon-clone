package shop.rp2.colt.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.rp2.colt.config.BaseException;
import shop.rp2.colt.config.FlagYN;
import shop.rp2.colt.config.Gender;
import shop.rp2.colt.src.user.models.User;
import shop.rp2.colt.src.user.models.user.PostLoginUserReq;

import java.time.LocalDate;

@SpringBootTest
class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    @Test
    void createTest() throws BaseException {
        User user = User.builder()
                .userIdName("first")
                .userImage("image")
                .userName("userName")
                .userPassword("password")
                .birthday(LocalDate.now())
                .cellPhone("111-2222")
                .email("email")
                .gender(Gender.MALE)
                .nickname("nickname")
                .isExit(FlagYN.N)
                .build();

    }

}