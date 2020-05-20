package ua.coursework.train_station.repositories.trainServicemanRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.trainServiceman.TrainServiceman;
import ua.coursework.train_station.model.trainServiceman.TrainServicemanBrigades;

import java.util.List;

@Repository
public interface TrainServicemanRepository  extends CrudRepository<TrainServiceman,Long> {

    int countAllByExperience(int experience);
    int countAllBySex(Gender gender);
    int countAllByAge(int age);
    int countAllByChildrenAmount(int amount);
    int countAllBySalary(int salary);

    Page<TrainServiceman> findAll();
    Page<TrainServiceman>findAll(Pageable pageable);
    Page<TrainServiceman>findAllByExperience(int experience,Pageable pageable);
    Page<TrainServiceman>findAllBySex(Gender gender, Pageable pageable);
    Page<TrainServiceman>findAllByAge(int age,Pageable pageable);
    Page<TrainServiceman>findAllByChildrenAmount(int childrenAmount,Pageable pageable);
    Page<TrainServiceman>findAllBySalary(int salary,Pageable pageable);
    Page<TrainServiceman>findAllByTrainServicemanBrigades(TrainServicemanBrigades driverBrigade, Pageable pageable);
    Page<TrainServiceman>findAllByTrainServicemanBrigadesAndAge(TrainServicemanBrigades brigade,int age,Pageable pageable);
    Page<TrainServiceman>findAllByTrainServicemanBrigadesAndSalary(TrainServicemanBrigades brigade,int salary,Pageable pageable);
}
