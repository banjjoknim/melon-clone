package shop.rp2.colt.src.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.rp2.colt.src.music.models.*;

@Service
public class MusicReplyService {

    private final MusicReplyRepository musicReplyRepository;

    @Autowired
    public MusicReplyService(MusicReplyRepository musicReplyRepository) {
        this.musicReplyRepository = musicReplyRepository;
    }

    public Long createMusicReply(Long musicId, PostMusicReplyReq request) {
        if (request.getComment() == null) {
            throw new IllegalArgumentException("댓글 내용을 입력해주세요.");
        }
        MusicReply reply = new MusicReply(musicId, request.getUserId(), request.getComment());
        musicReplyRepository.save(reply);
        return reply.getReplyId();
    }

    public Long updateMusicReplyById(Long replyId, PutMusicReplyReq request) {
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
        MusicReply reply = new MusicReply(musicId, request.getUserId(), request.getComment(), belongToReplyId);
        musicReplyRepository.save(reply);
        return reply.getReplyId();
    }
}
