package caseStudy.BlogBack.Repository;

import caseStudy.BlogBack.Model.Blog;
import caseStudy.BlogBack.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog , Long> {
 List<Blog> findByUsers(Optional<Users> user);
List<Blog> findAllByUsersOrderByDateDesc(Users users);
List<Blog> findByBlognameContainingAndAccessOrderByDateDesc(String str, String str1);
List<Blog> findAllByCategoryAndAccess(String category,String access);

}
