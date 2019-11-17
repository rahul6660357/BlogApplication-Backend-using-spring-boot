package caseStudy.BlogBack.Controller;

import caseStudy.BlogBack.Model.Blog;
import caseStudy.BlogBack.Repository.BlogRepository;
import caseStudy.BlogBack.ResourceNotFoundException;
import caseStudy.BlogBack.Service.BlogService;
import caseStudy.BlogBack.Service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

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
    public String createNote(@Valid @RequestBody Blog blog, Principal principal) {
        return blogService.addnewblog(blog, currentUserservice.getUserid(principal));

    }

    @RequestMapping(value = "/showblogs", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> showblogs(Principal principal) {
        return blogService.showblogs(currentUserservice.getUserid(principal));

    }

    @RequestMapping(value = "/showallblogs", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> showAllblogs(Principal principal) {
        return blogService.showAllblogs(currentUserservice.getUserid(principal));

    }

    @RequestMapping(value = "/addlikes/{blogid}", method = RequestMethod.GET)
    @ResponseBody
    public String AddLIKES(@PathVariable Long blogid, Principal principal) {
        return blogService.AddLikes(currentUserservice.getUserid(principal), blogid);
    }

    @RequestMapping(value = "/blogbyid/{blogid}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Blog> GetBlogs(@PathVariable Long blogid) {
        return blogRepository.findById(blogid);
    }

    @RequestMapping(value = "/getBlogs/{userid}", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> getBlogs(@PathVariable Long userid) {
        return blogService.showblogs(userid);
    }

    @RequestMapping(value = "/adddislikes/{blogid}", method = RequestMethod.GET)
    @ResponseBody
    public String AddDISLIKES(@PathVariable Long blogid, Principal principal) {
        return blogService.AddDISLikes(currentUserservice.getUserid(principal), blogid);
    }

    @RequestMapping(value = "/findblog/{data}", method = RequestMethod.GET)
    @ResponseBody
    public List<Blog> SearchBlog(@PathVariable String data) {
        return blogRepository.findByBlognameContainingAndAccessOrderByDateDesc(data, "public");
    }


    @PutMapping("/updateblog/{blogid}")
    public Blog updateBlog(@PathVariable(value = "blogid") Long blogid,
                           @Valid @RequestBody Blog noteDetails) {

        Blog note = blogRepository.findById(blogid)
                .orElseThrow(() -> new ResourceNotFoundException("Blog", "blogid", blogid));

        note.setAccess(noteDetails.getAccess());
        note.setBlogdetail(noteDetails.getBlogdetail());
        note.setBlogimage(noteDetails.getBlogimage());
        note.setBlogname(noteDetails.getBlogname());
        note.setBlogheading(noteDetails.getBlogheading());
        note.setWebsite(noteDetails.getWebsite());
        note.setCategory(noteDetails.getCategory());


        Blog updatedNote = blogRepository.save(note);
        return updatedNote;
    }

    @DeleteMapping("/deleteblog/{blogid}")
    public String delete(@PathVariable(value = "blogid") Long noteId) {
        blogRepository.deleteById(noteId);
        return "\"deleted Successfully\"";
    }
    @GetMapping("/find-by-category/{category}/{access}")
    public List<Blog> getitemByCategory(@PathVariable(value = "category") String category,@PathVariable(value = "access")String access) {
        return blogRepository.findAllByCategoryAndAccess(category,access);
    }
}
