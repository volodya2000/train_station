package ua.coursework.train_station.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.coursework.train_station.model.route.Route;
import ua.coursework.train_station.services.RouteServices.RouteService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class RouteController {

    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/delayedRoutes")
    public String getDelayedRoutes(Model model,@RequestParam(name = "page",defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Route> routes=routeService.findAllDelayedRoutes(pageable);
        int totalPages=routes.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("count",routeService.countAllDelayedRoutes());
        model.addAttribute("routesList",routes.getContent());
        return"route/allDelayedRoutes";
    }

    @GetMapping("/delayedDirection")
    public String getDelayedDirectionForm()
    {return "route/delayedDirectionForm";}

    @GetMapping("/delayedRouteDirection")
    public String routesDelayed(Model model, @RequestParam(required = false,name = "direction")String direction
            , @RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Route> trains=routeService.findAllDelayedRoutesByDirection(direction,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("count",routeService.countAllDelayedRoutesByDirection(direction));
        model.addAttribute("direction",direction);
        model.addAttribute("routesList",trains.getContent());
        return"route/delayedRouteDirection";
    }

    @GetMapping("/delayedByStations")
    public String getDelayedStationsForm()
    {return "route/delayedStationForm";}

    @GetMapping("/delayedRouteStations")
    public String routesDelayedByStations(Model model, @RequestParam(required = false,name = "start")String start,
            @RequestParam(name = "finish")String finish
            , @RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Route> trains=routeService.findAllDelayedRoutesByStations(start,finish,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("count",routeService.countAllDelayedRoutesByStations(start,finish));
        model.addAttribute("start",start);
        model.addAttribute("finish",finish);
        model.addAttribute("routesList",trains.getContent());
        return"route/delayedStationDirection";
    }
}
