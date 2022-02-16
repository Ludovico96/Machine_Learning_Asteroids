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
public class Scenario5 {
    GameManager gm;
    
   public Group root;
    public ImageView forestaZoom;
    public ImageView womanElf;
    
    
    
    public String scenaPrincipale;
    public EventScenario5[] event5;
    
   
    
    public Scenario5(GameManager gm){
        this.gm=gm;
    }
    
     public Scenario5(String scenario,EventScenario5[] event5){
         this.scenaPrincipale=scenario;
         this.event5=event5;
     }
     
      public void creaScenario(){
        gm.numeroScenario=5;
        forestaZoom=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\forestaZoom.jpg");
        womanElf=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\elf.png", 250, 250, 450, 440);
        gm.ui.createButtonChangeScene();
        
        root=new Group(forestaZoom,womanElf,gm.ui.changeRight);
       
    }
    
    public void setAction(){
        
        womanElf.setOnMouseClicked(event->{
            gm.ev5.clickElf();
        });
        
        gm.ev5.followingScene();
        
    }
    
     public void conservaScenario5(){
         String controllaScena=Integer.toString(gm.numeroScenario);
        try{
           // Files.write(Paths.get("./myscenario/scenario.txt"),toString().getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
           
            
        } catch(IOException e){
            System.out.println("Impossibile conservare scenario");
        }
    }
   
   public void prelevaScenario5(){
       try{
          // scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String controllaScena=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           gm.numeroScenario=Integer.parseInt(controllaScena);
           if(gm.numeroScenario==5){
          
               gm.sc.showScenario5();
           
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare scenario");
       }
   }
   
}
