package shop.rp2.colt.src.user.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.user.models.QGetAlbumLikedUserRes is a Querydsl Projection type for GetAlbumLikedUserRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetAlbumLikedUserRes extends ConstructorExpression<GetAlbumLikedUserRes> {

    private static final long serialVersionUID = 1040691732L;

    public QGetAlbumLikedUserRes(com.querydsl.core.types.Expression<Long> albumId, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userImage, com.querydsl.core.types.Expression<String> nickname, com.querydsl.core.types.Expression<Long> hasPlaylistCount) {
        super(GetAlbumLikedUserRes.class, new Class<?>[]{long.class, long.class, String.class, String.class, long.class}, albumId, userId, userImage, nickname, hasPlaylistCount);
    }

}

