
package progettovideogioco;


import java.util.Date;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javax.sound.sampled.Clip;


public class OttavoScenario {
    GameManager gm;
    
   
    Group root;
    private ImageView mare;
    private ImageView nave;
    private ImageView nuvola;
    private ImageView nuvola1;
    private ImageView nuvola2;
    private ImageView nuvola3;
    private ImageView nuvola4;
    private ImageView flash;
     
    
     
    private boolean fineDiscorso;
   
    
    public OttavoScenario(GameManager gm){
        this.gm=gm;
    }
    
    //Creazione scenario
    public void creaScenario(){
        gm.numeroScenario=8;
        mare=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\mare2.jpg");
        nave=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nave.png", 450, 450, 350, 150);
        nuvola=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nuvolaReale.png", 500, 500, -80, -100);
        nuvola1=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nuvolaReale.png", 500, 500, 160, -100);
        nuvola2=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nuvolaReale.png", 500, 500, 320, -100);
        nuvola3=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nuvolaReale.png", 500, 500, 540, -100);
        nuvola4=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nuvolaReale.png", 500, 500, 720, -100);
        flash=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\bianco.png");
        
        
        gm.ui.createButtonChangeScene();
        
        root=new Group(mare,flash,nuvola,nuvola1,nuvola2,nuvola3,nuvola4,nave,gm.ui.changeRight);
       
        flash.setVisible(false);
        
         if(gm.iniziaNuovaPartita==true){
           
           fineDiscorso=false;
       }
    }
    
    //Settaggio azioni
    public void setAction(){
        
        nave.setOnMouseClicked(event->{
           clickShip();
        });
        
        followinScene();
       
    }
    
    //Specifica azioni
    public void clickShip(){
         gm.rootManager.getChildren().remove(gm.ui.actionVbox);
          gm.rootManager.getChildren().remove(gm.ui.la);
          talkShip();
           gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"talkShip");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
     }
     
     public void talkShip(){
         gm.ui.createMessage("Me:Damn!! The weather got worse too fast \n it's not normal.. the ship will not resist too long \n to the storm");
         gm.rootManager.getChildren().add(gm.ui.la);
         fineDiscorso=true;
         effettiSpeciali();
     }
     
     public void effettiSpeciali(){
         flash.setVisible(true);
         FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(100), flash);
        fadeTransition.setFromValue(0.0f);
        fadeTransition.setToValue(1.0f);
        fadeTransition.setCycleCount(6);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
       
       
     }
     
     public void followinScene(){
         gm.ui.changeRight.setOnAction(event->{
             if(fineDiscorso==true){
                 fineDiscorso=false;
                 gm.rootManager.getChildren().remove(root);
                  gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario9");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             gm.sc.showScenario9();
             }
         });
     }
    
}
