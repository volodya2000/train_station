package ua.coursework.train_station.repositories.dispatcherRepository;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.dispatchers.DispatcherBrigade;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;

import javax.persistence.GeneratedValue;
import java.util.List;

@Repository
public interface DispatcherRepository extends CrudRepository<Dispatcher,Long> {

    Page<Dispatcher> findAll();
    Page<Dispatcher>findAll(Pageable pageable);
    Page<Dispatcher>findAllByExperience(int experience,Pageable pageable);
    Page<Dispatcher>findAllBySex(Gender gender,Pageable pageable);
    Page<Dispatcher>findAllByAge(int age,Pageable pageable);
    Page<Dispatcher>findAllByChildrenAmount(int childrenAmount,Pageable pageable);
    Page<Dispatcher>findAllBySalary(int salary,Pageable pageable);
    Page<Dispatcher>findAllByDispatcherBrigade(DispatcherBrigade driverBrigade, Pageable pageable);
    Page<Dispatcher>findAllByDispatcherBrigadeAndAge(DispatcherBrigade brigade,int age,Pageable pageable);
    Page<Dispatcher>findAllByDispatcherBrigadeAndSalary(DispatcherBrigade brigade,int salary,Pageable pageable);
}
