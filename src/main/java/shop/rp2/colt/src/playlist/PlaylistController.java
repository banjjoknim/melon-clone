package shop.rp2.colt.src.playlist;

import org.springframework.web.bind.annotation.*;
import shop.rp2.colt.config.BaseResponse;
import shop.rp2.colt.src.playlist.models.GetPlaylistsRes;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    // 전체 플레이리스트 조회
    @GetMapping("")
    public BaseResponse<List<GetPlaylistsRes>> getPlaylists() {
        return null;
    }

    // 플레이리스트 정보 조회
    @GetMapping("/{playlistId}")
    public BaseResponse<GetPlaylistsRes> getPlaylist(@PathVariable Long playlistId) {
        return null;
    }

    // 플레이리스트 좋아요 한 사람들 조회
    @GetMapping("/{playlistId}/liked-users")
    public BaseResponse<List> getPlaylistLikedUsers(@PathVariable Long playlistId) {
        return null;
    }

    // 플레이리스트 댓글 생성
    @PostMapping("/{playlistId}/reply")
    public BaseResponse<Long> postReplyInPlaylist(@PathVariable Long playlistId) {
        return null;
    }

    // 플레이리스트 댓글 제거
    @DeleteMapping("/{playlistId}/replys/{replyId}")
    public BaseResponse<Long> deleteReplyOnPlaylist(@PathVariable Long playlistId, @PathVariable Long replyId) {
        return null;
    }

    // 플레이리스트 댓글 답글 생성
    @PostMapping("/{playlistId}/replys/{replyId}/reply")
    public BaseResponse<Long> postReplyOnPlaylistReply(@PathVariable Long playlistId, @PathVariable Long replyId) {
        return null;
    }

    // 플레이리스트 댓글 좋아요 / 싫어요
    @PostMapping("/{playlistId}/replys/{replyId}/like")
    public BaseResponse<Long> postLikedOnPlaylistReply(@PathVariable Long playlistId, @PathVariable Long replyId) {
        return null;
    }

    // 플레이리스트 댓글 좋아요 / 싫어요 취소
    @DeleteMapping("/{playlistId}/replys/{replyId}/like")
    public BaseResponse<Long> deleteLikedOnPlaylistReply(@PathVariable Long playlistId, @PathVariable Long replyId) {
        return null;
    }
 
}
