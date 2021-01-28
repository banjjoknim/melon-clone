package shop.rp2.colt.src.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.rp2.colt.src.music.models.MusicLikedUser;

import javax.transaction.Transactional;

@Repository
public interface MusicLikedUserRepository extends JpaRepository<MusicLikedUser, Long> {

    @Transactional
    @Modifying
    @Query(value = "delete from MusicLikedUser mlu where mlu.musicId = :musicId and mlu.userId = :userId")
    Integer deleteMusicLikedUserById(@Param("musicId") Long musicId, @Param("userId") Long userId);

    boolean existsMusicLikedUserByMusicIdAndUserId(Long musicId, Long userId);

}
