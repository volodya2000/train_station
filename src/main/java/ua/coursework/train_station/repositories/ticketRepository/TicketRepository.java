package ua.coursework.train_station.repositories.ticketRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.ticket.Ticket;

import java.util.Date;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Long> {

    @Query(nativeQuery = true,value =
            "select  * from tickets join route r on tickets.route_id = r.id where " +
                    "r.begin_of_trip=?1 and r.end_of_trip=?2 and  tickets.is_bought is true")
    Page<Ticket>findAllsoldByDateInterval(String date1, String date2, Pageable pageable);


    @Query(nativeQuery = true,value = "select count(*) from tickets join route r on tickets.route_id = r.id " +
            "where r.begin_of_trip=?1 and r.end_of_trip=?2 and tickets.is_bought is true")
    int countAllsoldByDateInterval(String date1,String date2);

    @Query(nativeQuery = true,value = "select * from tickets join route r on tickets.route_id = r.id " +
            "where r.direction=?1 and tickets.is_bought is true")
    Page<Ticket>findAllsoldByDirection(String direction,Pageable pageable);;

    @Query(nativeQuery = true,value = "select count(*) from tickets join route r on tickets.route_id = r.id " +
            "where r.direction=?1 and tickets.is_bought is true")
    int countAllsoldByDirection(String direction);

    @Query(nativeQuery = true, value = "select *from tickets join route r on tickets.route_id = r.id " +
            "where r.duration=?1 and tickets.is_bought is true")
    Page<Ticket>findAllsoldByDuration(int duration,Pageable pageable);

    @Query(nativeQuery = true,value = "select  count(*) from tickets join route r on tickets.route_id = r.id " +
            "where r.duration=?1 and tickets.is_bought is true")
    int countAllsoldByDuration(int duration);

    @Query(nativeQuery = true,value = "select  * from tickets join route r on tickets.route_id = r.id " +
            "where r.price=?1 and tickets.is_bought is true")
    Page<Ticket>findAllsoldByPrice(int price,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from tickets join route r on tickets.route_id = r.id " +
            "where r.price=?1 and tickets.is_bought is true")
    int countAllsoldByPrice(int price);

    @Query(nativeQuery = true,value = "select *from tickets join route r on tickets.route_id = r.id " +
            "where r.start_station=?1 and r.final_station=?2 and tickets.is_bought=0")
    Page<Ticket>findAllNotBoughtByRoute(String start,String finish,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*)from tickets join route r " +
            "on tickets.route_id = r.id where r.start_station=?1 and r.final_station=?2 and is_bought=0")
    int countAllNotBoughtByRoute(String start,String finish);

    @Query(nativeQuery = true,value = "select * from tickets join route r on tickets.route_id = r.id " +
            "where r.begin_of_trip=?1 and is_bought=0")
    Page<Ticket>findAllNotBoughtByDeparture(String departure,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from tickets join route r on tickets.route_id = r.id " +
            "where r.begin_of_trip=?1 and is_bought=0")
    int countAllNotBoughtByDeparture(String  departure);

    @Query(nativeQuery = true,value = "select * from tickets join route r on tickets.route_id = r.id " +
            "where r.direction=?1 and is_bought=0")
    Page<Ticket>findAllNotBoughtByDirection(String direction,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*)from tickets join route r on tickets.route_id = r.id " +
            "where r.direction=?1 and is_bought=0")
    int countAllNotBoughtByDirection(String direction);


    @Query(nativeQuery = true,value = "select *from tickets join route r on tickets.route_id = r.id " +
            "where r.start_station=?1 and r.final_station=?2 and tickets.cancelled=1")
    Page<Ticket>findAllCancelledByRoute(String start,String finish,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*)from tickets join route r " +
            "on tickets.route_id = r.id where r.start_station=?1 and r.final_station=?2 and cancelled=1")
    int countAllCancelledByRoute(String start,String finish);

    @Query(nativeQuery = true,value = "select * from tickets join route r on tickets.route_id = r.id " +
            "where r.begin_of_trip=?1 and cancelled=1")
    Page<Ticket>findAllCancelledByDeparture(String departure,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*) from tickets join route r on tickets.route_id = r.id " +
            "where r.begin_of_trip=?1 and cancelled=1")
    int countAllCancelledByDeparture(String  departure);

    @Query(nativeQuery = true,value = "select * from tickets join route r on tickets.route_id = r.id " +
            "where r.direction=?1 and cancelled=1")
    Page<Ticket>findAllCancelledByDirection(String direction,Pageable pageable);

    @Query(nativeQuery = true,value = "select count(*)from tickets join route r on tickets.route_id = r.id " +
            "where r.direction=?1 and cancelled=1")
    int countAllCancelledByDirection(String direction);
}
