package ua.coursework.train_station.repositories.railwayRepairmanRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.railwayRepairman.RailwayRepairBrigades;
import ua.coursework.train_station.model.railwayRepairman.RailwayRepairman;

import java.util.List;

@Repository
public interface RailwayRepairmanRepository extends CrudRepository<RailwayRepairman,Long> {
    Page<RailwayRepairman> findAll();
    Page<RailwayRepairman>findAll(Pageable pageable);
    Page<RailwayRepairman>findAllByExperience(int experience,Pageable pageable);
    Page<RailwayRepairman>findAllBySex(Gender gender, Pageable pageable);
    Page<RailwayRepairman>findAllByAge(int age,Pageable pageable);
    Page<RailwayRepairman>findAllByChildrenAmount(int childrenAmount,Pageable pageable);
    Page<RailwayRepairman>findAllBySalary(int salary,Pageable pageable);
    Page<RailwayRepairman>findAllByRailwayRepairBrigades(RailwayRepairBrigades driverBrigade, Pageable pageable);
    Page<RailwayRepairman>findAllByRailwayRepairBrigadesAndAge(RailwayRepairBrigades brigade, int age, Pageable pageable);
    Page<RailwayRepairman>findAllByRailwayRepairBrigadesAndSalary(RailwayRepairBrigades brigade,int salary,Pageable pageable);
}
