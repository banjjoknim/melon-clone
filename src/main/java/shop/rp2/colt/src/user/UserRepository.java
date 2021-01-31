package shop.rp2.colt.src.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.rp2.colt.src.user.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByUserIdName(String userIdName);

    boolean existsUserByEmail(String email);

    boolean existsUserByNickname(String nickname);

    boolean existsUserByUserId(Long userId);

    boolean existsUserByCellPhone(String cellPhone);

    @Transactional
    @Modifying
    @Query(value = "update User u set u.cellPhone = :cellPhone, u.email = :email, u.nickname = :nickname, u.userImage = :userImage where u.userId = :userId")
    Integer updateUserById(@Param("cellPhone") String cellPhone, @Param("email") String email, @Param("nickname") String nickname, @Param("userImage") String userImage, @Param("userId") Long userId);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUserIdNameAndUserPassword(String userIdName, String userPassword);
}
