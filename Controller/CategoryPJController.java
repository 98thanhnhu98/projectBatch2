package com.example.Project.Controller;

import com.example.Project.Service.CategoryPJService;
import com.example.Project.dto.ListCategoryPJ;
import com.example.Project.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryPJController {
    @Autowired
    CategoryPJService categoryPJService;

    //http://localhost:8080/class/getAll
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAll() {
        List<Category> list = categoryPJService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    //http://localhost:8080/class/save/new
    @RequestMapping(value = "/save/new", method = RequestMethod.POST)
    public ResponseEntity<Category> saveClass(@RequestBody Category tblClass) {
        categoryPJService.saveCategory(tblClass);
        return ResponseEntity.ok(tblClass);
    }

    //http://localhost:8080/class/update/1
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateClass(@PathVariable("id") long id,
                                                  @RequestBody Category tblClass) {
        Category oldClass = categoryPJService.getOne(id);
        if (oldClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            oldClass.setNames(tblClass.getNames());
            categoryPJService.saveCategory(oldClass);
            return ResponseEntity.ok(oldClass);
        }
    }

    //http://localhost:8080/class/delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteClass(@PathVariable("id") long id) {
        Optional<Category> tblClass = categoryPJService.findCategoryById(id);
        if (tblClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            categoryPJService.deleteCategory(id);
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/lsclass", method = RequestMethod.GET)
    public ResponseEntity<ListCategoryPJ> listStudent() {
        List<Category> list = categoryPJService.getAll();
        ListCategoryPJ ls = new ListCategoryPJ();
        ls.setData(list);
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }
}
