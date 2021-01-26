package shop.rp2.colt.src.singer;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class TestSinger {

    private Long singerId;
    private String singerName;

    @QueryProjection
    public TestSinger(Long singerId, String singerName) {
        this.singerId = singerId;
        this.singerName = singerName;
    }
}
