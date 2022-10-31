package co.edu.unipiloto.platVMS.util;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class DateHelper {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private LocalDate newDate(){
        return LocalDate.now();
    }

    public String getCurrentDate(){
        return newDate().format(dateFormatter);
    }

    public String getCurrentTime(){
        return newDate().format(timeFormatter);
    }

    public LocalDate toLocalDate(String date){
        return LocalDate.parse(date,dateFormatter);
    }

    public LocalDate toLocalTime(String time){
        return LocalDate.parse(time,timeFormatter);
    }
}
