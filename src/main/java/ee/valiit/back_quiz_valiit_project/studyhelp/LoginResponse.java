package ee.valiit.back_quiz_valiit_project.studyhelp;

import lombok.Data;
import org.springframework.stereotype.Service;
@Data
@Service
public class LoginResponse {

    private Integer userId;

    private String roleName;

}
