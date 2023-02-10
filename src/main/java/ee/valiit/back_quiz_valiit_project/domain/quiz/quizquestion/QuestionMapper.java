package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;

import org.mapstruct.*;

import java.nio.charset.StandardCharsets;

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

}