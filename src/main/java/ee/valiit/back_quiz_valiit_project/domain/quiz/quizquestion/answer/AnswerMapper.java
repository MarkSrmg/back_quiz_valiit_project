package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.AnswerDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AnswerMapper {

    @Mapping(source = "text",target = "text")
    @Mapping(source = "picture",target = "picture")
    @Mapping(source = "isCorrect",target = "isCorrect")
    Answer toEntity(AnswerDto answerDto);


}