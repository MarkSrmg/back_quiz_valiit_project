package ee.valiit.back_quiz_valiit_project.studyhelp.signUp;

import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto.PendingResponse;
import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SignUpController {
    @Resource
    private SignUpService signUpService;

    @PostMapping("/signup")
    @Operation(summary = "Saves new user", description = "sends email to admin if user is teacher and sends error if user exists")
    public void signUp (@RequestBody UserDto userDto){
        signUpService.signUp(userDto);

    }
    @GetMapping("/signup")
    public List<PendingResponse> getPendingUser(){
        return signUpService.getPendingUser();

    }

}
