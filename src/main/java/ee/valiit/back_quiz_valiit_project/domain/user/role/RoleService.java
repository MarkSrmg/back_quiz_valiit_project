package ee.valiit.back_quiz_valiit_project.domain.user.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Resource
    private RoleRepository roleRepository;

    public Role findRole(String student) {
    return roleRepository.findByName(student).get();
    }
}
