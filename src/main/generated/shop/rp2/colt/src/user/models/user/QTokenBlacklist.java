package shop.rp2.colt.src.user.models.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTokenBlacklist is a Querydsl query type for TokenBlacklist
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTokenBlacklist extends EntityPathBase<TokenBlacklist> {

    private static final long serialVersionUID = -1310007500L;

    public static final QTokenBlacklist tokenBlacklist = new QTokenBlacklist("tokenBlacklist");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath jwtToken = createString("jwtToken");

    public final NumberPath<Long> tokenBlacklistId = createNumber("tokenBlacklistId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QTokenBlacklist(String variable) {
        super(TokenBlacklist.class, forVariable(variable));
    }

    public QTokenBlacklist(Path<? extends TokenBlacklist> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTokenBlacklist(PathMetadata metadata) {
        super(TokenBlacklist.class, metadata);
    }

}

