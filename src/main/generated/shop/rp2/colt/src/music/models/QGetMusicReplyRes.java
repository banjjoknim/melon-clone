package shop.rp2.colt.src.music.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.music.models.QGetMusicReplyRes is a Querydsl Projection type for GetMusicReplyRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetMusicReplyRes extends ConstructorExpression<GetMusicReplyRes> {

    private static final long serialVersionUID = 228793774L;

    public QGetMusicReplyRes(com.querydsl.core.types.Expression<String> nickname, com.querydsl.core.types.Expression<String> comment, com.querydsl.core.types.Expression<Long> likedCount, com.querydsl.core.types.Expression<Long> dislikedCount, com.querydsl.core.types.Expression<Long> hasReplyCount) {
        super(GetMusicReplyRes.class, new Class<?>[]{String.class, String.class, long.class, long.class, long.class}, nickname, comment, likedCount, dislikedCount, hasReplyCount);
    }

}

