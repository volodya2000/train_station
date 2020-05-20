package ua.coursework.train_station.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ua.coursework.train_station.model.route.Route;
import ua.coursework.train_station.model.route.RouteType;
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

    @ModelAttribute("categories")
    public RouteType[] allCategories()
    {
        return RouteType.values();
    }
    //7
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
    //7
    @GetMapping("/delayedDirection")
    public String getDelayedDirectionForm()
    {return "route/delayedDirectionForm";}
        //7
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
    //7
    @GetMapping("/delayedByStations")
    public String getDelayedStationsForm()
    {return "route/delayedStationForm";}
    //7
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
    //8
    @GetMapping("/pausedRouteStations")
    public String allPausedRoutes(Model model,@RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Route> trains=routeService.findAllPausedTrips(pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("count",routeService.countAllPausedTrips());
        model.addAttribute("routesList",trains.getContent());
        return "route/pausedStations";
    }
    //8
    @GetMapping("/pausedRoutesByCause")
    public String getPausedStationsCauseForm()
    {return "route/pausedStationCauseForm";}
    //8
    @GetMapping("/pausedRouteByCauseStations")
    public String allPausedRoutesByCause(Model model,@RequestParam(name = "page",defaultValue = "1")int page,
                                         @RequestParam(name = "cause")String cause)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Route> trains=routeService.findAllPausedTripsByCause(cause,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("cause",cause);
        model.addAttribute("count",routeService.countAllPausedTripByCause(cause));
        model.addAttribute("routesList",trains.getContent());
        return "route/pausedStationsByCause";
    }

    //8
    @GetMapping("/pausedRoutesByDirection")
    public String getPausedStationsDirectionForm()
    {return "route/pausedStationDirectionForm";}

    //8
    @GetMapping("/pausedRouteByDirectionStations")
    public String allPausedRoutesByDirection(Model model,@RequestParam(name = "page",defaultValue = "1")int page,
                                         @RequestParam(name = "direction")String direction)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Route> trains=routeService.findAllPausedTripsByDirection(direction,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("direction",direction);
        model.addAttribute("count",routeService.countAllPausedTripByDirection(direction));
        model.addAttribute("routesList",trains.getContent());
        return "route/pausedStationsByDirection";
    }

    //8
    @GetMapping("/pausedRoutesByDelayedTickets")
    public String getPausedStationsDelayedTicketsForm()
    {return "route/pausedStationDelayedTicketsForm";}
//8
    @GetMapping("/pausedRouteByDelayedTicketsStations")
    public String allPausedRoutesByDelayedTickets(Model model,@RequestParam(name = "page",defaultValue = "1")int page,
                                             @RequestParam(name = "number")int number)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Route> trains=routeService.findAllPausedTripsByCanceledTickets(number,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("number",number);
        model.addAttribute("count",routeService.countAllPausedTripsByCanceledTickets(number));
        model.addAttribute("routesList",trains.getContent());
        return "route/pausedStationsByDelayedTickets";
    }

    //10
    @GetMapping("/RoutesByCategoryAndDirection")
    public String getRouteCategoryAndDirectionForm()
    {return "route/categoryAndDirectionForm";}
    //10
    @GetMapping("/RouteByCategoryAndDirection")
    public String allAllRoutesByCategoryAndDirection(Model model,@RequestParam(name = "page",defaultValue = "1")int page,
                                                  @RequestParam(name = "category")RouteType category,
                                                     @RequestParam(name = "direction")String direction)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Route> trains=routeService.findAllRoutesByCategoryAndDirection(category.name(),direction,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("category",category);
        model.addAttribute("direction",direction);
        model.addAttribute("count",routeService.countAllRoutesByCategoryAndDirection(category.name(), direction));
        model.addAttribute("routesList",trains.getContent());
        return "route/routeByCategoryAndDirection";
    }


}
