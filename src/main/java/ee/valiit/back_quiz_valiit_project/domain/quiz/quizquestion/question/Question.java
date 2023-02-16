package ee.valiit.back_quiz_valiit_project.domain.quiz.quizquestion.question;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 500)
    @NotNull
    @Column(name = "text", nullable = false, length = 500)
    private String text;

    @Column(name = "picture")
    private byte[] picture;

    @Size(max = 1)
    @NotNull
    @Column(name = "type", nullable = false, length = 1)
    private String type;



}