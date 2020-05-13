package ua.coursework.train_station.repositories.driverRepositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;

import java.util.List;

@Repository
public interface DriverRepository extends CrudRepository<Driver,Long> {

        Driver findById(long id);
        Page<Driver>findByYearOfMedicalCheckGreaterThanEqual(int medicalCheck,Pageable pageable);//+
        Page<Driver>findAll();
        Page<Driver>findAll(Pageable pageable);
        Page<Driver>findAllByExperience(int experience,Pageable pageable);
        Page<Driver>findAllBySex(Gender gender,Pageable pageable);
        Page<Driver> findAllByAge(int age, Pageable pageable);
        Page<Driver>findAllByChildrenAmount(int childrenAmount,Pageable pageable);
        Page<Driver>findAllBySalary(int salary,Pageable pageable);
        Page<Driver>findAllByBrigade(DriverBrigade driverBrigade,Pageable pageable);
        Page<Driver>findAllByBrigadeAndAge(DriverBrigade brigade,int age,Pageable pageable);
        Page<Driver>findAllByBrigadeAndSalary(DriverBrigade brigade,int salary,Pageable pageable);
}
