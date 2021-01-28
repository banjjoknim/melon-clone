package shop.rp2.colt.src.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.rp2.colt.src.music.exception.NotFoundMusicException;
import shop.rp2.colt.src.music.exception.NotFoundMusicReplyException;
import shop.rp2.colt.src.music.models.*;

@Service
public class MusicReplyService {

    private final MusicRepository musicRepository;
    private final MusicReplyRepository musicReplyRepository;
    private final MusicReplyLikedUserRepository musicReplyLikedUserRepository;

    @Autowired
    public MusicReplyService(MusicRepository musicRepository, MusicReplyRepository musicReplyRepository, MusicReplyLikedUserRepository musicReplyLikedUserRepository) {
        this.musicRepository = musicRepository;
        this.musicReplyRepository = musicReplyRepository;
        this.musicReplyLikedUserRepository = musicReplyLikedUserRepository;
    }

    public Long createMusicReply(Long musicId, PostMusicReplyReq request) {
        if (request.getComment() == null) {
            throw new IllegalArgumentException("댓글 내용을 입력해주세요.");
        }
        if (!musicRepository.existsMusicByMusicId(musicId)) {
            throw new NotFoundMusicException("존재하지 않는 곡입니다");
        }
        MusicReply reply = new MusicReply(musicId, request.getUserId(), request.getComment());
        musicReplyRepository.save(reply);

        return reply.getReplyId();
    }

    public Long updateMusicReplyById(Long musicId, Long replyId, PutMusicReplyReq request) {
        if (!musicRepository.existsMusicByMusicId(musicId)) {
            throw new NotFoundMusicException("존재하지 않는 곡입니다");
        }
        if (request.getComment() == null) {
            throw new IllegalArgumentException("댓글 내용을 입력해주세요.");
        }
        if (!request.getUserId().equals(musicReplyRepository.findById(replyId).get().getUserId())) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }
        musicReplyRepository.updateMusicReply(replyId, request.getComment());

        return replyId;
    }

    public Long deleteMusicReplyById(Long replyId, DeleteMusicReplyReq request) {
        if (!request.getUserId().equals(musicReplyRepository.findById(replyId).get().getUserId())) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }
        musicReplyRepository.deleteByReplyId(replyId);

        return replyId;
    }

    public Long createReplyOnMusicReply(Long musicId, Long belongToReplyId, PostReplyOnMusicReplyReq request) {
        if (request.getComment() == null) {
            throw new IllegalArgumentException("내용을 입력해주세요.");
        }
        if (musicReplyRepository.findById(belongToReplyId).isEmpty()) {
            throw new NotFoundMusicReplyException("존재하지 않는 댓글입니다.");
        }
        MusicReply reply = new MusicReply(musicId, request.getUserId(), request.getComment(), belongToReplyId);
        musicReplyRepository.save(reply);

        return reply.getReplyId();
    }

    public Long updateLikedOnMusicReply(Long replyId, PutLikedOnMusicReplyReq request) {
        if (musicReplyRepository.findById(replyId).isEmpty()) {
            throw new NotFoundMusicReplyException("존재하지 않는 댓글입니다.");
        }
        if (musicReplyLikedUserRepository.existsMusicReplyLikedUserByReplyIdAndAndUserIdAndLiked(replyId, request.getUserId(), request.getLiked().name())) {
            musicReplyLikedUserRepository.deleteMusicReplyLikedUserByReplyIdAndUserIdAndLiked(replyId, request.getUserId(), request.getLiked().name());
            return replyId;
        }
        if (musicReplyLikedUserRepository.existsMusicReplyLikedUserByReplyIdAndUserId(replyId, request.getUserId())) {
            throw new IllegalArgumentException("좋아요와 싫어요는 둘 중에 하나만 할 수 있습니다.");
        }

        MusicReplyLikedUser musicReplyLikedUser = new MusicReplyLikedUser(replyId, request.getUserId(), request.getLiked().name());
        musicReplyLikedUserRepository.save(musicReplyLikedUser);

        return replyId;
    }

}
