package ee.valiit.back_quiz_valiit_project.studyhelp.question;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.question.dto.QuestionResponse;
import ee.valiit.back_quiz_valiit_project.studyhelp.question.dto.QuestionShort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AllQuestionController {

    @Resource
    private AllQuestionService allQuestionService;

    @GetMapping("/questions")
    @Operation(summary = "Finds all questions by QuizId and enables to edit them", description = "x")
    public List<QuestionShort> getQuestions(@RequestParam Integer quizId) {
        return allQuestionService.getQuestions(quizId);
    }

    @PostMapping("/questions")
    @Operation(summary = "adds question to database", description = "adds question to question table in database after save button press")
    public QuestionResponse addQuestion(@RequestParam Integer quizId, @RequestBody QuestionDto questionDto) {
        return allQuestionService.addQuestion(quizId, questionDto);
    }
    @PutMapping("/questions")
    @Operation(summary = "Edits question in database", description = "Finds question via Id and adds changes to question table in database after edit button press")
    public void editQuestion(@RequestParam Integer questionId, @RequestBody QuestionDto questionDto) {
        allQuestionService.editQuestion(questionId, questionDto);
    }
}
