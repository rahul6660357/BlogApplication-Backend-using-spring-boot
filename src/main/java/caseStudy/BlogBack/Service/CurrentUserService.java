package caseStudy.BlogBack.Service;

import caseStudy.BlogBack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class CurrentUserService {

    @Autowired
    UserRepository userRepository;

    public Long getUserid(Principal principal) {
        String email =principal.getName();
        Long id= userRepository.findByEmail(email).get().getUserid();
        return id;
    }
}
