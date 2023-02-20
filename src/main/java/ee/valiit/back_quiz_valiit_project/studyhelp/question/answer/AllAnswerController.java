package ee.valiit.back_quiz_valiit_project.studyhelp.question.answer;

import ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.answer.AnswerInfo;
import ee.valiit.back_quiz_valiit_project.studyhelp.dto.AnswerDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/questions")
@RestController
public class AllAnswerController {
    @Resource
    private AllAnswerService allAnswerService;

    @PostMapping("/answer")
    @Operation(summary = "adds new answer to question", description = "gets questionId and adds the answer to the question to database")
    public AnswerResponse addAnswer(@RequestParam Integer questionId, @RequestBody AnswerDto answerDto) {
        return allAnswerService.addAnswer(questionId, answerDto);
    }
    @PutMapping("/answer")
    @Operation(summary = "Edits question in database", description = "Finds question via Id and adds changes to question table in database after edit button press")
    public void editAnswer(@RequestParam Integer answerId, @RequestBody AnswerDto answerDto) {
        allAnswerService.editAnswer(answerId, answerDto);
    }
    @GetMapping("/answers")
    @Operation(summary = "Gets answers from database", description = "finds all answers for question with questionId")
    public List<AnswerInfo> getAnswers (@RequestParam Integer questionId) {
       return allAnswerService.getAnswers(questionId);
    }
    @GetMapping("/answer")
    @Operation(summary = "Gets answer from database", description = "find answer with answerId")
    public AnswerDto getAnswer (@RequestParam Integer answerId) {
        return allAnswerService.getAnswer(answerId);
    }
    @DeleteMapping("/answer")
    @Operation(summary = "Deletes answer from database", description = "find answer with answerId and deletes it")
    public void deleteAnswer (@RequestParam Integer answerId) {
        allAnswerService.deleteAnswer(answerId);
    }
}
