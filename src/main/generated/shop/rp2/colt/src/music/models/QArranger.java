package shop.rp2.colt.src.music.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QArranger is a Querydsl query type for Arranger
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArranger extends EntityPathBase<Arranger> {

    private static final long serialVersionUID = 585556495L;

    public static final QArranger arranger = new QArranger("arranger");

    public final NumberPath<Long> arrangerId = createNumber("arrangerId", Long.class);

    public final StringPath arrangerName = createString("arrangerName");

    public final NumberPath<Long> musicId = createNumber("musicId", Long.class);

    public QArranger(String variable) {
        super(Arranger.class, forVariable(variable));
    }

    public QArranger(Path<? extends Arranger> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArranger(PathMetadata metadata) {
        super(Arranger.class, metadata);
    }

}

