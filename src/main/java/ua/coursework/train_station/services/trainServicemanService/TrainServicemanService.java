package ua.coursework.train_station.services.trainServicemanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.cashiers.Cashier;
import ua.coursework.train_station.model.cashiers.CashierBrigades;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.trainServiceman.TrainServiceman;
import ua.coursework.train_station.model.trainServiceman.TrainServicemanBrigades;
import ua.coursework.train_station.repositories.cashierRepository.CashierBrigadeRepository;
import ua.coursework.train_station.repositories.dispatcherRepository.DispatcherRepository;
import ua.coursework.train_station.repositories.trainServicemanRepository.TrainServicemanBrigadeRepository;
import ua.coursework.train_station.repositories.trainServicemanRepository.TrainServicemanRepository;

import java.util.List;

@Service
public class TrainServicemanService {
    private TrainServicemanRepository trainServicemanRepository;
    private TrainServicemanBrigadeRepository trainServicemanBrigadeRepository;

    @Autowired
    public TrainServicemanService(TrainServicemanRepository trainServicemanRepository, TrainServicemanBrigadeRepository trainServicemanBrigadeRepository) {
        this.trainServicemanRepository = trainServicemanRepository;
        this.trainServicemanBrigadeRepository = trainServicemanBrigadeRepository;
    }

    public TrainServicemanBrigades findByName(String name)
    {return trainServicemanBrigadeRepository.findByName(name);}

    public Page<TrainServiceman>findAllByBrigade(TrainServicemanBrigades brigade, Pageable pageable)
    {return trainServicemanRepository.findAllByTrainServicemanBrigades(brigade,pageable);}

    public Page<TrainServiceman>findAllByBrigadeAndAge(TrainServicemanBrigades brigade,int age,Pageable pageable)
    {return trainServicemanRepository.findAllByTrainServicemanBrigadesAndAge(brigade,age,pageable);}

    public Page<TrainServiceman>findAllByBrigadeAndSalary(TrainServicemanBrigades brigade,int salary,Pageable pageable)
    {return trainServicemanRepository.findAllByTrainServicemanBrigadesAndSalary(brigade,salary,pageable);}


    public Page<TrainServiceman> findAll(Pageable pageable)
    {
        return trainServicemanRepository.findAll(pageable);
    }


    public Page<TrainServiceman> findAllByExperience(int experience,Pageable pageable) {
        return trainServicemanRepository.findAllByExperience(experience,pageable);
    }


    public Page<TrainServiceman> findAllBySex(Gender gender, Pageable pageable) {
        return trainServicemanRepository.findAllBySex(gender,pageable);
    }


    public Page<TrainServiceman> findAllByAge(int age,Pageable pageable) {
        return trainServicemanRepository.findAllByAge(age,pageable);
    }


    public Page<TrainServiceman> findAllByChildrenAmount(int childrenAmount,Pageable pageable) {
        return trainServicemanRepository.findAllByChildrenAmount(childrenAmount, pageable);
    }


    public Page<TrainServiceman> findAllBySalary(int salary,Pageable pageable) {
        return trainServicemanRepository.findAllBySalary(salary,pageable);
    }
}
