package ua.coursework.train_station.formaters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import ua.coursework.train_station.model.Gender;
import ua.coursework.train_station.model.drivers.Driver;
import ua.coursework.train_station.services.driverServices.DriverService;

import java.text.ParseException;
import java.util.Locale;

@Component
public class GenderFormatter implements Formatter<Gender> {

    private DriverService driverService;

    @Autowired
    public GenderFormatter(DriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    public Gender parse(String s, Locale locale) throws ParseException {
        if(s.equals("MALE"))
        {
            return Gender.MALE;
        }else return Gender.FEMALE;
    }

    @Override
    public String print(Gender gender, Locale locale) {
        return null;
    }
}
