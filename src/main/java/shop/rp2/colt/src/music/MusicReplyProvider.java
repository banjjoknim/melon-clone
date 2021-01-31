package shop.rp2.colt.src.music;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.rp2.colt.src.music.exception.NotFoundMusicException;
import shop.rp2.colt.src.music.models.GetMusicReplyRes;
import shop.rp2.colt.src.music.models.QGetMusicReplyRes;

import java.util.List;

import static shop.rp2.colt.src.music.models.QMusicReply.musicReply;
import static shop.rp2.colt.src.music.models.QMusicReplyLikedUser.musicReplyLikedUser;
import static shop.rp2.colt.src.user.models.QUser.user;

@Service
public class MusicReplyProvider {

    private final JPAQueryFactory jpaQueryFactory;
    private final MusicReplyRepository musicReplyRepository;
    private final MusicRepository musicRepository;

    @Autowired
    public MusicReplyProvider(JPAQueryFactory jpaQueryFactory, MusicReplyRepository musicReplyRepository, MusicRepository musicRepository) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.musicReplyRepository = musicReplyRepository;
        this.musicRepository = musicRepository;
    }

    // todo : 답글 보유 수 로직 추가할 것.
    public List<GetMusicReplyRes> retrieveMusicReplyById(Long musicId) {

        if (!musicRepository.existsMusicByMusicId(musicId)) {
            throw new NotFoundMusicException("존재하지 않는 곡입니다.");
        }

        return jpaQueryFactory
                .select(new QGetMusicReplyRes(
                        user.nickname,
                        musicReply.replyComment,
                        Expressions.stringTemplate("DATE_FORMAT({0}, '%Y.%m.%d')", musicReply.createdAt), // 댓글 작성일
                        JPAExpressions.select(ExpressionUtils.count(musicReplyLikedUser))
                                .from(musicReplyLikedUser)
                                .where(musicReplyLikedUser.replyId.eq(musicReply.replyId).and(musicReplyLikedUser.liked.eq("Y"))), // 좋아요 수
                        JPAExpressions.select(ExpressionUtils.count(musicReplyLikedUser))
                                .from(musicReplyLikedUser)
                                .where(musicReplyLikedUser.replyId.eq(musicReply.replyId).and(musicReplyLikedUser.liked.eq("N"))) // 싫어요 수
//                        JPAExpressions.select(ExpressionUtils.count(musicReply))
//                                .from(musicReply)
//                                .where(musicReply.belongToReplyId.eq(musicReply.replyId)) // 답글 보유 수(미완성)

                ))
                .from(user)
                .innerJoin(musicReply).on(user.userId.eq(musicReply.userId))
                .where(musicReply.musicId.eq(musicId))
                .fetch();

    }
}
