package ua.coursework.train_station.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.ticket.Ticket;
import ua.coursework.train_station.services.driverServices.DriverBrigadeService;
import ua.coursework.train_station.services.driverServices.DriverService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class DriverController {

    private DriverBrigadeService driverBrigadeService;
    private DriverService driverService;

    @ModelAttribute("brigades")
    public List<DriverBrigade>allDriverBrigades()
    {
        return driverBrigadeService.findAll();
    }

    @Autowired
    public DriverController(DriverService driverService,DriverBrigadeService driverBrigadeService) {
        this.driverService = driverService;
        this.driverBrigadeService=driverBrigadeService;
    }


    @ModelAttribute("brigades")
    public List<DriverBrigade> allBrigades()
    {return driverBrigadeService.findAll();}

    @ModelAttribute("gender")
    public Gender[] allGender()
    {
        return Gender.values(); }
    @ModelAttribute("driver")
    public Driver registerDriver()
    {
        return new Driver();
    }

    //3
    @GetMapping("/driverMedicalCheck")//+
    public String driverMedicalCheckForm()
    {
        return "driver/MedicalCheckForm";
    }

    //3
    @GetMapping("/driversMedicalCheck")//+
    public String medicalCheck(@RequestParam("year") int year, Model model,@RequestParam(name = "page",defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Driver> workers=driverService.findAllByYearOfMedicalCheckGreaterThanEqual(year,pageable);
       // driverService.deleteByMedicalCheck(year);
        int totalPages=workers.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("year",year);
        model.addAttribute("count",workers.getContent().size());
        model.addAttribute("driversList",workers.getContent());
        return "driver/driversMedicalCheck";
    }


    @GetMapping("/driverExperience")//+
    public String getDriverExperienceForm()
    {
        return "driver/ExperienceCheckForm";
    }

    @GetMapping("/driversExperience")//+
    public String sendDriverExperienceForm(@ModelAttribute("experience") int experience,Model model,
                                           @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Driver> workers=driverService.findAllByExperience(experience,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","experience");
        model.addAttribute("paramValue",experience);
        model.addAttribute("driverAgeUrl","/driversExperience?page");
        model.addAttribute("driversList", workers.getContent());
        return "driver/driversExperienceList";
    }
    //3
    @GetMapping("/driverGender")//+
    public String getDriverChildrenForm()
    {
        return "driver/GenderCheckForm";
    }
    //3
    @GetMapping("/driversGender")//+
    public String sendDriverGenderForm(@ModelAttribute("sex") Gender sex,Model model,@RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Driver> workers=driverService.findAllBySex(sex,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("count",driverService.countAllBySex(sex.name()));
        model.addAttribute("paramName","sex");
        model.addAttribute("paramValue",sex);
        model.addAttribute("driverAgeUrl","/driversGender?page");
        model.addAttribute("driversList", workers.getContent());
        return "driver/driversGenderList";
    }


    @GetMapping("/driverChildren")//+
    public String driverChildrenCheckForm()
    {
        return "driver/ChildrenCheckForm";
    }

    @GetMapping("/driversChildren")//+
    public String childrenCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                           @RequestParam(value = "children",required = false) int children, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Driver> workers=driverService.findAllByChildrenAmount(children,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("paramName","children");
        model.addAttribute("paramValue",children);
        model.addAttribute("driverAgeUrl","/driversChildren?page");
        model.addAttribute("driversList", workers.getContent());
        return "driver/driversChildrenList";
    }


    //3
    @GetMapping("/driverAge")//+
    public String driverAgeCheckForm()
    {
        return "driver/AgeCheckForm";
    }
    //3
    @GetMapping("/driversAge")//+
    public String ageCheck(@RequestParam(name = "page",required = false,defaultValue = "1") int page,
                           @RequestParam(value = "age",required = false) int age, Model model) {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Driver> workers=driverService.findAllByAge(age,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("count",driverService.countAllByAge(age));
        model.addAttribute("paramName","age");
        model.addAttribute("paramValue",age);
        model.addAttribute("driverAgeUrl","/driversAge?page");
        model.addAttribute("driversList", workers.getContent());
        return "driver/driversAgeList";
    }

    //3
    @GetMapping("/driverSalary")//+
    public String driverSalaryCheckForm()
    {
        return "driver/SalaryCheckForm";
    }
    //3
    @GetMapping("/driversSalary")//+
    public String salaryCheck(@RequestParam("salary") int salary,Model model,
                              @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Driver> workers=driverService.findAllBySalary(salary,pageable);
        int totalPages = workers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("count",driverService.countAllBySalary(salary));
        model.addAttribute("paramName","salary");
        model.addAttribute("paramValue",salary);
        model.addAttribute("driverAgeUrl","/driversSalary?page");
        model.addAttribute("driversList", workers.getContent());
        return "driver/driversSalaryList";
    }

    @GetMapping("/addDriver")//+
    public String addDriver()
    {
        return "driver/driverForm";
    }

    @PostMapping("/addDriver")//+
    public String loginUser(@ModelAttribute("driver") Driver driver, Model model )
    {
        System.out.println("driver brigade name: "+driver.getBrigade().getName());
        System.out.println("driver brigade object: "+driver.getBrigade());
        model.addAttribute("savedDriver",driver);
        driverService.save(driver);
        return "hello";
    }

    @GetMapping("/driverBrigades")
    public String driverBrigadeForm()
    {
        return "driver/BrigadeForm";
    }

    @GetMapping("/drivers/{brigadeName}")
    public String brigadePage(@PathVariable String brigadeName,Model model)
    {
        model.addAttribute("brigadeName",brigadeName);
        return "driver/brigade";
    }

    @GetMapping("/driverBrigade/{brigadeName}")
    public String allBrigadeWorkers(@PathVariable String brigadeName,Model model,
                          @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Driver> drivers=driverService.findAllByBrigade(brigadeName,pageable);
        int totalPages = drivers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("brigadeName",brigadeName);
        model.addAttribute("driversList",drivers.getContent());
        model.addAttribute("url","/driverBrigade/"+brigadeName);
        return "driver/driversInBrigade";
    }

    @GetMapping("/driverBrigade/{brigadeName}/age")
    public String ageForm(@PathVariable String brigadeName,Model model,
                          @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        System.out.println("BRIGADE AGE IN AGE FORM:"+brigadeName);
        model.addAttribute("brigadeName",brigadeName);
        return "driver/brigadeAge";
    }
    @PostMapping("/driverBrigade/{brigadeName}/age")
    public String BrigadeAgeWorkers(@PathVariable String brigadeName,Model model,
                                    @RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                   @RequestParam(name = "Age") int Age)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Driver> drivers=driverService.findAllByBrigadeAndAge(brigadeName,Age,pageable);
        int totalPages = drivers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        System.out.println("BRIGADE AGE IN brigade age workers:"+brigadeName);
        model.addAttribute("brigadeName",brigadeName);
        model.addAttribute("driversList",drivers.getContent());
        model.addAttribute("Age",Age);
        return "driver/driversAgeInBrigade";
    }

    @GetMapping("/driverBrigade/{brigadeName}/salary")
    public String salaryForm(@PathVariable String brigadeName,Model model,
                          @RequestParam(name = "page",required = false,defaultValue = "1") int page)
    {
        System.out.println("BRIGADE AGE IN AGE FORM:"+brigadeName);
        model.addAttribute("brigadeName",brigadeName);
        return "driver/brigadeSalary";
    }

    @PostMapping("/driverBrigade/{brigadeName}/salary")
    public String BrigadeSalaryWorkers(@PathVariable String brigadeName,Model model,
                                    @RequestParam(name = "page",required = false,defaultValue = "1") int page,
                                    @RequestParam(name = "Salary") int salary)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Driver> drivers=driverService.findAllByBrigadeAndSalary(brigadeName,salary,pageable);
        int totalPages = drivers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        model.addAttribute("brigadeName",brigadeName);
        model.addAttribute("driversList",drivers.getContent());
        model.addAttribute("Salary",salary);
        return "driver/driversSalaryInBrigade";
    }

    @GetMapping("/driversAll")
    public String allDrivers(@RequestParam(name = "page",defaultValue = "1") int page,Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Driver>drivers=driverService.findAll(pageable);
        int totalPages = drivers.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("driversList",drivers.getContent());
        model.addAttribute("count",drivers.getContent().size());
        return "driver/allDrivers";
    }
}
