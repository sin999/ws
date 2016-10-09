package ru.sbt.sin.cbrf.ws.entities;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Created by 1 on 09.10.2016.
 */
public class ValuteCursOnDate {
    public static final String rootElement ="ValuteCursOnDate";
// <ValuteCursOnDate diffgr:id="ValuteCursOnDate1" msdata:rowOrder="0">
//    <Vname>Австралийский доллар</Vname>
//    <Vnom>1</Vnom>
//    <Vcurs>46.5061</Vcurs>
//    <Vcode>36</Vcode>
//    <VchCode>AUD</VchCode>
// </ValuteCursOnDate>
    public ValuteCursOnDate(Node node){
        if(rootElement.equals(node.getNodeName())){
            NodeList nodeList = node.getChildNodes();
            for(int ind = 0 ; ind<nodeList.getLength() ; ind++){
                fill(nodeList.item(ind));
            }
        }

    }

    private void fill(Node node){
        if("Vname".equals(node.getNodeName())){
            setName(node.getTextContent().trim());
        }
        if("Vnom".equals(node.getNodeName())){
            setNom(Long.parseLong(node.getTextContent()));
        }
        if("Vcurs".equals(node.getNodeName())){
            setCurs(Double.parseDouble(node.getTextContent()));
        }
        if("Vcode".equals(node.getNodeName())){
            setCode(Long.parseLong(node.getTextContent()));
        }
        if("VchCode".equals(node.getNodeName())){
            setChCode(node.getTextContent().trim());
        }
    }

    private String name;
    private long nom;
    private Double curs;
    private long code;
    private String chCode;

//    public static ValuteCursOnDate unmarshal(String xml){
//        ValuteCursOnDate customer = null;
//        try {
//
//            File file = new File("C:\\file.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(ValuteCursOnDate.class);
//
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            customer = (ValuteCursOnDate) jaxbUnmarshaller.unmarshal(file);
//            System.out.println(customer);
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        return customer;
//    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNom() {
        return nom;
    }

    public void setNom(long nom) {
        this.nom = nom;
    }

    public Double getCurs() {
        return curs;
    }

    public void setCurs(Double curs) {
        this.curs = curs;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getChCode() {
        return chCode;
    }

    public void setChCode(String chCode) {
        this.chCode = chCode;
    }
}
