package ua.coursework.train_station;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@SpringBootApplication
public class TrainStationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainStationApplication.class, args);
    }
}
