package shop.rp2.colt.src.music;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.rp2.colt.src.music.models.PutMusicReq;

@SpringBootTest
class MusicServiceTest {

    @Autowired
    private MusicService musicService;

    @Autowired
    private MusicReplyService musicReplyService;

    @Autowired
    private MusicReplyProvider musicReplyProvider;

    @Autowired
    private JPAQueryFactory queryFactory;

    @Test
    void 음악좋아요() {
//        PostMusicLikedUserReq postMusicLikedUserReq = PostMusicLikedUserReq.builder()
//                .userId(1L)
//                .liked(FlagYN.Y)
//                .build();
//        musicService.createLikeOnMusicById(9L, postMusicLikedUserReq);
    }

//    @Test
//    void 음악좋아요취소() {
//        musicService.deleteLikedOnMusicById(9L, 1L);
//    }

    @Test
    void 음악댓글보기() {
        musicReplyProvider.retrieveMusicReplyById(1L).stream()
                .map(getMusicReplyRes -> getMusicReplyRes.getHasReplyCount())
                .forEach(System.out::println);
    }

    @Test
    void 음악수정() {
        PutMusicReq putMusicReq = new PutMusicReq();
        musicService.updateMusicById(14L, putMusicReq);
    }

//    @Test
//    void 좋아요취소() {
//        musicService.deleteLikedOnMusicById(1L, 1L);
//    }

}