package shop.rp2.colt.src.music.models;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class GetMusicReplyRes {

    private String nickname;
    private String comment;
    private String createdAt;
    private Long likedCount;
    private Long dislikedCount;
//    private Long hasReplyCount; // 답글 수

    @QueryProjection
    public GetMusicReplyRes(String nickname, String comment, String createdAt, Long likedCount, Long dislikedCount) {
        this.nickname = nickname;
        this.comment = comment;
        this.createdAt = createdAt;
        this.likedCount = likedCount;
        this.dislikedCount = dislikedCount;
    }
}
