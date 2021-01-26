package shop.rp2.colt.src.user.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.user.models.QGetMusicLikedUserRes is a Querydsl Projection type for GetMusicLikedUserRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetMusicLikedUserRes extends ConstructorExpression<GetMusicLikedUserRes> {

    private static final long serialVersionUID = 70074570L;

    public QGetMusicLikedUserRes(com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userImage, com.querydsl.core.types.Expression<String> nickname) {
        super(GetMusicLikedUserRes.class, new Class<?>[]{long.class, String.class, String.class}, userId, userImage, nickname);
    }

}

