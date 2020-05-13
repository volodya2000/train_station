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
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.services.dispatcherServices.DispatcherService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class DispatcherController {


    private DispatcherService dispatcherService;

    @Autowired
    public DispatcherController(DispatcherService dispatcherService) {
        this.dispatcherService = dispatcherService;
    }

    @ModelAttribute("gender")
    public Gender[] allGender()
    {
        return Gender.values(); }

    @GetMapping("/dispatcherExperience")//+
    public String getDispatcherExperienceForm()
    {
        return "dispatcher/ExperienceCheckForm";
    }

    @GetMapping("/dispatchersExperience")//+
    public String sendDispatcherExperienceForm(@ModelAttribute("experience") int experience, Model model,
                                           @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Dispatcher> workers=dispatcherService.findAllByExperience(experience,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","experience");
        model.addAttribute("paramValue",experience);
        model.addAttribute("dispatcherAgeUrl","/dispatchersExperience?page");
        model.addAttribute("dispatchersList", workers.getContent());
        return "dispatcher/dispatchersExperienceList";
    }

    @GetMapping("/dispatcherGender")//+
    public String getDispatcherChildrenForm()
    {
        return "dispatcher/GenderCheckForm";
    }

    @GetMapping("/dispatchersGender")//+
    public String sendDispatcherGenderForm(@ModelAttribute("sex") Gender sex,Model model,@RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Dispatcher> workers=dispatcherService.findAllBySex(sex,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","sex");
        model.addAttribute("paramValue",sex);
        model.addAttribute("dispatcherAgeUrl","/dispatchersGender?page");
        model.addAttribute("dispatchersList", workers.getContent());
        return "dispatcher/dispatchersGenderList";
    }


    @GetMapping("/dispatcherChildren")//+
    public String dispatcherChildrenCheckForm()
    {
        return "dispatcher/ChildrenCheckForm";
    }

    @GetMapping("/dispatchersChildren")//+
    public String childrenCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                @RequestParam(value = "children",required = false) int children, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Dispatcher> workers=dispatcherService.findAllByChildrenAmount(children,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","children");
        model.addAttribute("paramValue",children);
        model.addAttribute("dispatcherAgeUrl","/dispatchersChildren?page");
        model.addAttribute("dispatchersList", workers.getContent());
        return "dispatcher/dispatchersChildrenList";
    }



    @GetMapping("/dispatcherAge")//+
    public String driverAgeCheckForm()
    {
        return "dispatcher/AgeCheckForm";
    }

    @GetMapping("/dispatchersAge")//+
    public String ageCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                           @RequestParam(value = "age",required = false) int age, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Dispatcher> workers=dispatcherService.findAllByAge(age,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","age");
        model.addAttribute("paramValue",age);
        model.addAttribute("dispatcherAgeUrl","/dispatchersAge?page");
        model.addAttribute("dispatchersList", workers.getContent());
        return "dispatcher/dispatchersAgeList";
    }

    @GetMapping("/dispatcherSalary")//+
    public String dispatcherSalaryCheckForm()
    {
        return "dispatcher/SalaryCheckForm";
    }

    @GetMapping("/dispatchersSalary")//+
    public String salaryCheck(@RequestParam("salary") int salary,Model model,
                              @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Dispatcher> workers=dispatcherService.findAllBySalary(salary,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","salary");
        model.addAttribute("paramValue",salary);
        model.addAttribute("dispatcherAgeUrl","/dispatchersSalary?page");
        model.addAttribute("dispatchersList", workers.getContent());
        return "dispatcher/dispatchersSalaryList";
    }


}
