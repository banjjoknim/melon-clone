package shop.rp2.colt.src.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.rp2.colt.config.BaseException;
import shop.rp2.colt.src.user.models.User;
import shop.rp2.colt.src.user.models.user.TokenBlacklist;
import shop.rp2.colt.src.user.models.user.*;
import shop.rp2.colt.utils.AES128;
import shop.rp2.colt.utils.JwtService;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static shop.rp2.colt.config.BaseResponseStatus.NOT_FOUND_USER_ID_NAME;
import static shop.rp2.colt.config.secret.Secret.JWT_SECRET_KEY;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TokenBlacklistRepository tokenBlacklistRepository;
    private final JwtService jwtService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    private final AES128 aes128 = new AES128(JWT_SECRET_KEY);

    @Autowired
    public UserService(UserRepository userRepository, TokenBlacklistRepository tokenBlacklistRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.tokenBlacklistRepository = tokenBlacklistRepository;
        this.jwtService = jwtService;
    }

    // 회원가입
    @Transactional
    public Long createUser(PostUserReq request) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        if (userRepository.existsUserByUserIdName(request.getUserIdName())) {
            throw new IllegalArgumentException("중복된 아이디입니다.");
        }
        if (userRepository.existsUserByEmail(request.getEmail())) {
            throw new IllegalArgumentException("중복된 이메일입니다.");
        }
        if (userRepository.existsUserByNickname(request.getNickname())) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }
        if (userRepository.existsUserByCellPhone(request.getCellPhone())) {
            throw new IllegalArgumentException("중복된 전화번호입니다.");
        }
        if (!request.getPassword().equals(request.getPasswordCheck())) {
            throw new IllegalArgumentException("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        String encodePassword = aes128.encrypt(request.getPassword());

        User user = User.builder()
                .userIdName(request.getUserIdName())
                .userPassword(encodePassword)
                .userName(request.getUserName())
                .gender(request.getGender())
                .birthday(LocalDate.parse(request.getBirthday(), formatter))
                .email(request.getEmail())
                .cellPhone(request.getCellPhone())
                .nickname(request.getNickname())
                .userImage(request.getUserImage())
                .build();
        userRepository.save(user);

        return user.getUserId();
    }

    // 로그인시 토큰 발급
    @Transactional
    public String createUserToken(PostLoginUserReq request) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        if (!userRepository.existsUserByUserIdName(request.getUserIdName())) {
            throw new IllegalArgumentException(NOT_FOUND_USER_ID_NAME.getMessage());
        }
        User user = userRepository.findUserByUserIdNameAndUserPassword(request.getUserIdName(), aes128.encrypt(request.getPassword()))
                .orElseThrow(() -> new IllegalArgumentException("비밀번호가 틀렸습니다."));

        return jwtService.createJwt(user.getUserId());
    }

    // 회원정보 수정
    @Transactional
    public Long updateUserById(Long userId, PutUserReq request) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, BaseException {

        if(tokenBlacklistRepository.existsTokenBlacklistByJwtToken(jwtService.getJwt())){
            throw new IllegalArgumentException("유효하지 않은 JWT입니다.");
        }
        if (!userRepository.existsUserByUserId(userId)) {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
        if (request.getCellPhone() == null || request.getEmail() == null || request.getNickname() == null) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
        if (userRepository.existsUserByNickname(request.getNickname())) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }
        if (!userId.equals(jwtService.getUserId())) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }
        if (!userRepository.findById(userId).get().getUserPassword().equals(aes128.encrypt(request.getPassword()))) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }

        String userImage = Optional.ofNullable(request.getUserImage()).orElseGet(() -> userRepository.findById(userId).get().getUserImage());
        userRepository.updateUserById(request.getCellPhone(), request.getEmail(), request.getNickname(), userImage, jwtService.getUserId());

        return userId;
    }

    // 회원탈퇴
    @Transactional
    public Long deleteUserById(Long userId, DeleteUserReq request) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, BaseException {

        if(tokenBlacklistRepository.existsTokenBlacklistByJwtToken(jwtService.getJwt())){
            throw new IllegalArgumentException("유효하지 않은 JWT입니다.");
        }
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
        if (!userId.equals(jwtService.getUserId())) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }
        if (!userRepository.findById(userId).get().getUserPassword().equals(aes128.encrypt(request.getPassword()))) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
        userRepository.deleteById(userId);

        return userId;
    }

    // 아이디 찾기
    @Transactional(readOnly = true)
    public String retrieveUserIdName(String email) {

        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        return user.getUserIdName();
    }

    // 비밀번호 찾기
    @Transactional(readOnly = true)
    public String retrieveUserPassword(String email) {

        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        return user.getUserPassword();
    }

    // 로그아웃시 토큰 블랙리스트에 추가, todo: 토큰 사용시 블랙리스트 체크로직 추가할 것.
    @Transactional
    public Long addTokenInBlacklist() throws BaseException {

        TokenBlacklist tokenBlacklist = TokenBlacklist.builder()
                .jwtToken(jwtService.getJwt())
                .expiration(jwtService.getExpiration())
                .build();
        tokenBlacklistRepository.save(tokenBlacklist);
        return tokenBlacklist.getTokenBlacklistId();
    }

}
