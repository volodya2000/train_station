package ua.coursework.train_station.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.railwayRepairman.RailwayRepairBrigades;
import ua.coursework.train_station.model.railwayRepairman.RailwayRepairman;
import ua.coursework.train_station.services.railwayRepairmanService.RailwayRepairmanService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class RailwayRepairmanController {

    private RailwayRepairmanService railwayRepairmanService;

    @Autowired
    public RailwayRepairmanController(RailwayRepairmanService railwayRepairmanService) {
        this.railwayRepairmanService = railwayRepairmanService;
    }

    @ModelAttribute("railway_repairmen_brigades")
    public List<RailwayRepairBrigades> brigades()
    {return railwayRepairmanService.findAllBrigades();}

    @ModelAttribute("gender")
    public Gender[] allGender()
    {
        return Gender.values(); }

    @GetMapping("/railwayRepairmanExperience")//+
    public String getRailwayRepairmanExperienceForm()
    {
        return "railwayRepairman/ExperienceCheckForm";
    }

    @GetMapping("/railwayRepairmenExperience")//+
    public String sendRailwayRepairmanExperienceForm(@ModelAttribute("experience") int experience, Model model,
                                            @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<RailwayRepairman> workers= railwayRepairmanService.findAllByExperience(experience,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","experience");
        model.addAttribute("paramValue",experience);
        model.addAttribute("url","/railwayRepairmenExperience?page");
        model.addAttribute("railwayRepairmenList", workers.getContent());
        return "railwayRepairman/railwayRepairmenExperienceList";
    }

    @GetMapping("/railwayRepairmanGender")//+
    public String getRailwayRepairmanChildrenForm()
    {
        return "railwayRepairman/GenderCheckForm";
    }

    @GetMapping("/railwayRepairmenGender")//+
    public String sendRailwayRepairmanGenderForm(@ModelAttribute("sex") Gender sex,Model model,@RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<RailwayRepairman> workers=railwayRepairmanService.findAllBySex(sex,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","sex");
        model.addAttribute("paramValue",sex);
        model.addAttribute("url","/railwayRepairmenGender?page");
        model.addAttribute("railwayRepairmenList", workers.getContent());
        return "railwayRepairman/railwayRepairmenGenderList";
    }


    @GetMapping("/railwayRepairmanChildren")//+
    public String railwayRepairmanChildrenCheckForm()
    {
        return "railwayRepairman/ChildrenCheckForm";
    }

    @GetMapping("/railwayRepairmenChildren")//+
    public String childrenCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                @RequestParam(value = "children",required = false) int children, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<RailwayRepairman> workers=railwayRepairmanService.findAllByChildrenAmount(children,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","children");
        model.addAttribute("paramValue",children);
        model.addAttribute("url","/railwayRepairmenChildren?page");
        model.addAttribute("railwayRepairmenList", workers.getContent());
        return "railwayRepairman/railwayRepairmenChildrenList";
    }



    @GetMapping("/railwayRepairmanAge")//+
    public String railwayRepairmanAgeCheckForm()
    {
        return "railwayRepairman/AgeCheckForm";
    }

    @GetMapping("/railwayRepairmenAge")//+
    public String ageCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                           @RequestParam(value = "age",required = false) int age, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<RailwayRepairman> workers=railwayRepairmanService.findAllByAge(age,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","age");
        model.addAttribute("paramValue",age);
        model.addAttribute("url","/railwayRepairmenAge?page");
        model.addAttribute("railwayRepairmenList", workers.getContent());
        return "railwayRepairman/railwayRepairmenAgeList";
    }

    @GetMapping("/railwayRepairmanSalary")//+
    public String railwayRepairmanSalaryCheckForm()
    {
        return "railwayRepairman/SalaryCheckForm";
    }

    @GetMapping("/railwayRepairmenSalary")//+
    public String salaryCheck(@RequestParam("salary") int salary,Model model,
                              @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<RailwayRepairman> workers=railwayRepairmanService.findAllBySalary(salary,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","salary");
        model.addAttribute("paramValue",salary);
        model.addAttribute("url","/railwayRepairmenSalary?page");
        model.addAttribute("railwayRepairmenList", workers.getContent());
        return "railwayRepairman/railwayRepairmenSalaryList";
    }
    @GetMapping("/railwayRepairmanBrigades")
    public String railwayRepairmanBrigadeForm()
    {
        return "railwayRepairman/BrigadeForm";
    }

    @GetMapping("/railwayRepairmen/{brigadeName}")
    public String brigadePage(@PathVariable String brigadeName, Model model)
    {
        model.addAttribute("brigadeName",brigadeName);
        return "railwayRepairman/brigade";
    }

    @GetMapping("/railwayRepairmanBrigade/{brigadeName}")
    public String allBrigadeWorkers(@PathVariable String brigadeName,Model model,
                                    @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<RailwayRepairman> railwayRepairmen=railwayRepairmanService.findAllByBrigade(railwayRepairmanService.findByName(brigadeName),pageable);
        int totalPages = railwayRepairmen.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("brigadeName",brigadeName);
        model.addAttribute("railwayRepairmenList",railwayRepairmen.getContent());
        model.addAttribute("url","/railwayRepairmanBrigade/"+brigadeName);
        return "railwayRepairman/railwayRepairmenInBrigade";
    }

    @GetMapping("/railwayRepairmanBrigade/{brigadeName}/age")
    public String ageForm(@PathVariable String brigadeName,Model model,
                          @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        System.out.println("BRIGADE AGE IN AGE FORM:"+brigadeName);
        model.addAttribute("brigadeName",brigadeName);
        return "railwayRepairman/brigadeAge";
    }
    @PostMapping("/railwayRepairmanBrigade/{brigadeName}/age")
    public String BrigadeAgeWorkers(@PathVariable String brigadeName,Model model,
                                    @RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                    @RequestParam(name = "Age") int Age)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<RailwayRepairman> railwayRepairmen=railwayRepairmanService.findAllByBrigadeAndAge(railwayRepairmanService.findByName(brigadeName),Age,pageable);
        int totalPages = railwayRepairmen.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        System.out.println("BRIGADE AGE IN brigade age workers:"+brigadeName);
        model.addAttribute("brigadeName",brigadeName);
        model.addAttribute("railwayRepairmenList",railwayRepairmen.getContent());
        model.addAttribute("Age",Age);
        return "railwayRepairman/railwayRepairmenAgeInBrigade";
    }

    @GetMapping("/railwayRepairmanBrigade/{brigadeName}/salary")
    public String salaryForm(@PathVariable String brigadeName,Model model,
                             @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        System.out.println("BRIGADE AGE IN AGE FORM:"+brigadeName);
        model.addAttribute("brigadeName",brigadeName);
        return "railwayRepairman/brigadeSalary";
    }

    @PostMapping("/railwayRepairmanBrigade/{brigadeName}/salary")
    public String BrigadeSalaryWorkers(@PathVariable String brigadeName,Model model,
                                       @RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                       @RequestParam(name = "Salary") int salary)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<RailwayRepairman> railwayRepairmen=railwayRepairmanService.findAllByBrigadeAndSalary(railwayRepairmanService.findByName(brigadeName),salary,pageable);
        int totalPages = railwayRepairmen.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("brigadeName",brigadeName);
        model.addAttribute("railwayRepairmenList",railwayRepairmen.getContent());
        model.addAttribute("Salary",salary);
        return "railwayRepairman/railwayRepairmenSalaryInBrigade";
    }
}
