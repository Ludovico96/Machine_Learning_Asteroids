
package progettovideogioco;


import java.util.Date;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class NonoScenario {
    GameManager gm;
    
   
    Group root;
    private ImageView underWater;
    private ImageView princess;
    
   
    
    private int contaClick=1;
    private boolean fineDiscorso;
    
   
    
    public NonoScenario(GameManager gm){
        this.gm=gm;
    }
    
   
    //Creazione scenario
    public void creaScenario(){
        gm.numeroScenario=9;
        underWater=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\underWater.jpg");
        princess=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\princessHead.png", 600, 600, 300, 100);
        
        
        
        gm.ui.createButtonChangeScene();
        
        root=new Group(underWater,gm.ui.changeRight);
       
         if(gm.iniziaNuovaPartita==true){
           contaClick=1;
           fineDiscorso=false;
       }
    }
    
    //Settaggio azioni
    public void setAction(){
        underWater.setOnMouseClicked(event->{
            clickUnderWater();
            
        });
        
        followingScene();
        
        lostWeapon();
        
    }
    
    //Specifica azioni
    public void lostWeapon(){
         gm.user.possiediFionda=false;
         gm.user.possiediScudo=false;
         gm.user.possiediSpada=false;
         gm.user.possiediTorcia=false;
         gm.rootManager.getChildren().removeAll(gm.user.spada,gm.user.scudo,gm.user.torcia,gm.user.fionda);
     }
     
     public void clickUnderWater(){
         gm.rootManager.getChildren().remove(gm.ui.actionVbox);
          gm.rootManager.getChildren().remove(gm.ui.la);
          if(contaClick==1){
              talkUnderWater();
          }else if(contaClick==2){
              talkUnderWater2();
          }else if(contaClick==3){
              talkUnderWater3();
          }else if(contaClick==4){
              talkUnderWater4();
          }else if(contaClick>4){
              talkUnderWater5();
          }
           gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"talkUnderWater");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
     }
     
     public void talkUnderWater(){
         gm.ui.createMessage("I'm drowning damn after everything \n I've been through really ends like this? ");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
     }
     
     public void talkUnderWater2(){
         gm.ui.createMessage("Arya.. , where are you?  ");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
         gm.rootManager.getChildren().add(princess);
         FadeTransition ft = new FadeTransition(Duration.millis(5000), princess);
        ft.setFromValue(0.2);
        ft.setToValue(0.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
     }
     
     public void talkUnderWater3(){
         gm.ui.createMessage("(It seems at the end i don't have \n the strength to save you )");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
     }
     
     public void talkUnderWater4(){
         gm.ui.createMessage("(No, i must fight, i can't surrender \n i will arrive Arya wait for me \n i'm really near)");
         //gm.ui.createMusic("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\musica\\musicaScenario10.wav");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
     }
     
     public void talkUnderWater5(){
         gm.ui.createMessage("(But first..i'm thinking about these shark)");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
         fineDiscorso=true;
     }
     
     public void followingScene(){
         gm.ui.changeRight.setOnAction(event->{
             if(fineDiscorso==true){
                 contaClick=1;
                 fineDiscorso=false;
                 gm.rootManager.getChildren().remove(root);
                  gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario10");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
                 gm.sc.showScenario10();
             }
         });
     }
}
