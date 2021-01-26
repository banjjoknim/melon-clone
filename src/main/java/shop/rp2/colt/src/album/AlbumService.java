package shop.rp2.colt.src.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.rp2.colt.src.album.models.Album;
import shop.rp2.colt.src.album.models.AlbumLikedUser;
import shop.rp2.colt.src.album.models.DeleteAlbumLikedUserReq;
import shop.rp2.colt.src.album.models.PostAlbumLikedUserReq;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumLikedUserRepository albumLikedUserRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository, AlbumLikedUserRepository albumLikedUserRepository) {
        this.albumRepository = albumRepository;
        this.albumLikedUserRepository = albumLikedUserRepository;
    }

    public Long createLikeOnAlbumById(Long albumId, PostAlbumLikedUserReq request) {
        AlbumLikedUser albumLikedUser = new AlbumLikedUser(request.getUserId(), albumId);
        albumLikedUserRepository.save(albumLikedUser);
        return albumId;
    }

    public Long deleteLikedOnAlbumById(Long albumId, DeleteAlbumLikedUserReq request) {
        albumLikedUserRepository.deleteAlbumLikedUserByAlbumIdAndUserId(albumId, request.getUserId());
        return albumId;
    }

    public Long createAlbum(Album album) {
        if (album.getAlbumTitle() == null || album.getGenreId() == null || album.getSingerId() == null) {
            throw new IllegalArgumentException("입력하지 않은 값이 있습니다.");
        }
        albumRepository.save(album);
        return album.getAlbumId();
    }
}
