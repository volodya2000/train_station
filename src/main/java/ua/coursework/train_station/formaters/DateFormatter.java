package ua.coursework.train_station.formaters;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class DateFormatter implements Formatter<Date> {

    public DateFormatter() {
    }

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(s);
        return date;
    }

    @Override
    public String print(Date date, Locale locale) {
        return null;
    }
}
