package shop.rp2.colt.src.music;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MusicReplyServiceTest {

    private final MusicReplyRepository musicReplyRepository;
    private final MusicReplyService musicReplyService;

    @Autowired
    public MusicReplyServiceTest(MusicReplyRepository musicReplyRepository, MusicReplyService musicReplyService) {
        this.musicReplyRepository = musicReplyRepository;
        this.musicReplyService = musicReplyService;
    }


//    @Test
//    void 음악댓글저장() {
//        musicReplyService.createMusicReply(1L, 1L, "첫 댓글이요~");
//        MusicReply reply = new MusicReply(1L, 1L, "첫 테스트 댓그그글", 1L);
//        musicReplyRepository.save(reply);
//    }
//
//    @Test
//    void 음악댓글수정() {
//        musicReplyService.updateMusicReplyById(14L, "수정 좀 해봣어");
//    }
//
//    @Test
//    void 음악댓글제거() {
//        musicReplyService.deleteMusicReplyById(9L);
//    }
//
//    @Test
//    void 음악댓글답글생성() {
//        musicReplyService.createReplyOnMusicReply(1L, 10L, "답글이야 이건");
//    }
}