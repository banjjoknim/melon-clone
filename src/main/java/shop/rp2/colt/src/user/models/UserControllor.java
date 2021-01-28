package shop.rp2.colt.src.user.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.rp2.colt.config.BaseResponse;
import shop.rp2.colt.src.user.models.user.*;

import static shop.rp2.colt.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/users")
public class UserControllor {

    private final UserService userService;

    @Autowired
    public UserControllor(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("/new-user")
    public BaseResponse<Long> postUser(@RequestBody PostUserReq request) {

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
            return new BaseResponse<>(FAILED_TO_POST_USER);
        }
    }

    // 로그인
    @PostMapping("/login")
    public BaseResponse<Long> postLoginUser() {

        return null;
    }

    // 로그아웃
    @DeleteMapping("/login")
    public BaseResponse<Long> deleteLoginUser() {

        return null;
    }

    // 회원정보수정
    @PutMapping("/{userId}")
    public BaseResponse<Long> putUser(@PathVariable Long userId, @RequestBody PutUserReq request) {

        try {
            return new BaseResponse(SUCCESS_PUT_USER, userService.updateUserById(userId, request));
        } catch (IllegalArgumentException e) {
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
    public BaseResponse<Long> deleteUser(@PathVariable Long userId, @RequestBody DeleteUserReq request) {

        try {
            return new BaseResponse<>(SUCCESS_DELETE_USER, userService.deleteUserById(userId, request));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(NOT_FOUND_USER.getMessage())) {
                return new BaseResponse<>(NOT_FOUND_USER);
            }
            if (e.getMessage().equals(HAS_NOT_AUTHORITY.getMessage())){
                return new BaseResponse<>(HAS_NOT_AUTHORITY);
            }
            return new BaseResponse<>(NOT_CORRECT_PASSWORD);
        }
    }

    // 아이디 찾기
    @PostMapping("/id")
    public BaseResponse<String> postUserId(@RequestParam(name = "email") String email) {
        try {
            return new BaseResponse<>(SUCCESS_GET_USER_ID_NAME, userService.createUserIdName(email));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(NOT_FOUND_USER);
        }
    }

    // 비밀번호 찾기
    @PostMapping("/password")
    public BaseResponse<String> postUserPassword(@RequestParam(name = "email") String email) {
        try {
            return new BaseResponse<>(SUCCESS_GET_USER_ID_PASSWORD, userService.createUserPassword(email));
        } catch (IllegalArgumentException e) {
            return new BaseResponse<>(NOT_FOUND_USER);
        }
    }

    // 프로필 조회
    @GetMapping("/{userId}/profiles")
    public BaseResponse<GetUserProfileRes> getUserProfile() {
        return null;
    }

    // 플레이리스트 조회
    @GetMapping("/{userId}/playlists")
    public BaseResponse<GetUserPlaylistsRes> getUserPlaylists() {
        return null;
    }

    // 좋아요한 조회
    @GetMapping("/{userId}/likes")
    public BaseResponse<GetUserLikesRes> getUserLikes() {
        return null;
    }

    // 최근들은 조회
    @GetMapping("/{userId}/listen-historys")
    public BaseResponse<GetUserListenHistorysRes> getUserListenHistorys() {
        return null;
    }

}
