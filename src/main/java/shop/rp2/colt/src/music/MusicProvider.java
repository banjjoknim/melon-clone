package shop.rp2.colt.src.music;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.rp2.colt.src.music.models.*;
import shop.rp2.colt.src.user.models.GetMusicLikedUserRes;
import shop.rp2.colt.src.user.models.QGetMusicLikedUserRes;

import java.util.List;

import static shop.rp2.colt.src.album.models.QAlbum.album;
import static shop.rp2.colt.src.album.models.QGenre.genre;
import static shop.rp2.colt.src.music.models.QArranger.arranger;
import static shop.rp2.colt.src.music.models.QComposer.composer;
import static shop.rp2.colt.src.music.models.QLyricWriter.lyricWriter;
import static shop.rp2.colt.src.music.models.QMusic.music;
import static shop.rp2.colt.src.music.models.QMusicLikedUser.musicLikedUser;
import static shop.rp2.colt.src.music.models.QMusicReply.musicReply;
import static shop.rp2.colt.src.music.models.QMusicReplyLikedUser.musicReplyLikedUser;
import static shop.rp2.colt.src.singer.models.QSinger.singer;
import static shop.rp2.colt.src.user.models.QUser.user;

@Repository
public class MusicProvider {

    // QueryDsl
    private final JPAQueryFactory jpaQueryFactory;
    private final MusicRepository musicRepository;

    @Autowired
    public MusicProvider(JPAQueryFactory jpaQueryFactory, MusicRepository musicRepository) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.musicRepository = musicRepository;
    }

    // 전체 곡 조회
    @Transactional(readOnly = true)
    public List<GetMusicsRes> retrieveMusics() {
        return jpaQueryFactory
                .select(new QGetMusicsRes(
                        music.musicId,
                        music.musicTitle,
                        singer.singerName,
                        album.albumImage,
                        singer.country,
                        Expressions.stringTemplate("DATE_FORMAT({0}, '%Y.%m.%d')", album.releaseDate)))
                .from(music)
                .innerJoin(album).on(music.albumId.eq(album.albumId))
                .innerJoin(singer).on(album.albumId.eq(singer.singerId))
                .fetch();
    }

    // 음악 번호로 곡 정보 조회
    @Transactional(readOnly = true)
    public GetMusicRes retrieveMusicById(Long musicId) {
        if (!musicRepository.existsMusicByMusicId(musicId)) {
            throw new IllegalArgumentException("존재하지 않는 곡입니다.");
        }

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
                        JPAExpressions
                                .select(ExpressionUtils.count(musicLikedUser.musicId))
                                .from(musicLikedUser)
                                .groupBy(music.musicId)
                                .having(music.musicId.eq(musicId)), // 좋아요 수
                        JPAExpressions
                                .select(ExpressionUtils.count(musicReply.replyId))
                                .from(musicReply)
                                .groupBy(musicReply.musicId)
                                .having(musicReply.musicId.eq(musicId)) // 댓글 수
                ))
                .from(music)
                .innerJoin(album).on(music.albumId.eq(album.albumId))
                .innerJoin(singer).on(album.singerId.eq(singer.singerId))
                .innerJoin(genre).on(album.genreId.eq(genre.genreId))
                .innerJoin(musicReply).on(music.musicId.eq(musicReply.musicId))
                .innerJoin(musicReplyLikedUser).on(musicReply.replyId.eq(musicReplyLikedUser.replyId))
                .where(music.musicId.eq(musicId))
                .fetchOne();
    }

    // 곡 가사 조회
    @Transactional(readOnly = true)
    public GetMusicLyricsRes retrieveMusicLyrics(Long musicId) {
        return jpaQueryFactory
                .select(new QGetMusicLyricsRes(music.lyrics))
                .from(music)
                .where(music.musicId.eq(musicId))
                .fetchOne();
    }

    // 곡 상세정보 조회
    @Transactional(readOnly = true)
    public GetMusicInfoRes retrieveMusicDetails(Long musicId) {
        return jpaQueryFactory
                .select(new QGetMusicInfoRes(singer.singerName, lyricWriter.lyricWriterName, composer.composerName, arranger.arrangerName, genre.genreName))
                .from(music)
                .innerJoin(album).on(music.albumId.eq(album.albumId))
                .innerJoin(genre).on(album.genreId.eq(genre.genreId))
                .innerJoin(singer).on(album.singerId.eq(singer.singerId))
                .innerJoin(lyricWriter).on(lyricWriter.musicId.eq(music.musicId))
                .innerJoin(composer).on(composer.musicId.eq(music.musicId))
                .innerJoin(arranger).on(arranger.musicId.eq(music.musicId))
                .where(music.musicId.eq(musicId))
                .fetchOne();
    }

    // 곡 좋아요 한 유저들 조회
    // todo: 보유한 플레이리스트 수 컬럼 추가할 것.
    @Transactional(readOnly = true)
    public List<GetMusicLikedUserRes> retrieveMusicLikedUsers(Long musicId) {
        if (!musicRepository.existsMusicByMusicId(musicId)) {
            throw new IllegalArgumentException("존재하지 않는 곡입니다.");
        }
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
