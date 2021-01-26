package shop.rp2.colt.src.album;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.rp2.colt.src.album.models.AlbumLikedUser;

import javax.transaction.Transactional;

@Repository
public interface AlbumLikedUserRepository extends JpaRepository<AlbumLikedUser, Long> {

    @Transactional
    @Modifying
    @Query(value = "delete from AlbumLikedUser alu where alu.albumId = :albumId and alu.userId = :userId")
    Integer deleteMusicLikedUserById(@Param("albumId") Long albumId, @Param("userId") Long userId);

    boolean existsAlbumLikedUserByAlbumIdAndUserId(Long albumId, Long userId);

    @Transactional
    Integer deleteAlbumLikedUserByAlbumIdAndUserId(Long albumId, Long userId);

}
