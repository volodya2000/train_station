package ua.coursework.train_station.model.headOfDepartments;

import javax.persistence.*;

@Entity
@Table(name = "head_of_department")
public class HeadOfDepartments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

}
