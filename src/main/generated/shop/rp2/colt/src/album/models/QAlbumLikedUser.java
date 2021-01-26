package shop.rp2.colt.src.album.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAlbumLikedUser is a Querydsl query type for AlbumLikedUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlbumLikedUser extends EntityPathBase<AlbumLikedUser> {

    private static final long serialVersionUID = 1039934780L;

    public static final QAlbumLikedUser albumLikedUser = new QAlbumLikedUser("albumLikedUser");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    public final NumberPath<Long> albumId = createNumber("albumId", Long.class);

    public final NumberPath<Long> albumLikedUserId = createNumber("albumLikedUserId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QAlbumLikedUser(String variable) {
        super(AlbumLikedUser.class, forVariable(variable));
    }

    public QAlbumLikedUser(Path<? extends AlbumLikedUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlbumLikedUser(PathMetadata metadata) {
        super(AlbumLikedUser.class, metadata);
    }

}

