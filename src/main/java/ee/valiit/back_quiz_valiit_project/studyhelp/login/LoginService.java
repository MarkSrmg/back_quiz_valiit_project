package ee.valiit.back_quiz_valiit_project.studyhelp.login;

import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.domain.user.UserMapper;
import ee.valiit.back_quiz_valiit_project.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        User user = userService.findUser(username, password);
        LoginResponse loginResponse = userMapper.toDto(user);
        return loginResponse;
    }

}
