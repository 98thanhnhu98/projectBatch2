package com.example.Project.view;

import com.example.Project.Service.*;
import com.example.Project.dto.userTenancyRoom;
import com.example.Project.model.Authority;
import com.example.Project.model.Room;
import com.example.Project.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;


@Controller
public class UsersView {
    @Autowired
    TenancyPJService tenancyPJService;
    @Autowired
    UsersPJServiceIML usersPJService;

    @Autowired
    RoomPJServiceIML roomPJService;
    @Autowired
    AuthoserviceIML authoserviceIML;

    @GetMapping("/user-home")
    public String showHang(Model model) {
        List<Users> user = usersPJService.getAll();
        model.addAttribute("users", user);
        return "Users-html";
    }

//    @GetMapping("/allTenancy/{id}")
//    public String read1(Model model, @PathVariable("id") long id) {
//        List<userTenancyRoom> tables = tenancyPJService.getInfo(id);
//        model.addAttribute("table", tables);
//        return "myTenancy";
//    }
    @GetMapping("/detailOne/{id}")//List
    public String readdetail(Model model, @PathVariable("id") long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Users users = usersPJService.findUserByEmail2(email);
        model.addAttribute("user", users);
        List<userTenancyRoom> tables = tenancyPJService.getInfo(id);
        model.addAttribute("table", tables);
        return "ListTenancyOfUser";
    }

    @GetMapping("/detailTwo/{id}") //List
    public String readdetail2(Model model, @PathVariable("id") long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Users users = usersPJService.findUserByEmail2(email);
        model.addAttribute("user", users);
        List<userTenancyRoom> tables = tenancyPJService.getInfo(id);
        model.addAttribute("table", tables);
        return "ListRoomOfUser";
    }



    @GetMapping(path = {"/", "/home"})
    public String home(Model model, @RequestParam(defaultValue = "5") int page,
                       @RequestParam(defaultValue = "6") int limit) {
        Page<Room> rooms = roomPJService.findRoom(PageRequest.of(page - 5, limit));
        model.addAttribute("rooms", rooms);
        model.addAttribute("page", page);
        model.addAttribute("limit", limit);
        model.addAttribute("time", Calendar.getInstance().getTime());
        return "index";
    }

    @GetMapping(path = {"/403", "/404"})
    public String error() {
        return "403";
    }

    @GetMapping("/pageLogin")
    public String showLogin() {
        return "loginPage";
    }


    //page register của USER
    @RequestMapping("/pageRegister")
    public String showRegister(Model model) {
        model.addAttribute("user", new Users());
        return "RegisterPage";
    }



    @PostMapping("/process_register")
    public String processRegister(Users users) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        Authority a = authoserviceIML.findByName("USER");
        users.setAuthorityByAuthorityId_0(a);
        users.setAuthorityId(5L);
        usersPJService.saveUsers(users);
        return "register_success";
    }

    @GetMapping(path = {"/login-success"})
    public String index1(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Users users = usersPJService.findUserByEmail2(email);
        model.addAttribute("users", users);
        return "User-detail";
    }


    @GetMapping("/Categoryshtml")
    public String Categoryshtml() {
        return "/main/resources/static/Categoryshtml.html";
    }

    @GetMapping("/Feedback")
    public String Feedback() {
        return "/Feedback";
    }

    @GetMapping("/Roles")
    public String Roles() {
        return "/main/resources/static/Roles-html.html";
    }

    @GetMapping("/services")
    public String services() {
        return "/services";
    }
}
