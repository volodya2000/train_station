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
import ua.coursework.train_station.model.passenger.Passenger;
import ua.coursework.train_station.services.passengerServices.PassengerService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class PassengerController {

    private PassengerService passengerService;

    @ModelAttribute("gender")
    public Gender[] genders()
    {return Gender.values();}

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    //11
    @GetMapping("/passengersByRouteForm")
    public String findPassengersByRouteForm()
    {
        return "passenger/findPassengersByRouteForm";
    }

    //11
    @GetMapping("/passengersByRoute")
    public String findPassengersByRoute(@RequestParam(name = "page",defaultValue = "1")int page
            ,@RequestParam(name = "startStation") String startStation
                                        ,@RequestParam(name = "finalStation") String finalStation, Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Passenger>passengers=passengerService.findPassengersByRoute(startStation,finalStation,pageable);
        int totalPages=passengers.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("startStation",startStation);
        model.addAttribute("finalStation",finalStation);
        model.addAttribute("count",passengerService.countAllPassengersByRoute(startStation, finalStation));
        model.addAttribute("passengersList",passengers.getContent());
        return "passenger/findPassengersByRoute";
    }

    //11
    @GetMapping("/passengersByDepartureForm")
    public String findPassengersByDepratureForm()
    {
        return "passenger/findPassengersByDepartureForm";
    }

    //11
    @GetMapping("/passengersByDeparture")
    public String findPassengersByDeparture(@RequestParam(name = "page",defaultValue = "1")int page
            , @RequestParam(name = "departure") String departure, Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Passenger>passengers=passengerService.findPassengersByDeparture(departure,pageable);
        int totalPages=passengers.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("departure",departure);
        model.addAttribute("count",passengerService.countAllPassengersByDeparture(departure));
        model.addAttribute("passengersList",passengers.getContent());
        return "passenger/findPassengersByDeparture";
    }

    //11
    @GetMapping("/passengersByExternalTripForm")
    public String findPassengersByExternalTripForm()
    {
        return "passenger/findPassengersByExternalTripForm";
    }

    //11
    @GetMapping("/passengersByExternalTrip")
    public String findPassengersByExternalTrip(@RequestParam(name = "page",defaultValue = "1")int page
            , @RequestParam(name = "departure") String departure, Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Passenger>passengers=passengerService.findPassengersByExternalTrip(departure,pageable);
        int totalPages=passengers.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("departure",departure);
        model.addAttribute("count",passengerService.countAllPassengersByExternalTrip(departure));
        model.addAttribute("passengersList",passengers.getContent());
        return "passenger/findPassengersByExternalTrip";
    }

    //11
    @GetMapping("/passengersByLuggageForm")
    public String findPassengersByLuggageForm()
    {
        return "passenger/findPassengersByLuggageForm";
    }

    //11
    @GetMapping("/passengersByLuggage")
    public String findPassengersByLuggage(@RequestParam(name = "page",defaultValue = "1")int page
            , @RequestParam(name = "luggage") boolean luggage, Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Passenger>passengers=passengerService.findPassengersByLuggage(luggage,pageable);
        int totalPages=passengers.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("luggage",luggage);
        model.addAttribute("count",passengerService.countAllPassengersByLuggage(luggage));
        model.addAttribute("passengersList",passengers.getContent());
        return "passenger/findPassengersByLuggage";
    }

    //11
    @GetMapping("/passengersByGenderForm")
    public String findPassengersByGenderForm()
    {
        return "passenger/findPassengersByGenderForm";
    }

    //11
    @GetMapping("/passengersByGender")
    public String findPassengersByGender(@RequestParam(name = "page",defaultValue = "1")int page
            , @RequestParam(name = "gender") Gender gender, Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Passenger>passengers=passengerService.findPassengersByGender(gender, pageable);
        int totalPages=passengers.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("gender",gender);
        model.addAttribute("count",passengerService.countAllPassengerByGender(gender));
        model.addAttribute("passengersList",passengers.getContent());
        return "passenger/findPassengersByGender";
    }

    //11
    @GetMapping("/passengersByAgeForm")
    public String findPassengersByAgeForm()
    {
        return "passenger/findPassengersByAgeForm";
    }

    //11
    @GetMapping("/passengersByAge")
    public String findPassengersByAge(@RequestParam(name = "page",defaultValue = "1")int page
            , @RequestParam(name = "age") int age, Model model)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Passenger>passengers=passengerService.findPassengersByAge(age,pageable);
        int totalPages=passengers.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("age",age);
        model.addAttribute("count",passengerService.countAllPassengersByAge(age));
        model.addAttribute("passengersList",passengers.getContent());
        return "passenger/findPassengersByAge";
    }
}
