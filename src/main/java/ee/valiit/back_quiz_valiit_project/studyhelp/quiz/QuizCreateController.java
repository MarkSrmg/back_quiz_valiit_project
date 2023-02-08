package ee.valiit.back_quiz_valiit_project.studyhelp.quiz;

import ee.valiit.back_quiz_valiit_project.studyhelp.dto.QuizDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizCreateController {

    @Resource
    private QuizCreateService quizCreateService;


    @PostMapping("/create")
    @Operation(summary = "Create new Quiz", description = "Posts new quiz name and answers needed, and returs quizName and quizId")
    public QuizResponse addNewQuiz(@RequestBody QuizDto quizDto){
        return quizCreateService.addNewQuiz(quizDto);
    }

}
