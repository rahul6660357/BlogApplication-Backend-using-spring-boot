package caseStudy.BlogBack.Controller;


import caseStudy.BlogBack.Model.Users;
import caseStudy.BlogBack.Repository.UserRepository;
import caseStudy.BlogBack.ResourceNotFoundException;
import caseStudy.BlogBack.Service.CurrentUserService;
import caseStudy.BlogBack.Service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired(required = true)
    CurrentUserService currentUserservice;

    @Autowired
    UserDetailService userDetailService;


    @GetMapping("/get1")
    public String getallUser(){
        return "\"succesfully logedin\"";
    }

    @PostMapping("/adduser")
    public Users createuser(@Valid @RequestBody Users user) {
        user.setActive(1);
        user.setImage("../assets/Images/female.jpg");
        user.setRole("admin");
        return userRepository.save(user);
    }

    @PutMapping("/updateuser/{userid}")
    public Users updateUser(@PathVariable(value = "userid") Long noteId,
                            @Valid @RequestBody Users userDetails) {

        Users note = userRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setEmail(userDetails.getEmail());
        note.setFirstname(userDetails.getFirstname());
        note.setPassword(userDetails.getPassword());
        note.setLastname(userDetails.getLastname());
        note.setPhnno(userDetails.getPhnno());
        note.setBio(userDetails.getBio());

        Users updatedNote = userRepository.save(note);
        return updatedNote;
    }

    @GetMapping("/getuserdetail")

    public Optional<Users> getUserDetail(Principal principal){

        return userDetailService.getUserDetail(currentUserservice.getUserid(principal));
    }

    @GetMapping("/getallusers")

    public List<Users> getAllUsers(Principal principal){

        return userRepository.findAll(); }

    @GetMapping("/username/{name}")
    public List<Users> getbyname(@PathVariable(value = "name") String name){
        return  userRepository.findAllByFirstnameContaining(name);
    }

}
