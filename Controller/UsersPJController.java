package com.example.Project.Controller;

import com.example.Project.Service.UsersPJService;
import com.example.Project.dto.ListUsersPJ;
import com.example.Project.dto.userTenancyRoom;
import com.example.Project.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersPJController {
    @Autowired
    UsersPJService usersPJService;


    //http://localhost:8080/class/getAll
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> listAll() {
        List<Users> list = usersPJService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    //http://localhost:8080/class/save/new
    @RequestMapping(value = "/save/new", method = RequestMethod.POST)
    public ResponseEntity<Users> saveClass(@RequestBody Users tblClass) {
        usersPJService.saveUsers(tblClass);
        return ResponseEntity.ok(tblClass);
    }

    //http://localhost:8080/class/update/1
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Users> updateClass(@PathVariable("id") long id,
                                             @RequestBody Users tblClass) {
        Users oldClass = usersPJService.getOne(id);
        if (oldClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            oldClass.setFullname(tblClass.getFullname());
            oldClass.setEmail(tblClass.getEmail());
            oldClass.setPhone(tblClass.getPhone());
            oldClass.setAddress(tblClass.getAddress());
            oldClass.setPassword(tblClass.getPassword());
            usersPJService.saveUsers(oldClass);
            return ResponseEntity.ok(oldClass);
        }
    }

    //http://localhost:8080/class/delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Users> deleteClass(@PathVariable("id") long id) {
        Optional<Users> tblClass = usersPJService.findUsersById(id);
        if (!tblClass.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            usersPJService.deleteUsers(id);
            return ResponseEntity.ok().build();
        }
    }


    @RequestMapping(value = "/lsclass", method = RequestMethod.GET)
    public ResponseEntity<ListUsersPJ> listStudent() {
        List<Users> list = usersPJService.getAll();
        ListUsersPJ ls = new ListUsersPJ();
        ls.setData(list);
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }

    //http://localhost:8080/users/lsclas/ + id
    @RequestMapping(value = "/lsclas/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Users>> listStudentone(@PathVariable("id") long id) {
        Optional<Users> users = usersPJService.findUsersById(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
//    public ResponseEntity<List<userTenancyRoom>> read(@PathVariable("id") long id) {
//        List<userTenancyRoom> list = usersPJService.getInfo(id);
//        return new ResponseEntity<List<userTenancyRoom>>(list,HttpStatus.OK);
//    }

    @GetMapping("/getoneUser")
    public ResponseEntity<List<Users>> UserlikeKeyWord(@RequestParam String name) {
        return new ResponseEntity<List<Users>>(usersPJService.getNameBykeyWord(name), HttpStatus.OK);
    }
}
