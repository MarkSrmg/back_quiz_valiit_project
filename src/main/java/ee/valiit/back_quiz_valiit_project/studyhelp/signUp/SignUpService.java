package ee.valiit.back_quiz_valiit_project.studyhelp.signUp;

import ee.valiit.back_quiz_valiit_project.domain.user.User;
import ee.valiit.back_quiz_valiit_project.domain.user.UserMapper;
import ee.valiit.back_quiz_valiit_project.domain.user.UserService;
import ee.valiit.back_quiz_valiit_project.domain.user.role.Role;
import ee.valiit.back_quiz_valiit_project.domain.user.role.RoleService;
import ee.valiit.back_quiz_valiit_project.domain.user.role.RoleType;
import ee.valiit.back_quiz_valiit_project.studyhelp.login.LoginResponse;
import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto.PendingResponse;
import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto.UserDto;
import ee.valiit.back_quiz_valiit_project.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ee.valiit.back_quiz_valiit_project.domain.user.role.RoleType.PENDING;
import static ee.valiit.back_quiz_valiit_project.domain.user.role.RoleType.STUDENT;
import static ee.valiit.back_quiz_valiit_project.validation.EmailMessage.*;

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


    public LoginResponse signUp(UserDto userDto) {
        Optional<User> user = userService.findUniqueUsername(userDto.getUserName());
        Validator.getValidUniqueUser(user);
        User newUser = userMapper.toEntity(userDto);
        Role role = new Role();
        if ("teacher".equals(userDto.getUserRole())) {
            role = roleService.findRole(PENDING);
            emailSenderService.sendEmail("noreplymailtestservice@gmail.com", EMAIL_TO_ADMIN.getSubject(), EMAIL_TO_ADMIN.getBody());
            emailSenderService.sendEmail(newUser.getEmail(), EMAIL_TO_USER_PENDING.getSubject(), EMAIL_TO_USER_PENDING.getBody());
        }else{
            role = roleService.findRole(STUDENT);
        }
        newUser.setRole(role);
        userService.saveUser(newUser);
        return userMapper.toDto(newUser);
    }

    public List<PendingResponse> getPendingUser() {
        List<User> pendingUsers = userService.findPendingUsers(PENDING);
        List<User> users = Validator.getValidUsers(pendingUsers);
        List <PendingResponse> pendingResponse = userMapper.toPendingResponse(users);
        return pendingResponse;
    }

    public void changeUserStatus(Integer userId) {
        User user = userService.findUser(userId);
        Role role = roleService.findRole(RoleType.TEACHER);
        user.setRole(role);
        userService.saveUser(user);
        emailSenderService.sendEmail(user.getEmail(), EMAIL_TO_USER_APPROVED.getSubject(), EMAIL_TO_USER_APPROVED.getBody());
    }
}
