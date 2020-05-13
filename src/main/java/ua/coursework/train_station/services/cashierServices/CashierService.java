package ua.coursework.train_station.services.cashierServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.cashiers.Cashier;
import ua.coursework.train_station.model.cashiers.CashierBrigades;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.repositories.cashierRepository.CashierBrigadeRepository;
import ua.coursework.train_station.repositories.cashierRepository.CashierRepository;

import java.util.List;

@Service
public class CashierService {
    private CashierRepository cashierRepository;
    private CashierBrigadeRepository cashierBrigadeRepository;

    public CashierBrigades findByName(String name)
    {return cashierBrigadeRepository.findByName(name);}

    public List<CashierBrigades>findAllBrigades()
    {return  cashierBrigadeRepository.findAll();}

    public Page<Cashier>findAllByBrigade(CashierBrigades brigade, Pageable pageable)
    {return cashierRepository.findAllByBrigade(brigade,pageable);}

    public Page<Cashier>findAllByBrigadeAndAge(CashierBrigades brigade,int age,Pageable pageable)
    {return cashierRepository.findAllByBrigadeAndAge(brigade,age,pageable);}

    public Page<Cashier>findAllByBrigadeAndSalary(CashierBrigades brigade,int salary,Pageable pageable)
    {return cashierRepository.findAllByBrigadeAndSalary(brigade,salary,pageable);}

    @Autowired
    public CashierService(CashierRepository cashierRepository, CashierBrigadeRepository cashierBrigadeRepository) {
        this.cashierRepository = cashierRepository;
        this.cashierBrigadeRepository = cashierBrigadeRepository;
    }

    public Page<Cashier> findAll(Pageable pageable)
    {
        return cashierRepository.findAll(pageable);
    }


    public Page<Cashier> findAllByExperience(int experience,Pageable pageable) {
        return cashierRepository.findAllByExperience(experience,pageable);
    }


    public Page<Cashier> findAllBySex(Gender gender, Pageable pageable) {
        return cashierRepository.findAllBySex(gender,pageable);
    }


    public Page<Cashier> findAllByAge(int age,Pageable pageable) {
        return cashierRepository.findAllByAge(age,pageable);
    }


    public Page<Cashier> findAllByChildrenAmount(int childrenAmount,Pageable pageable) {
        return cashierRepository.findAllByChildrenAmount(childrenAmount, pageable);
    }


    public Page<Cashier> findAllBySalary(int salary,Pageable pageable) {
        return cashierRepository.findAllBySalary(salary,pageable);
    }

}
