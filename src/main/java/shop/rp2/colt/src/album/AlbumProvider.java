package shop.rp2.colt.src.album;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.rp2.colt.src.album.models.GetAlbumsRes;
import shop.rp2.colt.src.album.models.QGetAlbumsRes;

import java.util.List;

import static shop.rp2.colt.src.album.models.QAlbum.album;
import static shop.rp2.colt.src.singer.models.QSinger.singer;

@Service
public class AlbumProvider {

    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public AlbumProvider(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<GetAlbumsRes> retrieveAlbums() {
        return jpaQueryFactory
                .select(new QGetAlbumsRes(
                        album.albumId,
                        album.albumTitle,
                        singer.singerName,
                        album.albumImage,
                        album.releaseDate, // todo: 문자열로 형태 변환 필요
                        JPAExpressions
                                .select((album.totalScore).divide(album.scoredUserCount))
                                .from(album)
                                .where(album.albumId.eq(1L)), // todo: 앨범별로 변환하는 쿼리 추가해야 함.
                        album.scoredUserCount)
                )
                .from(album)
                .innerJoin(singer).on(album.singerId.eq(singer.singerId))
                .fetch();
    }

}
