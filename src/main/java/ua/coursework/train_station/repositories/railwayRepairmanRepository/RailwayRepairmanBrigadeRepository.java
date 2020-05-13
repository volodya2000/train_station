package ua.coursework.train_station.repositories.railwayRepairmanRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.model.railwayRepairman.RailwayRepairBrigades;

import java.util.List;

@Repository
public interface RailwayRepairmanBrigadeRepository extends CrudRepository<RailwayRepairBrigades,Long> {
    List<RailwayRepairBrigades> findAll();
    RailwayRepairBrigades findByName(String name);
    List<RailwayRepairBrigades>findAllByName(String name);
}
