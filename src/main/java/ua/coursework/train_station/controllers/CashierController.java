package ua.coursework.train_station.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.cashiers.Cashier;
import ua.coursework.train_station.model.cashiers.CashierBrigades;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.services.cashierServices.CashierService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CashierController {

    private CashierService cashierService;

    @Autowired
    public CashierController(CashierService cashierService) {
        this.cashierService = cashierService;
    }

    @ModelAttribute("cashierbrigades")
    public List<CashierBrigades>allDriverBrigades()
    {
        return cashierService.findAllBrigades();
    }

    @ModelAttribute("gender")
    public Gender[] allGender()
    {
        return Gender.values(); }

    @GetMapping("/cashierExperience")//+
    public String getCashierExperienceForm()
    {
        return "dispatcher/ExperienceCheckForm";
    }

    @GetMapping("/cashiersExperience")//+
    public String sendCashierExperienceForm(@ModelAttribute("experience") int experience, Model model,
                                               @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Cashier> workers= cashierService.findAllByExperience(experience,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","experience");
        model.addAttribute("paramValue",experience);
        model.addAttribute("url","/cashiersExperience?page");
        model.addAttribute("cashiersList", workers.getContent());
        return "cashier/cashiersExperienceList";
    }

    @GetMapping("/cashierGender")//+
    public String getCashierChildrenForm()
    {
        return "cashier/GenderCheckForm";
    }

    @GetMapping("/cashiersGender")//+
    public String sendCashierGenderForm(@ModelAttribute("sex") Gender sex,Model model,@RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Cashier> workers=cashierService.findAllBySex(sex,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","sex");
        model.addAttribute("paramValue",sex);
        model.addAttribute("url","/cashiersGender?page");
        model.addAttribute("cashiersList", workers.getContent());
        return "cashier/cashiersGenderList";
    }


    @GetMapping("/cashierChildren")//+
    public String cashierChildrenCheckForm()
    {
        return "cashier/ChildrenCheckForm";
    }

    @GetMapping("/cashiersChildren")//+
    public String childrenCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                @RequestParam(value = "children",required = false) int children, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Cashier> workers=cashierService.findAllByChildrenAmount(children,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","children");
        model.addAttribute("paramValue",children);
        model.addAttribute("url","/cashiersChildren?page");
        model.addAttribute("cashiersList", workers.getContent());
        return "cashier/cashiersChildrenList";
    }



    @GetMapping("/cashierAge")//+
    public String cashierAgeCheckForm()
    {
        return "cashier/AgeCheckForm";
    }

    @GetMapping("/cashiersAge")//+
    public String ageCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                           @RequestParam(value = "age",required = false) int age, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Cashier> workers=cashierService.findAllByAge(age,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","age");
        model.addAttribute("paramValue",age);
        model.addAttribute("url","/cashiersAge?page");
        model.addAttribute("cashiersList", workers.getContent());
        return "cashier/cashiersAgeList";
    }

    @GetMapping("/cashierSalary")//+
    public String cashierSalaryCheckForm()
    {
        return "cashier/SalaryCheckForm";
    }

    @GetMapping("/cashiersSalary")//+
    public String salaryCheck(@RequestParam("salary") int salary,Model model,
                              @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Cashier> workers=cashierService.findAllBySalary(salary,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","salary");
        model.addAttribute("paramValue",salary);
        model.addAttribute("url","/cashiersSalary?page");
        model.addAttribute("cashiersList", workers.getContent());
        return "cashier/cashiersSalaryList";
    }
    @GetMapping("/cashierBrigades")
    public String cashierBrigadeForm()
    {
        return "cashier/BrigadeForm";
    }

    @GetMapping("/cashiers/{brigadeName}")
    public String brigadePage(@PathVariable String brigadeName, Model model)
    {
        model.addAttribute("brigadeName",brigadeName);
        return "cashier/brigade";
    }

    @GetMapping("/cashierBrigade/{brigadeName}")
    public String allBrigadeWorkers(@PathVariable String brigadeName,Model model,
                                    @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        System.out.println("in cashier brigade");
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Cashier> cashiers=cashierService.findAllByBrigade(cashierService.findByName(brigadeName),pageable);
        int totalPages = cashiers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        for (Cashier c:cashiers.toList()
             ) {
            System.out.println(c.getName());
        }
        model.addAttribute("brigadeName",brigadeName);
        model.addAttribute("cashiersList",cashiers.getContent());
        model.addAttribute("url","/cashierBrigade/"+brigadeName);
        return "cashier/cashiersInBrigade";
    }

    @GetMapping("/cashierBrigade/{brigadeName}/age")
    public String ageForm(@PathVariable String brigadeName,Model model,
                          @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        System.out.println("BRIGADE AGE IN AGE FORM:"+brigadeName);
        model.addAttribute("brigadeName",brigadeName);
        return "cashier/brigadeAge";
    }
    @PostMapping("/cashierBrigade/{brigadeName}/age")
    public String BrigadeAgeWorkers(@PathVariable String brigadeName,Model model,
                                    @RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                    @RequestParam(name = "Age") int Age)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Cashier> cashiers=cashierService.findAllByBrigadeAndAge(cashierService.findByName(brigadeName),Age,pageable);
        int totalPages = cashiers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        System.out.println("BRIGADE AGE IN brigade age workers:"+brigadeName);
        model.addAttribute("brigadeName",brigadeName);
        model.addAttribute("cashiersList",cashiers.getContent());
        model.addAttribute("Age",Age);
        return "cashier/cashiersAgeInBrigade";
    }

    @GetMapping("/cashierBrigade/{brigadeName}/salary")
    public String salaryForm(@PathVariable String brigadeName,Model model,
                             @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        System.out.println("BRIGADE AGE IN AGE FORM:"+brigadeName);
        model.addAttribute("brigadeName",brigadeName);
        return "cashier/brigadeSalary";
    }

    @PostMapping("/cashierBrigade/{brigadeName}/salary")
    public String BrigadeSalaryWorkers(@PathVariable String brigadeName,Model model,
                                       @RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                       @RequestParam(name = "Salary") int salary)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Cashier> cashiers=cashierService.findAllByBrigadeAndSalary(cashierService.findByName(brigadeName),salary,pageable);
        int totalPages = cashiers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("brigadeName",brigadeName);
        model.addAttribute("cashiersList",cashiers.getContent());
        model.addAttribute("Salary",salary);
        return "cashier/cashiersSalaryInBrigade";
    }
}
