package ua.coursework.train_station.repositories.cashierRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.cashiers.Cashier;
import ua.coursework.train_station.model.cashiers.CashierBrigades;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;

import java.util.Calendar;
import java.util.List;

@Repository
public interface CashierRepository extends CrudRepository<Cashier,Long> {
    Page<Cashier> findAll();
    Page<Cashier>findAll(Pageable pageable);
    Page<Cashier>findAllByExperience(int experience,Pageable pageable);
    Page<Cashier>findAllBySex(Gender gender, Pageable pageable);
    Page<Cashier>findAllByAge(int age,Pageable pageable);
    Page<Cashier>findAllByChildrenAmount(int childrenAmount,Pageable pageable);
    Page<Cashier>findAllBySalary(int salary,Pageable pageable);
    Page<Cashier>findAllByBrigade(CashierBrigades driverBrigade, Pageable pageable);
    Page<Cashier>findAllByBrigadeAndAge(CashierBrigades brigade, int age, Pageable pageable);
    Page<Cashier>findAllByBrigadeAndSalary(CashierBrigades brigade,int salary,Pageable pageable);
}
