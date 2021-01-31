package shop.rp2.colt.src.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import shop.rp2.colt.config.BaseException;
import shop.rp2.colt.src.album.AlbumRepository;
import shop.rp2.colt.src.album.exception.NotFoundAlbumException;
import shop.rp2.colt.src.music.exception.NotFoundMusicException;
import shop.rp2.colt.src.music.models.Music;
import shop.rp2.colt.src.music.models.MusicLikedUser;
import shop.rp2.colt.src.music.models.PutMusicReq;
import shop.rp2.colt.utils.JwtService;

@Service
public class MusicService {

    private final MusicRepository musicRepository;
    private final MusicLikedUserRepository musicLikedUserRepository;
    private final AlbumRepository albumRepository;
    private final JwtService jwtService;

    @Autowired
    public MusicService(MusicRepository musicRepository, MusicLikedUserRepository musicLikedUserRepository, AlbumRepository albumRepository, JwtService jwtService) {
        this.musicRepository = musicRepository;
        this.musicLikedUserRepository = musicLikedUserRepository;
        this.albumRepository = albumRepository;
        this.jwtService = jwtService;
    }

    public Long createMusic(Music music) {
        if (!albumRepository.existsById(music.getAlbumId())) {
            throw new NotFoundAlbumException("존재하지 않는 앨범 번호입니다.");
        }
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
        if (!musicRepository.existsMusicByMusicId(musicId)) {
            throw new InvalidDataAccessApiUsageException("없는 곡 번호입니다.");
        }
        musicRepository.updateMusicById(musicId, putMusicReq.getMusicTitle(), putMusicReq.getLyrics(), putMusicReq.getPlaytime());
        return musicId;
    }

    public Long deleteMusicById(Long musicId) {
        musicRepository.deleteById(musicId);
        return musicId;
    }

    // 곡 좋아요 또는 좋아요 취소
    public Long updateLikeOnMusicById(Long musicId) throws BaseException {

        Long userId = jwtService.getUserId();
        if (!musicLikedUserRepository.existsMusicLikedUserByUserId(userId)) {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
        if (!musicRepository.existsMusicByMusicId(musicId)){
            throw new NotFoundMusicException("존재하지 않는 곡입니다.");
        }
        if (musicLikedUserRepository.existsMusicLikedUserByMusicIdAndUserId(musicId, userId)) {
            musicLikedUserRepository.deleteMusicLikedUserById(musicId, userId);
            return musicId;
        }
        MusicLikedUser musicLikedUser = new MusicLikedUser(userId, musicId);
        musicLikedUserRepository.save(musicLikedUser);
        return musicId;
    }

}
