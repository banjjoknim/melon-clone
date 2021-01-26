package shop.rp2.colt.src.playlist.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QListedMusicInPlaylist is a Querydsl query type for ListedMusicInPlaylist
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QListedMusicInPlaylist extends EntityPathBase<ListedMusicInPlaylist> {

    private static final long serialVersionUID = -1895877883L;

    public static final QListedMusicInPlaylist listedMusicInPlaylist = new QListedMusicInPlaylist("listedMusicInPlaylist");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> musicId = createNumber("musicId", Long.class);

    public final NumberPath<Long> playlistId = createNumber("playlistId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QListedMusicInPlaylist(String variable) {
        super(ListedMusicInPlaylist.class, forVariable(variable));
    }

    public QListedMusicInPlaylist(Path<? extends ListedMusicInPlaylist> path) {
        super(path.getType(), path.getMetadata());
    }

    public QListedMusicInPlaylist(PathMetadata metadata) {
        super(ListedMusicInPlaylist.class, metadata);
    }

}

