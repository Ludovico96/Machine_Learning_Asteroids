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
public class EventScenarioGameOver {
    public GameManager gm;
    public Clip clip;
    
    
    public EventScenarioGameOver(GameManager gm){
        this.gm=gm;
    }
    
    public void musicScenario() {
       try {File file=new File("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\gameOver.wav");
        AudioInputStream audioStream=AudioSystem.getAudioInputStream(file);
         clip=AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        } catch( Exception e ){
           System.out.println("imposibile prelevre audio");
       }
      }
}
