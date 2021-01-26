package shop.rp2.colt.src.album.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.album.models.QGetAlbumRes is a Querydsl Projection type for GetAlbumRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetAlbumRes extends ConstructorExpression<GetAlbumRes> {

    private static final long serialVersionUID = -1418163148L;

    public QGetAlbumRes(com.querydsl.core.types.Expression<Long> albumId, com.querydsl.core.types.Expression<String> albumTitle, com.querydsl.core.types.Expression<String> albumImage, com.querydsl.core.types.Expression<String> singerName, com.querydsl.core.types.Expression<String> singerImage, com.querydsl.core.types.Expression<String> soundQuality, com.querydsl.core.types.Expression<Long> likedUserCount, com.querydsl.core.types.Expression<Long> replyCount) {
        super(GetAlbumRes.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, long.class, long.class}, albumId, albumTitle, albumImage, singerName, singerImage, soundQuality, likedUserCount, replyCount);
    }

}

