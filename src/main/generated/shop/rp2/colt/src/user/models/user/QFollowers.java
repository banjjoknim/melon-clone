package shop.rp2.colt.src.user.models.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFollowers is a Querydsl query type for Followers
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFollowers extends EntityPathBase<Followers> {

    private static final long serialVersionUID = 719712773L;

    public static final QFollowers followers = new QFollowers("followers");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> followedUserId = createNumber("followedUserId", Long.class);

    public final NumberPath<Long> followersId = createNumber("followersId", Long.class);

    public final NumberPath<Long> followingUserId = createNumber("followingUserId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFollowers(String variable) {
        super(Followers.class, forVariable(variable));
    }

    public QFollowers(Path<? extends Followers> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFollowers(PathMetadata metadata) {
        super(Followers.class, metadata);
    }

}

