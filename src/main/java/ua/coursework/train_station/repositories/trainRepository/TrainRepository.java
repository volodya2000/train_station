package ua.coursework.train_station.repositories.trainRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import ua.coursework.train_station.model.route.Route;
import ua.coursework.train_station.model.train.Train;

import javax.print.attribute.standard.MediaSize;
import java.util.Date;

@Repository
public interface TrainRepository extends CrudRepository<Train,Long> {

    @Query(nativeQuery =true,value = "select *from train")
    Page<Train>findAll(Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*)from train")
    int countAll();

    @Query(nativeQuery = true,value = "select * from train join route r on train.route_id = r.id " +
            "where r.begin_of_trip>=?1 or r.end_of_trip <=?1")
    Page<Train>findAllAtCurrentTime(Date date, Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from train join route r on train.route_id = r.id " +
            "where r.begin_of_trip>=?1 or r.end_of_trip <=?1")
    int countAllAtCurrentTime(Date date);

    @Query(nativeQuery = true,value = "select * from train join route r on train.route_id = r.id " +
            "where r.end_of_trip=?1")
    Page<Train>findAllByRouteEndOfTrip(String date,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from train join route r on train.route_id = r.id where " +
            "r.end_of_trip=?1")
    int countAllTrainsByEndOfTrip(String date);

    @Query(nativeQuery = true,value = "select * from train where number_of_trips=?1")
    Page<Train>findAllByNumberOfTrips(int number,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from train where number_of_trips=?1 ")
    int countAllTrainsByNumberOfTrips(int number);


    @Query(nativeQuery = true,value = "select * from train t where t.date_of_inspection >= ?1 and t.date_of_inspection <= ?2")
    Page<Train>findAllByDateOfInspectionBetween(String date1, String date2,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*)from train where date_of_inspection>=?1 and " +
            "date_of_inspection<=?2")
    int countAllTrainsByDateOfInspectionBetween(String date1,String date2);

    @Query(nativeQuery = true,value = "select * from train t where t.date_of_inspection =?1")
    Page<Train>findAllByDateOfInspection(String date, Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*)from train where date_of_inspection=?1")
    int countAllTrainsByDateOfInspection(String date);

    @Query(nativeQuery = true,value = "select * from  train t where t.number_of_inspections =?1")
    Page<Train>findAllByNumberOfInspections(int number,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from train where number_of_inspections=?1")
    int countAllTrainsByNumberOfInspections(int number);

    @Query(nativeQuery = true,value = "select * from train where age=?1")
    Page<Train>findAllByAge(int age,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from train where age=?1")
    int countAllTrainsByAge(int age);

    Page<Train>findAllByTripsBeforeInspection(int number,Pageable pageable);

    @Query(nativeQuery = true,value = "select train.id,train.age,train.name,train.date_of_inspection," +
            "train.number_of_inspections,train.number_of_trips,train.type,train.trips_before_inspection,train.route_id,r.start_station,r.final_station from train join route r on train.route_id = r.id where r.final_station=?2 and r.start_station=?1")
    Page<Train>findAllByRouteStartStationAndRouteFinalStation(String start,String finish,Pageable pageable);

    @Query(nativeQuery = true,value = "select  count(*) from train join route r on train.route_id = r.id " +
            "where r.start_station=?1 and r.final_station=?2")
    int countAllByRouteStations(String start,String finish);

    @Query(nativeQuery = true,value = "select * from train join route r on train.route_id = r.id " +
            "where r.duration=?1")
    Page<Train>findAllByRouteDuration(int duration,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*)from train join route r on train.route_id = r.id " +
            "where r.duration=?1")
    int countAllByRouteDuration(int duration);

    @Query(nativeQuery = true,value = "select * from train join route r on train.route_id = r.id " +
            "where r.price=?1")
    Page<Train>findAllByRoutePrice(int price , Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from train join route r on train.route_id = r.id " +
            "where r.price=?1")
    int countAllByRoutePrice(int price);

    @Query(nativeQuery = true,value = "select * from train join route r on train.route_id = r.id " +
            "where r.price=?1 and r.duration=?2 and r.start_station=?3 and r.final_station=?4 ")
    Page<Train>findAllByRoutePriceAndRouteDurationAndRouteStartStationAndRouteFinalStation(int price,
                                                                                           int duration,String start,String finish,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from train join route r on train.route_id = r.id " +
            "where r.price=?1 and r.duration=?2 and r.start_station=?3 and r.final_station=?4 ")
    int countAllTrainsByRouteAndDurationAndPrice(int price,int duration,String start,String finish);
}
