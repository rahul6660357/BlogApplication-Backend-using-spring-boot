package caseStudy.BlogBack.Service;

import caseStudy.BlogBack.Model.Blog;
import caseStudy.BlogBack.Model.Users;
import caseStudy.BlogBack.Repository.BlogRepository;
import caseStudy.BlogBack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogRepository blogRepository;


    public String addnewblog(Blog blog, Long userid) {
        Optional<Users> user = userRepository.findById((userid));

        blog.setUsers(user.get());
        blog.setDate(new Date());
        blog.setAccess("public");
        blogRepository.save(blog);
        return "\"Successfully added\"";
    }

    public List<Blog> showblogs(Long userid) {

            Optional<Users> users = userRepository.findById(userid);
            return blogRepository.findAllByUsers(users);
    }

    public String AddLikes(Long userid, Long blogid) {

        Optional<Users> user = userRepository.findById((userid));
          Blog blog = blogRepository.findById(blogid).get();
          blog.setLikes(blog.getLikes()+1);
          blogRepository.save(blog);
          return "\"addes successfully\"";

    }

    public String AddDISLikes(Long userid, Long blogid) {
        Optional<Users> user = userRepository.findById((userid));
        Blog blog = blogRepository.findById(blogid).get();
        blog.setDislikes(blog.getDislikes()+1);
        blogRepository.save(blog);
        return "\"addes successfully\"";
    }
}
