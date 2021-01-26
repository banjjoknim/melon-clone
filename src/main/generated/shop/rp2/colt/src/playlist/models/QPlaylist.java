package shop.rp2.colt.src.playlist.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlaylist is a Querydsl query type for Playlist
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlaylist extends EntityPathBase<Playlist> {

    private static final long serialVersionUID = -1056237652L;

    public static final QPlaylist playlist = new QPlaylist("playlist");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<shop.rp2.colt.config.FlagYN> isPublic = createEnum("isPublic", shop.rp2.colt.config.FlagYN.class);

    public final NumberPath<Long> playlistId = createNumber("playlistId", Long.class);

    public final StringPath playlistName = createString("playlistName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QPlaylist(String variable) {
        super(Playlist.class, forVariable(variable));
    }

    public QPlaylist(Path<? extends Playlist> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlaylist(PathMetadata metadata) {
        super(Playlist.class, metadata);
    }

}

