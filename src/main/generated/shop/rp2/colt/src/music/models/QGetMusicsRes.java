package shop.rp2.colt.src.music.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.music.models.QGetMusicsRes is a Querydsl Projection type for GetMusicsRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetMusicsRes extends ConstructorExpression<GetMusicsRes> {

    private static final long serialVersionUID = -77017243L;

    public QGetMusicsRes(com.querydsl.core.types.Expression<Long> musicId, com.querydsl.core.types.Expression<String> musicTitle, com.querydsl.core.types.Expression<String> singerName, com.querydsl.core.types.Expression<String> albumImage, com.querydsl.core.types.Expression<String> country, com.querydsl.core.types.Expression<java.time.LocalDateTime> registedDate) {
        super(GetMusicsRes.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, java.time.LocalDateTime.class}, musicId, musicTitle, singerName, albumImage, country, registedDate);
    }

}

