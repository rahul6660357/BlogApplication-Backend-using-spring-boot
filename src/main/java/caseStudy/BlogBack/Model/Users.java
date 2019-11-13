package caseStudy.BlogBack.Model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;
    private  String firstname;
    private String lastname;
    private long phnno ;
    private String role;
    private String image;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    @Column(nullable = false,columnDefinition = "int default '1'")
    private int active;
    private String bio;


    public Users(String firstname, String lastname, long phnno, String role, String image, String email, String password, int active, String bio) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phnno = phnno;
        this.role = role;
        this.image = image;
        this.email = email;
        this.password = password;
        this.active = active;
        this.bio = bio;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Users()
   {

   }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getPhnno() {
        return phnno;
    }

    public void setPhnno(long phnno) {
        this.phnno = phnno;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
