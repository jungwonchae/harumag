package com.example.harumag.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/labs")
@Controller
public class LabsController {
    @GetMapping("/{page}")
    public String page(@PathVariable String page) {
        return "labs/" + page;
    }
    @GetMapping("/{page}/{id}")
    public String page(@PathVariable String page, @PathVariable String id) {
        return "labs/" + page;
    }
}
