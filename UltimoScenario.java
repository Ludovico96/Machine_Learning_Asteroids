
package progettovideogioco;

import java.util.Date;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class UltimoScenario {
    
    GameManager gm;
    
    private ImageView tomb;
    private ImageView flower;
    private ImageView valleFinale;
    private ImageView black;
    
    private Label la;
    
    Group root;
    private int contaClick=1;
    
    public UltimoScenario(GameManager gm){
        this.gm=gm;
    }
    
     public void creaScenario(){
        gm.numeroScenario=14;
        black=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nero.png");
        valleFinale=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\valleFinale.jpg");
        tomb=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\tomba.png", 300, 300, 300, 300);
        flower=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\flower.png", 400, 400, 300, 290);
        
        
        valleFinale.setVisible(false);
        
        root=new Group(black,tomb,flower,valleFinale);
       
         if(gm.iniziaNuovaPartita==true){
              valleFinale.setVisible(false);
           contaClick=1;
       }
    }
    
    //Settaggio azioni
    public void setAction(){
        tomb.setOnMouseClicked(event->{
            ingrandisciOggetti();
        });
        
        valleFinale.setOnMouseClicked(event->{
            clickValle();
        });
    }
    
    public void ingrandisciOggetti(){
        FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(3000), tomb);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
        
        FadeTransition fadeTransition2 = 
            new FadeTransition(Duration.millis(3000), flower);
        fadeTransition2.setFromValue(1.0f);
        fadeTransition2.setToValue(0.0f);
        fadeTransition2.setCycleCount(1);
        fadeTransition2.setAutoReverse(true);
        
        valleFinale.setVisible(true);
        
        FadeTransition fadeTransition3 = 
            new FadeTransition(Duration.millis(7000), valleFinale);
        fadeTransition3.setFromValue(0.0f);
        fadeTransition3.setToValue(1.0f);
        fadeTransition3.setCycleCount(1);
        fadeTransition3.setAutoReverse(true);
        
         ScaleTransition scaleTransition = 
            new ScaleTransition(Duration.millis(3000), tomb);
        scaleTransition.setToX(2.5f);
        scaleTransition.setToY(2.5f);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(true);
        
         ScaleTransition scaleTransition2 = 
            new ScaleTransition(Duration.millis(3000), flower);
        scaleTransition2.setToX(2.5f);
        scaleTransition2.setToY(2.5f);
        scaleTransition2.setCycleCount(1);
        scaleTransition2.setAutoReverse(true);
        
       ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                scaleTransition
        );
        parallelTransition.setCycleCount(1);
        parallelTransition.play();
        
        ParallelTransition parallelTransition2 = new ParallelTransition();
        parallelTransition2.getChildren().addAll(
                fadeTransition2,
                scaleTransition2,
                fadeTransition3
                
        );
        parallelTransition2.setCycleCount(1);
        parallelTransition2.play();
        
        
        
    }
    
     public void clickValle(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.rootManager.getChildren().remove(gm.ui.la);
        
        
        if(contaClick==1){
             lookValley();
        }else if(contaClick==2){
             lookValley2();
        }else if(contaClick==3){
             lookValley3();
        }else if(contaClick==4){
             lookValley4();
        }else if(contaClick>4){
             lookValley5();
        }
       
         gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookValley");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
    }
    
    public void lookValley(){
        gm.ui.createMessage("Temeria:Do you think she likes to stay here forever?"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
    }
    
     public void lookValley2(){
        gm.ui.createMessage("Me:Sure...she loved this place"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
    }
     
     public void lookValley3(){
        gm.ui.createMessage("Me:knowing her she would not have liked \n large memorials but she would have \n remained close to loved ones"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
    }
     
     public void lookValley4(){
        gm.ui.createMessage("Temeria:how I wish I had more time to spend together.."); 
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
    }
     
     public void lookValley5(){
        gm.ui.createMessage("Me:I know...but moreover, here we will always carry \n the memory of that carefree little girl in our hearts"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
        theEnd();
        
    }
    
     public void theEnd(){
        
         la=new Label("THE END");
        la.setLayoutX(400);
        la.setLayoutY(400);
        la.setStyle("-fx-font-size: 50px;  -fx-text-fill: black");
        gm.rootManager.getChildren().add(la);
        
        FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(3000), la);
        fadeTransition.setFromValue(0.0f);
        fadeTransition.setToValue(1.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
     }
    
     
}
