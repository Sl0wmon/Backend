package capstone1.Backend.controller;

import capstone1.Backend.config.Response;
import capstone1.Backend.dto.UserDto;
import capstone1.Backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/user/register")
    public Response<?> registerUser(@RequestBody UserDto userDto) {
        return new Response<>("true", "회원가입 완료", userService.registerUser(userDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/user/view")
    public Response<?> getUser(@RequestBody UserDto userDto) {
        return new Response<>("true", "회원 정보 조회 완료", userService.getUser(userDto.getUserId()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/user/update")
    public Response<?> updateUser(@RequestBody UserDto userDto) {
        return new Response<>("true", "회원 정보 수정 시도 완료", userService.updateUser(userDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/user/delete")
    public Response<?> deleteUser(@RequestBody UserDto userDto) {
        return new Response<>("true", "회원 탈퇴 시도 완료", userService.deleteUser(userDto.getUserId()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/user/login")
    public Response<?> loginUser(@RequestBody UserDto userDto) {
        return new Response<>("true", "로그인 시도 완료", userService.loginUser(userDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/user/checkId")
    public Response<?> checkUser(@RequestBody UserDto userDto) {
        return new Response<>("true", "아이디 중복 확인 완료", userService.checkUser(userDto.getUserId()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/api/user/checkPhoneNumber")
    public Response<?> checkPhoneNumber(@RequestBody UserDto userDto) {
        return new Response<>("true", "전화번호 중복 확인 완료", userService.checkPhoneNumber(userDto.getPhoneNumber()));
    }
}
