package com.example.demo.Controllers;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Services.MarkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "mark")
public class MarkController {

    @Autowired
    MarkServices markServices  ;



    @RequestMapping(value="mark/getAll", method = RequestMethod.GET)
    public List<Mark> getAllMark(){
        List<Mark> mark = markServices.getAllMark();
        return mark;
    }


    @RequestMapping(value="mark/getById", method = RequestMethod.GET)
    public Mark getMArkById(@RequestParam Integer id){
        Mark mArk = markServices.getMarkById(id);
        return mArk;
    }

    @RequestMapping(value = "getAllMarksByIsActive")
    public List<Mark> getAllActiveMarks() {
        List<Mark> activeMarksList = markServices.getAllActiveMarks();
        return activeMarksList;
    }
}
