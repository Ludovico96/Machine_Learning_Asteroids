
package progettovideogioco;


import java.util.Date;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class DodicesimoScenario {
    GameManager gm;
    
   
    Group root;
    private ImageView beforeVolcano;
    private ImageView magician;
    private ImageView magicPortal;
    private ImageView fire;
    
    private int contaClick=1;
    
   
    
    
    public DodicesimoScenario(GameManager gm){
        this.gm=gm;
    }
    
    //Creazione scenario
    public void creaScenario(){
        gm.numeroScenario=12;
        beforeVolcano=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\beforeVolcano.png");
        magician=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\magician.png", 300, 300, 200, 350);
        magicPortal=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\spirale.png", 300, 300, 500, 350);
        fire=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\fireSpell.png", 100, 100, 200, 350);

        
        gm.ui.createButtonChangeScene();
        fire.setVisible(false);
        
        root=new Group(beforeVolcano,magician,fire,gm.ui.changeRight);
       
        if(gm.iniziaNuovaPartita==true){
           contaClick=1;
           
       }
    }
    
    //Settaggio azioni
    public void setAction(){
       beforeVolcano.setOnMouseClicked(event->{
          clickVolcano();
       });
       
       magician.setOnMouseClicked(event->{
          clickMagician();
       });
       
       magicPortal.setOnMouseClicked(event->{
          clickPortal();
       });
    }
    
    //Specifica azioni
   public void clickVolcano(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
          gm.rootManager.getChildren().remove(gm.ui.la);
          lookVolcano();
           gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookVolcano");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
     }
     
     public void lookVolcano(){
         gm.ui.createMessage("Me:Finally the storm bring me \n to the island with the Volcano \n Arya must be breinged there \n i must move there is still \n a long way to go");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
     
     public void clickMagician(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "talk", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookMagician();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookMagician");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        
       gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            if(contaClick==1){
            talkMagician();
            }else if(contaClick==2){
            talkMagician2();
            }else if(contaClick==3){
            talkMagician3();
            }else if(contaClick==4){
            talkMagician4();
            }else if(contaClick==5){
            talkMagician5();
            }else if(contaClick==6){
            talkMagician6();
            }else if(contaClick==7){
            talkMagician7();
            }else if(contaClick>7){
            talkMagician8();
            }
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"talkMagician");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
           doNothingMagician();
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingMagician");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
     }
     
     public void lookMagician(){
         gm.ui.createMessage("(And now???..Who is this old man?)");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
     public void talkMagician(){
         gm.ui.createMessage("Magician:prepare yourself!!");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
     }
      public void talkMagician2(){
         gm.ui.createMessage("Me:wait!!! what???");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
     }
      
       public void talkMagician3(){
         gm.ui.createMessage("Magician::SHIELD UPPPP!!!!");
         gm.rootManager.getChildren().add(gm.ui.la);
        fire.setVisible(true);
        ScaleTransition scaleTransition = 
            new ScaleTransition(Duration.millis(2000), fire);
        scaleTransition.setToX(2.5f);
        scaleTransition.setToY(2.5f);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);
        
        FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(3000), fire);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
        
       SequentialTransition sequentialTransition = new SequentialTransition();
sequentialTransition.getChildren().addAll(
         scaleTransition,
        fadeTransition
       );
sequentialTransition.setCycleCount(1);
sequentialTransition.setAutoReverse(true);

sequentialTransition.play();
         
         contaClick++;
         gm.user.elimina2Vita();
     }
        public void talkMagician4(){
         gm.ui.createMessage("Magician::So...how i can exspect your shield \n can't resiste to the the magic of fire \n but you survived and that's is enough");
         gm.rootManager.getChildren().add(gm.ui.la);
         
         contaClick++;
     }
        
         public void talkMagician5(){
         gm.ui.createMessage("Me:What are you saying \n you are crazy old man \n i kill you now \n i don't have any time, i must...");
         gm.rootManager.getChildren().add(gm.ui.la);
         
         contaClick++;
     }
         
         public void talkMagician6(){
         gm.ui.createMessage("Magician:save the princess.. i know \n but i test your preparation and you \n are not ready for what attend you \n in these volcano");
         gm.rootManager.getChildren().add(gm.ui.la);
         
         contaClick++;
     }
         
         public void talkMagician7(){
         gm.ui.createMessage("Magician:Take this magic formula is the only thing \n that could save you  it can create portal \n that reflect magic fire,but remember you are not  \n a magician, you can use this only two times");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.user.hasMagic();
         contaClick++;
     }
         
          public void talkMagician8(){
         gm.ui.createMessage("Magician:I want to help you, the princess is necessary to \n the kingdom. I bring you directly to the Volcano \n enter in this magic portal");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.rootManager.getChildren().add(magicPortal);
         RotateTransition rotateTransition = 
            new RotateTransition(Duration.millis(100), magicPortal);
        rotateTransition.setByAngle(360f);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();
         contaClick++;
     }
         
         
     
     
     public void doNothingMagician(){
         gm.ui.createMessage("...");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
     
     public void clickPortal(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "enter", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookPortal();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookPortal");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        
       gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            enterPortal();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"enterPortal");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
           doNothingPortal();
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingPortal");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
     }
     
     public void lookPortal(){
         gm.ui.createMessage("Me:wow..really a magic portal? \n really i can arrive to the volcano in this way? ");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
     public void enterPortal(){
         gm.ui.createMessage(" Me:.... let's do this \n Arya wait me.. i'm here!");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.rootManager.getChildren().remove(root);
         contaClick=1;
         gm.sc.showScenario13();
         gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario13");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
           gm.user.aggiungi2Vita();
     }
     
     public void doNothingPortal(){
         gm.ui.createMessage("(Should i trust the magician?)");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
}
