package ua.coursework.train_station.services.helpDeskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.helpDeskService.HelpDeskServiceBrigades;
import ua.coursework.train_station.model.helpDeskService.HelpDeskServiceMan;
import ua.coursework.train_station.repositories.helpDeskRepository.HelpDeskRepository;
import ua.coursework.train_station.repositories.helpDeskRepository.HelpDeskServiceBrigadeRepository;

@Service
public class HelpDeskService {
    private HelpDeskRepository helpDeskRepository;
    private HelpDeskServiceBrigadeRepository HelpDeskServiceBrigadeRepository;


    @Autowired
    public HelpDeskService(HelpDeskRepository helpDeskRepository, ua.coursework.train_station.repositories.helpDeskRepository.HelpDeskServiceBrigadeRepository helpDeskServiceBrigadeRepository) {
        this.helpDeskRepository = helpDeskRepository;
        HelpDeskServiceBrigadeRepository = helpDeskServiceBrigadeRepository;
    }

    public HelpDeskServiceBrigades findByName(String name)
    {return HelpDeskServiceBrigadeRepository.findByName(name);}

    public Page<HelpDeskServiceMan>findAllByBrigade(HelpDeskServiceBrigades brigade, Pageable pageable)
    {return helpDeskRepository.findAllByBrigades(brigade,pageable);}

    public Page<HelpDeskServiceMan>findAllByBrigadeAndAge(HelpDeskServiceBrigades brigade,int age,Pageable pageable)
    {return helpDeskRepository.findAllByBrigadesAndAge(brigade,age,pageable);}

    public Page<HelpDeskServiceMan>findAllByBrigadeAndSalary(HelpDeskServiceBrigades brigade,int salary,Pageable pageable)
    {return helpDeskRepository.findAllByBrigadesAndSalary(brigade,salary,pageable);}


    public Page<HelpDeskServiceMan> findAll(Pageable pageable)
    {
        return helpDeskRepository.findAll(pageable);
    }


    public Page<HelpDeskServiceMan> findAllByExperience(int experience, Pageable pageable) {
        return helpDeskRepository.findAllByExperience(experience,pageable);
    }


    public Page<HelpDeskServiceMan> findAllBySex(Gender gender, Pageable pageable) {
        return helpDeskRepository.findAllBySex(gender,pageable);
    }


    public Page<HelpDeskServiceMan> findAllByAge(int age,Pageable pageable) {
        return helpDeskRepository.findAllByAge(age,pageable);
    }


    public Page<HelpDeskServiceMan> findAllByChildrenAmount(int childrenAmount,Pageable pageable) {
        return helpDeskRepository.findAllByChildrenAmount(childrenAmount, pageable);
    }


    public Page<HelpDeskServiceMan> findAllBySalary(int salary,Pageable pageable) {
        return helpDeskRepository.findAllBySalary(salary,pageable);
    }
}
