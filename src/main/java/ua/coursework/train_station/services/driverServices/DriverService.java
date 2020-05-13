package ua.coursework.train_station.services.driverServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.repositories.driverRepositories.DriverRepository;

import java.util.List;

@Service
public class DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository)
    {
        this.driverRepository=driverRepository;
    }


    public Page<Driver> findAllByChildrenAmount(int childrenAmount, Pageable pageable) {
        return driverRepository.findAllByChildrenAmount(childrenAmount, pageable);
    }

    public Page<Driver> findAllByYearOfMedicalCheckGreaterThanEqual(int medicalCheck,Pageable pageable) {
        return driverRepository.findByYearOfMedicalCheckGreaterThanEqual(medicalCheck,pageable);
    }

    public Page<Driver> findAllByExperience(int experience,Pageable pageable) {
        return driverRepository.findAllByExperience(experience,pageable);
    }


    public Page<Driver> findAllBySex(Gender gender, Pageable pageable) {
        return driverRepository.findAllBySex(gender,pageable);
    }


    public Page<Driver> findAllByAge(int age, Pageable pageable) {
        return driverRepository.findAllByAge(age,pageable);
    }


    public Page<Driver> findAllBySalary(int salary,Pageable pageable) {
        return driverRepository.findAllBySalary(salary,pageable);
    }

    public Page<Driver>findAll(Pageable pageable)
    {return driverRepository.findAll(pageable);}

    public Driver findDriverById(long id)
    {return driverRepository.findById(id);}

    public Page<Driver>findAllByBrigade(DriverBrigade brigade,Pageable pageable)
    {return driverRepository.findAllByBrigade(brigade,pageable);}

    public Page<Driver>findAllByBrigadeAndAge(DriverBrigade brigade,int age,Pageable pageable)
    {return driverRepository.findAllByBrigadeAndAge(brigade,age,pageable);}

    public Page<Driver>findAllByBrigadeAndSalary(DriverBrigade brigade,int salary,Pageable pageable)
    {return driverRepository.findAllByBrigadeAndSalary(brigade,salary,pageable);}

    public void save(Driver driver)
    {
        driverRepository.save(driver);
    }

}
