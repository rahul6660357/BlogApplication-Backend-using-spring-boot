package caseStudy.BlogBack.Service;

import caseStudy.BlogBack.Model.Users;
import caseStudy.BlogBack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailService {

    @Autowired
    UserRepository userRepository;



    public Optional<Users> getUserDetail(Long userid) {
        Optional<Users> users = userRepository.findById(userid);
        return userRepository.findById(userid);
    }


}
