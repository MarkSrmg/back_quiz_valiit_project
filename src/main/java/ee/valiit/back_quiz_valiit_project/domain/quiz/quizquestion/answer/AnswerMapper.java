package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.AnswerDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.play.AnswerResponse;
import ee.valiit.back_quiz_valiit_project.util.PictureUtil;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",imports = {PictureUtil.class})
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
    @Mapping(expression = "java(PictureUtil.byteArrayToString(answer.getPicture()))", target = "answerPicture")
    @Mapping(constant = "false", target = "isSelected")
    @Mapping(source = "isCorrect", target = "isCorrect")
    AnswerResponse toDto(Answer answer);


    List<AnswerResponse> toDtos(List<Answer> answers);

    @InheritConfiguration (name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Answer updateAnswer(AnswerDto answerDto, @MappingTarget Answer answer);
}