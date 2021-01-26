package shop.rp2.colt.src.album;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.rp2.colt.src.album.models.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
