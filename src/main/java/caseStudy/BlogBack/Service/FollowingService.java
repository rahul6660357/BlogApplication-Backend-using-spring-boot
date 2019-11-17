package caseStudy.BlogBack.Service;

import caseStudy.BlogBack.Model.Following;
import caseStudy.BlogBack.Model.Users;
import caseStudy.BlogBack.Repository.FollowingRepository;
import caseStudy.BlogBack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

        Following following = new Following();

        following.setFollowing(user.get());
        following.setFollower(user1.get());
        followingRepository.save(following);


        return "\"sucess\"";
    }


    public List<Following> findAllUser(Long userid) {
        Optional<Users> user = userRepository.findById(userid);

        return followingRepository.findByFollower(user);
    }

//    public String checkfollower(Long userid, Long userid1) {
//        Optional<Users> follower = userRepository.findById(userid1);
//        List<Following> f = followingRepository.findByFollower(follower);
//        for (Following ff : f) {
//            if (ff.getFollowing().getUserid() == userid) {
//
//                break;
//
//            }
//            return "\"true\"";
//
//        }
//        return "\"false\"";
//    }
}
