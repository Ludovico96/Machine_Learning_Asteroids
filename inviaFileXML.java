/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Utente
 */
public class inviaFileXML {
    //Invia gli scenari in formato XML alla classe RiceviScenarioXML
    public static void serializzaXML(Scenario1 s1){
         XStream xs=new XStream();
          xs.alias("Scenario1", Scenario1.class);
          xs.alias("eventScenario1", EventScenario1.class);
          xs.alias("action", String.class);
          xs.omitField(EventScenario1.class, "death");
           xs.omitField(EventScenario1.class, "contaClick");
          
         xs.useAttributeFor(Scenario1.class, "scenaPrincipale");
         xs.useAttributeFor( EventScenario1.class, "oggettoScenario");
         
         //  xs.alias("Action",String.class);
         String x=xs.toXML(s1);
       
        
         try{
             Files.write(Paths.get("./myscenario/scenarioXML.xml"), x.getBytes());
             x=new String(Files.readAllBytes(Paths.get("./myscenario/scenarioXML.xml")));
             
         } catch(Exception e){}
         s1=(Scenario1) xs.fromXML(x);
         System.out.println("Bosco: "+s1.event1.length);
         try(DataOutputStream dout=new DataOutputStream((new Socket("localhost",8080)).getOutputStream());
                 ) {
             dout.writeUTF(x);
         }catch(Exception e){
             e.printStackTrace();
         }
         
    }
    
    
    public static void serializzaXML(Scenario2 s2){
         XStream xs=new XStream();
          xs.alias("Scenario2", Scenario2.class);
          xs.alias("eventScenario2", EventScenario2.class);
          xs.alias("action", String.class);
         // xs.omitField(EventScenario1.class, "death");
          
         xs.useAttributeFor(Scenario2.class, "scenaPrincipale");
         xs.useAttributeFor( EventScenario2.class, "oggettoScenario");
         
         //  xs.alias("Action",String.class);
         String x=xs.toXML(s2);
       
        
         try{
             Files.write(Paths.get("./myscenario/scenarioXML.xml"), x.getBytes());
             x=new String(Files.readAllBytes(Paths.get("./myscenario/scenarioXML.xml")));
             
         } catch(Exception e){}
         s2=(Scenario2) xs.fromXML(x);
//         System.out.println("Bosco: \n oggettiScenario: "+s1.oggettiScenario.length);
         try(DataOutputStream dout=new DataOutputStream((new Socket("localhost",8080)).getOutputStream());
                 ) {
             dout.writeUTF(x);
         }catch(Exception e){
             e.printStackTrace();
         }
         
    }
    
   
    
   
    
    public static void main(String[] args){
        Scenario1 s1=
                new Scenario1("Bosco", new EventScenario1[]{
                    new EventScenario1("casa",new String[]{
                        "LookHouse","TakeHouse","DoNothingHouse"
                    },new String[]{
                        "its your home","you obtein a sword","you eat nad your life recovered"
                    }),
                    new EventScenario1("cavaliere",new String[]{
                        "LookKnight","TalkKnight","AttackKnight"
                    },new String[]{
                        "its a knight","hello Stranger","you fool! // you defeat the knight"
                    })
                });
        
        Scenario2 s2=
                new Scenario2("BoscoCaverna", new EventScenario2[]{
                    new EventScenario2("vecchio",new String[]{
                        "LookOld","TalkOld","DoNothingOld"
                    },new String[]{
                        "Its an old man","Hello my boy, \n do you want to help me? // I must enter in the cavern \n to find an erb to cure \n my sick daughter...please help me"
                            ,"Hy boy"
                    }),
                    new EventScenario2("caverna",new String[]{
                        "LookCavern","EnterCavern","DoNothingCavern"
                    },new String[]{
                        "its a cavern","the cavern is too dark to enter","fiuuuuuuuu......fiuuuuu...."
                    })
                });
        serializzaXML(s1);
       serializzaXML(s2);
       
    }
   
}
