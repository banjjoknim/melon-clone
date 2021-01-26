package shop.rp2.colt.src.music;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MusicLikedUserRepositoryTest {

    @Autowired
    private MusicLikedUserRepository musicLikedUserRepository;

    @Test
    void test() {
        System.out.println(musicLikedUserRepository.findMusicLikedUserById(2L, 1L));
    }
}