package shop.rp2.colt.src.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.rp2.colt.src.music.models.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import java.util.List;

@Service
public class MusicService {

    private final MusicRepository musicRepository;
    private final MusicLikedUserRepository musicLikedUserRepository;

    @Autowired
    public MusicService(MusicRepository musicRepository, MusicLikedUserRepository musicLikedUserRepository) {
        this.musicRepository = musicRepository;
        this.musicLikedUserRepository = musicLikedUserRepository;
    }

    public Long createMusic(Music music) {
        if (music.getMusicTitle() == null || music.getLyrics() == null || music.getPlaytime() == null) {
            throw new IllegalArgumentException("입력하지 않은 값이 있습니다.");
        }
        musicRepository.save(music);
        return music.getMusicId();
    }

    public Long updateMusicById(Long musicId, PutMusicReq putMusicReq) {
        if (putMusicReq.getMusicTitle() == null || putMusicReq.getLyrics() == null || putMusicReq.getPlaytime() == null) {
            throw new IllegalArgumentException("입력하지 않은 값이 있습니다.");
        }
        musicRepository.updateMusicById(musicId, putMusicReq.getMusicTitle(), putMusicReq.getLyrics(), putMusicReq.getPlaytime());
        return musicId;
    }

    public Long deleteMusicById(Long musicId) {
        musicRepository.deleteById(musicId);
        return musicId;
    }

    // todo : 좋아요 싫어요 구분 로직 추가할 것
    public Long createLikeOnMusicById(Long musicId, PostMusicLikedUserReq request) {
        MusicLikedUser musicLikedUser = new MusicLikedUser(request.getUserId(), musicId);
        musicLikedUserRepository.save(musicLikedUser);
        return musicId;
    }


    public Long deleteLikedOnMusicById(Long musicId, DeleteMusicLikedUserReq request) {
        musicLikedUserRepository.deleteMusicLikedUserById(musicId, request.getUserId());
        return musicId;
    }

}
