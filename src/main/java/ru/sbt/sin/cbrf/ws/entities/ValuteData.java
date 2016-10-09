package ru.sbt.sin.cbrf.ws.entities;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Created by 1 on 09.10.2016.
 */
public class ValuteData extends ArrayList<ValuteCursOnDate> {
    public static final String ELEMENT_NAME ="ValuteData";
    public ValuteData(Node node){
        if(ELEMENT_NAME.equals(node.getNodeName())){
            NodeList nodeList = node.getChildNodes();
            for(int ind = 0 ; ind<nodeList.getLength() ; ind++){
                Node element = nodeList.item(ind);
                if(ValuteCursOnDate.ELEMENT_NAME.equals(element.getNodeName())) {
                    add(new ValuteCursOnDate(element));
                }
            }
        }
    }
}
