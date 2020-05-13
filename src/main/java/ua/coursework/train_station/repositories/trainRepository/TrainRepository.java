package ua.coursework.train_station.repositories.trainRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import ua.coursework.train_station.model.route.Route;
import ua.coursework.train_station.model.train.Train;

import java.util.Date;

@Repository
public interface TrainRepository extends CrudRepository<Train,Long> {

    Page<Train>findAll(Pageable pageable);
    Page<Train>findAllByRoute(Route route, Pageable pageable);
    @Query(nativeQuery = true,value = "select * from train join route r on train.route_id = r.id " +
            "where r.end_of_trip=?1")
    Page<Train>findAllByRouteEndOfTrip(Date date,Pageable pageable);
    Page<Train>findAllByNumberOfTrips(int number,Pageable pageable);
    @Query(nativeQuery = true,value = "select * from train t where t.date_of_inspection >= ?1 and t.date_of_inspection <= ?2")
    Page<Train>findAllByDateOfInspectionBetween(Date date1, Date date2,Pageable pageable);
    @Query(nativeQuery = true,value = "select * from train t where t.date_of_inspection =?1")
    Page<Train>findAllByDateOfInspection(Date date, Pageable pageable);
    @Query(nativeQuery = true,value = "select * from  train t where t.number_of_inspections =?1")
    Page<Train>findAllByNumberOfInspections(int number,Pageable pageable);
    Page<Train>findAllByAge(int age,Pageable pageable);
    Page<Train>findAllByTripsBeforeInspection(int number,Pageable pageable);
    @Query(nativeQuery = true,value = "select train.id,train.age,train.name,train.date_of_inspection," +
            "train.number_of_inspections,train.number_of_trips,train.type,train.trips_before_inspection,train.route_id,r.start_station,r.final_station from train join route r on train.route_id = r.id where r.final_station=?2 and r.start_station=?1")
    Page<Train>findAllByRouteStartStationAndRouteFinalStation(String start,String finish,Pageable pageable);
    Page<Train>findAllByRouteDuration(int duration,Pageable pageable);
    Page<Train>findAllByRoutePrice(int price , Pageable pageable);
    Page<Train>findAllByRoutePriceAndRouteDurationAndRouteStartStationAndRouteFinalStation(int price,
                                                                                           int duration,String start,String finish,Pageable pageable);
}
