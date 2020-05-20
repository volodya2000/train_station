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
import ua.coursework.train_station.model.trainRepairman.TrainRepairman;
import ua.coursework.train_station.services.trainRepairmanService.TrainRepairManService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TrainRepairmanController {

    private TrainRepairManService trainRepairManService;

    @Autowired
    public TrainRepairmanController(TrainRepairManService trainRepairManService) {
        this.trainRepairManService = trainRepairManService;
    }


    @ModelAttribute("gender")
    public Gender[] allGender()
    {
        return Gender.values(); }

    @GetMapping("/trainRepairmanExperience")//+
    public String gettrainRepairmanExperienceForm()
    {
        return "trainRepairman/ExperienceCheckForm";
    }

    @GetMapping("/trainRepairmenExperience")//+
    public String sendtrainRepairmanExperienceForm(@ModelAttribute("experience") int experience, Model model,
                                                     @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<TrainRepairman> workers= trainRepairManService.findAllByExperience(experience,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","experience");
        model.addAttribute("paramValue",experience);
        model.addAttribute("url","/trainRepairmenExperience?page");
        model.addAttribute("trainRepairmenList", workers.getContent());
        return "trainRepairman/trainRepairmenExperienceList";
    }

    @GetMapping("/trainRepairmanGender")//+
    public String gettrainRepairmanChildrenForm()
    {
        return "trainRepairman/GenderCheckForm";
    }

    @GetMapping("/trainRepairmenGender")//+
    public String sendtrainRepairmanGenderForm(@ModelAttribute("sex") Gender sex,Model model,@RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<TrainRepairman> workers=trainRepairManService.findAllBySex(sex,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","sex");
        model.addAttribute("paramValue",sex);
        model.addAttribute("url","/trainRepairmenGender?page");
        model.addAttribute("trainRepairmenList", workers.getContent());
        return "trainRepairman/trainRepairmenGenderList";
    }


    @GetMapping("/trainRepairmanChildren")//+
    public String trainRepairmanChildrenCheckForm()
    {
        return "trainRepairman/ChildrenCheckForm";
    }

    @GetMapping("/trainRepairmenChildren")//+
    public String childrenCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                @RequestParam(value = "children",required = false) int children, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<TrainRepairman> workers=trainRepairManService.findAllByChildrenAmount(children,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","children");
        model.addAttribute("paramValue",children);
        model.addAttribute("url","/trainRepairmenChildren?page");
        model.addAttribute("trainRepairmenList", workers.getContent());
        return "trainRepairman/trainRepairmenChildrenList";
    }



    @GetMapping("/trainRepairmanAge")//+
    public String trainRepairmanAgeCheckForm()
    {
        return "trainRepairman/AgeCheckForm";
    }

    @GetMapping("/trainRepairmenAge")//+
    public String ageCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                           @RequestParam(value = "age",required = false) int age, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<TrainRepairman> workers=trainRepairManService.findAllByAge(age,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","age");
        model.addAttribute("paramValue",age);
        model.addAttribute("url","/trainRepairmenAge?page");
        model.addAttribute("trainRepairmenList", workers.getContent());
        return "trainRepairman/trainRepairmenAgeList";
    }

    @GetMapping("/trainRepairmanSalary")//+
    public String trainRepairmanSalaryCheckForm()
    {
        return "trainRepairman/SalaryCheckForm";
    }

    @GetMapping("/trainRepairmenSalary")//+
    public String salaryCheck(@RequestParam("salary") int salary,Model model,
                              @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<TrainRepairman> workers=trainRepairManService.findAllBySalary(salary,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","salary");
        model.addAttribute("paramValue",salary);
        model.addAttribute("url","/trainRepairmenSalary?page");
        model.addAttribute("trainRepairmenList", workers.getContent());
        return "trainRepairman/trainRepairmenSalaryList";
    }

    @GetMapping("/trainRepairmenAll")
    public String getAll(@RequestParam(name = "page",defaultValue = "1")int page,Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<TrainRepairman> workers=trainRepairManService.findAll(pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("count",workers.getContent().size());
        model.addAttribute("trainRepairmenList", workers.getContent());
        return "trainRepairman/allRepairmen";
    }
}
