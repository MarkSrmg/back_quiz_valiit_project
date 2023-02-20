package ee.valiit.back_quiz_valiit_project.domain.user;

import ee.valiit.back_quiz_valiit_project.validation.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User findUser(String username, String password) {
        Optional<User> optionalUser = userRepository.findUser(username, password, Status.ACTIVE);
        User user = Validator.getValidUser(optionalUser);
        return user;
    }
    public User findUser(Integer userId){
        return userRepository.findById(userId).get();
    }

    public Optional <User> findUniqueUsername(String userName) {
        Optional<User> user = userRepository.findByUsername(userName);
        return user;
    }

    public void saveUser(User newUser) {
        userRepository.save(newUser);
    }

    public List <User> findPendingUsers(String pending) {
        return userRepository.findByRole_Name(pending);
    }
}
