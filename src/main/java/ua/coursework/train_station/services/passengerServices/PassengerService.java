package ua.coursework.train_station.services.passengerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.passenger.Passenger;
import ua.coursework.train_station.repositories.passengerRepository.PassengerRepository;

import java.util.Date;

@Service
public class PassengerService {

    private PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Page<Passenger> findPassengersByRoute(String startStation, String finalStation, Pageable pageable)
    {return passengerRepository.findPassengersByRoute(startStation, finalStation, pageable);}

    public int countAllPassengersByRoute(String startStation,String finalStation)
    {return passengerRepository.countAllPassengersByRoute(startStation, finalStation);}

    public Page<Passenger>findPassengersByDeparture(String departure, Pageable pageable)
    {return passengerRepository.findPassengersByDeparture(departure,pageable);}

    public int countAllPassengersByDeparture(String departure)
    {return passengerRepository.countAllPassengersByDeparture(departure);}

    public Page<Passenger>findPassengersByExternalTrip(String date,Pageable pageable)
    {return passengerRepository.findPassengersByExternalTrip(date, pageable);}

    public int countAllPassengersByExternalTrip(String date)
    {return passengerRepository.countAllPassengersByExternalTrip(date);}

    public Page<Passenger>findPassengersByLuggage(boolean luggage,Pageable pageable)
    {return passengerRepository.findPassengersByLuggage(luggage,pageable);}

    public int countAllPassengersByLuggage(boolean luggage)
    {return passengerRepository.countAllPassengersByLuggage(luggage);}

    public Page<Passenger>findPassengersByGender(Gender gender, Pageable pageable)
    {return passengerRepository.findPassengersByGender(gender, pageable);}

    public int countAllPassengerByGender(Gender gender)
    {return passengerRepository.countAllPassengerByGender(gender);}

    public Page<Passenger>findPassengersByAge(int age,Pageable pageable)
    {return passengerRepository.findPassengersByAge(age,pageable);}

    public int countAllPassengersByAge(int age)
    {return passengerRepository.countAllPassengersByAge(age);}





}
