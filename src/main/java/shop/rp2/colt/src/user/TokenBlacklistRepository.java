package shop.rp2.colt.src.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.rp2.colt.src.user.models.user.TokenBlacklist;

@Repository
public interface TokenBlacklistRepository extends JpaRepository<TokenBlacklist, Long> {

    boolean existsTokenBlacklistByJwtToken(String jwtToken);

}
