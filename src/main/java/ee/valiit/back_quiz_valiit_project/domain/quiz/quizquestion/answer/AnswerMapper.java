package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.AnswerDto;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AnswerMapper {

    @Mapping(source = "picture",target = "picture", qualifiedByName = "stringToByteArray")
    Answer toEntity(AnswerDto answerDto);

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String picture) {
        if (picture == null  || picture.equals("")) {
            return null;
        }
        return picture.getBytes(StandardCharsets.UTF_8);
    }

}