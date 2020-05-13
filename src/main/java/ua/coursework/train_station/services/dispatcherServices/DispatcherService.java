package ua.coursework.train_station.services.dispatcherServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.Worker;
import ua.coursework.train_station.model.cashiers.Cashier;
import ua.coursework.train_station.model.cashiers.CashierBrigades;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.dispatchers.DispatcherBrigade;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.repositories.cashierRepository.CashierBrigadeRepository;
import ua.coursework.train_station.repositories.dispatcherRepository.DispatcherBrigadeRepository;
import ua.coursework.train_station.repositories.dispatcherRepository.DispatcherRepository;

import java.util.List;

@Service
public class DispatcherService  {

    private DispatcherRepository dispatcherRepository;
    private DispatcherBrigadeRepository dispatcherBrigadeRepository;
    @Autowired
    public DispatcherService(DispatcherRepository dispatcherRepository, DispatcherBrigadeRepository dispatcherBrigadeRepository) {
        this.dispatcherRepository=dispatcherRepository;
        this.dispatcherBrigadeRepository=dispatcherBrigadeRepository;
    }

    public DispatcherBrigade findByName(String name)
    {return dispatcherBrigadeRepository.findByName(name);}

    public Page<Dispatcher>findAllByBrigade(DispatcherBrigade brigade, Pageable pageable)
    {return dispatcherRepository.findAllByDispatcherBrigade(brigade,pageable);}

    public Page<Dispatcher>findAllByBrigadeAndAge(DispatcherBrigade brigade,int age,Pageable pageable)
    {return dispatcherRepository.findAllByDispatcherBrigadeAndAge(brigade,age,pageable);}

    public Page<Dispatcher>findAllByBrigadeAndSalary(DispatcherBrigade brigade,int salary,Pageable pageable)
    {return dispatcherRepository.findAllByDispatcherBrigadeAndSalary(brigade,salary,pageable);}

    public Page<Dispatcher> findAll(Pageable pageable)
    {
        return dispatcherRepository.findAll(pageable);
    }


    public Page<Dispatcher> findAllByExperience(int experience,Pageable pageable) {
        return dispatcherRepository.findAllByExperience(experience,pageable);
    }


    public Page<Dispatcher> findAllBySex(Gender gender,Pageable pageable) {
        return dispatcherRepository.findAllBySex(gender,pageable);
    }


    public Page<Dispatcher> findAllByAge(int age,Pageable pageable) {
        return dispatcherRepository.findAllByAge(age,pageable);
    }


    public Page<Dispatcher> findAllByChildrenAmount(int childrenAmount,Pageable pageable) {
        return dispatcherRepository.findAllByChildrenAmount(childrenAmount, pageable);
    }


    public Page<Dispatcher> findAllBySalary(int salary,Pageable pageable) {
        return dispatcherRepository.findAllBySalary(salary,pageable);
    }
}
