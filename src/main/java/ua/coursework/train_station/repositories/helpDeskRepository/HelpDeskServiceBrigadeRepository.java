package ua.coursework.train_station.repositories.helpDeskRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.helpDeskService.HelpDeskServiceBrigades;

import java.util.List;

@Repository
public interface HelpDeskServiceBrigadeRepository extends CrudRepository<HelpDeskServiceBrigades,Long> {
    List<HelpDeskServiceBrigades> findAll();
    HelpDeskServiceBrigades findByName(String name);
}
