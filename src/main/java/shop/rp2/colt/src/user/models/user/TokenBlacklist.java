package shop.rp2.colt.src.user.models.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import shop.rp2.colt.config.BaseTimeEntity;

import javax.persistence.*;

@NoArgsConstructor
@DynamicInsert
@Getter
@Entity
@Table(name = "TOKEN_BLACKLIST")
public class TokenBlacklist extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_blacklist_id")
    private Long tokenBlacklistId;

    @Column(name = "jwt_token")
    private String jwtToken;

    @Builder
    public TokenBlacklist(String token) {
        this.jwtToken = jwtToken;
    }
}
