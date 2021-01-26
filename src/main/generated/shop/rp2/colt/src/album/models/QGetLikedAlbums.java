package shop.rp2.colt.src.album.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.album.models.QGetLikedAlbums is a Querydsl Projection type for GetLikedAlbums
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetLikedAlbums extends ConstructorExpression<GetLikedAlbums> {

    private static final long serialVersionUID = -1982709106L;

    public QGetLikedAlbums(com.querydsl.core.types.Expression<Long> albumId, com.querydsl.core.types.Expression<String> albumTitle, com.querydsl.core.types.Expression<String> singerName, com.querydsl.core.types.Expression<String> albumImage, com.querydsl.core.types.Expression<java.time.LocalDateTime> releaseDate, com.querydsl.core.types.Expression<Double> rating, com.querydsl.core.types.Expression<Long> scoredUserCount) {
        super(GetLikedAlbums.class, new Class<?>[]{long.class, String.class, String.class, String.class, java.time.LocalDateTime.class, double.class, long.class}, albumId, albumTitle, singerName, albumImage, releaseDate, rating, scoredUserCount);
    }

}

