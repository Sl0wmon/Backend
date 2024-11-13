package capstone1.Backend.service;

import capstone1.Backend.dto.UserDto;
import capstone1.Backend.entity.User;
import capstone1.Backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getUser(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User registerUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setPw(passwordEncoder.encode(userDto.getPw())); // 비밀번호 암호화
        user.setName(userDto.getName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return userRepository.save(user);
    }

    public User updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getUserId()).orElse(null);
        if (user == null) {
            return null;
        }
        user.setPw(passwordEncoder.encode(userDto.getPw())); // 비밀번호 암호화
        user.setName(userDto.getName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return userRepository.save(user);
    }

    public boolean deleteUser(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }

    public boolean loginUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getUserId()).orElse(null);
        if (user == null) {
            return false;
        }
        return passwordEncoder.matches(userDto.getPw(), user.getPw()); // 암호화된 비밀번호와 비교
    }

    public boolean checkUser(String userId) {
        return userRepository.findById(userId).isPresent();
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).isPresent();
    }
}
