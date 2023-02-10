package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;

import ee.valiit.back_quiz_valiit_project.studyhelp.play.QuestionResponse;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface QuestionMapper {
    @Mapping(source = "questionText", target = "text")
    @Mapping(source = "questionPicture", target = "picture", qualifiedByName = "stringToByteArray")
    @Mapping(constant = "F", target = "type")
    Question toEntity(QuestionDto questionDto);


    @Named("stringToByteArray")
    static byte[] stringToByteArray(String picture) {
        if (picture == null || picture.equals("")) {
            return null;
        }
        return picture.getBytes(StandardCharsets.UTF_8);
    }

    @Mapping(source = "id", target = "questionId")
    @Mapping(source = "text", target = "questionText")
    // TODO: 09.02.2023 ByteA to string
    @Mapping(source = "picture", target = "questionPicture", qualifiedByName = "byteArrayToString")
    @Mapping(source = "type", target = "questionType")
    QuestionResponse toDto(Question randomQuestion);

    @Named("byteArrayToString")
    static String byteArrayToString(byte[] picture){
        if (picture == null){
            return null;
        }
        return picture.toString();
    }

}