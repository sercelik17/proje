package yte.intern.data.project.authentication.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import yte.intern.data.project.authentication.entity.Authority;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.authentication.repository.UserRepository;
import yte.intern.data.project.authentication.entity.Authority;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.authentication.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserTablePopulator {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void populateDatabase() {

        if (!userRepository.existsByUsername("admin")) {
            Users user = new Users(List.of(new Authority("ADMIN")),"admin", passwordEncoder.encode("admin") );
            userRepository.save(user);
        }
    }

}