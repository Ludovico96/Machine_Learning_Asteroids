/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import javax.xml.*; 
 import javax.xml.parsers.*; 
 import org.w3c.dom.*; 
import java.io.*; 
  import org.xml.sax.*; 
  import javax.xml.validation.*; 
  import javax.xml.transform.stream.*; 
  import javax.xml.transform.dom.*; 
  import com.sun.net.httpserver.*; 
  import java.net.*;

/**
 *
 * @author Utente
 */
public class ValidazioneXML {
    
    public static void valida(){
        try{
            DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
            SchemaFactory sf=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Document d=db.parse(new File("./myscenario/azioneSingola.xml"));
            Schema s=sf.newSchema(new StreamSource(new File("./myscenario/azioni.xsd")));
            s.newValidator().validate(new DOMSource(d));
            
        } catch(Exception e){
            if(e instanceof SAXException)
                System.out.println("Errore di validazione: "+e.getMessage());
            
            else
                System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args){
        valida();
    }
}
