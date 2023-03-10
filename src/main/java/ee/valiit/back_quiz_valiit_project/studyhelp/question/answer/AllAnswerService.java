package ee.valiit.back_quiz_valiit_project.studyhelp.question.answer;

import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.Question;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.Answer;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerInfo;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerMapper;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerService;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.AnswerDto;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question.QuestionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllAnswerService {
    @Resource
    private AnswerService answerService;
    @Resource
    private QuestionService questionService;
    @Resource
    private AnswerMapper answerMapper;

    public AnswerResponse addAnswer(Integer questionId, AnswerDto answerDto) {
        Question question = questionService.findQuestion(questionId);
        Answer answer = answerMapper.toEntity(answerDto);
        answer.setQuestion(question);
        answerService.saveAnswer(answer);
        return new AnswerResponse(answer.getId());
    }


    public void editAnswer(Integer answerId, AnswerDto answerDto) {
        Answer answer = answerService.findAnswer(answerId);
        Answer updateAnswer = answerMapper.updateAnswer(answerDto, answer);
        answerService.saveAnswer(updateAnswer);
    }

    public List<AnswerInfo> getAnswers(Integer questionId) {
        List<Answer> answers = answerService.findAnswers(questionId);
        return answerMapper.toInfos(answers);
    }

    public AnswerDto getAnswer(Integer questionId) {
        Answer answer = answerService.findAnswerByQuestionId(questionId);
        return answerMapper.toDto(answer);
    }

    public void deleteAnswer(Integer answerId) {
        answerService.deleteAnswer(answerId);
    }
}
