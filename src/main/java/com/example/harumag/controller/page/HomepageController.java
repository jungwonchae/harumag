package com.example.harumag.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {
    @GetMapping("/homePage")
    public String homePage() {
        return "homePage"; // homePage.html을 렌더링
    }
}
