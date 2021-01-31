package shop.rp2.colt.src.playlist.models;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * shop.rp2.colt.src.playlist.models.QGetPlaylistsRes is a Querydsl Projection type for GetPlaylistsRes
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QGetPlaylistsRes extends ConstructorExpression<GetPlaylistsRes> {

    private static final long serialVersionUID = 1257202523L;

    public QGetPlaylistsRes(com.querydsl.core.types.Expression<Long> playlistId, com.querydsl.core.types.Expression<String> playlistName, com.querydsl.core.types.Expression<String> playlistImage, com.querydsl.core.types.Expression<Long> musicsInPlaylistCount) {
        super(GetPlaylistsRes.class, new Class<?>[]{long.class, String.class, String.class, long.class}, playlistId, playlistName, playlistImage, musicsInPlaylistCount);
    }

}

