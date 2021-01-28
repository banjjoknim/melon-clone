package shop.rp2.colt.src.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.rp2.colt.src.album.models.Album;
import shop.rp2.colt.src.album.models.AlbumLikedUser;
import shop.rp2.colt.src.album.models.PutAlbumLikedUserReq;
import shop.rp2.colt.src.singer.SingerRepository;
import shop.rp2.colt.src.singer.exception.NotFoundSingerException;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumLikedUserRepository albumLikedUserRepository;
    private final SingerRepository singerRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository, AlbumLikedUserRepository albumLikedUserRepository, SingerRepository singerRepository) {
        this.albumRepository = albumRepository;
        this.albumLikedUserRepository = albumLikedUserRepository;
        this.singerRepository = singerRepository;
    }

    public Long createAlbum(Album album) {
        if (!singerRepository.existsById(album.getSingerId())) {
            throw new NotFoundSingerException("존재하지 않는 가수입니다.");
        }
        if (album.getAlbumTitle() == null || album.getGenreId() == null || album.getSingerId() == null) {
            throw new IllegalArgumentException("입력하지 않은 값이 있습니다.");
        }
        albumRepository.save(album);
        return album.getAlbumId();
    }

    public Long createLikeOnAlbumById(Long albumId, PutAlbumLikedUserReq request) {
        if (!albumRepository.existsById(albumId)) {
            throw new IllegalArgumentException("존재하지 않는 앨범입니다.");
        }
        if (albumLikedUserRepository.existsAlbumLikedUserByAlbumIdAndUserId(albumId, request.getUserId())) {
            return deleteLikedOnAlbumById(albumId, request);
        }
        AlbumLikedUser albumLikedUser = new AlbumLikedUser(request.getUserId(), albumId);
        albumLikedUserRepository.save(albumLikedUser);
        return albumId;
    }

    private Long deleteLikedOnAlbumById(Long albumId, PutAlbumLikedUserReq request) {
        albumLikedUserRepository.deleteAlbumLikedUserByAlbumIdAndUserId(albumId, request.getUserId());
        return albumId;
    }

}
