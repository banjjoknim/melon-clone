package shop.rp2.colt.src.user.models.history;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSongHistory is a Querydsl query type for SongHistory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSongHistory extends EntityPathBase<SongHistory> {

    private static final long serialVersionUID = 1413757618L;

    public static final QSongHistory songHistory = new QSongHistory("songHistory");

    public final shop.rp2.colt.config.QBaseTimeEntity _super = new shop.rp2.colt.config.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> musicId = createNumber("musicId", Long.class);

    public final NumberPath<Long> songHistoryId = createNumber("songHistoryId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QSongHistory(String variable) {
        super(SongHistory.class, forVariable(variable));
    }

    public QSongHistory(Path<? extends SongHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSongHistory(PathMetadata metadata) {
        super(SongHistory.class, metadata);
    }

}

