package ru.sbt.sin.cbrf.ws.app1;

import com.blogspot.nikcode.jaxws.generated.*;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

/**
 * Created by 1 on 08.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        DailyInfo service = new DailyInfo();
        DailyInfoSoap port = service.getDailyInfoSoap();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2016,10,6);

        XMLGregorianCalendar onDate = new XMLGregorianCalendarImpl(gregorianCalendar);
        try {
            onDate = GetCursOnDateResultParser.getXMLGregorianCalendarNow();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

//        EnumValutesResponse.EnumValutesResult en = port.enumValutes(false);
//        GetCursOnDateResponse.GetCursOnDateResult curs = port.getCursOnDate(onDate);
//
//        onDate = port.getLatestDateTime();
//        GetCursOnDateXMLResponse.GetCursOnDateXMLResult result = port.getCursOnDateXML(new XMLGregorianCalendarImpl(new GregorianCalendar()));
        GetCursOnDateResultParser.Valute list = null;

//        GetCursOnDateXMLResponse.GetCursOnDateXMLResult result = port.getCursOnDateXML(onDate);
        com.blogspot.nikcode.jaxws.generated.AllDataInfoXMLResponse.AllDataInfoXMLResult result = port.allDataInfoXML();
        System.out.println("Result is "+(result==null?"NULL":(result.getContent()==null?"Content is NUll":result.getContent().toString())));


//        try{
//            list = GetCursOnDateResultParser.getValuteByValuteCh("USD", result);
//        } catch (Exception e){
//
//        }
//        System.out.println(list==null?"NULL":list.curs);
//
//        try{
//            list = GetCursOnDateResultParser.getValuteByValuteCode("840", result);
//        } catch (Exception e){
//
//        }
//        System.out.println(list==null?"NULL":list.curs);
    }
}
