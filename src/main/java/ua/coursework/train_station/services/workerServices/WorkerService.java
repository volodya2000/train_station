package ua.coursework.train_station.services.workerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.Worker;
import ua.coursework.train_station.repositories.workerRepositories.WorkerRepository;

import java.util.List;

@Service
public class WorkerService {

    private WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Page<Worker>findAll(Pageable pageable)
    { return  workerRepository.findAll(pageable); }

    public List<? extends Worker> findAllByExperience(int experience)
    { return workerRepository.findAllByExperience(experience);}

    public List<? extends Worker>findAllBySex(Gender gender)
    {return workerRepository.findAllBySex(gender);}
    public List<? extends Worker>findAllByChildrenAmount(int childrenAmount)
    {return workerRepository.findAllByChildrenAmount(childrenAmount);}

    public List<? extends Worker>findAllBySalary(int salsary)
    {return workerRepository.findAllBySalary(salsary);}
}