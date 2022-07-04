
package progettovideogioco;


import java.util.Date;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


public class SestoScenario {
    GameManager gm;
    
    Group root;
    private ImageView forestaZoom;
    private ImageView womanElf;
    
    private int contaClick=1;
    private boolean fineDiscorso;
    
    
   
    private final Button choice1=new Button("I want to save the princess");
    private final Button choice2=new Button("I want to save a friend");
    
    
    
   
    
    public SestoScenario(GameManager gm){
        this.gm=gm;
    }
    
   
     //Creazione scenario
      public void creaScenario(){
        gm.numeroScenario=6;
        forestaZoom=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\forestaZoom.jpg");
        womanElf=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\elf.png", 250, 250, 450, 440);
        gm.ui.createButtonChangeScene();
        
        root=new Group(forestaZoom,womanElf,gm.ui.changeRight);
       
         if(gm.iniziaNuovaPartita==true){
           contaClick=1;
           fineDiscorso=false;
       }
    }
    
      //Setta azioni
    public void setAction(){
        
        womanElf.setOnMouseClicked(event->{
            clickElf();
        });
        
        followingScene();
        
    }
    
   //Specifica azioni
    public void clickElf(){
         gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "Talk", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookElf();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookElf");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
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
             } else if(contaClick>8){
                 talkElf9();
             }
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"talkElf");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoNothingElf();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingElf");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
     }
     
     public void lookElf(){
        gm.ui.createMessage("(She looks like an elf, it's impossibile \n i believe that the elf was only a legend)");
        gm.rootManager.getChildren().add(gm.ui.la);
     }
     
     public void talkElf(){
        gm.ui.createMessage("Elf:What are you doing in this forest? \n aswer me, at this distance i don't fail the shot \n believe me!!");
        gm.rootManager.getChildren().add(gm.ui.la);
        
        contaClick++;
         
     }
     
     public void talkElf2(){
        gm.ui.createMessage("Elf:Choose carefully your last word...");
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
        gm.ui.createMessage("Elf:So.. you are his childhood friend \n she told me about you.. \n only tyou could risk your life to save my sister");
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
     }
     
     public void talkElf4(){
         gm.ui.createMessage("Me:I don't know she have a sister she never menzioned you \n Elf:I not surprised about this, we are stepsisters \n and because of my elf blood we were separeted \n when we was young ");
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
     }
     
     public void talkElf5(){
        gm.ui.createMessage("Elf:you know that the elf are hated in all kingdom \n i tried to oppose with all my strenght \n about our separation \n but your dear princess don't move a single finger ");
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
     }
     
     public void talkElf6(){
        gm.ui.createMessage("Elf:From that day i didn't wan't to know anything \n and i refused me in this forest \n Me:i'm very sorry about your story  \n but i must found the princess,she's in danger");
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
     }
     
     public void talkElf7(){
        gm.ui.createMessage("Elf:Yes, i know..he was like that even as a child, \n he had all eyes on her \n ");
        gm.rootManager.getChildren().add(gm.ui.la);
        
        contaClick++;
     }
     
      public void talkElf8(){
        gm.ui.createMessage("Elf:You must arrive to the sea behind this forest \n and accross the sea, it is said that \n the princess was taken to a volcano");
        gm.rootManager.getChildren().add(gm.ui.la);
       
       contaClick++;
     }
      
       public void talkElf9(){
        gm.ui.createMessage("Elf:a last things...the force you challenge \n is out of your reach \n restore your life with this potion");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.aggiungi2Vita();
       
       fineDiscorso=true;
     }
       
      
       
     
     
     
     
     public void DoNothingElf(){
         
     }
     
     
     
     public void choice1(){
         choice1.setOnAction(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             gm.ui.createMessage("Elf:The princess? Why do you want to save the princess? \n Me:Because she is my fried and she is in danger");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClick++;
             gm.rootManager.getChildren().removeAll(choice1,choice2);
         });
     }
     
     public void choice2(){
         choice2.setOnAction(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             gm.ui.createMessage("Elf:Wrong answer , i'm not intestered in your business");
             gm.rootManager.getChildren().add(gm.ui.la);
             gm.user.elimina2Vita();
             
            
             
         });
     }
     
     public void followingScene(){
         gm.ui.changeRight.setOnAction(event->{
             if(fineDiscorso==true){
                 gm.rootManager.getChildren().remove(root);
                 contaClick=1;
                 fineDiscorso=false;
                  gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario7");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
                 gm.sc.showScenario7();
             }
         });
     }
   
}
