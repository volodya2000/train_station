package ua.coursework.train_station.repositories.driverRepositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.model.drivers.DriverBrigade;

import java.util.List;

@Repository
public interface DriverBrigadeRepository extends CrudRepository<DriverBrigade,Long> {

    List<DriverBrigade> findAll();
    DriverBrigade findByName(String name);
    int countAllByDriversInBrigade(DriverBrigade brigade);
    @Query(nativeQuery = true,
            value = "select count (*) from drivers where drivers.brigade_id=:brigade_id; "
    )
    int countAllByBrigade(@Param("brigade_id") int brigade_id);
}
