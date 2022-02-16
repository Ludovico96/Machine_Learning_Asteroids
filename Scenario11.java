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
public class Scenario11 {
     public GameManager gm;
    //public UI ui=new UI(gm);
   
    public Group root;
    public ImageView beforeVolcano;
    public ImageView magician;
    public ImageView magicPortal;
    
    
    public String scenaPrincipale;
    public EventScenario11[] event11;
    
   
    
    public Scenario11(GameManager gm){
        this.gm=gm;
    }
    
     public Scenario11(String scenario,EventScenario11[] event11){
         this.scenaPrincipale=scenario;
         this.event11=event11;
     }
    
    public void creaScenario(){
        gm.numeroScenario=11;
        beforeVolcano=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\beforeVolcano.png");
        magician=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\magician.png", 300, 300, 200, 350);
        magicPortal=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\spirale.png", 300, 300, 500, 350);
        
        gm.ui.createButtonChangeScene();
        
        root=new Group(beforeVolcano,magician,gm.ui.changeRight);
       
    }
    
    public void setAction(){
       beforeVolcano.setOnMouseClicked(event->{
           gm.ev11.clickVolcano();
       });
       
       magician.setOnMouseClicked(event->{
           gm.ev11.clickMagician();
       });
       
       magicPortal.setOnMouseClicked(event->{
           gm.ev11.clickPortal();
       });
    }
    
    public void conservaScenario11(){
         String controllaScena=Integer.toString(gm.numeroScenario);
        try{
           // Files.write(Paths.get("./myscenario/scenario.txt"),toString().getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
           
            
        } catch(IOException e){
            System.out.println("Impossibile conservare scenario");
        }
    }
   
   public void prelevaScenario11(){
       try{
          // scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String controllaScena=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           gm.numeroScenario=Integer.parseInt(controllaScena);
           if(gm.numeroScenario==11){
          
               gm.sc.showScenario11();
           
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare scenario");
       }
   } 
}
