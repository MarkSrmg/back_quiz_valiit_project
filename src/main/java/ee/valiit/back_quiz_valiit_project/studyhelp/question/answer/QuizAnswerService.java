package ee.valiit.back_quiz_valiit_project.studyhelp.question.answer;

import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.Question;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.Answer;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerMapper;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.AnswerDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.question.QuestionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class QuizAnswerService {
    @Resource
    private AnswerService answerService;
    @Resource
    private QuestionService questionService;
    @Resource
    private AnswerMapper answerMapper;

    public void addAnswer(Integer questionId, AnswerDto answerDto) {
        Question question = questionService.findQuestion(questionId);
        Answer answer = answerMapper.toEntity(answerDto);
        answer.setQuestion(question);
        answerService.saveAnswer(answer);
    }
}
