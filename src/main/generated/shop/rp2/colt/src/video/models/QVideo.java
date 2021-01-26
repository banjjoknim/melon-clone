package shop.rp2.colt.src.video.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVideo is a Querydsl query type for Video
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVideo extends EntityPathBase<Video> {

    private static final long serialVersionUID = -2044913988L;

    public static final QVideo video = new QVideo("video");

    public final EnumPath<shop.rp2.colt.config.FlagYN> isDeleted = createEnum("isDeleted", shop.rp2.colt.config.FlagYN.class);

    public final EnumPath<shop.rp2.colt.config.FlagYN> isPublic = createEnum("isPublic", shop.rp2.colt.config.FlagYN.class);

    public final NumberPath<Long> musicId = createNumber("musicId", Long.class);

    public final TimePath<java.time.LocalTime> playtime = createTime("playtime", java.time.LocalTime.class);

    public final DateTimePath<java.time.LocalDateTime> releaseDate = createDateTime("releaseDate", java.time.LocalDateTime.class);

    public final StringPath videoFile = createString("videoFile");

    public final NumberPath<Long> videoId = createNumber("videoId", Long.class);

    public final StringPath videoImage = createString("videoImage");

    public final StringPath videoTitle = createString("videoTitle");

    public final NumberPath<Long> viewCount = createNumber("viewCount", Long.class);

    public QVideo(String variable) {
        super(Video.class, forVariable(variable));
    }

    public QVideo(Path<? extends Video> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVideo(PathMetadata metadata) {
        super(Video.class, metadata);
    }

}

