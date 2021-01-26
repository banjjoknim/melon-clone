package shop.rp2.colt.src.user.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.user.models.QGetPlaylistLikedUserRes is a Querydsl Projection type for GetPlaylistLikedUserRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetPlaylistLikedUserRes extends ConstructorExpression<GetPlaylistLikedUserRes> {

    private static final long serialVersionUID = -256482147L;

    public QGetPlaylistLikedUserRes(com.querydsl.core.types.Expression<Long> playlistId, com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<String> userImage, com.querydsl.core.types.Expression<String> nickname, com.querydsl.core.types.Expression<Long> hasPlaylistCount) {
        super(GetPlaylistLikedUserRes.class, new Class<?>[]{long.class, long.class, String.class, String.class, long.class}, playlistId, userId, userImage, nickname, hasPlaylistCount);
    }

}

