package com.melodyjumper.expensetrackerapi.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {
    @PostMapping("")
    public String addCategory(HttpServletRequest request) {
        Integer userId = (Integer) request.getAttribute("userId");
        return "authenticated with userId : " + userId;
    }
}
