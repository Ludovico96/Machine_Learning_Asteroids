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
public class Scenario6 {
     public GameManager gm;
    //public UI ui=new UI(gm);
   
    public Group root;
    public ImageView fiume;
    public ImageView womanElf;
    
    
    public String scenaPrincipale;
    public EventScenario6[] event6;
    
   
    
    public Scenario6(GameManager gm){
        this.gm=gm;
    }
    
     public Scenario6(String scenario,EventScenario6[] event6){
         this.scenaPrincipale=scenario;
         this.event6=event6;
     }
    
    public void creaScenario(){
        gm.numeroScenario=6;
        fiume=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\fiume.png");
        womanElf=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\womanBust.png", 400, 400, 0, 300);
        gm.ui.createButtonChangeScene();
        
        root=new Group(fiume,womanElf,gm.ui.changeRight);
       
    }
    
    public void setAction(){
        
        womanElf.setOnMouseClicked(event->{
            gm.ev6.clickElf();
        });
       
        gm.ev6.followingScene();
    }
    
    public void conservaScenario6(){
         String controllaScena=Integer.toString(gm.numeroScenario);
        try{
           // Files.write(Paths.get("./myscenario/scenario.txt"),toString().getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
           
            
        } catch(IOException e){
            System.out.println("Impossibile conservare scenario");
        }
    }
   
   public void prelevaScenario6(){
       try{
          // scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String controllaScena=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           gm.numeroScenario=Integer.parseInt(controllaScena);
           if(gm.numeroScenario==6){
          
               gm.sc.showScenario6();
           
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare scenario");
       }
   }
    
}
