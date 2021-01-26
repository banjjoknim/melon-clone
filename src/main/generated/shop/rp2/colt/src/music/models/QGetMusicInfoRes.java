package shop.rp2.colt.src.music.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.music.models.QGetMusicInfoRes is a Querydsl Projection type for GetMusicInfoRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetMusicInfoRes extends ConstructorExpression<GetMusicInfoRes> {

    private static final long serialVersionUID = 1273903546L;

    public QGetMusicInfoRes(com.querydsl.core.types.Expression<String> singerName, com.querydsl.core.types.Expression<String> lyricWriterName, com.querydsl.core.types.Expression<String> composerName, com.querydsl.core.types.Expression<String> arrangerName, com.querydsl.core.types.Expression<String> genreName) {
        super(GetMusicInfoRes.class, new Class<?>[]{String.class, String.class, String.class, String.class, String.class}, singerName, lyricWriterName, composerName, arrangerName, genreName);
    }

}

