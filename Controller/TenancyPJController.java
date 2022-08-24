package com.example.Project.Controller;

import com.example.Project.Service.TenancyPJService;
import com.example.Project.dto.ListTenancyPJ;
import com.example.Project.dto.userTenancyRoom;
import com.example.Project.model.Tenancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenancy")
public class TenancyPJController {
    @Autowired
    TenancyPJService tenancyPJService;

        @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<userTenancyRoom>> read(@PathVariable("id") long id) {
        List<userTenancyRoom> list = tenancyPJService.getInfo(id);
        return new ResponseEntity<List<userTenancyRoom>>(list,HttpStatus.OK);
    }
    //http://localhost:8080/class/getAll
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Tenancy>> listAll() {
        List<Tenancy> list = tenancyPJService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }


    //http://localhost:8080/class/save/new
    @RequestMapping(value = "/save/new", method = RequestMethod.POST)
    public ResponseEntity<Tenancy> saveClass(@RequestBody Tenancy tblClass) {
        tenancyPJService.saveTenancy(tblClass);
        return ResponseEntity.ok(tblClass);
    }

    @RequestMapping(value = "/lsclass", method = RequestMethod.GET)
    public ResponseEntity<ListTenancyPJ> listStudent() {
        List<Tenancy> list = tenancyPJService.getAll();
        ListTenancyPJ ls = new ListTenancyPJ();
        ls.setData(list);
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }
}
