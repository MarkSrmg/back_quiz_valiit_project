package ee.valiit.back_quiz_valiit_project.domain.user;

import ee.valiit.back_quiz_valiit_project.studyhelp.login.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toDto(User user);

}