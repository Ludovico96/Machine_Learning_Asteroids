/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.sound.sampled.Clip;
import javax.swing.SwingWorker;

/**
 *
 * @author Utente
 */
public class EventScenario3 {
    GameManager gm;
    
   public String oggettoScenario;
   public String[] actions;
   public String[] consequences;
   public int contaViteLupo=3;
   public int attaccoCasualeNemico;
   public boolean deathWolf;
    
    //public int contaClick=1;
    
    
    //public Clip clip;
    
    public EventScenario3(GameManager gm){
        this.gm=gm;
    }
    
    public EventScenario3(String oggettoScenario,String[] actions,String[] consequences){
        this.oggettoScenario=oggettoScenario;
        this.actions=actions;
        this.consequences=consequences;
    }
    
    public void clickWolf(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("Look", "Attack", "Run");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookWolf();
             
        });
        
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             attackWolf();
             
             
        });
        
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             runWolf();
             
        });
    }
    
    
    public void lookWolf(){
        if(deathWolf==false){
        gm.ui.createMessage("it's an angry wolf \n the old man lied to me "); 
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\wolfGrowl2.wav");
        } else{
            
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("The wolf is dead \n (Finally, i can go now, \n i must find an exit)"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        }
    }
    
    public void attackWolf(){
        if(deathWolf==false){
        attaccoCasualeNemico=(int) (Math.random()*4);
        if(gm.user.possiediSpada==true && gm.user.possiediScudo==false){
            gm.ui.createMessage("You hurt the wolf \n The wolf bite you");
             gm.rootManager.getChildren().add(gm.ui.la);
             gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\swordKill.wav");
             gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\wolfAttack.wav");
            if(contaViteLupo==1){
                gm.rootManager.getChildren().remove(gm.ui.la);
                gm.ui.createMessage("You defeat the wolf");
                gm.rootManager.getChildren().add(gm.ui.la);
                deathWolf=true;
                gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\wolfHowl.wav");
            }else {
             gm.user.eliminaVita();
             contaViteLupo--;
           
            }
        } else if(gm.user.possiediSpada==true && gm.user.possiediScudo==true){
            if(attaccoCasualeNemico<2){
                gm.ui.createMessage("You hurt the wolf \n The wolf bite you");
             gm.rootManager.getChildren().add(gm.ui.la);
             gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\swordKill.wav");
             gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\wolfAttack.wav");
            if(contaViteLupo==1){
                gm.rootManager.getChildren().remove(gm.ui.la);
                gm.ui.createMessage("You defeat the wolf");
                gm.rootManager.getChildren().add(gm.ui.la);
                deathWolf=true;
                gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\wolfHowl.wav");
            }else {
             gm.user.eliminaVita();
             contaViteLupo--;
           
            }
            } else{
                gm.ui.createMessage("You hurt the wolf \n You parry the wolf's attack");
             gm.rootManager.getChildren().add(gm.ui.la);
             gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\swordKill.wav");
             if(contaViteLupo==1){
                 gm.rootManager.getChildren().remove(gm.ui.la);
                gm.ui.createMessage("You defeat the wolf");
                gm.rootManager.getChildren().add(gm.ui.la);
                deathWolf=true;
                gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\wolfHowl.wav");
            }
             contaViteLupo--;
             
            }
        } else if(gm.user.possiediSpada==false && gm.user.possiediScudo==false){
            gm.ui.createMessage(" The wolf bite you");
            gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\wolfAttack.wav");
             gm.rootManager.getChildren().add(gm.ui.la);
              gm.user.eliminaVita();
        }
      
    }else{
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("The wolf is dead \n (Finally, i can go now, \n i must find an exit)"); 
        
        gm.rootManager.getChildren().add(gm.ui.la);
        }
        
        
       
        System.out.println(deathWolf);
    }
    
    
   
    public void runWolf(){
        if(deathWolf==false){
        gm.ui.createMessage("the wolf bite you \n (i can't run, i must fight it)"); 
        gm.user.eliminaVita();
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\wolfAttack.wav");
        }else{
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("The wolf is dead \n (Finally, i can go now, \n i must find an exit)"); 
        
        gm.rootManager.getChildren().add(gm.ui.la);
        }
    }
    
    
    public void clickBody(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("Look", "Take", "DoNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookBody();
             
        });
        
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             takeBody();
             
             
        });
        
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             doNothingBody();
             
        });
    }
    
    public void lookBody(){
        gm.ui.createMessage("(it's a corpe..maybe a knight \n  the wolf might have surprised and  killed him)");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
     public void takeBody(){
        if(gm.user.possiediScudo==false && gm.ev3.deathWolf==true){
        gm.ui.createMessage("(it's a corpe..\n  the wolf might have killed him) \n you obtein a shield");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.hasShield();
        }
    }
     
      public void doNothingBody(){
        gm.ui.createMessage("...");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
      
      public void followingScene(){
          
           
          
             gm.ui.changeRight.setOnMouseClicked(event->{
                 if(deathWolf==true){
                     gm.sc.showScenario4();
                 } else {
                     gm.rootManager.getChildren().remove(gm.ui.la);
                     gm.ui.createMessage("(I can't escape)");
                     gm.rootManager.getChildren().add(gm.ui.la);
                 }
                
             });
           
             
        
      /*else if(deathWolf==true){
          gm.ui.changeRight.setOnAction(event->{
                 gm.sc.showScenario4();
             });
      }*/
      }
    
    
} 




