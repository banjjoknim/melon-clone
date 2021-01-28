package shop.rp2.colt.src.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.rp2.colt.config.BaseResponse;
import shop.rp2.colt.src.album.models.*;
import shop.rp2.colt.src.singer.exception.NotFoundSingerException;
import shop.rp2.colt.src.user.models.GetAlbumLikedUserRes;

import java.util.List;

import static shop.rp2.colt.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {


    private final AlbumProvider albumProvider;
    private final AlbumService albumService;
    private final AlbumReplyProvider albumReplyProvider;
    private final AlbumReplyService albumReplyService;

    @Autowired
    public AlbumController(AlbumProvider albumProvider, AlbumService albumService, AlbumReplyProvider albumReplyProvider, AlbumReplyService albumReplyService) {
        this.albumProvider = albumProvider;
        this.albumService = albumService;
        this.albumReplyProvider = albumReplyProvider;
        this.albumReplyService = albumReplyService;
    }

    // 앨범 생성
    @PostMapping("/new-album")
    public BaseResponse<Long> postNewAlbum(@RequestBody Album album) {
        try {
            return new BaseResponse<>(SUCCESS_POST_ALBUM, albumService.createAlbum(album));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_POST_ALBUM);
        } catch (NotFoundSingerException e){
            return new BaseResponse<>(NOT_FOUND_SINGER);
        }
    }

    // 전체 앨범 조회
    @GetMapping("")
    public BaseResponse<List<GetAlbumsRes>> getAlbums() {
        return new BaseResponse<>(SUCCESS_GET_ALBUMS, albumProvider.retrieveAlbums());
    }

    // 앨범 정보 조회
    @GetMapping("/{albumId}")
    public GetAlbumRes getAlbum(@PathVariable Long albumId) {
        return null;
    }

    // 앨범 수정
    @PutMapping("/{albumId}")
    public BaseResponse<Long> putAlbum(@PathVariable Long albumId, PutAlbumReq request) {
        return null;
    }

    // 앨범 삭제

    // 앨범 좋아요 및 취소
    @PutMapping("/{albumId}/like")
    public BaseResponse<Long> postLikedOnAlbum(@PathVariable Long albumId, @RequestBody PutAlbumLikedUserReq request) {
        try {
            return new BaseResponse<>(SUCCESS_PUT_LIKED_ON_ALBUM, albumService.createLikeOnAlbumById(albumId, request));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(NOT_FOUND_ALBUM);
        }
    }

    // 앨범 좋아요 한 사람들 조회
    @GetMapping("/{albumId}/liked-users")
    public GetAlbumLikedUserRes getAlbumLikedUser() {
        return null;
    }

    // 앨범 댓글 생성
    @PostMapping("/{albumId}/reply")
    public BaseResponse<Long> postReplyInAlbum(@PathVariable Long albumId) {
        return null;
    }

    // 앨범 댓글 제거
    @DeleteMapping("/{albumId}/replys/{replyId}")
    public BaseResponse<Long> deleteReplyInAbbum(@PathVariable Long albumId, @PathVariable Long replyId) {
        return null;
    }

    // 앨범 댓글 답글 생성
    @PostMapping("/{albumId}/replys/{replyId}/reply")
    public BaseResponse<Long> postReplyOnAlbumReply(@PathVariable Long albumId, @PathVariable Long replyId) {
        return null;
    }

    // 앨범 댓글 좋아요 / 싫어요
    @PostMapping("/{albumId}/replys/{replyId}/like")
    public BaseResponse<Long> postLikedOnAlbumReply() {
        return null;
    }

    // 앨범 댓글 좋아요 / 싫어요 취소
    @DeleteMapping("/{albumId}/replys/{replyId}/like")
    public BaseResponse<Long> deleteLikedOnAlbumReply() {
        return null;
    }
}
