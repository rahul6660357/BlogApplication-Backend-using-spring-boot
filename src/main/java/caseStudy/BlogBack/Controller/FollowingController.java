package caseStudy.BlogBack.Controller;

import caseStudy.BlogBack.Model.Blog;
import caseStudy.BlogBack.Service.CurrentUserService;
import caseStudy.BlogBack.Service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

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
}
