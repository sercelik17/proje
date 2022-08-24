package yte.intern.data.project.authentication.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import yte.intern.data.project.admin.entity.Admin;
import yte.intern.data.project.authentication.entity.Authority;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.authentication.repository.AuthorityRepository;
import yte.intern.data.project.authentication.repository.UserRepository;
import yte.intern.data.project.authentication.entity.Authority;
import yte.intern.data.project.authentication.entity.Users;
import yte.intern.data.project.authentication.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserTablePopulator {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;




    @PostConstruct
    public void populateDatabase() {
        if(!authorityRepository.existsByAuthority("STUDENT")){
            authorityRepository.save(new Authority("STUDENT"));
        }

        if(!authorityRepository.existsByAuthority("ASISTAN")){
            authorityRepository.save(new Authority("ASISTAN"));
        }
        if(!authorityRepository.existsByAuthority("AKADEMISYEN")) {
            authorityRepository.save(new Authority("AKADEMISYEN"));
        }
        if(!authorityRepository.existsByAuthority("ADMIN")) {
            authorityRepository.save(new Authority("ADMIN"));
        }
        Authority admin = authorityRepository.findByAuthority("ADMIN")
                .orElseThrow(() -> new EntityNotFoundException("Authority:ADMIN not found!"));

        if (!userRepository.existsByUsername("admin")) {
            Users user = new Users(List.of(admin),"admin", passwordEncoder.encode("admin") );
            userRepository.save(user);

        }



    }

}