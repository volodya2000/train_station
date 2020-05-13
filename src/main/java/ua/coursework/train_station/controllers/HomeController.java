package ua.coursework.train_station.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/departments")
    public String getDepartments()
    {
        return "departmentsPage";
    }
}
