package ee.valiit.back_quiz_valiit_project.studyhelp.question;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;
import ee.valiit.back_quiz_valiit_project.studyhelp.question.dto.QuestionResponse;
import ee.valiit.back_quiz_valiit_project.studyhelp.question.dto.QuestionShort;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionsController {

    @Resource
    private QuestionsService questionsService;

    @GetMapping("/questions")
    @Operation(summary = "Finds all questions by QuizId and enables to edit them", description = "x")
    public List<QuestionShort> getQuestions(@RequestParam Integer quizId) {
        return questionsService.getQuestions(quizId);
    }
    @GetMapping("/question")
    @Operation(summary = "Finds question by QuestionId", description = "Gets one single question with questionId")
    public QuestionDto getQuestion(@RequestParam Integer questionId) {
        return questionsService.getQuestion(questionId);
    }

    @PostMapping("/questions")
    @Operation(summary = "adds question to database", description = "adds question to question table in database after save button press")
    public QuestionResponse addQuestion(@RequestParam Integer quizId, @RequestBody QuestionDto questionDto) {
        return questionsService.addQuestion(quizId, questionDto);
    }
    @PutMapping("/questions")
    @Operation(summary = "Edits question in database", description = "Finds question via Id and adds changes to question table in database after edit button press")
    public void editQuestion(@RequestParam Integer questionId, @RequestBody QuestionDto questionDto) {
        questionsService.editQuestion(questionId, questionDto);
    }
    @DeleteMapping("/questions")
    @Operation(summary = "Deletes question from database", description = "Finds question via Id and changes the status in quiz_question to deactivated")
    public void deleteQuestion(@RequestParam Integer questionId, @RequestParam Integer quizId) {
        questionsService.deleteQuestion(questionId, quizId);
    }

}
