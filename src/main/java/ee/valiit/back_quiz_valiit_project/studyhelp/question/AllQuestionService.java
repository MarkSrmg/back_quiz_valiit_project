package ee.valiit.back_quiz_valiit_project.studyhelp.question;

import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.Question;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.QuestionMapper;
import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.QuestionService;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AllQuestionService {
    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private QuestionService questionService;

    @Transactional
    public void addQuestion(QuestionDto questionDto) {
        Question question = questionMapper.toEntity(questionDto);
        questionService.saveQuestion(question);

    }
}
