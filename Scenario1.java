/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;



import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Utente
 */
public class Scenario1 implements Serializable{
    
    public GameManager gm;
    
   
    public Group root;
    public ImageView bosco;
    public ImageView casa;
    public ImageView cavaliere;
    public ImageView baule;
    public Clip musicaScenario1;
  
    
    public String scenaPrincipale;
    public EventScenario1[] event1;
 
    
    
    public Scenario1(GameManager gm){
        this.gm=gm;
    }
    
   
    public Scenario1(String scenario,EventScenario1[] event1){
        this.scenaPrincipale=scenario;
        this.event1=event1;
    }
    
    
    
    
    public void creaScenario(){
        gm.numeroScenario=1;
        bosco=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\scenario1.png");
        casa=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\casa.png", 
                400, 400, 250, 300);
        cavaliere=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cavaliere.png", 170, 170, 660, 500);
        baule=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\baule.png", 100, 100, 890, 580);
        gm.ui.createButtonChangeScene();
        
        root=new Group(bosco,casa,cavaliere,baule,gm.ui.changeRight);
        
    }
    
    public void setAction() {
        
        
        casa.setOnMouseClicked(event->{
            gm.ev1.clickHouse();
           
        });
        
        cavaliere.setOnMouseClicked(event->{
            gm.ev1.clickKnight(); 
        });
        
        baule.setOnMouseClicked(event->{
            gm.ev1.clickChest();
        });
        
       gm.ev1.followingScene();
        
       
        
        bosco.setOnMouseClicked(event->{
            gm.rootManager.getChildren().removeAll(gm.ui.actionVbox,gm.ui.la);
            

        });
        
        //gm.ev1.musicScenario();
      // gm.ui.createMusic("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\musica\\musicaProva.wav");
        
        
        
    }
    
     public String toString1(){
        scenaPrincipale="bosco";
        return scenaPrincipale;
    }
    
   public void conservaScenario1(){
         String controllaScena=Integer.toString(gm.numeroScenario);
         String controllaMorteCavaliere=Boolean.toString(gm.ev1.death);
        try{
            //Files.write(Paths.get("./myscenario/scenario.txt"),toString1().getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
             Files.write(Paths.get("./myscenario/morteCavaliere.txt"),controllaMorteCavaliere.getBytes());
           
            
        } catch(IOException e){
            System.out.println("Impossibile conservare scenario");
        }
    }
   
   public void prelevaScenario1(){
       try{
          // scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String controllaScena=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           String controllaMorteCavaliere=new String(Files.readAllBytes(Paths.get("./myscenario/morteCavaliere.txt")));
           gm.numeroScenario=Integer.parseInt(controllaScena);
           gm.ev1.death=Boolean.parseBoolean(controllaMorteCavaliere);
           if(gm.numeroScenario==1){
           
           gm.sc.showScenario1();
           gm.user.prelevaVita();
           if(gm.ev1.death==true){
//               gm.ui.music.stop();
           }
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare scenario");
       }
   }
   
}
    
        
    
    
    
    
    
            

