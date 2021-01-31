package shop.rp2.colt.src.user.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import shop.rp2.colt.config.FlagYN;
import shop.rp2.colt.config.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@DynamicInsert
@Getter
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_id_name")
    private String userIdName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "cell_phone")
    private String cellPhone;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "user_image")
    private String userImage;

    @Column(name = "is_exit")
    @Enumerated(EnumType.STRING)
    private FlagYN isExit;

    @Builder
    public User(String userIdName, String userPassword, String userName, Gender gender, LocalDate birthday, String email, String cellPhone, String nickname, String userImage, FlagYN isExit) {
        this.userIdName = userIdName;
        this.userPassword = userPassword;
        this.userName = userName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.cellPhone = cellPhone;
        this.nickname = nickname;
        this.userImage = userImage;
        this.isExit = isExit;
    }

}
