package ua.coursework.train_station.services.railwayRepairmanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.railwayRepairman.RailwayRepairBrigades;
import ua.coursework.train_station.model.railwayRepairman.RailwayRepairman;
import ua.coursework.train_station.repositories.railwayRepairmanRepository.RailwayRepairmanBrigadeRepository;
import ua.coursework.train_station.repositories.railwayRepairmanRepository.RailwayRepairmanRepository;

import java.util.List;

@Service
public class RailwayRepairmanService {

    private RailwayRepairmanRepository railwayRepairmanRepository;
    private RailwayRepairmanBrigadeRepository railwayRepairmanBrigadeRepository;

    @Autowired
    public RailwayRepairmanService(RailwayRepairmanRepository railwayRepairmanRepository,
                                   RailwayRepairmanBrigadeRepository railwayRepairmanBrigadeRepository) {
        this.railwayRepairmanRepository = railwayRepairmanRepository;
        this.railwayRepairmanBrigadeRepository=railwayRepairmanBrigadeRepository;
    }

    public List<RailwayRepairBrigades> findAllBrigades()
    { return railwayRepairmanBrigadeRepository.findAll();}

    public RailwayRepairBrigades findByName(String name)
    {return railwayRepairmanBrigadeRepository.findByName(name);}

    public Page<RailwayRepairman>findAllByBrigade(RailwayRepairBrigades brigade, Pageable pageable)
    {return railwayRepairmanRepository.findAllByRailwayRepairBrigades(brigade,pageable);}

    public Page<RailwayRepairman>findAllByBrigadeAndAge(RailwayRepairBrigades brigade,int age,Pageable pageable)
    {return railwayRepairmanRepository.findAllByRailwayRepairBrigadesAndAge(brigade,age,pageable);}

    public Page<RailwayRepairman>findAllByBrigadeAndSalary(RailwayRepairBrigades brigade,int salary,Pageable pageable)
    {return railwayRepairmanRepository.findAllByRailwayRepairBrigadesAndSalary(brigade,salary,pageable);}


    public Page<RailwayRepairman> findAll(Pageable pageable)
    {
        return railwayRepairmanRepository.findAll(pageable);
    }


    public Page<RailwayRepairman> findAllByExperience(int experience,Pageable pageable) {
        return railwayRepairmanRepository.findAllByExperience(experience,pageable);
    }


    public Page<RailwayRepairman> findAllBySex(Gender gender, Pageable pageable) {
        return railwayRepairmanRepository.findAllBySex(gender,pageable);
    }


    public Page<RailwayRepairman> findAllByAge(int age,Pageable pageable) {
        return railwayRepairmanRepository.findAllByAge(age,pageable);
    }


    public Page<RailwayRepairman> findAllByChildrenAmount(int childrenAmount,Pageable pageable) {
        return railwayRepairmanRepository.findAllByChildrenAmount(childrenAmount, pageable);
    }


    public Page<RailwayRepairman> findAllBySalary(int salary,Pageable pageable) {
        return railwayRepairmanRepository.findAllBySalary(salary,pageable);
    }
}
