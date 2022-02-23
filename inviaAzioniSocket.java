/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import com.thoughtworks.xstream.XStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/**
 *
 * @author Utente
 */
public class inviaAzioniSocket {
    
    public GameManager gm;
    
    //public static String y="";
    
    
    
    
    
    public inviaAzioniSocket(GameManager gm){ 
        this.gm=gm;
    }
    
    
    
    public void serializzaAzioniXML(AzioniInGame azioni){
        XStream xs=new XStream();
        xs.alias("AzioniInGame", AzioniInGame.class);
        String x=xs.toXML(azioni);
        
        try{
            Files.write(Paths.get("./myscenario/azioni.xml"), x.getBytes());
           // y=new String(Files.readAllBytes(Paths.get("./myscenario/azioni.xml")));
            
             
        } catch(Exception e){System.out.println("Impossibile salvare azione in xml");}
        
        
       // prelevaAzioniXML();
        //y+=x+" \n ";
        
        
       
        System.out.println(x);
        try(
                DataOutputStream dout=new DataOutputStream((new Socket("localhost",8080)).getOutputStream());
                ){
            dout.writeUTF(x);
        } catch(Exception e){
            e.printStackTrace();
        } 
            
    }
    
   /* public static void prelevaAzioniXML(){
        try{
            y=new String(Files.readAllBytes(Paths.get("./myscenario/azioni.xml")));
        } catch(IOException e){
            System.out.println("Impossibile prelevare azioniXML");
        }
    }*/
    
   /* public static void inviaAzioniXML(){
        //prelevaAzioniXML();
         try{
            y=new String(Files.readAllBytes(Paths.get("./myscenario/azioni.xml")));
        } catch(IOException e){
            System.out.println("Impossibile prelevare azioniXML");
        }
        try(
                
                DataOutputStream dout=new DataOutputStream((new Socket("localhost",8080)).getOutputStream());
                ){
            dout.writeUTF(y);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
       
        inviaAzioniXML();
    }
    */
    
}
