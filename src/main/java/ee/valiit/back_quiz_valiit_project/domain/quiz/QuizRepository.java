package ee.valiit.back_quiz_valiit_project.domain.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    @Query("select q from Quiz q where q.user.id = ?1 and q.status = ?2 order by q.timestamp DESC LIMIT 5")
    List<Quiz> findUserQuizzesLast5(Integer userId, String status);

    @Query("select q from Quiz q where q.status = ?1 and q.isPublic = ?2 order by q.timestamp DESC LIMIT 5")
    List<Quiz> findPublicQuizzesLast5(String status, Boolean isPublic);

    @Query("select q from Quiz q where q.user.id = ?1 and q.status = ?2 order by q.timestamp DESC ")
    List<Quiz> findUserQuizzes(Integer userId, String status);

    @Query("select q from Quiz q where q.status = ?1 and q.isPublic = ?2 order by q.timestamp DESC ")
    List<Quiz> findPublicQuizzes(String status, Boolean isPublic);






}