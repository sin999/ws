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
import java.util.List;

/**
 * Cbrf data access service
 * Created by 1 on 09.10.2016.
 */
public class CbrfService {
    private DailyInfo service = new DailyInfo();
    private DailyInfoSoap port = service.getDailyInfoSoap();


    public List<ValuteCursOnDate> getCursListOnDate(Date date){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(date.getTime());
        XMLGregorianCalendar onDate = new XMLGregorianCalendarImpl(gregorianCalendar);
        ElementNSImpl elementNS = (ElementNSImpl)port.getCursOnDate(onDate).getAny();
        return new ValuteData(elementNS.getFirstChild());
    }
}
