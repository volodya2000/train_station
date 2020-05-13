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
import ua.coursework.train_station.model.trainServiceman.TrainServiceman;
import ua.coursework.train_station.services.trainServicemanService.TrainServicemanService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TrainServicemanController {

    private TrainServicemanService trainServicemanService;

    @Autowired
    public TrainServicemanController(TrainServicemanService trainServicemanService) {
        this.trainServicemanService = trainServicemanService;
    }

    @ModelAttribute("gender")
    public Gender[] allGender()
    {
        return Gender.values(); }

    @GetMapping("/trainServicemanExperience")//+
    public String gettrainServicemanExperienceForm()
    {
        return "trainServiceman/ExperienceCheckForm";
    }

    @GetMapping("/trainServicemenExperience")//+
    public String sendtrainServicemanExperienceForm(@ModelAttribute("experience") int experience, Model model,
                                                   @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<TrainServiceman> workers= trainServicemanService.findAllByExperience(experience,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","experience");
        model.addAttribute("paramValue",experience);
        model.addAttribute("url","/trainServicemenExperience?page");
        model.addAttribute("trainServicemenList", workers.getContent());
        return "trainServiceman/trainServicemenExperienceList";
    }

    @GetMapping("/trainServicemanGender")//+
    public String gettrainServicemanChildrenForm()
    {
        return "trainServiceman/GenderCheckForm";
    }

    @GetMapping("/trainServicemenGender")//+
    public String sendtrainServicemanGenderForm(@ModelAttribute("sex") Gender sex,Model model,@RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<TrainServiceman> workers=trainServicemanService.findAllBySex(sex,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","sex");
        model.addAttribute("paramValue",sex);
        model.addAttribute("url","/trainServicemenGender?page");
        model.addAttribute("trainServicemenList", workers.getContent());
        return "trainServiceman/trainServicemenGenderList";
    }


    @GetMapping("/trainServicemanChildren")//+
    public String trainServicemanChildrenCheckForm()
    {
        return "trainServiceman/ChildrenCheckForm";
    }

    @GetMapping("/trainServicemenChildren")//+
    public String childrenCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                @RequestParam(value = "children",required = false) int children, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<TrainServiceman> workers=trainServicemanService.findAllByChildrenAmount(children,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","children");
        model.addAttribute("paramValue",children);
        model.addAttribute("url","/trainServicemenChildren?page");
        model.addAttribute("trainServicemenList", workers.getContent());
        return "trainServiceman/trainServicemenChildrenList";
    }



    @GetMapping("/trainServicemanAge")//+
    public String trainServicemanAgeCheckForm()
    {
        return "trainServiceman/AgeCheckForm";
    }

    @GetMapping("/trainServicemenAge")//+
    public String ageCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                           @RequestParam(value = "age",required = false) int age, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<TrainServiceman> workers=trainServicemanService.findAllByAge(age,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","age");
        model.addAttribute("paramValue",age);
        model.addAttribute("url","/trainServicemenAge?page");
        model.addAttribute("trainServicemenList", workers.getContent());
        return "trainServiceman/trainServicemenAgeList";
    }

    @GetMapping("/trainServicemanSalary")//+
    public String trainServicemanSalaryCheckForm()
    {
        return "trainServiceman/SalaryCheckForm";
    }

    @GetMapping("/trainServicemenSalary")//+
    public String salaryCheck(@RequestParam("salary") int salary,Model model,
                              @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<TrainServiceman> workers=trainServicemanService.findAllBySalary(salary,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","salary");
        model.addAttribute("paramValue",salary);
        model.addAttribute("url","/trainServicemenSalary?page");
        model.addAttribute("trainServicemenList", workers.getContent());
        return "trainServiceman/trainServicemenSalaryList";
    }
}
