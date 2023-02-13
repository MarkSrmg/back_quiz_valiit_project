package ee.valiit.back_quiz_valiit_project.studyhelp.question;

import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.Question;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuestionDto;
import ee.valiit.back_quiz_valiit_project.util.PictureUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.mapstruct.Mapping;
import org.springframework.web.bind.annotation.*;

@RestController
public class AllQuestionController {

    @Resource
    private AllQuestionService allQuestionService;

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
