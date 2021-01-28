package shop.rp2.colt.src.music.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.Expression;


/**
 * QMusicReplyLikedUser is a Querydsl query type for MusicReplyLikedUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMusicReplyLikedUser extends EntityPathBase<MusicReplyLikedUser> {

    private static final long serialVersionUID = 163919722L;

    public static ConstructorExpression<MusicReplyLikedUser> create(Expression<Long> replyId, Expression<Long> userId, Expression<String> liked) {
        return Projections.constructor(MusicReplyLikedUser.class, new Class<?>[]{long.class, long.class, String.class}, replyId, userId, liked);
    }

    public static final QMusicReplyLikedUser musicReplyLikedUser = new QMusicReplyLikedUser("musicReplyLikedUser");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath liked = createString("liked");

    public final NumberPath<Long> musicReplyLikedUserId = createNumber("musicReplyLikedUserId", Long.class);

    public final NumberPath<Long> replyId = createNumber("replyId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QMusicReplyLikedUser(String variable) {
        super(MusicReplyLikedUser.class, forVariable(variable));
    }

    public QMusicReplyLikedUser(Path<? extends MusicReplyLikedUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMusicReplyLikedUser(PathMetadata metadata) {
        super(MusicReplyLikedUser.class, metadata);
    }

}

