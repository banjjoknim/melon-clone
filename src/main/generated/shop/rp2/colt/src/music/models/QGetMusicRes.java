package shop.rp2.colt.src.music.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.music.models.QGetMusicRes is a Querydsl Projection type for GetMusicRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetMusicRes extends ConstructorExpression<GetMusicRes> {

    private static final long serialVersionUID = 967315784L;

    public QGetMusicRes(com.querydsl.core.types.Expression<Long> musicId, com.querydsl.core.types.Expression<String> musicTitle, com.querydsl.core.types.Expression<String> albumTitle, com.querydsl.core.types.Expression<String> albumImage, com.querydsl.core.types.Expression<String> singerName, com.querydsl.core.types.Expression<String> singerImage, com.querydsl.core.types.Expression<String> genreName, com.querydsl.core.types.Expression<String> soundQuality, com.querydsl.core.types.Expression<Long> likedUserCount, com.querydsl.core.types.Expression<Long> replyCount) {
        super(GetMusicRes.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, long.class, long.class}, musicId, musicTitle, albumTitle, albumImage, singerName, singerImage, genreName, soundQuality, likedUserCount, replyCount);
    }

}

