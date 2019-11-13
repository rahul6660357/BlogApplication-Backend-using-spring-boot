package caseStudy.BlogBack.Controller;

import caseStudy.BlogBack.Model.Blog;
import caseStudy.BlogBack.Repository.BlogRepository;
import caseStudy.BlogBack.Service.BlogService;
import caseStudy.BlogBack.Service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/Blogs")
public class BlogController {

    @Autowired(required = true)
    CurrentUserService currentUserservice;

    @Autowired
    BlogService blogService;

    @Autowired
    BlogRepository blogRepository;

    @PostMapping("/addblog")
    public String createNote(@Valid @RequestBody Blog blog,  Principal principal)
    {
        return blogService.addnewblog(blog, currentUserservice.getUserid(principal));

    }

    @RequestMapping(value = "/showblogs", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> showblogs(Principal principal){
        return blogService.showblogs( currentUserservice.getUserid(principal));

    }

    @RequestMapping(value = "/addlikes/{blogid}", method = RequestMethod.GET)
    @ResponseBody
    public String AddLIKES(@PathVariable Long blogid, Principal principal)
    {
        return blogService.AddLikes(currentUserservice.getUserid(principal),blogid);
    }

    @RequestMapping(value = "/adddislikes/{blogid}", method = RequestMethod.GET)
    @ResponseBody
    public String AddDISLIKES(@PathVariable Long blogid, Principal principal)
    {
        return blogService.AddDISLikes(currentUserservice.getUserid(principal),blogid);
    }


}
