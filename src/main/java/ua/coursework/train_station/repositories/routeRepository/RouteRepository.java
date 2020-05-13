package ua.coursework.train_station.repositories.routeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.route.Route;

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
}
