package shop.rp2.colt.src.music.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QComposer is a Querydsl query type for Composer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QComposer extends EntityPathBase<Composer> {

    private static final long serialVersionUID = 1279414505L;

    public static final QComposer composer = new QComposer("composer");

    public final NumberPath<Long> composerId = createNumber("composerId", Long.class);

    public final StringPath composerName = createString("composerName");

    public final NumberPath<Long> musicId = createNumber("musicId", Long.class);

    public QComposer(String variable) {
        super(Composer.class, forVariable(variable));
    }

    public QComposer(Path<? extends Composer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComposer(PathMetadata metadata) {
        super(Composer.class, metadata);
    }

}

