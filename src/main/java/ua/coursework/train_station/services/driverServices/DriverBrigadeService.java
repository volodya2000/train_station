package ua.coursework.train_station.services.driverServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.repositories.driverRepositories.DriverBrigadeRepository;

import java.util.List;

@Service
public class DriverBrigadeService {

    private DriverBrigadeRepository driverBrigadeRepository;

    @Autowired
    public DriverBrigadeService(DriverBrigadeRepository driverBrigadeRepository) {
        this.driverBrigadeRepository = driverBrigadeRepository;
    }

    public List<DriverBrigade> findAll()
    {return driverBrigadeRepository.findAll();}

    public DriverBrigade findByName(String name)
    {return driverBrigadeRepository.findByName(name);}
}

