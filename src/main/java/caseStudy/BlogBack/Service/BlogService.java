package caseStudy.BlogBack.Service;

import caseStudy.BlogBack.Model.Blog;
import caseStudy.BlogBack.Model.Following;
import caseStudy.BlogBack.Model.Users;
import caseStudy.BlogBack.Repository.BlogRepository;
import caseStudy.BlogBack.Repository.FollowingRepository;
import caseStudy.BlogBack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    FollowingRepository followingRepository;


    public String addnewblog(Blog blog, Long userid) {
        Optional<Users> user = userRepository.findById((userid));

        blog.setUsers(user.get());
        blog.setDate(new Date());
        blogRepository.save(blog);
        return "\"Successfully added\"";
    }

    public List<Blog> showblogs(Long userid) {

            Users users = userRepository.findById(userid).get();
           // return blogRepository.findAllByUsers(users);
        return blogRepository.findAllByUsersOrderByDateDesc(users);
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


    public List<Blog> showAllblogs(Long userid) {
        Optional<Users> user = userRepository.findById(userid);
List<Blog> list = new LinkedList<Blog>();
        List<Following> followingList = followingRepository.findByFollower(user);

        for(Following f: followingList)
        {

            List<Blog> blogList = blogRepository.findAllByUsersOrderByDateDesc(f.getFollowing());
            for(Blog b: blogList)
            {

                list.add(b);

            }

        }
        List<Blog> b = blogRepository.findByUsers(user);
        for(Blog bb: b)
        {

            list.add(bb);

        }
        return list;
    }

}
