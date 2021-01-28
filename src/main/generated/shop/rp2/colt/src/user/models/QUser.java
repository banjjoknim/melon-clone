package shop.rp2.colt.src.user.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1219136482L;

    public static final QUser user = new QUser("user");

    public final DatePath<java.time.LocalDate> birthday = createDate("birthday", java.time.LocalDate.class);

    public final StringPath cellPhone = createString("cellPhone");

    public final StringPath email = createString("email");

    public final EnumPath<shop.rp2.colt.config.Gender> gender = createEnum("gender", shop.rp2.colt.config.Gender.class);

    public final EnumPath<shop.rp2.colt.config.FlagYN> isExit = createEnum("isExit", shop.rp2.colt.config.FlagYN.class);

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userIdName = createString("userIdName");

    public final StringPath userImage = createString("userImage");

    public final StringPath userName = createString("userName");

    public final StringPath userPassword = createString("userPassword");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

