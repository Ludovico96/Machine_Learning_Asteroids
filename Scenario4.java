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
public class Scenario4 {
     public GameManager gm;
    //public UI ui=new UI(gm);
   
    public Group root;
    public ImageView forestaIntera;
    public ImageView caverna;
    
    
    public String scenaPrincipale;
    public EventScenario4[] event4;
    
   
    
    public Scenario4(GameManager gm){
        this.gm=gm;
    }
    
     public Scenario4(String scenario,EventScenario4[] event4){
         this.scenaPrincipale=scenario;
         this.event4=event4;
     }
     
      public void creaScenario(){
        gm.numeroScenario=4;
        forestaIntera=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\forestaIntera.jpg");
        caverna=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\caverna.png", 250, 250, 30, 470);
        gm.ui.createButtonChangeScene();
        
        root=new Group(forestaIntera,caverna,gm.ui.changeRight);
       
    }
    
    public void setAction(){
        forestaIntera.setOnMouseClicked(event->{
            gm.ev4.clickForest();
        });
        
        gm.ev4.followingScene();
    }
    
     public void conservaScenario4(){
         String controllaScena=Integer.toString(gm.numeroScenario);
        try{
           // Files.write(Paths.get("./myscenario/scenario.txt"),toString().getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
           
            
        } catch(IOException e){
            System.out.println("Impossibile conservare scenario");
        }
    }
   
   public void prelevaScenario4(){
       try{
          // scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String controllaScena=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           gm.numeroScenario=Integer.parseInt(controllaScena);
           if(gm.numeroScenario==4){
          
               gm.sc.showScenario4();
           
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare scenario");
       }
   }
   
}
