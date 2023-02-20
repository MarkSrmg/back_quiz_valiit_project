package ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto;

import lombok.Data;

@Data
public class UserDto {
    private String userName;
    private String password;
    private String userRole;
    private String userEmail;
}
