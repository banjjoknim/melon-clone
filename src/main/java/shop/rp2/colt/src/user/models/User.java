package shop.rp2.colt.src.user.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import shop.rp2.colt.config.FlagYN;

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

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "gender")
    private String gender;

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
}
