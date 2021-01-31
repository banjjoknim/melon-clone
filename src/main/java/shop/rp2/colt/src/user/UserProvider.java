package shop.rp2.colt.src.user;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.rp2.colt.src.playlist.models.GetPlaylistsRes;
import shop.rp2.colt.src.playlist.models.QGetPlaylistsRes;
import shop.rp2.colt.src.user.models.user.GetUserLikesRes;
import shop.rp2.colt.src.user.models.user.GetUserProfilesRes;
import shop.rp2.colt.src.user.models.user.QGetUserProfilesRes;

import java.util.List;

import static shop.rp2.colt.src.playlist.models.QListedMusicInPlaylist.listedMusicInPlaylist;
import static shop.rp2.colt.src.playlist.models.QPlaylist.playlist;
import static shop.rp2.colt.src.user.models.QUser.user;
import static shop.rp2.colt.src.user.models.user.QFollowers.followers;

@Service
public class UserProvider {

    private final JPAQueryFactory jpaQueryFactory;
    private final UserRepository userRepository;

    @Autowired
    public UserProvider(JPAQueryFactory jpaQueryFactory, UserRepository userRepository) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.userRepository = userRepository;
    }

    // 유저 프로필 조회
    // todo: 팔로워 수 관련 예외처리 해줄 것.
    public GetUserProfilesRes retrieveUserProfiles(Long userId) {

        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        return jpaQueryFactory.select(new QGetUserProfilesRes(user.nickname,
                user.userImage,
                JPAExpressions.select(ExpressionUtils.count(followers))
                        .from(followers)
                        .where(followers.followingUserId.eq(userId)),
                JPAExpressions.select(ExpressionUtils.count(followers))
                        .from(followers)
                        .where(followers.followedUserId.eq(userId))
        ))
                .from(user)
                .where(user.userId.eq(userId))
                .fetchOne();
    }

    // 유저 플레이리스트 조회
    public List<GetPlaylistsRes> retrieveUserPlaylists(Long userId) {

        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        return jpaQueryFactory.select(new QGetPlaylistsRes(playlist.playlistId,
                playlist.playlistName,
                user.userImage, // todo : 플레이리스트 수록곡 중 첫번째 곡 앨범사진으로 변경할 것.
                JPAExpressions.select(ExpressionUtils.count(listedMusicInPlaylist))
                        .from(listedMusicInPlaylist)
                        .where(listedMusicInPlaylist.playlistId.eq(playlist.playlistId))))
                .from(playlist)
                .where(user.userId.eq(userId))
                .innerJoin(user).on(playlist.userId.eq(user.userId))
                .fetch();
    }

    // todo: 유저 좋아요한 조회 기능 구현할 것.
    public GetUserLikesRes retrieveUserLikes(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        return null;
    }

}
