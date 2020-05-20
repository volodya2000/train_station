package ua.coursework.train_station.repositories.routeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.route.Route;
import ua.coursework.train_station.model.route.RouteType;

import javax.print.attribute.standard.MediaSize;
import java.util.Date;
import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<Route,Long>
{
    Route findRouteByBeginOfTripGreaterThanAndEndOfTripLessThan(Date begin,Date end);
    @Query(nativeQuery = true,value = "select count(*)from route r where r.`delayed`=1")
    int countAllByDelayedTrue();

    @Query(nativeQuery = true,value = "select * from route r where r.`delayed` =1")
    Page<Route>findAllDelayedRoutes(Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from route r where r.`delayed`=1 and r.direction=?1")
    int countAllByDelayedDirection(String direction);

    @Query(nativeQuery = true,value = "select * from route r where r.`direction`=?1 and r.`delayed`=1")
    Page<Route>findAllByRouteDirection(String  direction,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from route r where r.`delayed`=1 and r.start_station=?1 and r.final_station=?2")
    int countAllByDelayedStations(String start,String finish);

    @Query(nativeQuery = true,value = "select * from route r where r.start_station=?1 " +
            "and r.final_station=?2 and r.`delayed`=1")
    Page<Route>findAllByRouteStartStationAndRouteFinalStation(String start,String finish,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from route where paused_trip_id is not null")
    int countAllPausedTrips();

    @Query(nativeQuery = true,value = "select * from route where paused_trip_id is not null")
    Page<Route>findAllPausedTrips(Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from route join paused_trip pt on route.paused_trip_id = pt.id " +
            "where paused_trip_id is not null and pt.сause=?1")
    int countAllPausedTripByCause(String cause);

    @Query(nativeQuery = true,value = "select * from route join paused_trip pt on route.paused_trip_id = pt.id where pt.сause=?1 " +
            "and route.paused_trip_id is not null")
    Page<Route>findAllPausedTripsByCause(String cause ,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(route.id) from route " +
            "where route.paused_trip_id is not null and route.direction=?1")
    int countAllPausedTripByDirection(String direction);

    @Query(nativeQuery = true,value = "select * from route join paused_trip pt on route.paused_trip_id = pt.id where pt.id is not null " +
            "and route.direction=?1")
    Page<Route>findAllPausedTripsByDirection(String direction,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(route.id) from route join paused_trip pt on route.paused_trip_id = pt.id " +
            "where route.paused_trip_id is not null and pt.number_of_canceled_tickets=?1")
    int countAllPausedTripsByCanceledTickets(int number);

    @Query(nativeQuery = true,value = "select * from route join paused_trip pt on route.paused_trip_id = pt.id " +
            "where route.paused_trip_id is not null and pt.number_of_canceled_tickets=?1")
    Page<Route>findAllPausedTripsByCanceledTickets(int number,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*)from route " +
            "where direction=?2 and route_type=?1")
    int countAllRoutesByCategoryAndDirection(String category,String direction);

    @Query(nativeQuery = true,value = "select * from route where route_type=?1 and direction=?2")
    Page<Route>findAllRoutesByCategoryAndDirection(String category, String direction, Pageable pageable);


}
