package ee.valiit.back_quiz_valiit_project.studyhelp.signUp;

import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.domain.user.UserMapper;
import ee.valiit.back_quiz_valiit_project.domain.user.UserService;
import ee.valiit.back_quiz_valiit_project.domain.user.role.Role;
import ee.valiit.back_quiz_valiit_project.domain.user.role.RoleService;
import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto.UserDto;
import ee.valiit.back_quiz_valiit_project.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static ee.valiit.back_quiz_valiit_project.domain.user.role.RoleType.PENDING;
import static ee.valiit.back_quiz_valiit_project.domain.user.role.RoleType.STUDENT;
import static ee.valiit.back_quiz_valiit_project.validation.EmailMessage.EMAIL_TO_ADMIN;

@Service
public class SignUpService {
    @Resource
    private EmailSenderService emailSenderService;
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserMapper userMapper;


    public void signUp(UserDto userDto) {
        Optional<User> user = userService.findUniqueUsername(userDto.getUserName());
        Validator.getValidUniqueUser(user);
        User newUser = userMapper.toEntity(userDto);
        Role role = new Role();
        if ("teacher".equals(userDto.getUserRole())) {
            role = roleService.findRole(PENDING);
            emailSenderService.sendEmail("noreplymailtestservice@gmail.com", EMAIL_TO_ADMIN.getSubject(), EMAIL_TO_ADMIN.getBody());
        }else{
            role = roleService.findRole(STUDENT);
        }
        newUser.setRole(role);
        userService.saveUser(newUser);
    }

}
