package shop.rp2.colt.src.album.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.album.models.QGetAlbumsRes is a Querydsl Projection type for GetAlbumsRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetAlbumsRes extends ConstructorExpression<GetAlbumsRes> {

    private static final long serialVersionUID = -1012420103L;

    public QGetAlbumsRes(com.querydsl.core.types.Expression<Long> albumId, com.querydsl.core.types.Expression<String> albumTitle, com.querydsl.core.types.Expression<String> singerName, com.querydsl.core.types.Expression<String> albumImage, com.querydsl.core.types.Expression<java.time.LocalDateTime> releaseDate, com.querydsl.core.types.Expression<Double> rating, com.querydsl.core.types.Expression<Long> scoredUserCount) {
        super(GetAlbumsRes.class, new Class<?>[]{long.class, String.class, String.class, String.class, java.time.LocalDateTime.class, double.class, long.class}, albumId, albumTitle, singerName, albumImage, releaseDate, rating, scoredUserCount);
    }

}

