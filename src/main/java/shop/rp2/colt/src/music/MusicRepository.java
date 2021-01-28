package shop.rp2.colt.src.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.rp2.colt.src.music.models.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

    @Transactional
    @Modifying // todo: 논리적 제거, 공개여부 수정 추가해야함.
    @Query(value = "update Music m set m.musicTitle = :musicTitle, m.lyrics = :lyrics, m.playtime = :playtime where m.musicId = :musicId")
    Integer updateMusicById(@Param("musicId") Long musicId, @Param("musicTitle") String musicTitle, @Param("lyrics") String lyrics, @Param("playtime") String playtime);

    boolean existsMusicByMusicId(Long musicId);
}
