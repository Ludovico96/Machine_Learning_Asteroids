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
public class EventScenario2 {
    GameManager gm;
    
   public String oggettoScenario;
   public String[] actions;
   public String[] consequences;
    
    public int contaClick=1;
    
    
    public Clip clip;
    
    public EventScenario2(GameManager gm){
        this.gm=gm;
    }
    
    public EventScenario2(String oggettoScenario,String[] actions,String[] consequences){
        this.oggettoScenario=oggettoScenario;
        this.actions=actions;
        this.consequences=consequences;
    }
    
    
    public void clickOld(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "talk", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookOld();
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             if(contaClick==1){
             talkOld();
             contaClick++;
             }else if(contaClick==2){
             talkOld2();
             }
             
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoNothingOld();
             
        });
        
    }
    
    public void lookOld(){
        gm.ui.createMessage("It's an old man"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void talkOld(){
        gm.ui.createMessage("Hello my boy, \n do you want to help me?"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void talkOld2(){
         gm.ui.createMessage("I must enter in the cavern \n to find an erb to cure \n my sick daughter...please help me"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void DoNothingOld(){
        gm.ui.createMessage("Hy boy"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    
    public void clickCavern(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "enter", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookCavern();
             
        });
        
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             enterCavern();
             
        });
        
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoNothingCavern();
             
        });
    }
    
    
    public void lookCavern(){
        gm.ui.createMessage("it's a dark cavern"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void enterCavern(){
        if(gm.user.possiediTorcia==true){
            followingScene();
        }else{
        gm.ui.createMessage("the cavern is too dark to enter \n (i must enter to continue my journey)"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        }
    }
    
    public void DoNothingCavern(){
        gm.ui.createMessage("fiuuuuuuuu......fiuuuuu...."); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    
    public void clickFire(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "Take", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookFire();
             
        });
        
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             takeFire();
             gm.user.hasTorch();
             
        });
        
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoNothingFire();
             
        });
    }
    
    
    public void lookFire(){
        gm.ui.createMessage("it's a Bonfire"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void takeFire(){
        
        gm.ui.createMessage("You obtein a torch"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void DoNothingFire(){
        gm.ui.createMessage("(maybe i can light up the cavern)"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    
    
    
     public void musicScenario() {
       try {File file=new File("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\musica\\musicaProva2.wav");
        AudioInputStream audioStream=AudioSystem.getAudioInputStream(file);
         clip=AudioSystem.getClip();
        clip.open(audioStream);
        
        
        
        if(gm.numeroScenario==2){
            gm.ev1.clip.stop();
       clip.start();
        }else{
            clip.stop();
        }
       
       } catch( Exception e ){
           System.out.println("imposibile prelevare audio");
       }
    }
    
    
    public void followingScene(){
       
            gm.sc.showScenario3();
           
      
//        
        
    }    
    
        
    
}
