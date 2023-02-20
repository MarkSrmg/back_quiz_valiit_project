package ee.valiit.back_quiz_valiit_project.studyhelp.signUp;

import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto.UserDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @Resource
    private SignUpService signUpService;

    @PostMapping("/signup")
    public void signUp (@RequestBody UserDto userDto){
        signUpService.signUp(userDto);

    }

}
