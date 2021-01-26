package shop.rp2.colt.src.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;
import shop.rp2.colt.config.BaseResponse;
import shop.rp2.colt.src.music.models.*;
import shop.rp2.colt.src.user.models.GetMusicLikedUserRes;

import java.util.List;

import static shop.rp2.colt.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/musics")
public class MusicController {

    private final MusicProvider musicProvider;
    private final MusicService musicService;
    private final MusicReplyProvider musicReplyProvider;
    private final MusicReplyService musicReplyService;

    @Autowired
    public MusicController(MusicProvider musicProvider, MusicService musicService, MusicReplyService musicReplyService, MusicReplyProvider musicReplyProvider) {
        this.musicProvider = musicProvider;
        this.musicService = musicService;
        this.musicReplyService = musicReplyService;
        this.musicReplyProvider = musicReplyProvider;
    }

    // 곡 생성
    @PostMapping("/new")
    public BaseResponse<Long> postNewMusic(@RequestBody Music music) {
        try {
            return new BaseResponse<>(SUCCESS_POST_MUSIC, musicService.createMusic(music));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(REQUEST_ERROR);
        }
    }

    // 전체 곡 조회
    @GetMapping("")
    public BaseResponse<List<GetMusicsRes>> getMusics() {
        return new BaseResponse<>(SUCCESS_GET_MUSICS, musicProvider.retrieveMusics());
    }

    // 곡 정보 조회
    @GetMapping("/{musicId}")
    public BaseResponse<GetMusicRes> getMusic(@PathVariable Long musicId) {
        return new BaseResponse<>(SUCCESS_GET_MUSIC_INFO, musicProvider.retrieveMusicById(musicId));
    }

    // 곡 수정
    @PutMapping("/{musicId}")
    public BaseResponse<Long> putMusic(@PathVariable Long musicId, @RequestBody PutMusicReq putMusicReq) {
        try {
            return new BaseResponse<>(SUCCESS_PUT_MUSIC, musicService.updateMusicById(musicId, putMusicReq));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_UPDATE_MUSIC);
        }
    }

    // 곡 삭제
    @DeleteMapping("/{musicId}")
    public BaseResponse<Long> deleteMusic(@PathVariable Long musicId) {
        try {
            return new BaseResponse<>(SUCCESS_DELETE_MUSIC, musicService.deleteMusicById(musicId));
        } catch (EmptyResultDataAccessException e) {
            return new BaseResponse<>(FAILED_DELETE_MUSIC);
        }
    }

    // 곡 좋아요
    @PostMapping("/{musicId}/like")
    public BaseResponse<Long> postLikedOnMusic(@PathVariable Long musicId, @RequestBody PostMusicLikedUserReq postMusicLikedUserReq) {
        try {
            return new BaseResponse<>(SUCCESS_POST_LIKED_ON_MUSIC, musicService.createLikeOnMusicById(musicId, postMusicLikedUserReq));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_POST_LIKED_MUSIC);
        }
    }

    // 곡 좋아요 취소
    @DeleteMapping("/{musicId}/like")
    public BaseResponse<Long> deleteLikedOnMusic(@PathVariable Long musicId, @RequestBody DeleteMusicLikedUserReq deleteMusicLikedUserReq) {
        try {
            return new BaseResponse<>(SUCCESS_DELETE_LIKED_ON_MUSIC, musicService.deleteLikedOnMusicById(musicId, deleteMusicLikedUserReq));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_DELETE_LIKED_MUSIC);
        }
    }

    // 곡 좋아요 한 유저들 조회
    @GetMapping("/{musicId}/liked-users")
    public BaseResponse<List<GetMusicLikedUserRes>> getMusicLikedUsers(@PathVariable Long musicId) {
        return new BaseResponse<>(SUCCESS_GET_MUSIC_LIKED_USERS, musicProvider.retrieveMusicLikedUsers(musicId));
    }

    // 곡 댓글 조회
    @GetMapping("/{musicId}/replys")
    public BaseResponse<List<GetMusicReplyRes>> getMusicReplys(@PathVariable Long musicId) {
        return new BaseResponse<>(SUCCESS_GET_MUSIC_REPLYS, musicReplyProvider.retrieveMusicReplyById(musicId));
    }

    // 곡 댓글 생성
    @PostMapping("/{musicId}/reply")
    public BaseResponse<Long> postReplyInMusic(@PathVariable Long musicId, @RequestBody PostMusicReplyReq postMusicReplyReq) {
        try {
            return new BaseResponse<>(SUCCESS_POST_MUSIC_REPLY, musicReplyService.createMusicReply(musicId, postMusicReplyReq));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_POST_MUSIC_REPLY);
        }
    }

    // 곡 댓글 수정
    @PutMapping("/{musicId}/replys/{replyId}")
    public BaseResponse<Long> putReplyInMusic(@PathVariable Long replyId, @RequestBody PutMusicReplyReq putMusicReplyReq) {
        try {
            return new BaseResponse<>(SUCCESS_PUT_MUSIC_REPLY, musicReplyService.updateMusicReplyById(replyId, putMusicReplyReq));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_PUT_MUSIC_REPLY);
        }
    }

    // 곡 댓글 제거
    @DeleteMapping("/{musicId}/replys/{replyId}")
    public BaseResponse<Long> deleteReplyInMusic(@PathVariable Long replyId, @RequestBody DeleteMusicReplyReq request) {
        try {
            return new BaseResponse<>(SUCCESS_DELETE_MUSIC_REPLY, musicReplyService.deleteMusicReplyById(replyId, request));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_DELETE_MUSIC_REPLY);
        }
    }

    // 곡 댓글 답글 생성
    @PostMapping("/{musicId}/replys/{replyId}/reply")
    public BaseResponse<Long> postReplyOnMusicReply(@PathVariable Long musicId, @PathVariable Long replyId, @RequestBody PostReplyOnMusicReplyReq request) {
        try {
            return new BaseResponse<>(SUCCESS_POST_REPLY_ON_MUSIC_REPLY, musicReplyService.createReplyOnMusicReply(musicId, replyId, request));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_POST_MUSIC_REPLY);
        }
    }

    // 곡 댓글 좋아요 / 싫어요  todo: 댓글 좋아요 테이블 만들어야 함
    @PostMapping("/{musicId}/replys/{replyId}/like")
    public BaseResponse<Long> postLikedOnMusicReply(@PathVariable Long musicId, @PathVariable Long replyId) {
        return null;
    }

    // 곡 댓글 좋아요 / 싫어요 취소 todo: 댓글 좋아요 테이블 만들어야 함
    @DeleteMapping("/{musicId}/replys/{replyId}/like")
    public BaseResponse<Long> deleteLikedOnMusicReply(@PathVariable Long musicId, @PathVariable Long replyId) {
        return null;
    }
}
