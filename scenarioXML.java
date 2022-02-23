/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import com.thoughtworks.xstream.XStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Utente
 */
public class scenarioXML implements Serializable{
    public GameManager gm;
    
    public String user;
    public int scenario;
    public int vita;
    public boolean spada;
    public boolean scudo;
    public boolean torcia;
    public boolean fionda;
    public boolean bomba;
    public boolean magia;
    
  
    
    
    public scenarioXML(){
        
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
    
    public  scenarioXML serializzaXML(scenarioXML sxml){
        XStream xs=new XStream();
       xs.alias("Scenario", scenarioXML.class);
       String x=xs.toXML(sxml);
       try{
           Files.write(Paths.get("./myscenario/scenarioXML.txt"), x.getBytes()); 
           x=new String(Files.readAllBytes(Paths.get("./myscenario/scenarioXML.txt")));
       } catch(Exception e){
           System.out.println("impossibile salvare scenarioXML");
       }
      sxml =(scenarioXML) xs.fromXML(x);
      System.out.println(sxml.user);
       
      /* try(DataOutputStream dout=
              new DataOutputStream((new Socket("localhost",8081)).getOutputStream()) 
               ){
           dout.writeUTF(x);
       } catch(Exception e){
           e.printStackTrace();
       }*/
        return sxml;
        
    }
    
    
   
    
  /*  public void serializzaBin(scenarioXML sxml){
        try(ObjectOutputStream ooutf=
              new ObjectOutputStream(new FileOutputStream("./myscenario/scenarioXML.bin"));
                ){
            ooutf.writeObject(sxml);
            
        }catch(Exception e){
            
        }
    }
    
    public void deserializzaBin(){
        scenarioXML sxml=null;
        try(ObjectInputStream oinf=
               new ObjectInputStream(new FileInputStream("./myscenario/scenarioXML.bin"));
                ){
            sxml=(scenarioXML) oinf.readObject();
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(sxml.user);
    }*/
    
   
}
