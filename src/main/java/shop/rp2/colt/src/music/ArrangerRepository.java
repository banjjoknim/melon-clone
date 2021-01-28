package shop.rp2.colt.src.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.rp2.colt.src.music.models.Arranger;

@Repository
public interface ArrangerRepository extends JpaRepository<Arranger, Long> {

}
