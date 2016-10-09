package ru.sbt.sin.cbrf.ws.entities;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;

/**
 * Created by 1 on 09.10.2016.
 */
public class ValuteData extends HashMap<Long,ValuteCursOnDate> {
    private String rootElement ="ValuteData";
    public ValuteData(Node node){
        if(rootElement.equals(node.getNodeName())){
            NodeList nodeList = node.getChildNodes();
            for(int ind = 0 ; ind<nodeList.getLength() ; ind++){
                Node element = nodeList.item(ind);
                if(ValuteCursOnDate.rootElement.equals(element.getNodeName())) {
                    ValuteCursOnDate valuteCursOnDate = new ValuteCursOnDate(element);
                    put(valuteCursOnDate.getCode(),valuteCursOnDate);
                }
            }
        }
    }
}
