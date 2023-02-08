package ee.valiit.back_quiz_valiit_project.studyhelp.question.answer;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.AnswerDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizAnswerController {
    @Resource
    private QuizAnswerService quizAnswerService;

    @PostMapping("/questions/answer")
    @Operation(summary = "adds new answer to question", description = "gets questionId and adds the answer to the question to database")
    public void addAnswer(@RequestParam Integer questionId, @RequestBody AnswerDto answerDto) {
        quizAnswerService.addAnswer(questionId, answerDto);

    }
}
