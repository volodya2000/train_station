package ua.coursework.train_station.repositories.trainRepairmanRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.trainRepairman.TrainRepairBrigades;
import ua.coursework.train_station.model.trainRepairman.TrainRepairman;

import java.util.List;

@Repository
public interface TrainRepairmanRepository extends CrudRepository<TrainRepairman,Long> {
    Page<TrainRepairman> findAll();
    Page<TrainRepairman>findAll(Pageable pageable);
    Page<TrainRepairman>findAllByExperience(int experience,Pageable pageable);
    Page<TrainRepairman>findAllBySex(Gender gender, Pageable pageable);
    Page<TrainRepairman>findAllByAge(int age,Pageable pageable);
    Page<TrainRepairman>findAllByChildrenAmount(int childrenAmount,Pageable pageable);
    Page<TrainRepairman>findAllBySalary(int salary,Pageable pageable);
    Page<TrainRepairman>findAllByBrigade(TrainRepairBrigades driverBrigade, Pageable pageable);
    Page<TrainRepairman>findAllByBrigadeAndAge(TrainRepairBrigades brigade,int age,Pageable pageable);
    Page<TrainRepairman>findAllByBrigadeAndSalary(TrainRepairBrigades brigade,int salary,Pageable pageable);
}
