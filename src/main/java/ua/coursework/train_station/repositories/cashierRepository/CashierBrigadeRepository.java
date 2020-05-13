package ua.coursework.train_station.repositories.cashierRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.cashiers.CashierBrigades;

import java.util.List;

@Repository
public interface CashierBrigadeRepository extends CrudRepository<CashierBrigades,Long> {

    List<CashierBrigades> findAll();
    CashierBrigades findByName(String name);
}
