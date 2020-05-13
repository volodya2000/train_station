package ua.coursework.train_station.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.helpDeskService.HelpDeskServiceMan;
import ua.coursework.train_station.services.helpDeskService.HelpDeskService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HelpDeskServicemanController {

    private HelpDeskService helpDeskService;

    @Autowired
    public HelpDeskServicemanController(HelpDeskService helpDeskService) {
        this.helpDeskService = helpDeskService;
    }

    @ModelAttribute("gender")
    public Gender[] allGender()
    {
        return Gender.values(); }

    @GetMapping("/helpDeskExperience")//+
    public String getHelpDeskExperienceForm()
    {
        return "helpDesk/ExperienceCheckForm";
    }

    @GetMapping("/helpDesksExperience")//+
    public String sendHelpDeskExperienceForm(@ModelAttribute("experience") int experience, Model model,
                                            @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<HelpDeskServiceMan> workers= helpDeskService.findAllByExperience(experience,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","experience");
        model.addAttribute("paramValue",experience);
        model.addAttribute("url","/helpDesksExperience?page");
        model.addAttribute("helpDesksList", workers.getContent());
        return "helpDesk/helpDesksExperienceList";
    }

    @GetMapping("/helpDeskGender")//+
    public String getHelpDeskChildrenForm()
    {
        return "helpDesk/GenderCheckForm";
    }

    @GetMapping("/helpDesksGender")//+
    public String sendHelpDeskGenderForm(@ModelAttribute("sex") Gender sex,Model model,@RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<HelpDeskServiceMan> workers=helpDeskService.findAllBySex(sex,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","sex");
        model.addAttribute("paramValue",sex);
        model.addAttribute("url","/helpDesksGender?page");
        model.addAttribute("helpDesksList", workers.getContent());
        return "helpDesk/helpDesksGenderList";
    }


    @GetMapping("/helpDeskChildren")//+
    public String helpDeskChildrenCheckForm()
    {
        return "helpDesk/ChildrenCheckForm";
    }

    @GetMapping("/helpDesksChildren")//+
    public String childrenCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                @RequestParam(value = "children",required = false) int children, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<HelpDeskServiceMan> workers=helpDeskService.findAllByChildrenAmount(children,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","children");
        model.addAttribute("paramValue",children);
        model.addAttribute("url","/helpDesksChildren?page");
        model.addAttribute("helpDesksList", workers.getContent());
        return "helpDesk/helpDesksChildrenList";
    }



    @GetMapping("/helpDeskAge")//+
    public String helpDeskAgeCheckForm()
    {
        return "helpDesk/AgeCheckForm";
    }

    @GetMapping("/helpDesksAge")//+
    public String ageCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                           @RequestParam(value = "age",required = false) int age, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<HelpDeskServiceMan> workers=helpDeskService.findAllByAge(age,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","age");
        model.addAttribute("paramValue",age);
        model.addAttribute("url","/helpDesksAge?page");
        model.addAttribute("helpDesksList", workers.getContent());
        return "helpDesk/helpDesksAgeList";
    }

    @GetMapping("/helpDeskSalary")//+
    public String helpDeskSalaryCheckForm()
    {
        return "helpDesk/SalaryCheckForm";
    }

    @GetMapping("/helpDesksSalary")//+
    public String salaryCheck(@RequestParam("salary") int salary,Model model,
                              @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<HelpDeskServiceMan> workers=helpDeskService.findAllBySalary(salary,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","salary");
        model.addAttribute("paramValue",salary);
        model.addAttribute("url","/helpDesksSalary?page");
        model.addAttribute("helpDesksList", workers.getContent());
        return "helpDesk/helpDesksSalaryList";
    }
}
