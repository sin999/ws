package ru.sbt.sin.cbrf.ws.services;

import com.blogspot.nikcode.jaxws.generated.DailyInfo;
import com.blogspot.nikcode.jaxws.generated.DailyInfoSoap;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import ru.sbt.sin.cbrf.ws.entities.ValuteCursOnDate;
import ru.sbt.sin.cbrf.ws.entities.ValuteData;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

/**
 * Created by 1 on 09.10.2016.
 */
public class CbrfService {
    DailyInfo service = new DailyInfo();
    DailyInfoSoap port = service.getDailyInfoSoap();


    public Map<Long,ValuteCursOnDate> getCursMapOnDate(Date date){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(date.getTime());
//        GregorianCalendar gregorianCalendar = new GregorianCalendar(2016,8,1);
        XMLGregorianCalendar onDate = new XMLGregorianCalendarImpl(gregorianCalendar);
        ElementNSImpl elementNS = (ElementNSImpl)port.getCursOnDate(onDate).getAny();
        return new ValuteData(elementNS.getFirstChild());
    }
}
