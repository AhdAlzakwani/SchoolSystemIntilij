package com.example.demo.Services;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Repositories.MarkInterfase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkServices {

    @Autowired
    MarkInterfase markInterfase;

    public List<Mark> getAllMark(){
        return markInterfase.getAllMark();
    }
}
