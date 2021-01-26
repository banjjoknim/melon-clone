package shop.rp2.colt.src.music.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMusicLikedUser is a Querydsl query type for MusicLikedUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMusicLikedUser extends EntityPathBase<MusicLikedUser> {

    private static final long serialVersionUID = 97854844L;

    public static final QMusicLikedUser musicLikedUser = new QMusicLikedUser("musicLikedUser");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> musicId = createNumber("musicId", Long.class);

    public final NumberPath<Long> musicLikedUserId = createNumber("musicLikedUserId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QMusicLikedUser(String variable) {
        super(MusicLikedUser.class, forVariable(variable));
    }

    public QMusicLikedUser(Path<? extends MusicLikedUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMusicLikedUser(PathMetadata metadata) {
        super(MusicLikedUser.class, metadata);
    }

}

