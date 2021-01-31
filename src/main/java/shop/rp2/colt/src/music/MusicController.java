package shop.rp2.colt.src.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.web.bind.annotation.*;
import shop.rp2.colt.config.BaseException;
import shop.rp2.colt.config.BaseResponse;
import shop.rp2.colt.src.album.exception.NotFoundAlbumException;
import shop.rp2.colt.src.music.exception.NotFoundMusicException;
import shop.rp2.colt.src.music.exception.NotFoundMusicReplyException;
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
    @PostMapping("/new-music")
    public BaseResponse<Long> postNewMusic(@RequestBody Music music) {
        try {
            return new BaseResponse<>(SUCCESS_POST_MUSIC, musicService.createMusic(music));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_POST_MUSIC);
        } catch (NotFoundAlbumException e) {
            return new BaseResponse<>(NOT_FOUND_ALBUM);
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
        try {
            return new BaseResponse<>(SUCCESS_GET_MUSIC_INFO, musicProvider.retrieveMusicById(musicId));
        } catch (InvalidDataAccessApiUsageException | IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_GET_MUSIC);
        }
    }

    // 곡 가사 조회
    @GetMapping("/{musicId}/lyrics")
    public BaseResponse<GetMusicLyricsRes> getMusicLyrics(@PathVariable Long musicId) {
        return new BaseResponse<>(SUCCESS_GET_MUSIC_INFO, musicProvider.retrieveMusicLyrics(musicId));
    }

    // 곡 상세정보 조회
    @GetMapping("/{musicId}/details")
    public BaseResponse<GetMusicInfoRes> getMusicInfo(@PathVariable Long musicId) {
        return new BaseResponse<>(SUCCESS_GET_MUSIC_INFO, musicProvider.retrieveMusicDetails(musicId));
    }

    // 곡 수정
    @PutMapping("/{musicId}")
    public BaseResponse<Long> putMusic(@PathVariable Long musicId, @RequestBody PutMusicReq putMusicReq) {
        try {
            return new BaseResponse<>(SUCCESS_PUT_MUSIC, musicService.updateMusicById(musicId, putMusicReq));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_UPDATE_MUSIC);
        } catch (InvalidDataAccessApiUsageException e) {
            return new BaseResponse<>(NOT_FOUND_MUSIC);
        }
    }

    // 곡 삭제
    @DeleteMapping("/{musicId}")
    public BaseResponse<Long> deleteMusic(@PathVariable Long musicId) {
        try {
            return new BaseResponse<>(SUCCESS_DELETE_MUSIC, musicService.deleteMusicById(musicId));
        } catch (EmptyResultDataAccessException e) {
            return new BaseResponse<>(NOT_FOUND_MUSIC);
        }
    }

    // 곡 좋아요 / 좋아요 취소
    // todo: 곡 좋아요, 좋아요 취소 구분로직 추가할 것.
    @PutMapping("/{musicId}/likes")
    public BaseResponse<Long> putLikedOnMusic(@PathVariable Long musicId) {
        try {
            return new BaseResponse<>(SUCCESS_POST_OR_DELETE_LIKED_ON_MUSIC, musicService.updateLikeOnMusicById(musicId));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(NOT_FOUND_USER)) {
                return new BaseResponse<>(NOT_FOUND_USER);
            }
            return new BaseResponse<>(NOT_FOUND_MUSIC);
        } catch (BaseException e) {
            return new BaseResponse<>(INVALID_JWT);
        }
    }

    // 곡 좋아요 한 유저들 조회
    // todo: 해당 유저가 가진 플레이리스트 수 얻어오는 로직 추가할 것.
    @GetMapping("/{musicId}/liked-users")
    public BaseResponse<List<GetMusicLikedUserRes>> getMusicLikedUsers(@PathVariable Long musicId) {
        try {
            return new BaseResponse<>(SUCCESS_GET_MUSIC_LIKED_USERS, musicProvider.retrieveMusicLikedUsers(musicId));
        } catch (NotFoundMusicException e) {
            return new BaseResponse<>(NOT_FOUND_MUSIC);
        }
    }

    // 곡 댓글 조회
    @GetMapping("/{musicId}/replys")
    public BaseResponse<List<GetMusicReplyRes>> getMusicReplys(@PathVariable Long musicId) {
        try {
            return new BaseResponse<>(SUCCESS_GET_MUSIC_REPLYS, musicReplyProvider.retrieveMusicReplyById(musicId));
        } catch (NotFoundMusicException e) {
            return new BaseResponse<>(NOT_FOUND_MUSIC);
        }
    }

    // 곡 댓글 생성
    @PostMapping("/{musicId}/replys")
    public BaseResponse<Long> postReplyInMusic(@PathVariable Long musicId, @RequestBody PostMusicReplyReq postMusicReplyReq) {
        try {
            return new BaseResponse<>(SUCCESS_POST_MUSIC_REPLY, musicReplyService.createMusicReply(musicId, postMusicReplyReq));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(NOT_FOUND_USER.getMessage())) {
                return new BaseResponse<>(NOT_FOUND_USER);
            }
            return new BaseResponse<>(NOT_INPUT_CONTENT);
        } catch (NotFoundMusicException e) {
            return new BaseResponse<>(NOT_FOUND_MUSIC);
        } catch (BaseException e) {
            return new BaseResponse<>(INVALID_JWT);
        }
    }

    // 곡 댓글 수정
    @PutMapping("/{musicId}/replys/{replyId}")
    public BaseResponse<Long> putReplyInMusic(@PathVariable Long musicId, @PathVariable Long replyId, @RequestBody PutMusicReplyReq putMusicReplyReq) {
        try {
            return new BaseResponse<>(SUCCESS_PUT_MUSIC_REPLY, musicReplyService.updateMusicReplyById(musicId, replyId, putMusicReplyReq));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(NOT_FOUND_MUSIC_REPLY.getMessage())) {
                return new BaseResponse<>(NOT_FOUND_MUSIC_REPLY);
            }
            if (e.getMessage().equals(NOT_INPUT_CONTENT.getMessage())) {
                return new BaseResponse<>(NOT_INPUT_CONTENT);
            }
            return new BaseResponse<>(HAS_NOT_AUTHORITY);
        } catch (NotFoundMusicException e) {
            return new BaseResponse<>(NOT_FOUND_MUSIC);
        } catch (BaseException e) {
            return new BaseResponse<>(INVALID_JWT);
        }
    }

    // 곡 댓글 제거
    @DeleteMapping("/{musicId}/replys/{replyId}")
    public BaseResponse<Long> deleteReplyInMusic(@PathVariable Long musicId, @PathVariable Long replyId) {
        try {
            return new BaseResponse<>(SUCCESS_DELETE_MUSIC_REPLY, musicReplyService.deleteMusicReplyById(musicId, replyId));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(NOT_FOUND_MUSIC.getMessage())) {
                return new BaseResponse<>(NOT_FOUND_MUSIC);
            }
            if (e.getMessage().equals(NOT_FOUND_MUSIC_REPLY)) {
                return new BaseResponse<>(NOT_FOUND_MUSIC_REPLY);
            }
            return new BaseResponse<>(HAS_NOT_AUTHORITY);
        } catch (BaseException e) {
            return new BaseResponse<>(INVALID_JWT);
        }
    }

    // 곡 댓글 답글 생성
    @PostMapping("/{musicId}/replys/{replyId}/replys")
    public BaseResponse<Long> postReplyOnMusicReply(@PathVariable Long musicId, @PathVariable Long replyId, @RequestBody PostReplyOnMusicReplyReq request) {
        try {
            return new BaseResponse<>(SUCCESS_POST_REPLY_ON_MUSIC_REPLY, musicReplyService.createReplyOnMusicReply(musicId, replyId, request));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(NOT_FOUND_USER.getMessage())) {
                return new BaseResponse<>(NOT_FOUND_USER);
            }
            return new BaseResponse<>(NOT_INPUT_CONTENT);
        } catch (NotFoundMusicException e) {
            return new BaseResponse<>(NOT_FOUND_MUSIC);
        } catch (NotFoundMusicReplyException e) {
            return new BaseResponse<>(NOT_FOUND_MUSIC_REPLY);
        } catch (BaseException e) {
            return new BaseResponse<>(INVALID_JWT);
        }
    }

    // todo : 좋아요, 싫어요 취소 메세지 로직 추가할 것.
    // 곡 댓글 좋아요, 싫어요 또는 취소
    @PutMapping("/{musicId}/replys/{replyId}/likes")
    public BaseResponse<Long> updateLikedOnMusicReply(@PathVariable Long musicId, @PathVariable Long replyId, @RequestBody PutLikedOnMusicReplyReq request
    ) {
        try {
            if (request.getLiked().name().equals("Y")) {
                return new BaseResponse<>(SUCCESS_POST_LIKED_ON_MUSIC_REPLY, musicReplyService.updateLikedOnMusicReply(musicId, replyId, request));
            }
            return new BaseResponse<>(SUCCESS_POST_DISLIKED_ON_MUSIC_REPLY, musicReplyService.updateLikedOnMusicReply(musicId, replyId, request));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(FAILED_TO_PUT_LIKED_ON_MUSIC_REPLY);
        } catch (NotFoundMusicReplyException e) {
            return new BaseResponse<>(NOT_FOUND_MUSIC_REPLY);
        } catch (BaseException e) {
            return new BaseResponse<>(INVALID_JWT);
        }
    }

}
