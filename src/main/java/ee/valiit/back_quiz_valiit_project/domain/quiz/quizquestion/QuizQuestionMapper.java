package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import ee.valiit.back_quiz_valiit_project.studyhelp.question.dto.QuestionShort;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface QuizQuestionMapper {
    @Mapping(source = "question.id", target = "questionId")
    @Mapping(source = "question.text", target = "questionShortText", qualifiedByName = "toShortText")
    QuestionShort toQuestionShort(QuizQuestion quizQuestion);

    List<QuestionShort> toQuestionShorts(List<QuizQuestion> quizQuestions);

    @Named("toShortText")
    static String toShortText(String longText) {
        return longText.substring(0, 10) + "...";
    }

}