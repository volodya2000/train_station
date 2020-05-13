package ua.coursework.train_station.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.coursework.train_station.model.train.Train;
import ua.coursework.train_station.services.RouteServices.RouteService;
import ua.coursework.train_station.services.trainServices.TrainService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TrainController {

    private TrainService trainService;
    private RouteService routeService;

    public TrainController(TrainService trainService, RouteService routeService) {
        this.trainService = trainService;
        this.routeService = routeService;
    }

    @GetMapping("/trains")
    public String getStation()
    {
        return "train/menu";
    }

    @GetMapping("/trainsByArrival")
    public String trainsByArrivalTime()
    {return "train/arrivalDateForm";}

    @GetMapping("trainsByArrivalTime")
    public String trainsByArrival(Model model,@RequestParam(required = false)Date arrivalTime,
                                  @RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train> trains=trainService.findTrainAtStationByArrivalTime(arrivalTime,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        System.out.println("date: "+arrivalTime);
        trains.getContent().stream().forEach(System.out::println);
        model.addAttribute("arrivalTime",arrivalTime);
        model.addAttribute("trainList",trains.getContent());
        return"train/trainsByArrivalTime";
    }

    @GetMapping("/allTrains")
    public String getAllTrains(Model model, @RequestParam(value = "page",defaultValue = "1") int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train> trains=trainService.findAll(pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("trainList",trains.getContent());
        return"train/allTrains";
    }

    @GetMapping("/trainsNow")
    public String getAllTrainsAtCurrentTime(Model model,
                                            @RequestParam(name = "page",defaultValue = "1") int page )
    {
        Date date=new Date();
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train> trains=trainService.findTrainAtStationInCurrentTime(date,pageable);
        int totalPages = trains.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("arrivalTime",date);
        model.addAttribute("trainsList",trains.getContent());
        return "train/trainsAtCurrentTime";
    }

    @GetMapping("/trainsByTrip")
    public String getAllTrainsByTrip()
    {
        return "train/numberTripsForm";
    }

    @GetMapping("trainsByNumberOfTrips")
    public String getAllByTrips(@RequestParam(name = "page",defaultValue = "1")int page,
                                Model model,@RequestParam(name = "numberOfTrips")int trips)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train> trains=trainService.findTrainByNumberOfTrips(trips,pageable);
        int totalPages = trains.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("trainsList",trains.getContent());
        model.addAttribute("numberOfTrips",trips);
        return "train/trainsByNumberOfTrips";
    }

    @GetMapping("/trainsInspection")
    public String getDatesOfInspection()
    {return "train/inspectionForm";}

    @GetMapping("/trainsBetweenDatesOfInspection")
    public String trainsInspectionByPeriodOfTime(Model model,@RequestParam(required = false,name = "begin")Date date1,
                                  @RequestParam(required =false,name = "end")Date date2,
                                  @RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train> trains=trainService.findTrainBetweenDatesOfInspection(date1,date2,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("begin",date1);
        model.addAttribute("and",date2);
        model.addAttribute("trainList",trains.getContent());
        return"train/trainsBetweenDatesOfInspection";
    }

    @GetMapping("/trainsDayInspection")
    public String getDateOfInspection()
    {return "train/inspectionDayForm";}

    @GetMapping("/trainsDatesOfInspection")
    public String trainsInspectionDay(Model model,@RequestParam(required = false,name = "date")Date date,
                                                 @RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train> trains=trainService.findTrainByDateOfInspection(date,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        System.out.println("date= "+date);
        model.addAttribute("begin",date);
        model.addAttribute("trainList",trains.getContent());
        return"train/trainsDatesOfInspection";
    }

    @GetMapping("/trainsNumberInspection")
    public String getNumberOfInspection()
    {return "train/inspectionNumberForm";}

    @GetMapping("/trainsNumberOfInspection")
    public String trainsInspectionNumber(Model model,@RequestParam(required = false,name = "number")int number,
                                      @RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train>trains=trainService.findTrainByNumberOfInspections(number,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("number",number);
        model.addAttribute("trainList",trains.getContent());
        return"train/trainsNumberOfInspection";
    }

    @GetMapping("/trainsAge")
    public String getTrainsByAge()
    {return "train/ageForm";}

    @GetMapping("/trainsByAge")
    public String trainsByAge(Model model,@RequestParam(required = false,name = "age")int age,
                                         @RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train>trains=trainService.findTrainByAge(age,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("age",age);
        model.addAttribute("trainsList",trains.getContent());
        return"train/trainsAge";
    }

    @GetMapping("/trainsTrips")
    public String getTripsBeforeInspection()
    {return "train/tripsBeforeForm";}

    @GetMapping("/trainsTripsBeforeInspection")
    public String trainsTripsBeforeInspectionNumber(Model model,@RequestParam(required = false,name = "number")int number,
                                         @RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train>trains=trainService.findTrainByTripsBeforeInspections(number,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }

        model.addAttribute("number",number);
        model.addAttribute("trainsList",trains.getContent());
        return"train/trainsNumberTripsBeforeInspection";
    }

    @GetMapping("/trainsRoutesName")
    public String getTrainsByRoutesName()
    {return "train/routesNameForm";}

    @GetMapping("/trainsRoutesByName")
    public String trainsTripsbyRoutesName(Model model,@RequestParam(required = false,name = "start")String start
                                                    ,@RequestParam(required = false,name = "finish")String finish
                                                    ,@RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train>trains=trainService.findTrainByRouteStations(start.trim(),finish.trim(),pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("start",start);
        model.addAttribute("finish",finish);
        model.addAttribute("trainsList",trains.getContent());
        return"train/trainsByRoutesName";
    }

    @GetMapping("/trainsRoutesDuration")
    public String getTrainsByRoutesDuration()
    {return "train/routesDurationForm";}

    @GetMapping("/trainsRoutesByDuration")
    public String trainsByRoutesDuration(Model model,@RequestParam(required = false,name = "duration")int duration
            ,@RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train>trains=trainService.findTrainByRouteDuration(duration,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("duration",duration);
        model.addAttribute("trainsList",trains.getContent());
        return"train/trainsByRoutesDuration";
    }

    @GetMapping("/trainsRoutesPrice")
    public String getTrainsByRoutesPrice()
    {return "train/routesPriceForm";}

    @GetMapping("/trainsRoutesByPrice")
    public String trainsByRoutesPrice(Model model,@RequestParam(required = false,name = "price")int price
            ,@RequestParam(name = "page",defaultValue = "1")int page)
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train>trains=trainService.findTrainByRoutePrice(price,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("price",price);
        model.addAttribute("trainsList",trains.getContent());
        return"train/trainsByRoutesPrice";
    }

    @GetMapping("/trainsRoutes")
    public String getTrainsByRoutes()
    {return "train/routesAllForm";}

    @GetMapping("/trainsRoutesBy")
    public String trainsByRoutes(Model model,@RequestParam(required = false,name = "price")int price
            ,@RequestParam(name = "page",defaultValue = "1")int page,@RequestParam(required = false,name = "duration")int duration,
                                 @RequestParam(required = false,name = "start")String start
            ,@RequestParam(required = false,name = "finish")String finish
                                 )
    {
        PageRequest pageable = PageRequest.of(page - 1, 15);
        Page<Train>trains=trainService.findTrainByRoutePriceAndDurationAndStationsName(price,duration,start,finish,pageable);
        int totalPages=trains.getTotalPages();
        if(totalPages>0)
        {
            List<Integer> pageNumbers= IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        model.addAttribute("price",price);
        model.addAttribute("start",start);
        model.addAttribute("finish",finish);
        model.addAttribute("duration",duration);
        System.out.println("hello");
        model.addAttribute("trainsList",trains.getContent());
        return"train/trainsByRoutes";
    }
}
