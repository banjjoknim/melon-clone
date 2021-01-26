package shop.rp2.colt.src.music;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import shop.rp2.colt.src.music.models.GetMusicRes;
import shop.rp2.colt.src.music.models.GetMusicsRes;
import shop.rp2.colt.src.music.models.QGetMusicRes;
import shop.rp2.colt.src.music.models.QGetMusicsRes;
import shop.rp2.colt.src.user.models.GetMusicLikedUserRes;
import shop.rp2.colt.src.user.models.QGetMusicLikedUserRes;

import java.util.List;

import static shop.rp2.colt.src.album.models.QAlbum.album;
import static shop.rp2.colt.src.album.models.QGenre.genre;
import static shop.rp2.colt.src.music.models.QMusic.music;
import static shop.rp2.colt.src.music.models.QMusicLikedUser.musicLikedUser;
import static shop.rp2.colt.src.music.models.QMusicReply.musicReply;
import static shop.rp2.colt.src.singer.models.QSinger.singer;
import static shop.rp2.colt.src.user.models.QUser.user;

@Repository
public class MusicProvider {

    // QueryDsl
    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public MusicProvider(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    // 전체 곡 조회
    public List<GetMusicsRes> retrieveMusics() {
        return jpaQueryFactory
                .select(new QGetMusicsRes(music.musicId, music.musicTitle, singer.singerName, album.albumImage, singer.country, album.releaseDate))
                .from(music)
                .innerJoin(album).on(music.albumId.eq(album.albumId))
                .innerJoin(singer).on(album.albumId.eq(singer.singerId))
                .fetch();
    }

    // 음악 번호로 곡 정보 조회
    public GetMusicRes retrieveMusicById(Long musicId) {
        return jpaQueryFactory
                .select(new QGetMusicRes(
                        music.musicId,
                        music.musicTitle,
                        album.albumTitle,
                        album.albumImage,
                        singer.singerName,
                        singer.singerImage,
                        genre.genreName,
                        album.soundQuality,
                        ExpressionUtils.as(JPAExpressions
                                .select(ExpressionUtils.count(musicLikedUser.musicId))
                                .from(musicLikedUser)
                                .where(musicLikedUser.musicId.eq(music.musicId))
                                .groupBy(music.musicId), "likedUserCount"),
                        ExpressionUtils.as(JPAExpressions
                                .select(ExpressionUtils.count(musicReply.replyId))
                                .from(musicReply)
                                .where(musicReply.musicId.eq(music.musicId))
                                .groupBy(musicReply.musicId), "replyCount")
                ))
                .from(music)
                .innerJoin(album).on(music.albumId.eq(album.albumId))
                .innerJoin(singer).on(album.singerId.eq(singer.singerId))
                .innerJoin(genre).on(album.genreId.eq(genre.genreId))
                .where(music.musicId.eq(musicId))
                .fetchOne();
    }

    // 곡 좋아요 한 유저들 조회
    // todo: 보유한 플레이리스트 수 컬럼 추가할 것.
    public List<GetMusicLikedUserRes> retrieveMusicLikedUsers(Long musicId) {
        return jpaQueryFactory
                .select(new QGetMusicLikedUserRes(
                        musicLikedUser.userId,
                        user.userImage,
                        user.nickname
                ))
                .from(user)
                .innerJoin(musicLikedUser).on(user.userId.eq(musicLikedUser.userId))
                .where(musicLikedUser.musicId.eq(musicId))
                .fetch();
    }
}
