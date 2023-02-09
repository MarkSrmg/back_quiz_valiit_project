package ee.valiit.back_quiz_valiit_project.domain.quiz;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.Instant;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {Instant.class})
public interface QuizMapper {

//    @Mapping(source = "userId", target = "user.id")
    // TODO: 08.02.2023 Ei ole kindel kas on vaja pigem andmebaasist võtta siiski 
    @Mapping(source = "quizName", target = "name")
    @Mapping(source = "quizType", target = "type")
    // TODO: 08.02.2023 Vaja siia panna status constant
    @Mapping(constant = "A", target = "status")
    @Mapping(constant = "false", target = "isPublic")
    @Mapping(expression = "java(Instant.now())", target = "timestamp")
    Quiz toEntity(QuizRequest quizRequest);

//    CreateQuizDto toDto(Quiz quiz);


}