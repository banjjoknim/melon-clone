package shop.rp2.colt.src.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.rp2.colt.config.BaseException;
import shop.rp2.colt.config.BaseResponseStatus;
import shop.rp2.colt.src.music.exception.NotFoundMusicException;
import shop.rp2.colt.src.music.exception.NotFoundMusicReplyException;
import shop.rp2.colt.src.music.models.*;
import shop.rp2.colt.src.user.TokenBlacklistRepository;
import shop.rp2.colt.src.user.UserRepository;
import shop.rp2.colt.utils.JwtService;

import static shop.rp2.colt.config.BaseResponseStatus.INVALID_JWT;
import static shop.rp2.colt.config.BaseResponseStatus.NOT_FOUND_USER;

@Service
public class MusicReplyService {

    private final UserRepository userRepository;
    private final MusicRepository musicRepository;
    private final MusicReplyRepository musicReplyRepository;
    private final MusicReplyLikedUserRepository musicReplyLikedUserRepository;
    private final JwtService jwtService;
    private final TokenBlacklistRepository tokenBlacklistRepository;

    @Autowired
    public MusicReplyService(UserRepository userRepository, MusicRepository musicRepository, MusicReplyRepository musicReplyRepository, MusicReplyLikedUserRepository musicReplyLikedUserRepository, JwtService jwtService, TokenBlacklistRepository tokenBlacklistRepository) {
        this.userRepository = userRepository;
        this.musicRepository = musicRepository;
        this.musicReplyRepository = musicReplyRepository;
        this.musicReplyLikedUserRepository = musicReplyLikedUserRepository;
        this.jwtService = jwtService;
        this.tokenBlacklistRepository = tokenBlacklistRepository;
    }

    public Long createMusicReply(Long musicId, PostMusicReplyReq request) throws BaseException {
        if(tokenBlacklistRepository.existsTokenBlacklistByJwtToken(jwtService.getJwt())){
            throw new BaseException(INVALID_JWT);
        }
        userRepository.findById(jwtService.getUserId())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_USER.getMessage()));
        if (request.getComment().isBlank()) {
            throw new IllegalArgumentException("댓글 내용을 입력해주세요.");
        }
        if (!musicRepository.existsMusicByMusicId(musicId)) {
            throw new NotFoundMusicException("존재하지 않는 곡입니다");
        }
        MusicReply reply = new MusicReply(musicId, jwtService.getUserId(), request.getComment());
        musicReplyRepository.save(reply);

        return reply.getReplyId();
    }

    public Long updateMusicReplyById(Long musicId, Long replyId, PutMusicReplyReq request) throws BaseException {
        if(tokenBlacklistRepository.existsTokenBlacklistByJwtToken(jwtService.getJwt())){
            throw new BaseException(INVALID_JWT);
        }
        if (!musicRepository.existsMusicByMusicId(musicId)) {
            throw new NotFoundMusicException("존재하지 않는 곡입니다");
        }
        if (!musicReplyRepository.existsMusicReplyByMusicIdAndReplyId(musicId, replyId)) {
            throw new IllegalArgumentException("존재하지 않는 댓글입니다.");
        }
        if (request.getComment().isBlank()) {
            throw new IllegalArgumentException("댓글 내용을 입력하지 않았습니다.");
        }
        if (!jwtService.getUserId().equals(musicReplyRepository.findById(replyId).get().getUserId())) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }
        musicReplyRepository.updateMusicReply(replyId, request.getComment());

        return replyId;
    }

    public Long deleteMusicReplyById(Long musicId, Long replyId) throws BaseException {
        if(tokenBlacklistRepository.existsTokenBlacklistByJwtToken(jwtService.getJwt())){
            throw new BaseException(INVALID_JWT);
        }
        musicRepository.findById(musicId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 곡입니다."));
        musicReplyRepository.findById(replyId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        if (!jwtService.getUserId().equals(musicReplyRepository.findById(replyId).get().getUserId())) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }
        musicReplyRepository.deleteByReplyId(replyId);

        return replyId;
    }

    public Long createReplyOnMusicReply(Long musicId, Long belongToReplyId, PostReplyOnMusicReplyReq request) throws BaseException {
        if(tokenBlacklistRepository.existsTokenBlacklistByJwtToken(jwtService.getJwt())){
            throw new BaseException(INVALID_JWT);
        }
        if (userRepository.existsUserByUserId(jwtService.getUserId())) {
            throw new IllegalArgumentException(NOT_FOUND_USER.getMessage());
        }
        if (request.getComment().isBlank()) {
            throw new IllegalArgumentException("내용을 입력해주세요.");
        }
        musicRepository.findById(musicId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 곡입니다."));
        musicReplyRepository.findById(belongToReplyId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        MusicReply reply = new MusicReply(musicId, jwtService.getUserId(), request.getComment(), belongToReplyId);
        musicReplyRepository.save(reply);

        return reply.getReplyId();
    }

    public Long updateLikedOnMusicReply(Long musicId, Long replyId, PutLikedOnMusicReplyReq request) throws BaseException {
        if(tokenBlacklistRepository.existsTokenBlacklistByJwtToken(jwtService.getJwt())){
            throw new BaseException(INVALID_JWT);
        }
        if (musicReplyRepository.findById(replyId).isEmpty()) {
            throw new NotFoundMusicReplyException("존재하지 않는 댓글입니다.");
        }
        if (musicReplyLikedUserRepository.existsMusicReplyLikedUserByReplyIdAndAndUserIdAndLiked(replyId, jwtService.getUserId(), request.getLiked().name())) {
            musicReplyLikedUserRepository.deleteMusicReplyLikedUserByReplyIdAndUserIdAndLiked(replyId, jwtService.getUserId(), request.getLiked().name());
            return replyId;
        }
        if (musicReplyLikedUserRepository.existsMusicReplyLikedUserByReplyIdAndUserId(replyId, jwtService.getUserId())) {
            throw new IllegalArgumentException("좋아요와 싫어요는 둘 중에 하나만 할 수 있습니다.");
        }

        MusicReplyLikedUser musicReplyLikedUser = new MusicReplyLikedUser(replyId, jwtService.getUserId(), request.getLiked().name());
        musicReplyLikedUserRepository.save(musicReplyLikedUser);

        return replyId;
    }

}
