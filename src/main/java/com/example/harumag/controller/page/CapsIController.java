package com.example.harumag.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/capsI")
@Controller
public class CapsIController {
    @GetMapping("/{page}")
    public String page(@PathVariable String page) {
        return "capsI/" + page;
    }
    @GetMapping("/{page}/{id}")
    public String page(@PathVariable String page, @PathVariable String id) {
        return "capsI/" + page;
    }
}
