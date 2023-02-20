package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;

import ee.valiit.back_quiz_valiit_project.studyhelp.play.QuestionResponse;
import ee.valiit.back_quiz_valiit_project.util.PictureUtil;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {PictureUtil.class})
public interface QuestionMapper {
    @Mapping(source = "questionText", target = "text")
    @Mapping(source = "questionPicture", target = "picture", qualifiedByName = "stringToByteArray")
    @Mapping(source = "questionType", target = "type")
    Question toEntity(QuestionDto questionDto);


    @Mapping(source = "id", target = "questionId")
    @Mapping(source = "text", target = "questionText")
    // TODO: 09.02.2023 ByteA to string
    @Mapping(expression = "java(PictureUtil.byteArrayToString(randomQuestion.getPicture()))", target = "questionPicture")
    @Mapping(source = "type", target = "questionType")
    QuestionResponse toResponse(Question randomQuestion);

    @Mapping(source = "text",target = "questionText")
    @Mapping(expression = "java(PictureUtil.byteArrayToString(question.getPicture()))",target = "questionPicture")
    QuestionDto toDto(Question question);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Question updateQuestion(QuestionDto questionDto, @MappingTarget Question question);






    @Named("stringToByteArray")
    static byte[] stringToByteArray(String picture) {
        if (picture == null || picture.equals("")) {
            return null;
        }
        return picture.getBytes(StandardCharsets.UTF_8);
    }

}