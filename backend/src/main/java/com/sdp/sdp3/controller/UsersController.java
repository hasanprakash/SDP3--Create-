package com.sdp.sdp3.controller;

import java.util.List;

import com.sdp.sdp3.entities.Users;
import com.sdp.sdp3.repository.UsersRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

@CrossOrigin(origins = { "http://localhost:8081", "https://mango-pebble-0e6f6c200.azurestaticapps.net/" })
public class UsersController {

    @Autowired
    private UsersRepository repository;

    HttpServlet httpServlet;

    public static HttpSession session;

    @PostMapping("/register")
    public void createAccount(@RequestBody Users user, HttpServletRequest request) {
        // request.getSession().setAttribute("username", user.getUsername());
        // System.out.println(request.getSession().getAttribute("username"));
        System.out.println(user.getUsername()+" "+user.getPassword()+" "+user.getEmail());
        repository.save(user);
    }

    @GetMapping("/register")
    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping("/login")
    public boolean getUser(@RequestBody Users user, HttpServletRequest request) {
        UsersController.session = request.getSession();
        List<Users> l = repository.findByUsername(user.getUsername());
        if(l.size() == 0 || !l.get(0).getPassword().equals(user.getPassword())) {
            return true;
        }
        UsersController.session.setMaxInactiveInterval(3600);
        UsersController.session.setAttribute("username", user.getUsername());
        System.out.println(session.getAttribute("username"));
        return false;
    }

    @GetMapping("/logout")
    public boolean logoutUser(HttpServletRequest request) {
        boolean isLogout = false;
        if(UsersController.session != null && UsersController.session.getAttribute("username")!=null) {
            UsersController.session.setAttribute("username", null);
            UsersController.session.setMaxInactiveInterval(0);
            isLogout = true;
            return isLogout;
        }
        else {
            System.out.println("User already logged out!!");
            return isLogout;
        }
    }

    @GetMapping("/isLogout")
    public boolean isSessionActive(HttpServletRequest request) {
        return UsersController.session == null || UsersController.session.getAttribute("username") == null;
    }

    @GetMapping("/username")
    public String getUsername() {
        if(UsersController.session!=null && UsersController.session.getAttribute("username")!=null) {
            String username = (String) UsersController.session.getAttribute("username");
            System.out.println("Sending "+ username +" username to vue");
            return username;
        }
        else
            return null;
    }




    @GetMapping("/profile1")
    public void getProfile1(HttpServletRequest request) {
        request.getSession().setAttribute("hero", "Hasan");
        System.out.println(request.getSession().getAttribute("hero"));
    }
    @GetMapping("/profile2")
    public void getProfile2(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("hero"));
    }
}
