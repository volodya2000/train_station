package ua.coursework.train_station.services.trainServices;

import javafx.scene.shape.TriangleMesh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.train.Train;
import ua.coursework.train_station.repositories.routeRepository.RouteRepository;
import ua.coursework.train_station.repositories.trainRepository.TrainRepository;
import ua.coursework.train_station.services.RouteServices.RouteService;

import java.awt.*;
import java.util.Date;

@Service
public class TrainService {

    private TrainRepository trainRepository;
    private RouteRepository routeRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository, RouteRepository routeRepository) {
        this.trainRepository = trainRepository;
        this.routeRepository = routeRepository;
    }

    public Page<Train>findAll(Pageable pageable)
    {return trainRepository.findAll(pageable);}

    public Page<Train>findTrainAtStationInCurrentTime(Date date, Pageable pageable)
    {return trainRepository.findAllByRoute(routeRepository.findRouteByBeginOfTripGreaterThanAndEndOfTripLessThan(date,date),pageable);}

    public Page<Train>findTrainAtStationByArrivalTime(Date date, Pageable pageable)
    {return trainRepository.findAllByRouteEndOfTrip(date,pageable);}

    public Page<Train>findTrainByNumberOfTrips(int number,Pageable pageable)
    {return trainRepository.findAllByNumberOfTrips(number,pageable);}

    public Page<Train>findTrainBetweenDatesOfInspection(Date date1,Date date2,Pageable pageable)
    {return trainRepository.findAllByDateOfInspectionBetween(date1,date2,pageable);}

    public Page<Train>findTrainByDateOfInspection(Date date,Pageable pageable)
    {return  trainRepository.findAllByDateOfInspection(date,pageable);}

    public Page<Train>findTrainByNumberOfInspections(int number,Pageable pageable)
    {return trainRepository.findAllByNumberOfInspections(number,pageable);}

    public Page<Train>findTrainByAge(int age,Pageable pageable)
    {return trainRepository.findAllByAge(age,pageable);}

    public Page<Train>findTrainByTripsBeforeInspections(int number,Pageable pageable)
    {return trainRepository.findAllByTripsBeforeInspection(number,pageable);}

    public Page<Train>findTrainByRouteStations(String start,String finish ,Pageable pageable)
    {return trainRepository.findAllByRouteStartStationAndRouteFinalStation(start,finish,pageable); }

    public Page<Train>findTrainByRouteDuration(int duration,Pageable pageable)
    {return trainRepository.findAllByRouteDuration(duration,pageable);}

    public Page<Train>findTrainByRoutePrice(int price ,Pageable pageable)
    {return trainRepository.findAllByRoutePrice(price,pageable);}

    public Page<Train>findTrainByRoutePriceAndDurationAndStationsName(int price,int duration,String start,String finish,Pageable pageable)
    {return trainRepository.findAllByRoutePriceAndRouteDurationAndRouteStartStationAndRouteFinalStation(price, duration, start, finish,pageable);}
}
