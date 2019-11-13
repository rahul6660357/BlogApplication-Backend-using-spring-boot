package caseStudy.BlogBack.Repository;

import caseStudy.BlogBack.Model.Following;
import caseStudy.BlogBack.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowingRepository extends JpaRepository<Following, Long> {
    Optional<Following> findByFollowerAndAndFollowing(Optional<Users> user, Optional<Users> user1);
}
