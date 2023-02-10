package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.AnswerDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.play.AnswerResponse;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AnswerMapper {

    @Mapping(source = "answerPicture", target = "picture", qualifiedByName = "stringToByteArray")
    @Mapping(source = "answerText", target = "text")
    @Mapping(source = "answerIsCorrect", target = "isCorrect")
    Answer toEntity(AnswerDto answerDto);

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String picture) {
        if (picture == null || picture.equals("")) {
            return null;
        }
        return picture.getBytes(StandardCharsets.UTF_8);
    }

    @Mapping(source = "id", target = "answerId")
    @Mapping(source = "text", target = "answerText")
    @Mapping(source = "picture", target = "answerPicture", qualifiedByName = "byteArrayToString")
    @Mapping(constant = "false", target = "isSelected")
    AnswerResponse toDto(Answer answer);

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] picture){
        if (picture == null){
            return null;
        }
        return picture.toString();
    }

    List<AnswerResponse> toDtos(List<Answer> answers);
}