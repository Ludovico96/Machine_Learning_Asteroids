/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Utente
 */
public class EventScenarioBetween1and2 {
    
    public GameManager gm;
    public Clip clip;
    
    public EventScenarioBetween1and2(GameManager gm){
        this.gm=gm;
    }
    
    public void clickValle(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
       /* gm.ui.createObjectMenu("look", "", "");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookValley();
        }); */
        lookValley();
    }
    
    public void lookValley(){
        gm.ui.createMessage("(I rember when we was child and \n we run into this valley \n what happened to you Arya...)"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
     /*public void precedingScene(){
        gm.ui.changeLeft.setOnAction(event->{
            gm.sc.showScenario1Post2();
            //gm.sc.showScenario2();
//           clip.stop();
            
        });
    }*/
     
      public void followingScene(){
        gm.ui.changeRight.setOnAction(event->{
            gm.sc.showScenario2();
            //gm.sc.showScenario2();
         //  clip.stop();
            
        });
    }
      
    /*  public void musicScenario() {
       try {File file=new File("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\ambientForest.wav");
        AudioInputStream audioStream=AudioSystem.getAudioInputStream(file);
         clip=AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        } catch( Exception e ){
           System.out.println("imposibile prelevre audio");
       }
      } */
}
