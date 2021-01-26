package shop.rp2.colt.src.album.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAlbum is a Querydsl query type for Album
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlbum extends EntityPathBase<Album> {

    private static final long serialVersionUID = 1842602812L;

    public static final QAlbum album = new QAlbum("album");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    public final NumberPath<Long> albumId = createNumber("albumId", Long.class);

    public final StringPath albumImage = createString("albumImage");

    public final StringPath albumIntro = createString("albumIntro");

    public final StringPath albumTitle = createString("albumTitle");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> genreId = createNumber("genreId", Long.class);

    public final StringPath isDeleted = createString("isDeleted");

    public final StringPath isPublic = createString("isPublic");

    public final DateTimePath<java.time.LocalDateTime> releaseDate = createDateTime("releaseDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> scoredUserCount = createNumber("scoredUserCount", Long.class);

    public final NumberPath<Long> singerId = createNumber("singerId", Long.class);

    public final StringPath soundQuality = createString("soundQuality");

    public final NumberPath<Double> totalScore = createNumber("totalScore", Double.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAlbum(String variable) {
        super(Album.class, forVariable(variable));
    }

    public QAlbum(Path<? extends Album> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlbum(PathMetadata metadata) {
        super(Album.class, metadata);
    }

}

