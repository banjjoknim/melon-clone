package shop.rp2.colt.src.music.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMusicReply is a Querydsl query type for MusicReply
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMusicReply extends EntityPathBase<MusicReply> {

    private static final long serialVersionUID = 807077198L;

    public static final QMusicReply musicReply = new QMusicReply("musicReply");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    public final NumberPath<Long> belongToReplyId = createNumber("belongToReplyId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> musicId = createNumber("musicId", Long.class);

    public final StringPath replyComment = createString("replyComment");

    public final NumberPath<Long> replyId = createNumber("replyId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QMusicReply(String variable) {
        super(MusicReply.class, forVariable(variable));
    }

    public QMusicReply(Path<? extends MusicReply> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMusicReply(PathMetadata metadata) {
        super(MusicReply.class, metadata);
    }

}

