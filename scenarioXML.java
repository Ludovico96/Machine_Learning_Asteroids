
package progettovideogioco;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.XMLConstants; 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class scenarioXML implements Serializable{
    GameManager gm;
    
    String user;
    int scenario;
    int vita;
    boolean spada;
    boolean scudo;
    boolean torcia;
    boolean fionda;
    boolean bomba;
    boolean magia;
    
  
    //classe che salva i parametri dell'utente in un file XML
    
    public scenarioXML(){
        this.user="";
    }
    
    public scenarioXML(String user,int scenario,int vita,boolean spada,boolean scudo,boolean torcia,boolean fionda,boolean bomba,boolean magia){
        this.user=user;
        this.scenario=scenario;
        this.vita=vita;
        this.spada=spada;
        this.scudo=scudo;
        this.torcia=torcia;
        this.fionda=fionda;
        this.bomba=bomba;
        this.magia=magia;
    }
    
    public  void valida(){
        try{
            DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
            SchemaFactory sf=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Document d=db.parse(new File("./myscenario/scenarioXML.xml"));
            Schema s=sf.newSchema(new StreamSource(new File("./myscenario/scenarioXML.xsd")));
            s.newValidator().validate(new DOMSource(d));
            
        } catch(Exception e){
            if(e instanceof SAXException)
                System.out.println("Errore di validazione: "+e.getMessage());
            
            else
                System.out.println(e.getMessage());
        }
        
    }
    
    public  void serializzaXML(scenarioXML sxml){
        valida();
        XStream xs=new XStream();
       String x=xs.toXML(sxml);
       try{
           Files.write(Paths.get("./myscenario/scenarioXML.txt"), x.getBytes());
            Files.write(Paths.get("./myscenario/scenarioXML.xml"), x.getBytes());
       } catch(Exception e){
           System.out.println("impossibile salvare scenarioXML");
       }
     
    }
    
    public scenarioXML deserializzaXML(){
         XStream xs=new XStream();
         String x="null";
         scenarioXML sxml=null;
         try{
              x=new String(Files.readAllBytes(Paths.get("./myscenario/scenarioXML.txt")));
              sxml=(scenarioXML) xs.fromXML(x);
              return sxml;
         } catch(Exception e){
             System.out.println("impossibile prelevare scenarioXML");
         }
        return new scenarioXML();
         
         
         
         
     }
    
    
    
   
    
   
}
