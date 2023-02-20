package ee.valiit.back_quiz_valiit_project.domain.user;

import ee.valiit.back_quiz_valiit_project.studyhelp.Status;
import ee.valiit.back_quiz_valiit_project.studyhelp.login.LoginResponse;
import ee.valiit.back_quiz_valiit_project.studyhelp.signUp.dto.UserDto;
import org.mapstruct.*;

import static ee.valiit.back_quiz_valiit_project.studyhelp.Status.ACTIVE;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toDto(User user);

    @Mapping(constant = ACTIVE, target = "status")
    @Mapping(source = "userName", target = "username")
    @Mapping(source = "userEmail", target = "email")
    User toEntity(UserDto userDto);

}