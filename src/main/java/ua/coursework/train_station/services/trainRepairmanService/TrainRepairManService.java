package ua.coursework.train_station.services.trainRepairmanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.cashiers.Cashier;
import ua.coursework.train_station.model.cashiers.CashierBrigades;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.railwayRepairman.RailwayRepairBrigades;
import ua.coursework.train_station.model.trainRepairman.TrainRepairBrigades;
import ua.coursework.train_station.model.trainRepairman.TrainRepairman;
import ua.coursework.train_station.repositories.cashierRepository.CashierBrigadeRepository;
import ua.coursework.train_station.repositories.trainRepairmanRepository.TrainRepairmanBrigadesRepository;
import ua.coursework.train_station.repositories.trainRepairmanRepository.TrainRepairmanRepository;

import java.util.List;

@Service
public class TrainRepairManService {
    private TrainRepairmanRepository trainRepairmanRepository;
    private TrainRepairmanBrigadesRepository trainRepairmanBrigadesRepository;

    @Autowired
    public TrainRepairManService(TrainRepairmanRepository trainRepairmanRepository, TrainRepairmanBrigadesRepository trainRepairmanBrigadesRepository1) {
        this.trainRepairmanRepository = trainRepairmanRepository;
        this.trainRepairmanBrigadesRepository = trainRepairmanBrigadesRepository1;
    }

    public TrainRepairBrigades findByName(String name)
    {return trainRepairmanBrigadesRepository.findByName(name);}

    public Page<TrainRepairman>findAllByBrigade(TrainRepairBrigades brigade, Pageable pageable)
    {return trainRepairmanRepository.findAllByBrigade(brigade,pageable);}

    public Page<TrainRepairman>findAllByBrigadeAndAge(TrainRepairBrigades brigade,int age,Pageable pageable)
    {return trainRepairmanRepository.findAllByBrigadeAndAge(brigade,age,pageable);}

    public Page<TrainRepairman>findAllByBrigadeAndSalary(TrainRepairBrigades brigade,int salary,Pageable pageable)
    {return trainRepairmanRepository.findAllByBrigadeAndSalary(brigade,salary,pageable);}


    public Page<TrainRepairman> findAll(Pageable pageable)
    {
        return trainRepairmanRepository.findAll(pageable);
    }


    public Page<TrainRepairman> findAllByExperience(int experience,Pageable pageable) {
        return trainRepairmanRepository.findAllByExperience(experience,pageable);
    }


    public Page<TrainRepairman> findAllBySex(Gender gender, Pageable pageable) {
        return trainRepairmanRepository.findAllBySex(gender,pageable);
    }


    public Page<TrainRepairman> findAllByAge(int age,Pageable pageable) {
        return trainRepairmanRepository.findAllByAge(age,pageable);
    }


    public Page<TrainRepairman> findAllByChildrenAmount(int childrenAmount,Pageable pageable) {
        return trainRepairmanRepository.findAllByChildrenAmount(childrenAmount, pageable);
    }


    public Page<TrainRepairman> findAllBySalary(int salary,Pageable pageable) {
        return trainRepairmanRepository.findAllBySalary(salary,pageable);
    }
}
