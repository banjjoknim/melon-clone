package shop.rp2.colt.src.music;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.rp2.colt.src.music.models.GetMusicReplyRes;
import shop.rp2.colt.src.music.models.QGetMusicReplyRes;

import java.util.List;

import static shop.rp2.colt.src.music.models.QMusicReply.musicReply;
import static shop.rp2.colt.src.user.models.QUser.user;

@Service
public class MusicReplyProvider {

    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public MusicReplyProvider(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    // todo: 댓글에 대한 좋아요 수, 싫어요 수 테이블 및 로직 추가해야함. 입력 날짜 추가해야 함(오류 발생으로 제외)
    public List<GetMusicReplyRes> retrieveMusicReplyById(Long musicId) {

        return jpaQueryFactory
                .select(new QGetMusicReplyRes(
                        user.nickname,
                        musicReply.replyComment,
                        JPAExpressions.select(ExpressionUtils.count(musicReply)).from(musicReply).where(musicReply.musicId.eq(1L)), // 좋아요 수(미완성)
                        JPAExpressions.select(ExpressionUtils.count(musicReply)).from(musicReply).where(musicReply.musicId.eq(1L)), // 싫어요 수(미완성)
                        JPAExpressions.select(ExpressionUtils.count(musicReply)).from(musicReply).where(musicReply.belongToReplyId.eq(0L)) // 답글 보유 수(미완성)
                ))
                .from(user)
                .innerJoin(musicReply).on(user.userId.eq(musicReply.userId))
                .where(musicReply.musicId.eq(musicId))
                .fetch();

    }
}
