package ua.coursework.train_station.services.RouteServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.route.Route;
import ua.coursework.train_station.model.route.RouteType;
import ua.coursework.train_station.repositories.routeRepository.RouteRepository;

import java.util.Date;
import java.util.List;

@Service
public class RouteService {

    private RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route findRouteNotInTrip(Date date)
    {return routeRepository.findRouteByBeginOfTripGreaterThanAndEndOfTripLessThan(date,date);}

    public Page<Route> findAllDelayedRoutes(Pageable pageable)
    {return routeRepository.findAllDelayedRoutes(pageable);}

    public Page<Route>findAllDelayedRoutesByDirection(String direction, Pageable pageable)
    {return routeRepository.findAllByRouteDirection(direction,pageable);}

    public Page<Route>findAllDelayedRoutesByStations(String start,String finish ,Pageable pageable)
    {return  routeRepository.findAllByRouteStartStationAndRouteFinalStation(start,finish,pageable);}

    public int countAllDelayedRoutesByStations(String start,String finish )
    {return  routeRepository.countAllByDelayedStations(start,finish);}

    public int countAllDelayedRoutesByDirection(String direction )
    {return  routeRepository.countAllByDelayedDirection(direction);}

    public int countAllDelayedRoutes()
    {return  routeRepository.countAllByDelayedTrue();}

    public Page<Route>findAllPausedTrips(Pageable pageable)
    { return routeRepository.findAllPausedTrips(pageable);}

    public Page<Route>findAllPausedTripsByCause(String cause ,Pageable pageable)
    {return routeRepository.findAllPausedTripsByCause(cause,pageable);}

    public Page<Route>findAllPausedTripsByDirection(String direction ,Pageable pageable)
    {return routeRepository.findAllPausedTripsByDirection(direction,pageable);}

    public Page<Route>findAllPausedTripsByCanceledTickets(int number,Pageable pageable)
    {return routeRepository.findAllPausedTripsByCanceledTickets(number,pageable);}

    public int countAllPausedTrips()
    {return routeRepository.countAllPausedTrips();}

    public int countAllPausedTripByCause(String cause)
    {return routeRepository.countAllPausedTripByCause(cause);}

    public int countAllPausedTripByDirection(String direction)
    {return routeRepository.countAllPausedTripByDirection(direction);}

    public int countAllPausedTripsByCanceledTickets(int number)
    {return routeRepository.countAllPausedTripsByCanceledTickets(number);}

    public Page<Route>findAllRoutesByCategoryAndDirection(String category, String direction, Pageable pageable)
    {return routeRepository.findAllRoutesByCategoryAndDirection(category,direction,pageable);}

    public int countAllRoutesByCategoryAndDirection(String category,String direction)
    {return routeRepository.countAllRoutesByCategoryAndDirection(category, direction);}
}
