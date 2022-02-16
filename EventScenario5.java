/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import javafx.event.EventType;
import javafx.scene.control.Button;

/**
 *
 * @author Utente
 */
public class EventScenario5 {
    GameManager gm;
    
     public String oggettoScenario;
   public String[] actions;
   public String[] consequences;
    
    public int contaClick=1;
    boolean fineDiscorso;
    
    public Button choice1=new Button("I want to save the princess");
    public Button choice2=new Button("I want to save a friend");
    
    
    public EventScenario5(GameManager gm){
        this.gm=gm;
    }
    
     public EventScenario5(String oggettoScenario,String[] actions,String[] consequences){
        this.oggettoScenario=oggettoScenario;
        this.actions=actions;
        this.consequences=consequences;
    }
    
    public void clickElf(){
         gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "Talk", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookElf();
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             if(contaClick==1){
            talkElf();
             } else if(contaClick==2){
                 talkElf2();
             } else if(contaClick==3){
                 talkElf3();
             } else if(contaClick==4){
                 talkElf4();
             } else if(contaClick==5){
                 talkElf5();
             } else if(contaClick==6){
                 talkElf6();
             } else if(contaClick==7){
                 talkElf7();
             } else if(contaClick==8){
                 talkElf8();
             } else if(contaClick==9){
                 talkElf9();
             } else if(contaClick>9){
                 talkElf10();
             } 
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoNothingElf();
             
        });
     }
     
     public void lookElf(){
        gm.ui.createMessage("She looks like an elf, it's impossibile \n i believe that the elf was only a legend");
        gm.rootManager.getChildren().add(gm.ui.la);
     }
     
     public void talkElf(){
        gm.ui.createMessage("What are you doing in this forest? \n aswer me, at this distance i don't fail the shot \n believe me!!");
        gm.rootManager.getChildren().add(gm.ui.la);
        
        contaClick++;
       
     }
     
     public void talkElf2(){
        gm.ui.createMessage("Choose carefully your last word...");
        gm.rootManager.getChildren().add(gm.ui.la);
        choice1.setLayoutX(500);
        choice1.setLayoutY(930);
        choice2.setLayoutX(800);
        choice2.setLayoutY(930);
         gm.rootManager.getChildren().addAll(choice1,choice2);
         choice1();
         choice2();
     }
     
     public void talkElf3(){
         gm.rootManager.getChildren().removeAll(choice1,choice2);
        gm.ui.createMessage("So.. you are his childhood friend \n she told me about you.. \n only tyou could risk your life to save my sister");
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
     }
     
     public void talkElf4(){
         gm.ui.createMessage("(I don't know she have a sister she never menzioned you) \n I not surprised about this, we are stepsisters \n and because of my elf blood we were separeted \n when we was young ");
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
     }
     
     public void talkElf5(){
        gm.ui.createMessage("you know that the elf are hated in all kingdom \n i tried to oppose with all my strenght \n about our separation \n but your dear princess don't move a single finger ");
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
     }
     
     public void talkElf6(){
        gm.ui.createMessage("From this day i didn't wan't to know anything \n and i refused me in this forest \n (i'm very sorry about your story ) \n (but i must found the princess help me)");
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
     }
     
     public void talkElf7(){
        gm.ui.createMessage("Yes, i know..he was like that even as a child, \n he had all eyes on her \n restore your life whit this potion ");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.aggiungiVita();
        contaClick++;
     }
     
      public void talkElf8(){
        gm.ui.createMessage("You must must arrive to the sea behind this forest \n and accross the sea, it is said that \n the princess was taken to a volcano");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.aggiungiVita();
       contaClick++;
     }
      
       public void talkElf9(){
        gm.ui.createMessage("a last things...the force you challenge \n is out of your reach \n take this magic formula,cna be useful)");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.aggiungiVita();
       contaClick++;
     }
       
        public void talkElf10(){
        gm.ui.createMessage("(Thank you really... i hope you forgive \n your sister one day) \n i know she take car about you");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.aggiungiVita();
        fineDiscorso=true;
       
     }
       
     
     
     
     
     public void DoNothingElf(){
         
     }
     
     
     
     public void choice1(){
         choice1.setOnAction(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             gm.ui.createMessage("The princess? Whi do you want to save the princess? \n (Because she is my fried and she is in danger)");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClick++;
             choice2.setDisable(true);
         });
     }
     
     public void choice2(){
         choice2.setOnAction(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             gm.ui.createMessage("Wrong answer , i'm not intestered in your business");
             gm.rootManager.getChildren().add(gm.ui.la);
             gm.user.elimina2Vita();
             gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\arrow1.wav");
             //choice1.setDisable(true);
         });
     }
     
     public void followingScene(){
         gm.ui.changeRight.setOnAction(event->{
             if(fineDiscorso==true){
                 gm.sc.showScenario6();
             }
         });
     }
}
