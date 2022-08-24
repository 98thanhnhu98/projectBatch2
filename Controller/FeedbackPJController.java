package com.example.Project.Controller;

import com.example.Project.Service.FeedbackPJService;
import com.example.Project.dto.ListFeedbackPJ;
import com.example.Project.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feedback")
public class FeedbackPJController {
    @Autowired
    FeedbackPJService feedbackPJService;

    //http://localhost:8080/class/getAll
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Feedback>> listAll() {
        List<Feedback> list = feedbackPJService.getAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    //http://localhost:8080/class/save/new
    @RequestMapping(value = "/save/new", method = RequestMethod.POST)
    public ResponseEntity<Feedback> saveClass(@RequestBody Feedback tblClass) {
        feedbackPJService.saveFeedback(tblClass);
        return ResponseEntity.ok(tblClass);
    }

    //http://localhost:8080/class/update/1
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Feedback> updateClass(@PathVariable("id") long id,
                                                @RequestBody Feedback tblClass) {
        Feedback oldClass = feedbackPJService.getOne(id);
        if (oldClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            oldClass.setNote(tblClass.getNote());
            feedbackPJService.saveFeedback(oldClass);
            return ResponseEntity.ok(oldClass);
        }
    }

    //http://localhost:8080/class/delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Feedback> deleteClass(@PathVariable("id") long id) {
        Optional<Feedback> tblClass = feedbackPJService.findFeedbackById(id);
        if (tblClass == null) {
            return ResponseEntity.notFound().build();
        } else {
            feedbackPJService.deleteFeedback(id);
            return ResponseEntity.ok().build();
        }
    }
    @RequestMapping(value = "/lsclass", method = RequestMethod.GET)
    public ResponseEntity<ListFeedbackPJ> listStudent() {
        List<Feedback> list = feedbackPJService.getAll();
        ListFeedbackPJ ls = new ListFeedbackPJ();
        ls.setData(list);
        return new ResponseEntity<>(ls, HttpStatus.OK);
    }
}
