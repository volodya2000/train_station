package ua.coursework.train_station.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ua.coursework.train_station.model.Worker;
import ua.coursework.train_station.services.workerServices.WorkerService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class WorkersController {

    private WorkerService workerService;

    @Autowired
    public WorkersController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/all")
    public String getAll(@RequestParam(name = "page",required = false,defaultValue = "1") int page, Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Worker> workers=workerService.findAll(pageable);
        int totalPages=workers.getTotalPages();
        if(totalPages>0)
        {
            List<Integer>pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("workersList",workers.getContent());
        return "WorkersList";
    }

//    @GetMapping("/allHeadOfDepartments")
//    public String getAllHeadOfDepartments()
//    {
//
//    }
}
