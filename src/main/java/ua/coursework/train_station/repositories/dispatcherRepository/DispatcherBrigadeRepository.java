package ua.coursework.train_station.repositories.dispatcherRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.dispatchers.Dispatcher;
import ua.coursework.train_station.model.dispatchers.DispatcherBrigade;
import ua.coursework.train_station.model.drivers.DriverBrigade;

import java.util.List;
@Repository
public interface DispatcherBrigadeRepository extends CrudRepository<DispatcherBrigade,Long> {
    List<DispatcherBrigade> findAll();
    DispatcherBrigade findByName(String name);
}
