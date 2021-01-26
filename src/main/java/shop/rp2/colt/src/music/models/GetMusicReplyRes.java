package shop.rp2.colt.src.music.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetMusicReplyRes {

    private String nickname;
    private String comment;
    private LocalDateTime createdAt;
    private Long likedCount;
    private Long dislikedCount;
    private Long hasReplyCount; // 답글 수

    @QueryProjection
    public GetMusicReplyRes(String nickname, String comment, Long likedCount, Long dislikedCount, Long hasReplyCount) {
        this.nickname = nickname;
        this.comment = comment;
        this.likedCount = likedCount;
        this.dislikedCount = dislikedCount;
        this.hasReplyCount = hasReplyCount;
    }
}
