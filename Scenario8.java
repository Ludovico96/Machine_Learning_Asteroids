/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

/**
 *
 * @author Utente
 */
public class Scenario8 {
    public GameManager gm;
    //public UI ui=new UI(gm);
   
    public Group root;
    public ImageView underWater;
    
    
    
    public String scenaPrincipale;
    public EventScenario8[] event8;
    
   
    
    public Scenario8(GameManager gm){
        this.gm=gm;
    }
    
     public Scenario8(String scenario,EventScenario8[] event8){
         this.scenaPrincipale=scenario;
         this.event8=event8;
     }
    
    public void creaScenario(){
        gm.numeroScenario=8;
        underWater=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\underWater.jpg");
        
        //gm.ui.createMusic("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\underWater.wav");
        gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\bolle.wav");
        
        gm.ui.createButtonChangeScene();
        
        root=new Group(underWater,gm.ui.changeRight);
       
    }
    
    public void setAction(){
        underWater.setOnMouseClicked(event->{
            gm.ev8.clickUnderWater();
            
        });
        
        gm.ev8.followingScene();
        
        gm.ev8.lostWeapon();
        
    }
    
    public void conservaScenario8(){
         String controllaScena=Integer.toString(gm.numeroScenario);
        try{
           // Files.write(Paths.get("./myscenario/scenario.txt"),toString().getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
           
            
        } catch(IOException e){
            System.out.println("Impossibile conservare scenario");
        }
    }
   
   public void prelevaScenario8(){
       try{
          // scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String controllaScena=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           gm.numeroScenario=Integer.parseInt(controllaScena);
           if(gm.numeroScenario==8){
          
               gm.sc.showScenario8();
           
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare scenario");
       }
   } 
}
