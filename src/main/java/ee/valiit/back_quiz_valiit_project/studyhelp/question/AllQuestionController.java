package ee.valiit.back_quiz_valiit_project.studyhelp.question;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllQuestionController {

    @Resource
    private AllQuestionService allQuestionService;

    @PostMapping("/questions")
    @Operation(summary = "adds question to database", description = "adds question to question table in database after save button press")
    public QuestionResponse addQuestion(@RequestParam Integer quizId, @RequestBody QuestionDto questionDto) {
        return allQuestionService.addQuestion(quizId, questionDto);
    }

}
