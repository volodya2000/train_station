package ua.coursework.train_station.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.coursework.train_station.model.ticket.Ticket;
import ua.coursework.train_station.services.ticketServices.TicketService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    //9
    @GetMapping("/soldTicketsByDate")
    public String soldTicketsByDateForm()
    {
        return "ticket/soldTicketsByDateIntervalForm";
    }

    //9
    @GetMapping("/soldByDate")
    public  String findAllsoldByDateInterval(@RequestParam(name = "page",defaultValue = "1") int page,
                                                   String date1,
                                                  String date2, Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Ticket>tickets=ticketService.findAllsoldByDateInterval(date1,date2,pageable);
        int totalPages=tickets.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("date1",date1);
        model.addAttribute("date2",date2);
        model.addAttribute("count",ticketService.countAllsoldByDateInterval(date1,date2));
        model.addAttribute("ticketsList",tickets.getContent());
        return "ticket/soldTicketsByDateInterval";
    }

    //9'
    @GetMapping("/soldTicketsByDirection")
    public String findAllsoldByDirectionForm()
    {
        return "ticket/soldTicketsByDirectionForm";
    }

    //9
    @GetMapping("/soldByDirection")
    public String findAllsoldByDirection(@RequestParam(name = "page",defaultValue = "1")int page,
                                              @RequestParam(name = "direction")String direction,Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Ticket>tickets=ticketService.findAllsoldByDirection(direction,pageable);
        int totalPages=tickets.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("direction",direction);
        model.addAttribute("count",ticketService.countAllsoldByDirection(direction));
        model.addAttribute("ticketsList",tickets.getContent());
        return "ticket/soldTicketsByDirection";
    }

    //9
    @GetMapping("/soldTicketsByDuration")
    public String findAllsoldByDurationForm()
    { return "ticket/soldTicketsByDurationForm";}

    //9
    @GetMapping("/soldByDuration")
    public String findAllsoldByDuration(@RequestParam(name = "page",defaultValue = "1")int page,
                                             @RequestParam(name = "duration")int duration,Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Ticket>tickets=ticketService.findAllsoldByDuration(duration,pageable);
        int totalPages=tickets.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("duration",duration);
        model.addAttribute("count",ticketService.countAllsoldByDuration(duration));
        model.addAttribute("ticketsList",tickets.getContent());
        return "ticket/soldTicketsByDuration";
    }

    //9
    @GetMapping("/soldTicketsByPrice")
    public String findAllsoldByPriceForm()
    {return "ticket/soldTicketsByPriceForm";}

    //9
    @GetMapping("/soldByPrice")
    public String findAllsoldByPrice(@RequestParam(name = "page",defaultValue = "1")int page, Model model,
                                          @RequestParam(name = "price")int price)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Ticket>tickets=ticketService.findAllsoldByPrice(price,pageable);
        int totalPages=tickets.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("price",price);
        model.addAttribute("count",ticketService.countAllsoldByPrice(price));
        model.addAttribute("ticketsList",tickets.getContent());
        return "ticket/soldTicketsByPrice";
    }

    //12
    @GetMapping("/unsoldTicketsByRouteForm")
    public String findAllNotBoughtByRouteForm()
    {
        return "ticket/unsoldTicketsRouteForm";
    }

    //12
    @GetMapping("/unsoldTicketsByRoute")
    public String findAllNotBoughtByRoute(@RequestParam(name = "page",defaultValue = "1")int page,
                                          @RequestParam(name = "start") String start,
                                          @RequestParam(name ="finish") String finish,Model model)
    {

        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Ticket>tickets=ticketService.findAllNotBoughtByRoute(start, finish, pageable);
        int totalPages=tickets.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("start",start);
        model.addAttribute("finish",finish);
        model.addAttribute("count",ticketService.countAllNotBoughtByRoute(start, finish));
        model.addAttribute("ticketsList",tickets.getContent());
        return "ticket/unsoldTicketsByRoute";
    }

    //12
    @GetMapping("/unsoldTicketsByDepartureForm")
    public String findAllNotBoughtByDepartureForm()
    {
        return "ticket/unsoldTicketsDepartureForm";
    }

    //12
    @GetMapping("/unsoldTicketsByDeparture")
    public String findAllNotBoughtByDeparture(@RequestParam(name = "page",defaultValue = "1")int page,
                                              @RequestParam(name = "departure") String departure,
                                              Model model)
    {

        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Ticket>tickets=ticketService.findAllNotBoughtByDeparture(departure,pageable);
        int totalPages=tickets.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("departure",departure);
        model.addAttribute("count",ticketService.countAllNotBoughtByDeparture(departure));
        model.addAttribute("ticketsList",tickets.getContent());
        return "ticket/unsoldTicketsByDeparture";
    }

    //12
    @GetMapping("/unsoldTicketsByDirectionForm")
    public String findAllNotBoughtByDirectionForm()
    {
        return "ticket/unsoldTicketsDirectionForm";
    }

    //12
    @GetMapping("/unsoldTicketsByDirection")
    public String findAllNotBoughtByDirection(@RequestParam(name = "page",defaultValue = "1")int page,
                                              @RequestParam(name = "direction") String direction,
                                              Model model)
    {

        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Ticket>tickets=ticketService.findAllNotBoughtByDirection(direction,pageable);
        int totalPages=tickets.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("direction",direction);
        model.addAttribute("count",ticketService.countAllNotBoughtByDirection(direction));
        model.addAttribute("ticketsList",tickets.getContent());
        return "ticket/unsoldTicketsByDirection";
    }

    //13
    @GetMapping("/cancelledTicketsByRouteForm")
    public String findAllCancelledByRouteForm()
    {
        return "ticket/cancelledTicketsRouteForm";
    }

    //13
    @GetMapping("cancelledTicketsByRoute")
    public String findAllCancelledByRoute(@RequestParam(name = "page",defaultValue = "1")int page,
                                          @RequestParam(name = "start") String start,
                                          @RequestParam(name ="finish") String finish,Model model)
    {

        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Ticket>tickets=ticketService.findAllCancelledByRoute(start, finish, pageable);
        int totalPages=tickets.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("start",start);
        model.addAttribute("finish",finish);
        model.addAttribute("count",ticketService.countAllCancelledByRoute(start, finish));
        model.addAttribute("ticketsList",tickets.getContent());
        return "ticket/cancelledTicketsByRoute";
    }

    //13
    @GetMapping("/cancelledTicketsByDepartureForm")
    public String findAllCancelledByDepartureForm()
    {
        return "ticket/cancelledTicketsDepartureForm";
    }

    //13
    @GetMapping("/cancelledTicketsByDeparture")
    public String findAllCancelledByDeparture(@RequestParam(name = "page",defaultValue = "1")int page,
                                              @RequestParam(name = "departure") String departure,
                                              Model model)
    {

        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Ticket>tickets=ticketService.findAllCancelledByDeparture(departure,pageable);
        int totalPages=tickets.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("departure",departure);
        model.addAttribute("count",ticketService.countAllCancelledByDeparture(departure));
        model.addAttribute("ticketsList",tickets.getContent());
        return "ticket/cancelledTicketsByDeparture";
    }

    //13
    @GetMapping("/cancelledTicketsByDirectionForm")
    public String findAllCancelledByDirectionForm()
    {
        return "ticket/cancelledTicketsDirectionForm";
    }

    //13
    @GetMapping("/cancelledTicketsByDirection")
    public String findAllCancelledByDirection(@RequestParam(name = "page",defaultValue = "1")int page,
                                              @RequestParam(name = "direction") String direction,
                                              Model model)
    {

        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Ticket>tickets=ticketService.findAllCancelledByDirection(direction,pageable);
        int totalPages=tickets.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("direction",direction);
        model.addAttribute("count",ticketService.countAllCancelledByDirection(direction));
        model.addAttribute("ticketsList",tickets.getContent());
        return "ticket/cancelledTicketsByDirection";
    }
}
