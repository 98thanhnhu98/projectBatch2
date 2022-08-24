package com.example.Project.Controller.Admin;

import com.example.Project.dto.UserModel;
import com.example.Project.repository.UsersPJRepository;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsersPJRepository usersPJRepository;

//    @PostMapping("/register")// ko phải link này để đăng kí
//    public Users register(@RequestBody UserModel userModel){
//        Users newUser = new Users();
//        newUser.setEmail(userModel.getEmail());
//        newUser.setPassword(passwordEncoder.encode(userModel.getPassword()));
//        newUser.setAuthority(userModel.getAuthority());
//        return usersPJRepository.save(newUser);
//    }
    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome user</h1>");
    }
    @GetMapping("/admin")
    public String admin(){
        return ("<h1>Welcome admin</h1>");
    }
    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String dashbroard(){
        return "this is dashboard";
    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String profile(){
        return "this is profile";
    }

    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> login(@RequestBody UserModel userModel) throws Exception {
        Authentication authentication1;
        try {
            authentication1 = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userModel.getEmail(),userModel.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication1);
        }catch (BadCredentialsException e){
            throw new Exception("invalid credentials");
        }catch (UnsatisfiedDependencyException | BeanCurrentlyInCreationException e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
