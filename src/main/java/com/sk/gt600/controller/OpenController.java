package com.sk.gt600.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gt")
public class OpenController {

    @GetMapping("/hi")
    public String hi(){
        return "I love you jb";
    }
}
