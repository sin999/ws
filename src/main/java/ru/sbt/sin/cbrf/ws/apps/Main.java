package ru.sbt.sin.cbrf.ws.apps;

import ru.sbt.sin.cbrf.ws.services.CbrfService;
import ru.sbt.sin.cbrf.ws.entities.ValuteCursOnDate;

import java.sql.Date;
import java.util.Map;

/**
 * Service work test
 * Created by 1 on 08.10.2016.
 */
public class Main {
    private static CbrfService cbrfService = new CbrfService();
    public static void main(String[] args) {
        Date date = Date.valueOf("2016-10-2");
        Map<Long,ValuteCursOnDate> cursMap = cbrfService.getCursMapOnDate(date);
        System.out.println("Curs on date "+date);
        for(ValuteCursOnDate valuteCursOnDate : cursMap.values()){
            System.out.println( " "+valuteCursOnDate.getName()+" costs "+ valuteCursOnDate.getCurs()+" "+valuteCursOnDate.getChCode());
        }
    }
}
