package shop.rp2.colt.src.music.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMusic is a Querydsl query type for Music
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMusic extends EntityPathBase<Music> {

    private static final long serialVersionUID = 1829608188L;

    public static final QMusic music = new QMusic("music");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    public final NumberPath<Long> albumId = createNumber("albumId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<shop.rp2.colt.config.FlagYN> isDeleted = createEnum("isDeleted", shop.rp2.colt.config.FlagYN.class);

    public final EnumPath<shop.rp2.colt.config.FlagYN> isPublic = createEnum("isPublic", shop.rp2.colt.config.FlagYN.class);

    public final StringPath lyrics = createString("lyrics");

    public final NumberPath<Long> musicId = createNumber("musicId", Long.class);

    public final StringPath musicTitle = createString("musicTitle");

    public final StringPath playtime = createString("playtime");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMusic(String variable) {
        super(Music.class, forVariable(variable));
    }

    public QMusic(Path<? extends Music> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMusic(PathMetadata metadata) {
        super(Music.class, metadata);
    }

}

