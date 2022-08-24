package com.example.Project.Controller;

import com.example.Project.Service.FeeService;
import com.example.Project.model.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feePay")
public class FeeController {
    @Autowired
    FeeService feeService;

    //http://localhost:8080/class/getAll
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Fee>> listAll() {
        List<Fee> list = feeService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    //http://localhost:8080/class/save/new
    @RequestMapping(value = "/save/new", method = RequestMethod.POST)
    public ResponseEntity<Fee> saveClass(@RequestBody Fee tblClass) {
        feeService.saveFee(tblClass);
        return ResponseEntity.ok(tblClass);
    }


    //http://localhost:8080/class/delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Fee> deleteClass(@PathVariable("id") long id) {
        Optional<Fee> tblClass = feeService.findFeeById(id);
        if (tblClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            feeService.deleteFee(id);
            return ResponseEntity.ok().build();
        }
    }
//    @RequestMapping(value = "/lsclass", method = RequestMethod.GET)
//    public ResponseEntity<ListFeedbackPJ> listStudent() {
//        List<Feedback> list = feedbackPJService.getAll();
//        ListFeedbackPJ ls = new ListFeedbackPJ();
//        ls.setData(list);
//        return new ResponseEntity<>(ls, HttpStatus.OK);
//    }
}
