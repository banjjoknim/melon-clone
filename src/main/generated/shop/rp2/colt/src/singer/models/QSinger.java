package shop.rp2.colt.src.singer.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSinger is a Querydsl query type for Singer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSinger extends EntityPathBase<Singer> {

    private static final long serialVersionUID = 1101153408L;

    public static final QSinger singer = new QSinger("singer");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    public final DatePath<java.time.LocalDate> birthday = createDate("birthday", java.time.LocalDate.class);

    public final StringPath country = createString("country");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> debutDate = createDate("debutDate", java.time.LocalDate.class);

    public final StringPath gender = createString("gender");

    public final EnumPath<shop.rp2.colt.config.FlagYN> isDeleted = createEnum("isDeleted", shop.rp2.colt.config.FlagYN.class);

    public final NumberPath<Long> singerId = createNumber("singerId", Long.class);

    public final StringPath singerImage = createString("singerImage");

    public final StringPath singerName = createString("singerName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSinger(String variable) {
        super(Singer.class, forVariable(variable));
    }

    public QSinger(Path<? extends Singer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSinger(PathMetadata metadata) {
        super(Singer.class, metadata);
    }

}

