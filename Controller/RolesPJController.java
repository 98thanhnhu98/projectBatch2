package com.example.Project.Controller;

import com.example.Project.Service.RolePJService;
import com.example.Project.dto.ListRolesPJ;
import com.example.Project.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/rolez")
public class RolesPJController {
    @Autowired
    RolePJService rolePJService;


    //http://localhost:8080/class/getAll
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Authority>> listAll() {
        List<Authority> list = rolePJService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    //http://localhost:8080/class/save/new
    @RequestMapping(value = "/save/new", method = RequestMethod.POST)
    public ResponseEntity<Authority> saveClass(@RequestBody Authority tblClass) {
        rolePJService.saveClass(tblClass);
        return ResponseEntity.ok(tblClass);
    }

    //http://localhost:8080/class/update/1
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Authority> updateClass(@PathVariable("id") long id,
                                                 @RequestBody Authority tblClass) {
        Authority oldClass = rolePJService.getOne(id);
        if (oldClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            oldClass.setName(tblClass.getName());
            rolePJService.saveClass(oldClass);
            return ResponseEntity.ok(oldClass);
        }
    }

    //http://localhost:8080/class/delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Authority> deleteClass(@PathVariable("id") long id) {
        Optional<Authority> tblClass = rolePJService.findRolesById(id);
        if (tblClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            rolePJService.deleteRoles(id);
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/lsclass", method = RequestMethod.GET)
    public ResponseEntity<ListRolesPJ> listRole() {
        List<Authority> list = rolePJService.getAll();
        ListRolesPJ ls = new ListRolesPJ();
        ls.setData(list);
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }
}
