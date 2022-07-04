
package progettovideogioco;

import java.util.Date;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.util.Duration;






public class PrimoScenario {
    
    private GameManager gm;
    private int contaClick=1;
    private boolean death;
   
    Group root;
    private ImageView bosco;
    private ImageView casa;
    private ImageView cavaliere;
    private ImageView baule;
    private TranslateTransition translateTransition;
    
    
    
     public PrimoScenario(GameManager gm){
        this.gm=gm;
    }
    
     //Creazione scenario
    public void creaScenario(){
        gm.numeroScenario=1;
        bosco=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\scenario1.png");
        casa=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\casa.png", 
                400, 400, 250, 300);
        cavaliere=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cavaliere.png", 170, 170, 660, 500);
        baule=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\baule.png", 100, 100, 890, 580);
        gm.ui.createButtonChangeScene();
        
        root=new Group(bosco,casa,cavaliere,baule,gm.ui.changeRight);
        
        if(gm.iniziaNuovaPartita==true){
            contaClick=1;
            death=false;
        }
        
          translateTransition =
            new TranslateTransition(Duration.millis(1000), cavaliere);
        translateTransition.setFromX(0);
        translateTransition.setToX(100);
        translateTransition.setCycleCount(Timeline.INDEFINITE);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
                    

        
    }
    
    //Settaggio azioni
    public void setAction() {
        
        
        casa.setOnMouseClicked(event->{
           clickHouse();
           
        });
        
        cavaliere.setOnMouseClicked(event->{
           clickKnight(); 
        });
        
        baule.setOnMouseClicked(event->{
            clickChest();
        });
        
      followingScene();
        
       
        
        bosco.setOnMouseClicked(event->{
            gm.rootManager.getChildren().removeAll(gm.ui.actionVbox,gm.ui.la);
            

        });
        
       
        
        
    }
    
    //Specifica azioni
    public void clickHouse(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "enter", "takeFood");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookHouse();
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookHouse");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
           
        });
        
       gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            enterHouse();
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"enterHouse");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
           
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
           doNothingHouse();
           gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingHouse");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        
    }
    
    public void lookHouse(){
        gm.ui.createMessage("It's your home"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        
       
    }
    
    public void enterHouse(){
        gm.ui.createMessage("you find a picture about you \n and a girl with blue eyes");
        gm.rootManager.getChildren().add(gm.ui.la);
        
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
            translateTransition.stop();
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"talkKnight");
             gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
            
            if(death==true){
               talkKnightDead();
               
                
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
        gm.ui.createMessage("Knight:Stranger, i'm  Rodrick \n the first knight of the court"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void talkKnight2(){
        gm.ui.createMessage("Knight:we are communicating to the people that \n the princess Arya of our kingdom is missing"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void talkKnight3(){
        gm.ui.createMessage("Knight:anyone who wants to join the cause \n to find her is welcome  \n and will receive my eternal gratitude"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        
        
    }
    
     public void talkKnight4(){
        gm.ui.createMessage("Knight:if you want to face this journey I have brought \n you something that you will need for the journey \n open the chest to find out"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        
        
    }
    
    public void talkKnightDead(){
        gm.ui.createMessage("The knight is dead"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void attackKnight(){
       
        
        if(gm.user.possiediSpada==true){
            
            gm.ui.createMessage("You defeat the knight \n and you obtein his shield");
             if(death==false){
                  

             gm.user.hasShield();
             translateTransition.stop();
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
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookChest");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        
       gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            openChest();
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"openChest");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
           doNothingChest();
           gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingChest");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
    }
    
    
    public void lookChest(){
        gm.ui.createMessage("It's a chest"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void openChest(){
        if(gm.user.possiediSpada==false){
        gm.ui.createMessage("You obtein a sword"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.hasSword();
        
        }
    }
    
    public void doNothingChest(){
        gm.ui.createMessage("(I should open it)"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    
    
   
    
    
    public void followingScene(){
        gm.ui.changeRight.setOnAction(event->{
          gm.rootManager.getChildren().remove(root);
          contaClick=1;
          death=false;
            gm.sc.showScenario3();
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario3");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
           
            
        });
    }
    
    
   
   
}
    
        
    
    
    
    
    
            

