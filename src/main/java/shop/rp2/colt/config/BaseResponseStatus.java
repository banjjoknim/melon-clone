package shop.rp2.colt.config;

import lombok.Getter;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {

    // 1000 : 요청 성공
    SUCCESS(true, 200, "요청에 성공하였습니다."),
    SUCCESS_POST_MUSIC(true, 201, "곡 생성에 성공하였습니다."),
    SUCCESS_GET_MUSIC_LIKED_USERS(true, 1001, "좋아요 한 유저들의 조회에 성공하였습니다."),
    SUCCESS_GET_MUSICS(true, 1002, "곡 조회에 성공하였습니다"),
    SUCCESS_POST_OR_DELETE_LIKED_ON_MUSIC(true, 1003, "곡 좋아요에 성공하였습니다."),
    SUCCESS_DELETE_LIKED_ON_MUSIC(true, 1003, "곡 좋아요 취소에 성공하였습니다."),
    SUCCESS_GET_MUSIC_INFO(true, 1004, "곡 정보 조회에 성공하였습니다."),
    SUCCESS_PUT_MUSIC(true, 1005, "곡 정보 수정에 성공하였습니다."),
    SUCCESS_DELETE_MUSIC(true, 1006, "곡 삭제에 성공하였습니다."),
    SUCCESS_GET_MUSIC_REPLYS(true, 1007, "곡 댓글 조회에 성공하였습니다."),
    SUCCESS_POST_MUSIC_REPLY(true, 1008, "곡 댓글 생성에 성공하였습니다."),
    SUCCESS_PUT_MUSIC_REPLY(true, 1009, "곡 댓글 수정에 성공하였습니다."),
    SUCCESS_DELETE_MUSIC_REPLY(true, 1010, "곡 댓글 삭제에 성공하였습니다."),
    SUCCESS_POST_REPLY_ON_MUSIC_REPLY(true, 1011, "해당 댓글에 답글 생성을 성공하였습니다."),
    SUCCESS_POST_ALBUM(true, 1012, "앨범 생성에 성공하였습니다"),
    SUCCESS_GET_ALBUMS(true, 1013, "앨범 조회에 성공하였습니다."),
    SUCCESS_PUT_LIKED_ON_ALBUM(true, 1014, "앨범 좋아요 또는 취소에 성공하였습니다."),
    SUCCESS_POST_LIKED_ON_MUSIC_REPLY(true, 1016, "댓글 좋아요에 성공하였습니다."),
    SUCCESS_POST_DISLIKED_ON_MUSIC_REPLY(true, 1016, "댓글 싫어요에 성공하였습니다."),
    SUCCESS_POST_USER(true, 1017, "회원가입에 성공하였습니다."),
    SUCCESS_PUT_USER(true, 1018, "정보수정에 성공하였습니다."),
    SUCCESS_DELETE_USER(true, 1019, "회원탈퇴에 성공하였습니다."),
    SUCCESS_GET_USER_ID_NAME(true, 1020, "유저 아이디 찾기에 성공하였습니다."),
    SUCCESS_GET_USER_ID_PASSWORD(true, 1021, "유저 비밀번호 찾기에 성공하였습니다."),


    // 2000 : Request 오류
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    EMPTY_USERID(false, 2001, "유저 아이디 값을 확인해주세요."),
    EMPTY_JWT(false, 2010, "JWT를 입력해주세요."),
    INVALID_JWT(false, 2011, "유효하지 않은 JWT입니다."),
    EMPTY_EMAIL(false, 2020, "이메일을 입력해주세요."),
    INVALID_EMAIL(false, 2021, "이메일 형식을 확인해주세요."),
    EMPTY_PASSWORD(false, 2030, "비밀번호를 입력해주세요."),
    EMPTY_CONFIRM_PASSWORD(false, 2031, "비밀번호 확인을 입력해주세요."),
    WRONG_PASSWORD(false, 2032, "비밀번호를 다시 입력해주세요."),
    DO_NOT_MATCH_PASSWORD(false, 2033, "비밀번호와 비밀번호확인 값이 일치하지 않습니다."),
    EMPTY_NICKNAME(false, 2040, "닉네임을 입력해주세요."),
    NOT_CORRECT_PASSWORD(false, 2034, "비밀번호가 틀렸습니다."),

    DUPLICATE_USER_ID_NAME(false, 2041, "중복된 아이디입니다."),
    DUPLICATE_EMAIL(false, 2042, "중복된 이메일입니다."),
    DUPLICATE_NICKNAME(false, 2043, "중복된 닉네임입니다."),
    DUPLICATE_CELL_PHONE(false, 2044, "중복된 전화번호입니다."),

    FAILED_TO_POST_USER(false, 2049, "회원가입에 실패했습니다. 입력값을 확인해주세요."),
    FAILED_TO_POST_MUSIC(false, 2050, "곡 생성에 실패했습니다. 입력값을 확인해주세요."),
    FAILED_TO_POST_ALBUM(false, 2051, "앨범 생성에 실패했습니다. 입력값을 확인해주세요."),

    // 3000 : Response 오류
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),


    FAILED_TO_GET_MUSIC(false, 3001, "존재하지 않는 곡입니다."),
    FAILED_TO_UPDATE_MUSIC(false, 3002, "곡 수정에 실패했습니다. 입력값을 확인해주세요."),
    FAILED_DELETE_MUSIC(false, 3003, "존재하지 않는 곡입니다."),
    FAILED_TO_POST_LIKED_MUSIC(false, 3004, "이미 좋아요 또는 싫어요를 하셨습니다."),
    FAILED_TO_DELETE_LIKED_MUSIC(false, 3005, "좋아요 또는 싫어요를 하지 않았습니다."),
    NOT_INPUT_CONTENT(false, 3006, "내용을 입력하지 않았습니다."),
    HAS_NOT_AUTHORITY(false, 3007, "권한이 없습니다."),
    NOT_FOUND_MUSIC_REPLY(false, 3009, "해당 댓글이 존재하지 않습니다."),
    NOT_FOUND_MUSIC(false, 3010, "해당 곡이 존재하지 않습니다."),
    FAILED_TO_PUT_LIKED_ON_MUSIC_REPLY(false, 3011, "좋아요 또는 싫어요는 하나만 할 수 있습니다."),
    NOT_FOUND_ALBUM(false, 3012, "존재하지 않는 앨범입니다"),
    NOT_FOUND_SINGER(false, 3013, "존재하지 않는 가수입니다."),
    NOT_FOUND_USER(false, 3014, "존재하지 않는 유저입니다."),


    // 4000 : Database 오류
    SERVER_ERROR(false, 4000, "서버와의 통신에 실패하였습니다."),
    DATABASE_ERROR(false, 4001, "데이터베이스 연결에 실패하였습니다.");

    // 5000 : 필요시 만들어서 쓰세요
    // 6000 : 필요시 만들어서 쓰세요

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
