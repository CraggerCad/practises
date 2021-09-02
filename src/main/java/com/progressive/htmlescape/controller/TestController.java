package com.progressive.htmlescape.controller;

import com.progressive.htmlescape.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private Test test;

    @GetMapping("/asd")
    public ResponseEntity<?> testAndTime(){
        Map<Long, String> asd = new HashMap<>();
        if(!asd.containsKey(1L)){
            System.out.println("no");
        }
        asd.put(1L,"150");
        if(asd.containsKey(1L)){
            System.out.println("yes");
        }
        test.setTestAndTime(asd);
        return new ResponseEntity<>(test, HttpStatus.OK);
    }
}
