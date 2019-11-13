package caseStudy.BlogBack.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Following implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followingid;

    @ManyToOne
    private Users follower;

    @ManyToOne
    private Users following;

    public Following(Users follower, Users following) {
        this.follower = follower;
        this.following = following;
    }

    public Following() {
    }

    public Long getFollowingid() {
        return followingid;
    }

    public void setFollowingid(Long followingid) {
        this.followingid = followingid;
    }

    public Users getFollower() {
        return follower;
    }

    public void setFollower(Users follower) {
        this.follower = follower;
    }

    public Users getFollowing() {
        return following;
    }

    public void setFollowing(Users following) {
        this.following = following;
    }
}
