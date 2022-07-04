
package progettovideogioco;


import java.util.Date;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class QuartoScenario {
    GameManager gm;
   
   
    Group root;
    private ImageView cavernaInterno;
    private ImageView lupo;
    private ImageView corpo;
    
    
    
    private int contaViteLupo=3;
    private int attaccoCasualeNemico;
    private boolean deathWolf;
    
   
    
    public QuartoScenario(GameManager gm){
        this.gm=gm;
    }
    
    
    
    public void creaScenario(){
        gm.numeroScenario=4;
        cavernaInterno=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cavernaInterno.png");
        lupo=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\lupo.png", 300, 300, 400, 400);
        corpo=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\corpo2.png", 200, 200, 800, 350);
        gm.ui.createButtonChangeScene();
        
        root=new Group(cavernaInterno,lupo,corpo,gm.ui.changeRight);
       
        if(gm.iniziaNuovaPartita==true){
           contaViteLupo=3;
           deathWolf=false;
       }
        

    }
    
    public void setAction(){
        lupo.setOnMouseClicked(event->{
            clickWolf();
        });
        
        corpo.setOnMouseClicked(event->{
           clickBody();
        });
        
         cavernaInterno.setOnMouseClicked(event->{
            gm.rootManager.getChildren().removeAll(gm.ui.actionVbox,gm.ui.la);
            

        });
         
       followingScene();
         
    }
    
     public void clickWolf(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("Look", "Attack", "Run");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookWolf();
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookWolf");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             attackWolf();
             
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"attackWolf");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             runWolf();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"runWolf");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
    }
    
    
    public void lookWolf(){
        if(deathWolf==false){
        gm.ui.createMessage("Me:it's an angry wolf \n the old man lied to me "); 
        gm.rootManager.getChildren().add(gm.ui.la);
        } else{
            
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("The wolf is dead \n Me:Finally, i can go now, \n i must find an exit"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        }
    }
    
    public void attackWolf(){
        if(deathWolf==false){
        attaccoCasualeNemico=(int) (Math.random()*4);
        if(gm.user.possiediSpada==true && gm.user.possiediScudo==false){
            gm.ui.createMessage("You hurt the wolf \n The wolf bite you");
             gm.rootManager.getChildren().add(gm.ui.la);
            if(contaViteLupo==1){
                gm.rootManager.getChildren().remove(gm.ui.la);
                gm.ui.createMessage("You defeat the wolf");
                gm.rootManager.getChildren().add(gm.ui.la);
                deathWolf=true;
            }else {
             gm.user.eliminaVita();
             contaViteLupo--;
           
            }
        } else if(gm.user.possiediSpada==true && gm.user.possiediScudo==true){
            if(attaccoCasualeNemico<2){
                gm.ui.createMessage("You hurt the wolf \n The wolf bite you");
             gm.rootManager.getChildren().add(gm.ui.la);
          
            if(contaViteLupo==1){
                gm.rootManager.getChildren().remove(gm.ui.la);
                gm.ui.createMessage("You defeat the wolf");
                gm.rootManager.getChildren().add(gm.ui.la);
                deathWolf=true;
            }else {
             gm.user.eliminaVita();
             contaViteLupo--;
           
            }
            } else{
                gm.ui.createMessage("You hurt the wolf \n You parry the wolf's attack");
             gm.rootManager.getChildren().add(gm.ui.la);
             if(contaViteLupo==1){
                 gm.rootManager.getChildren().remove(gm.ui.la);
                gm.ui.createMessage("You defeat the wolf");
                gm.rootManager.getChildren().add(gm.ui.la);
                deathWolf=true;
            }
             contaViteLupo--;
             
            }
        } else if(gm.user.possiediSpada==false && gm.user.possiediScudo==false){
            gm.ui.createMessage(" The wolf bite you");
             gm.rootManager.getChildren().add(gm.ui.la);
              gm.user.eliminaVita();
        }
        
        TranslateTransition translateTransition =
         new TranslateTransition(Duration.millis(100), lupo);
        translateTransition.setFromY(0);
        translateTransition.setToY(50);
        translateTransition.setCycleCount(8);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
      
    }else{
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("The wolf is dead \n Me:Finally, i can go now, \n i must find an exit"); 
        
        gm.rootManager.getChildren().add(gm.ui.la);
        }
        
        
       
       
    }
    
    
   
    public void runWolf(){
        if(deathWolf==false){
        gm.ui.createMessage("the wolf bite you \n (i can't run, i must fight it)"); 
        gm.user.eliminaVita();
        gm.rootManager.getChildren().add(gm.ui.la);
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
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookBody");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             takeBody();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"takeBody");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             doNothingBody();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingBody");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
    }
    
    public void lookBody(){
        gm.ui.createMessage("(it's a corpe..maybe a knight \n  the wolf might have surprised and  killed him)");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
     public void takeBody(){
        if(gm.user.possiediScudo==false && deathWolf==true){
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
                     
                      gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario5");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
                     gm.rootManager.getChildren().remove(root);
                     gm.sc.showScenario5();
                     contaViteLupo=3;
                     deathWolf=false;
                 } else {
                     gm.rootManager.getChildren().remove(gm.ui.la);
                     gm.ui.createMessage("Me:I can't escape");
                     gm.rootManager.getChildren().add(gm.ui.la);
                 }
                 
                
             });
    
      }
    
    
    
    
    
}
