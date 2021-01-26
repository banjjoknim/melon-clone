package shop.rp2.colt.src.music.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLyricWriter is a Querydsl query type for LyricWriter
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLyricWriter extends EntityPathBase<LyricWriter> {

    private static final long serialVersionUID = -2072075959L;

    public static final QLyricWriter lyricWriter = new QLyricWriter("lyricWriter");

    public final NumberPath<Long> lyricWriterId = createNumber("lyricWriterId", Long.class);

    public final StringPath lyricWriterName = createString("lyricWriterName");

    public final NumberPath<Long> musicId = createNumber("musicId", Long.class);

    public QLyricWriter(String variable) {
        super(LyricWriter.class, forVariable(variable));
    }

    public QLyricWriter(Path<? extends LyricWriter> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLyricWriter(PathMetadata metadata) {
        super(LyricWriter.class, metadata);
    }

}

