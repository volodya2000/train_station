package ua.coursework.train_station.services.ticketServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.ticket.Ticket;
import ua.coursework.train_station.repositories.ticketRepository.TicketRepository;

import java.util.Date;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Page<Ticket> findAllsoldByDateInterval(String date1, String date2, Pageable pageable)
    {return ticketRepository.findAllsoldByDateInterval(date1,date2,pageable);}

    public int countAllsoldByDateInterval(String date1,String date2)
    {return ticketRepository.countAllsoldByDateInterval(date1, date2);}

    public Page<Ticket>findAllsoldByDirection(String direction,Pageable pageable)
    {return ticketRepository.findAllsoldByDirection(direction, pageable);}

    public int countAllsoldByDirection(String direction)
    {return ticketRepository.countAllsoldByDirection(direction);}

    public Page<Ticket>findAllsoldByDuration(int duration,Pageable pageable)
    {return ticketRepository.findAllsoldByDuration(duration, pageable);}

    public int countAllsoldByDuration(int duration)
    {return ticketRepository.countAllsoldByDuration(duration);}

    public Page<Ticket>findAllsoldByPrice(int price,Pageable pageable)
    {return ticketRepository.findAllsoldByPrice(price, pageable);}

    public int countAllsoldByPrice(int price)
    {return ticketRepository.countAllsoldByPrice(price);}


    public Page<Ticket>findAllNotBoughtByRoute(String start,String finish,Pageable pageable)
    {return ticketRepository.findAllNotBoughtByRoute(start,finish,pageable);}


    public int countAllNotBoughtByRoute(String start,String finish)
    {return ticketRepository.countAllNotBoughtByRoute(start, finish);}

    public Page<Ticket>findAllNotBoughtByDeparture(String departure,Pageable pageable)
    {return ticketRepository.findAllNotBoughtByDeparture(departure, pageable);}

    public int countAllNotBoughtByDeparture(String  departure)
    {return ticketRepository.countAllNotBoughtByDeparture(departure); }

    public Page<Ticket>findAllNotBoughtByDirection(String direction,Pageable pageable)
    {return ticketRepository.findAllNotBoughtByDirection(direction, pageable);}

    public int countAllNotBoughtByDirection(String direction)
    {return ticketRepository.countAllNotBoughtByDirection(direction);}



    public Page<Ticket>findAllCancelledByRoute(String start,String finish,Pageable pageable)
    {return ticketRepository.findAllCancelledByRoute(start, finish, pageable);}

    public int countAllCancelledByRoute(String start,String finish)
    {return ticketRepository.countAllCancelledByRoute(start,finish);}

    public Page<Ticket>findAllCancelledByDeparture(String departure,Pageable pageable)
    {return ticketRepository.findAllCancelledByDeparture(departure, pageable);}

    public int countAllCancelledByDeparture(String  departure)
    { return ticketRepository.countAllCancelledByDeparture(departure);}

    public Page<Ticket>findAllCancelledByDirection(String direction,Pageable pageable)
    {return ticketRepository.findAllCancelledByDirection(direction,pageable);}

    public int countAllCancelledByDirection(String direction)
    {return ticketRepository.countAllCancelledByDirection(direction);}
}
