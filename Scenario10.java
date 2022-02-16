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
public class Scenario10 {
     public GameManager gm;
    //public UI ui=new UI(gm);
   
    public Group root;
    public ImageView island;
    public ImageView palm;
    
    
    public String scenaPrincipale;
    public EventScenario10[] event10;
    
   
    
    public Scenario10(GameManager gm){
        this.gm=gm;
    }
    
     public Scenario10(String scenario,EventScenario10[] event10){
         this.scenaPrincipale=scenario;
         this.event10=event10;
     }
    
    public void creaScenario(){
        gm.numeroScenario=10;
        island=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\island.png");
        palm=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\palma.png", 450, 450, 0, 200);
        
        
        gm.ui.createButtonChangeScene();
        
        root=new Group(island,palm,gm.ui.changeRight);
       
    }
    
    public void setAction(){
        island.setOnMouseClicked(event->{
            gm.ev10.clickIsland();
        });
        
        palm.setOnMouseClicked(event->{
            gm.ev10.clickPalm();
        });
        gm.ev10.followingScene();
      //  gm.ev10.restoreWeapon();
    }
    
    public void conservaScenario10(){
         String controllaScena=Integer.toString(gm.numeroScenario);
        try{
           // Files.write(Paths.get("./myscenario/scenario.txt"),toString().getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
           
            
        } catch(IOException e){
            System.out.println("Impossibile conservare scenario");
        }
    }
   
   public void prelevaScenario10(){
       try{
          // scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String controllaScena=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           gm.numeroScenario=Integer.parseInt(controllaScena);
           if(gm.numeroScenario==10){
          
               gm.sc.showScenario10();
           
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare scenario");
       }
   } 
}
