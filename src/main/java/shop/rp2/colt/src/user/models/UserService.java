package shop.rp2.colt.src.user.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.rp2.colt.src.user.models.user.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Long createUser(PostUserReq request) {

        if (userRepository.existsUserByUserIdName(request.getUserIdName())) {
            throw new IllegalArgumentException("중복된 아이디입니다.");
        }
        if (userRepository.existsUserByEmail(request.getEmail())) {
            throw new IllegalArgumentException("중복된 이메일입니다.");
        }
        if (userRepository.existsUserByNickname(request.getNickname())) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }
        if (!request.getPassword().equals(request.getPasswordCheck())) {
            throw new IllegalArgumentException("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        }

        User user = User.builder()
                .userIdName(request.getUserIdName())
                .userPassword(request.getPassword())
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

    @Transactional
    public Long updateUserById(Long userId, PutUserReq request) {

        if (!userRepository.existsUserByUserId(userId)) {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
        if (request.getCellPhone() == null || request.getEmail() == null || request.getNickname() == null) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
        if (userRepository.existsUserByNickname(request.getNickname())) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }
        if (!userId.equals(request.getUserId())) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }
        if (!userRepository.findById(userId).get().getUserPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }

        String userImage = Optional.ofNullable(request.getUserImage()).orElseGet(() -> userRepository.findById(userId).get().getUserImage());
        userRepository.updateUserById(request.getCellPhone(), request.getEmail(), request.getNickname(), userImage, request.getUserId());

        return userId;
    }

    @Transactional
    public Long deleteUserById(Long userId, DeleteUserReq request) {

        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
        if (!userId.equals(request.getUserId())) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }
        if (!userRepository.findById(userId).get().getUserPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
        userRepository.deleteById(userId);

        return userId;
    }

    @Transactional(readOnly = true)
    public String createUserIdName(String email) {

        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        return user.getUserIdName();
    }

    @Transactional(readOnly = true)
    public String createUserPassword(String email) {

        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        return user.getUserPassword();
    }
}
