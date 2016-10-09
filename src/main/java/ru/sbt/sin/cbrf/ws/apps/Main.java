package ru.sbt.sin.cbrf.ws.apps;

import ru.sbt.sin.cbrf.ws.services.CbrfService;
import ru.sbt.sin.cbrf.ws.entities.ValuteCursOnDate;

import java.sql.Date;
import java.util.List;

/**
 * Service work test
 * Created by 1 on 08.10.2016.
 */
public class Main {
    private static CbrfService cbrfService = new CbrfService();
    public static void main(String[] args) {
        Date date = Date.valueOf("2000-10-09");
        List<ValuteCursOnDate> curses = cbrfService.getCursListOnDate(date);
        System.out.println("Curs on date "+date);
        for(ValuteCursOnDate valuteCursOnDate : curses){
            System.out.println( " "+valuteCursOnDate.getName()+" costs "+ valuteCursOnDate.getCurs()+" "+valuteCursOnDate.getChCode());
        }
    }
}
