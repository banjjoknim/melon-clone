package shop.rp2.colt.src.video.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.video.models.QGetVideosRes is a Querydsl Projection type for GetVideosRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetVideosRes extends ConstructorExpression<GetVideosRes> {

    private static final long serialVersionUID = 761756177L;

    public QGetVideosRes(com.querydsl.core.types.Expression<Long> videoId, com.querydsl.core.types.Expression<String> videoTitle, com.querydsl.core.types.Expression<String> singerName, com.querydsl.core.types.Expression<String> videoImage, com.querydsl.core.types.Expression<java.time.LocalTime> playtime, com.querydsl.core.types.Expression<Long> viewCount, com.querydsl.core.types.Expression<java.time.LocalDateTime> releaseDate) {
        super(GetVideosRes.class, new Class<?>[]{long.class, String.class, String.class, String.class, java.time.LocalTime.class, long.class, java.time.LocalDateTime.class}, videoId, videoTitle, singerName, videoImage, playtime, viewCount, releaseDate);
    }

}

