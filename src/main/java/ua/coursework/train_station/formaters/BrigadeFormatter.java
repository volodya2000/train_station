package ua.coursework.train_station.formaters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import ua.coursework.train_station.model.drivers.DriverBrigade;
import ua.coursework.train_station.services.driverServices.DriverBrigadeService;
import ua.coursework.train_station.services.driverServices.DriverService;

import java.text.ParseException;
import java.util.Locale;

@Component
public class BrigadeFormatter implements Formatter<DriverBrigade> {

    private DriverBrigadeService driverService;

    @Autowired
    public BrigadeFormatter(DriverBrigadeService driverService) {
        this.driverService = driverService;
    }

    @Override
    public DriverBrigade parse(String s, Locale locale) throws ParseException {
        DriverBrigade brigade=driverService.findByName(s);
        return brigade;
    }

    @Override
    public String print(DriverBrigade driverBrigade, Locale locale) {
        return null;
    }
}
