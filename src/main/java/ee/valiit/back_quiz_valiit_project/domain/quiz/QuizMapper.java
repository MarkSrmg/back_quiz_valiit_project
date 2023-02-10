package ee.valiit.back_quiz_valiit_project.domain.quiz;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizRequest;
import ee.valiit.back_quiz_valiit_project.studyhelp.quiz.dto.QuizDto;
import org.mapstruct.*;

import java.time.Instant;
import java.util.List;

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


    @Mapping(source = "id", target = "quizId")
    @Mapping(source = "name", target = "quizName")
    @Mapping(source = "type", target = "quizType")
    QuizDto toDto(Quiz quiz);

    List<QuizDto> toDtos(List<Quiz> quizzes);

}