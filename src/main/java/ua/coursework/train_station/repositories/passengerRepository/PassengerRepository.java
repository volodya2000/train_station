package ua.coursework.train_station.repositories.passengerRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.passenger.Passenger;

import java.util.Date;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger,Long> {

    @Query(nativeQuery = true,value = "select * from passenger join tickets t on passenger.id = t.passenger_id " +
            "join route r on t.route_id = r.id where r.start_station=?1 and  r.final_station=?2")
    Page<Passenger>findPassengersByRoute(String startStation, String finalStation, Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from passenger join tickets t on passenger.id = t.passenger_id "+
            "join route r on t.route_id = r.id where r.start_station=?1 and  r.final_station=?2")
    int countAllPassengersByRoute(String startStation,String finalStation);

    @Query(nativeQuery = true,value = "select * from passenger join tickets t on passenger.id = t.passenger_id " +
            "join route r on t.route_id = r.id where r.begin_of_trip=?1" )
    Page<Passenger>findPassengersByDeparture(String departure,Pageable pageable);


    @Query(nativeQuery = true,value = "select count(*) from passenger join tickets t on passenger.id = t.passenger_id " +
            "join route r on t.route_id = r.id where r.begin_of_trip=?1" )
    int countAllPassengersByDeparture(String departure);

    @Query(nativeQuery = true,value = "select * from passenger join tickets t on passenger.id = t.passenger_id " +
            "join route r on t.route_id = r.id where r.begin_of_trip=?1 and r.route_type='EXTERNAL'")
    Page<Passenger>findPassengersByExternalTrip(String date,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from passenger join tickets t on passenger.id = t.passenger_id " +
            "join route r on t.route_id = r.id where r.begin_of_trip=?1 and r.route_type='EXTERNAL'")
    int countAllPassengersByExternalTrip(String date);

    @Query(nativeQuery = true,value = "select * from passenger where clothes_in_luggage=?1")
    Page<Passenger>findPassengersByLuggage(boolean luggage,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from passenger where clothes_in_luggage=?1")
    int countAllPassengersByLuggage(boolean luggage);

    @Query(nativeQuery = true,value = "select * from passenger where gender=?1")
    Page<Passenger>findPassengersByGender(Gender gender,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from passenger where gender=?1")
    int countAllPassengerByGender(Gender gender);

    @Query(nativeQuery = true,value = "select * from passenger where age=?1")
    Page<Passenger>findPassengersByAge(int age,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*)from passenger where age=?1")
    int countAllPassengersByAge(int age);
}
