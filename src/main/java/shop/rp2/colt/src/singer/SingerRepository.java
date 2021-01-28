package shop.rp2.colt.src.singer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.rp2.colt.src.singer.models.Singer;

@Repository
public interface SingerRepository extends JpaRepository<Singer, Long> {

}
