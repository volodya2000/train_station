package ua.coursework.train_station.repositories.helpDeskRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.helpDeskService.HelpDeskServiceBrigades;
import ua.coursework.train_station.model.helpDeskService.HelpDeskServiceMan;

import java.util.List;

@Repository
public interface HelpDeskRepository extends CrudRepository<HelpDeskServiceMan,Long> {
    Page<HelpDeskServiceMan> findAll();
    Page<HelpDeskServiceMan>findAll(Pageable pageable);
    Page<HelpDeskServiceMan>findAllByExperience(int experience,Pageable pageable);
    Page<HelpDeskServiceMan>findAllBySex(Gender gender, Pageable pageable);
    Page<HelpDeskServiceMan>findAllByAge(int age,Pageable pageable);
    Page<HelpDeskServiceMan>findAllByChildrenAmount(int childrenAmount,Pageable pageable);
    Page<HelpDeskServiceMan>findAllBySalary(int salary,Pageable pageable);
    Page<HelpDeskServiceMan>findAllByBrigades(HelpDeskServiceBrigades driverBrigade, Pageable pageable);
    Page<HelpDeskServiceMan>findAllByBrigadesAndAge(HelpDeskServiceBrigades brigade,int age,Pageable pageable);
    Page<HelpDeskServiceMan>findAllByBrigadesAndSalary(HelpDeskServiceBrigades brigade,int salary,Pageable pageable);
}
