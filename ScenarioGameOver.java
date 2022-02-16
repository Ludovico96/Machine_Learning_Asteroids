/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Utente
 */
public class ScenarioGameOver {
    GameManager gm;
    public Button retry;
    public Label died;
    public Group root;
    public Clip clip;
            
    public ScenarioGameOver(GameManager gm){
        this.gm=gm;
    }

   public void creaScenario(){
       gm.numeroScenario=0;
       retry=new Button("Retry Game");
       died=new Label("You Died");
       died.setLayoutX(300);
       died.setLayoutY(400);
       died.setStyle("-fx-font-size: 100px; -fx-background-color:black; -fx-text-fill: red; ");
       retry.setLayoutX(450);
       retry.setLayoutY(550);
       root=new Group(died,retry);
      
       
   }
   
   public void setAction(){
       gm.scenarioEnd.retry.setOnAction(event->{
           gm.sc.showScenario1PostGameOver();
           
//            gm.ev1.clip.start();
       });
       
       gm.ui.createMusic("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\gameOver.wav");
       
       gm.evgo.musicScenario();
   }
   
   
   
  public void restartGame(){
       gm.scenarioEnd.retry.setOnAction(event->{
           gm.sc.showScenario1PostGameOver();
           
           gm.ev3.contaViteLupo=3;
           gm.ev3.deathWolf=false;
           gm.ev4.contaClick=1;
           gm.ev5.contaClick=1;
           gm.ev5.fineDiscorso=false;
           gm.ev5.choice1.setDisable(false);
           gm.ev5.choice2.setDisable(false);
           gm.ev6.contaClick=1;
           gm.ev6.fineDiscorso=false;
           gm.ev7.fineDiscorso=false;
           gm.ev8.contaClick=1;
           gm.ev8.fineDiscorso=false;
           gm.ev9.contaClick=1;
           gm.ev9.contaViteSqualo=6;
           gm.ev9.morteSqualo=false;
           gm.ev9.farBarrelExploded=false;
           gm.ev9.nearBarrelExploded=false;
           gm.ev11.contaClick=1;
           
           
           
           String controllaSpada="false";
       String controllaScudo="false";
       String controllaTorcia="false";
       String controllaBomba="false";
       String controllaFionda="false";
       String controllaMorteCavaliere="false";
       String controllaMorteLupo="false";
       gm.numeroScenario=1;
       String controllaScena=Integer.toString(gm.numeroScenario);
       String controllaVita="3";
       
       
       
       
       
       try{
           Files.write(Paths.get("./myscenario/armiOttenute.txt"),controllaSpada.getBytes());
            Files.write(Paths.get("./myscenario/armiOttenute2.txt"),controllaScudo.getBytes());
            Files.write(Paths.get("./myscenario/armiOttenute3.txt"),controllaTorcia.getBytes());
            Files.write(Paths.get("./myscenario/armiOttenute4.txt"),controllaBomba.getBytes());
            Files.write(Paths.get("./myscenario/armiOttenute5.txt"),controllaFionda.getBytes());
             Files.write(Paths.get("./myscenario/morteCavaliere.txt"),controllaMorteCavaliere.getBytes());
              Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
              Files.write(Paths.get("./myscenario/numeroVite.txt"),controllaVita.getBytes());
              Files.write(Paths.get("./myscenario/morteLupo.txt"),controllaMorteLupo.getBytes());
              
              
            gm.user.prelevaArmi();
            gm.scenario1.prelevaScenario1();
            gm.user.prelevaVita();
            //gm.scenario3.prelevaScenario3();
           
       } catch(IOException e){
           System.out.println("impossibile resettare gioco");
       }
       
       });
       
       /*String controllaSpada="false";
       String controllaScudo="false";
       String controllaTorcia="false";
       String controllaMorteCavaliere="false";
       
       try{
           Files.write(Paths.get("./myscenario/armiOttenute.txt"),controllaSpada.getBytes());
            Files.write(Paths.get("./myscenario/armiOttenute2.txt"),controllaScudo.getBytes());
            Files.write(Paths.get("./myscenario/armiOttenute3.txt"),controllaTorcia.getBytes());
             Files.write(Paths.get("./myscenario/morteCavaliere.txt"),controllaMorteCavaliere.getBytes());
             
            gm.user.prelevaArmi();
            gm.scenario1.prelevaScenario1();
           
       } catch(IOException e){
           System.out.println("impossibile resettare arma");
       }
       */
       
       
       
   }
    
    
    
}
