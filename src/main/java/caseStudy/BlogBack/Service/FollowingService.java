package caseStudy.BlogBack.Service;

import caseStudy.BlogBack.Model.Following;
import caseStudy.BlogBack.Model.Users;
import caseStudy.BlogBack.Repository.FollowingRepository;
import caseStudy.BlogBack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FollowingService {

    @Autowired
    FollowingRepository followingRepository;

    @Autowired
    UserRepository userRepository;

    public String followthispeople(Long userid, Long userid1) {
        Optional<Users> user = userRepository.findById(userid);
        Optional<Users> user1 = userRepository.findById(userid1);
        if(followingRepository.findByFollowerAndAndFollowing(user, user1).isPresent() && user.get()!= user1.get())
        {
          Following following = followingRepository.findByFollowerAndAndFollowing(user,user1).get();
          followingRepository.save(following);
        }
        else {

           if( user.get()!= user1.get()) {
               Following following = new Following();

               following.setFollowing(user.get());
               following.setFollower(user1.get());
               followingRepository.save(following);
           }
        }
return "\"sucess\"";
    }
}
