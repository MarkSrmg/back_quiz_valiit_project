package ee.valiit.back_quiz_valiit_project.studyhelp;

import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    public LoginResponse login(String username, String password) {
        User user = userService.findUser(username, password);

        return null;
    }

}
