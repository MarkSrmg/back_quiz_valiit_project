package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.AnswerDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.play.AnswerResponse;
import ee.valiit.back_quiz_valiit_project.util.PictureUtil;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", imports = {PictureUtil.class})
public interface AnswerMapper {

    @Mapping(expression = "java(PictureUtil.stringToByteArray(answerDto.getAnswerPicture()))", target = "picture")
    @Mapping(source = "answerText", target = "text")
    @Mapping(source = "answerIsCorrect", target = "isCorrect")
    Answer toEntity(AnswerDto answerDto);

    @Mapping(source = "id", target = "answerId")
    @Mapping(source = "text", target = "answerText", qualifiedByName = "noStringToNull")
    @Mapping(expression = "java(PictureUtil.byteArrayToString(answer.getPicture()))", target = "answerPicture")
    @Mapping(constant = "false", target = "isSelected")
    @Mapping(constant = "unanswered", target = "isAnswered")
    @Mapping(source = "isCorrect", target = "isCorrect")
    AnswerResponse toResponse(Answer answer);

    @Named("noStringToNull")
    static String noStringToNull(String text){
        if ("".equals(text)) {
            text=null;
        }return text;
    }

    List<AnswerResponse> toResponses(List<Answer> answers);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Answer updateAnswer(AnswerDto answerDto, @MappingTarget Answer answer);

    @Mapping(source = "id", target = "answerId")
    @Mapping(source = "text", target = "answerText")
    @Mapping(expression = "java(PictureUtil.byteArrayToString(answer.getPicture()))", target = "answerPicture")
    @Mapping(source = "isCorrect", target = "answerIsCorrect")
    AnswerInfo toInfo(Answer answer);

    List<AnswerInfo> toInfos(List<Answer> answers);

    @Mapping(source = "text", target = "answerText")
    @Mapping(expression = "java(PictureUtil.byteArrayToString(answer.getPicture()))", target = "answerPicture")
    @Mapping(source = "isCorrect", target = "answerIsCorrect")
    AnswerDto toDto(Answer answer);

}
