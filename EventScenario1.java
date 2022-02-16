/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import javafx.scene.layout.VBox;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 *
 * @author Utente
 */
public class EventScenario1 {
    
   public GameManager gm;
   
   
   public String oggettoScenario;
   public String[] actions;
   public String[] consequences;
   
   
   public int contaClick=1;
   public boolean death;
   
   public Clip clip;
   
    
    public EventScenario1(GameManager gm){
        this.gm=gm;
    }
    
    public EventScenario1(String oggettoScenario,String[] actions,String[] consequences){
        this.oggettoScenario=oggettoScenario;
        this.actions=actions;
        this.consequences=consequences;
    }
    
    public void clickHouse(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "enter", "takeFood");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookHouse();
        });
        
       gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            enterHouse();
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
           doNothingHouse();
        });
        
    }
    
    public void lookHouse(){
        gm.ui.createMessage("It's your home"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void enterHouse(){
        gm.ui.createMessage("you find a picture about you \n and a girl with blue eyes");
        gm.rootManager.getChildren().add(gm.ui.la);
        //gm.user.hasSword();
        
    }
    
    public void doNothingHouse(){
        gm.ui.createMessage("you eat and your \n life recoverd");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.aggiungiVita();
    }
    
    public void clickKnight(){
       
       gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("Look", "Talk", "Attack");
         gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookKnight();
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookKnight");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
        });
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"talkKnight");
             gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
            
            if(death==true){
               talkKnightDead();//fare una cache sulla morte dei personaggi
               
                
            }else{
            
            if(contaClick==1){
               talkKnight();
               contaClick++;
            
            }else if(contaClick==2){
                talkKnight2();
                contaClick++;
            }else if(contaClick==3){
                talkKnight3();
                contaClick++;
            }else if(contaClick==4){
                talkKnight4();
               
            }
             
            }
            
            
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
           attackKnight();
           gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"attackKnight");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);

        });
    }
    
    public void lookKnight(){
       gm.ui.createMessage("It's a knight"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void talkKnight(){
        gm.ui.createMessage("Stranger, i'm  Rodrick \n the first knight of the court"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void talkKnight2(){
        gm.ui.createMessage("we are communicating to the people that \n the princess Arya of our kingdom is missing"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void talkKnight3(){
        gm.ui.createMessage("anyone who wants to join the cause \n to find her is welcome  \n and will receive my eternal gratitude"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        
        
    }
    
     public void talkKnight4(){
        gm.ui.createMessage("if you want to face this journey I have brought \n you something that you will need for the journey \n open the chest to find out"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        
        
    }
    
    public void talkKnightDead(){
        gm.ui.createMessage("The knight is dead"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void attackKnight(){
       
        
        if(gm.user.possiediSpada==true){
            //death=true;
            gm.ui.createMessage("You defeat the knight \n and you obtein his shield");
             gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\swordKill.wav");
             if(death==false){
                  
             gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\deathWarrior.wav");
//             gm.ui.music.stop();
             gm.user.hasShield();
             }
             death=true;
             gm.rootManager.getChildren().add(gm.ui.la);
        } else {
             gm.user.eliminaVita();
              gm.ui.createMessage("You fool!, i want to talk \n listen to me");
              gm.rootManager.getChildren().add(gm.ui.la);
        }
                
    }
    
    public void clickChest(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "open", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookChest();
        });
        
       gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            openChest();
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
           doNothingChest();
        });
    }
    
    
    public void lookChest(){
        gm.ui.createMessage("It's a chest"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void openChest(){
        gm.ui.createMessage("You obtein a sword"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.hasSword();
    }
    
    public void doNothingChest(){
        gm.ui.createMessage("(I should open it)"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    
    
    public void musicScenario() {
       try {File file=new File("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\musica\\musicaProva.wav");
        AudioInputStream audioStream=AudioSystem.getAudioInputStream(file);
         clip=AudioSystem.getClip();
        clip.open(audioStream);
        
        
        
        if(gm.numeroScenario==1){
            if(gm.ev1.death==true){
            gm.ev1.clip.stop();
           
        }else{
       clip.start();
            }
        }else{
            clip.stop();
        }
       
       } catch( Exception e ){
           System.out.println("imposibile prelevare audio");
       }
    }
    
    
    
    public void followingScene(){
        gm.ui.changeRight.setOnAction(event->{
            gm.sc.showScenarioBetween1and2();
            
           // gm.ias.inviaCambioScenario();
            
        });
    }
    
   
    
}
