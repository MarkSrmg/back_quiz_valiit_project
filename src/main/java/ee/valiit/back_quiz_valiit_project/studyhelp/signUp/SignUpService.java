package ee.valiit.back_quiz_valiit_project.studyhelp.signUp;

import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.domain.user.UserService;
import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto.UserDto;
import ee.valiit.back_quiz_valiit_project.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpService {
    @Resource
    private EmailSenderService emailSenderService;
    @Resource
    private UserService userService;


    public void signUp(UserDto userDto) {
        Optional<User> user = userService.findUniqueUsername(userDto.getUserName());
        Validator.getValidUniqueUser(user);
        User newUser = new User();

        emailSenderService.sendEmail(userDto.getUserEmail(),"TestPealkiri", "TestSisu");

    }

}
