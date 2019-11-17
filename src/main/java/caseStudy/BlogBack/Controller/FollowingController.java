package caseStudy.BlogBack.Controller;

import caseStudy.BlogBack.Model.Following;
import caseStudy.BlogBack.Service.CurrentUserService;
import caseStudy.BlogBack.Service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/Follow")
public class FollowingController {
    @Autowired
    CurrentUserService currentUserService;

    @Autowired
    FollowingService followingService;



    @PostMapping("/followthis/{userid}")
    public String createNote(@PathVariable(value = "userid") Long userid, Principal principal)
    {
        return followingService.followthispeople(userid, currentUserService.getUserid(principal));

    }

    @GetMapping("/getfollower")
    public List<Following> getfollower(Principal principal)
    {
       return followingService.findAllUser(currentUserService.getUserid(principal));
    }


//    @GetMapping("/checkfollower/{userid}")
//    public String checkfollower(@PathVariable(value = "userid") Long userid,Principal principal)
//    {
//        return followingService.checkfollower(userid, currentUserService.getUserid(principal));
//    }

}
