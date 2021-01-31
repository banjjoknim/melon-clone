package shop.rp2.colt.src.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.rp2.colt.config.BaseException;
import shop.rp2.colt.config.BaseResponse;
import shop.rp2.colt.src.playlist.models.GetPlaylistsRes;
import shop.rp2.colt.src.user.models.user.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static shop.rp2.colt.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserProvider userProvider;
    private final UserService userService;

    @Autowired
    public UserController(UserProvider userProvider, UserService userService) {
        this.userProvider = userProvider;
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("/new-user")
    public BaseResponse<Long> postUser(@RequestBody PostUserReq request) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        try {
            return new BaseResponse<>(SUCCESS_POST_USER, userService.createUser(request));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(DUPLICATE_USER_ID_NAME.getMessage())) {
                return new BaseResponse<>(DUPLICATE_USER_ID_NAME);
            }
            if (e.getMessage().equals(DUPLICATE_EMAIL.getMessage())) {
                return new BaseResponse<>(DUPLICATE_EMAIL);
            }
            if (e.getMessage().equals(DUPLICATE_CELL_PHONE.getMessage())) {
                return new BaseResponse<>(DUPLICATE_CELL_PHONE);
            }
            if (e.getMessage().equals(NOT_CORRECT_PASSWORD.getMessage())) {
                return new BaseResponse<>(NOT_CORRECT_PASSWORD);
            }
            if (e.getMessage().equals(DUPLICATE_NICKNAME.getMessage())) {
                return new BaseResponse<>(DUPLICATE_NICKNAME);
            }
            return new BaseResponse<>(FAILED_TO_POST_USER);
        }
    }

    // 로그인
    @PostMapping("/login")
    public BaseResponse<String> postLoginUser(@RequestBody PostLoginUserReq request) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        try {
            return new BaseResponse<>(SUCCESS_POST_USER_TOKEN, userService.createUserToken(request));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(NOT_FOUND_USER_ID_NAME.getMessage())) {
                return new BaseResponse<>(NOT_FOUND_USER_ID_NAME);
            }
            return new BaseResponse<>(NOT_CORRECT_PASSWORD);
        }
    }

    // 로그아웃
    @PostMapping("/logout")
    public BaseResponse<Long> deleteLoginUser() {

        try {
            return new BaseResponse<>(SUCCESS_LOGOUT, userService.addTokenInBlacklist());
        } catch (BaseException e) {
            return new BaseResponse<>(INVALID_JWT);
        }
    }

    // 회원정보수정
    @PutMapping("/{userId}")
    public BaseResponse<Long> putUser(@PathVariable Long userId, @RequestBody PutUserReq request) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, BaseException {

        try {
            return new BaseResponse(SUCCESS_PUT_USER, userService.updateUserById(userId, request));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(INVALID_JWT.getMessage())) {
                return new BaseResponse<>(INVALID_JWT);
            }
            if (e.getMessage().equals(NOT_FOUND_USER.getMessage())) {
                return new BaseResponse<>(NOT_FOUND_USER);
            }
            if (e.getMessage().equals(REQUEST_ERROR.getMessage())) {
                return new BaseResponse(REQUEST_ERROR);
            }
            if (e.getMessage().equals(EMPTY_EMAIL.getMessage())) {
                return new BaseResponse(EMPTY_EMAIL);
            }
            if (e.getMessage().equals(EMPTY_NICKNAME.getMessage())) {
                return new BaseResponse(EMPTY_NICKNAME);
            }
            if (e.getMessage().equals(HAS_NOT_AUTHORITY.getMessage())) {
                return new BaseResponse(HAS_NOT_AUTHORITY);
            }
            return new BaseResponse(NOT_CORRECT_PASSWORD);
        }
    }

    // 회원탈퇴
    @DeleteMapping("/{userId}")
    public BaseResponse<Long> deleteUser(@PathVariable Long userId, @RequestBody DeleteUserReq request) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, BaseException {

        try {
            return new BaseResponse<>(SUCCESS_DELETE_USER, userService.deleteUserById(userId, request));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(INVALID_JWT.getMessage())) {
                return new BaseResponse<>(INVALID_JWT);
            }
            if (e.getMessage().equals(NOT_FOUND_USER.getMessage())) {
                return new BaseResponse<>(NOT_FOUND_USER);
            }
            if (e.getMessage().equals(HAS_NOT_AUTHORITY.getMessage())) {
                return new BaseResponse<>(HAS_NOT_AUTHORITY);
            }
            return new BaseResponse<>(NOT_CORRECT_PASSWORD);
        }
    }

    // 아이디 찾기
    @PostMapping("/id")
    public BaseResponse<String> postUserId(@RequestParam(name = "email") String email) {
        try {
            return new BaseResponse<>(SUCCESS_GET_USER_ID_NAME, userService.retrieveUserIdName(email));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(NOT_FOUND_USER);
        }
    }

    // 비밀번호 찾기
    @PostMapping("/password")
    public BaseResponse<String> postUserPassword(@RequestParam(name = "email") String email) {
        try {
            return new BaseResponse<>(SUCCESS_GET_USER_ID_PASSWORD, userService.retrieveUserPassword(email));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(NOT_FOUND_USER);
        }
    }

    // 프로필 조회
    @GetMapping("/{userId}/profiles")
    public BaseResponse<GetUserProfilesRes> getUserProfile(@PathVariable Long userId) {
        try {
            return new BaseResponse<>(SUCCESS_GET_USER_PROFILES, userProvider.retrieveUserProfiles(userId));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(NOT_FOUND_USER);
        }
    }

    // 유저 플레이리스트 목록 조회
    @GetMapping("/{userId}/playlists")
    public BaseResponse<List<GetPlaylistsRes>> getUserPlaylists(@PathVariable Long userId) {
        try {
            return new BaseResponse<>(SUCCESS_GET_USER_PLAYLISTS, userProvider.retrieveUserPlaylists(userId));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(NOT_FOUND_USER);
        }
    }

    // 좋아요한 조회
    @GetMapping("/{userId}/likes")
    public BaseResponse<GetUserLikesRes> getUserLikes(@PathVariable Long userId) {
        userProvider.retrieveUserLikes(userId);
        return null;
    }

    // 최근들은 조회
    @GetMapping("/{userId}/listen-historys")
    public BaseResponse<GetUserListenHistorysRes> getUserListenHistorys(@PathVariable Long userId) {
        return null;
    }

}
