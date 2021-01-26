package shop.rp2.colt.src.album.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAlbumReply is a Querydsl query type for AlbumReply
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlbumReply extends EntityPathBase<AlbumReply> {

    private static final long serialVersionUID = 87549198L;

    public static final QAlbumReply albumReply = new QAlbumReply("albumReply");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    public final NumberPath<Long> albumId = createNumber("albumId", Long.class);

    public final NumberPath<Long> belongToReplyId = createNumber("belongToReplyId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath replyComment = createString("replyComment");

    public final NumberPath<Long> replyId = createNumber("replyId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QAlbumReply(String variable) {
        super(AlbumReply.class, forVariable(variable));
    }

    public QAlbumReply(Path<? extends AlbumReply> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlbumReply(PathMetadata metadata) {
        super(AlbumReply.class, metadata);
    }

}

