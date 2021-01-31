package shop.rp2.colt.src.user.models.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.rp2.colt.config.BaseTimeEntity;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "FOLLOWERS")
public class Followers extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "followers_id")
    private Long followersId;

    @Column(name = "following_user_id")
    private Long followingUserId;

    @Column(name = "followed_user_id")
    private Long followedUserId;

}
