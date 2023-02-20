package ee.valiit.back_quiz_valiit_project.studyhelp.signUp;

import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto.PendingResponse;
import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SignUpController {
    @Resource
    private SignUpService signUpService;

    @PostMapping("/signup")
    @Operation(summary = "Saves new user", description = "sends email to admin if user is teacher and sends error 888 if user exists")
    public void signUp (@RequestBody UserDto userDto){
        signUpService.signUp(userDto);

    }
    @GetMapping("/signup")
    @Operation(summary = "finds all pending users", description = "finds all users that are pending if no users found code 889")
    public List<PendingResponse> getPendingUser(){
        return signUpService.getPendingUser();

    }

    @PutMapping("signup")
    @Operation(summary = "Changes User status pending to teacher")
    public void changeUserStatus(@RequestParam Integer userId){
        signUpService.changeUserStatus(userId);
    }


}
