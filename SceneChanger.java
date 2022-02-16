/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Utente
 */
public class SceneChanger {
    public GameManager gm;
    
    SceneChanger(GameManager gm){
        this.gm=gm;
    }
    
    public void showGameOver(){
        
        gm.rootManager.getChildren().clear();
       // gm.ui.music.stop();//ECCEZIONE
        
        //gm.ui.clip.stop();
        //gm.ev1.clip.stop();
        
        gm.scenarioEnd.creaScenario();
        gm.rootManager.getChildren().add(gm.scenarioEnd.root);
        gm.scenarioEnd.setAction();
        gm.scenarioEnd.restartGame();
        
    }
    
    public void showScenario1PostGameOver(){
        
        gm.numeroScenario=1;
       gm.rootManager.getChildren().clear();
      
       gm.scenario1.setAction();
       
       gm.rootManager.getChildren().addAll(gm.scenario1.root,gm.ui.staticVbox);
       
       
       gm.user.LifePlayer();
    }
    
    public void showScenario1(){
        gm.numeroScenario=1;
        gm.rootManager.getChildren().clear();
//        gm.ui.music.stop();
        gm.scenario1.creaScenario();
        gm.rootManager.getChildren().addAll(gm.scenario1.root,gm.ui.staticVbox);
        gm.scenario1.setAction();
    }
    
    /*public void showScenario1Post2(){
        gm.numeroScenario=1;
     // gm.ui.clip.stop();
        
         gm.rootManager.getChildren().removeAll(gm.scenario2.root,gm.ui.staticVbox,gm.ui.changeLeft,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
         gm.scenario1.setAction();
         gm.rootManager.getChildren().addAll(gm.scenario1.root,gm.ui.staticVbox,gm.ui.changeRight);
    }*/
    
    
    public void showScenarioBetween1and2(){
      //  gm.ui.music.stop();
        gm.rootManager.getChildren().removeAll(gm.scenario1.root,gm.ui.staticVbox,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
       // gm.ev1.clip.stop();
        gm.scenarioBetween1.creaScenario();
         gm.scenarioBetween1.setAction();
         gm.rootManager.getChildren().addAll(gm.scenarioBetween1.root,gm.ui.staticVbox);
    }
    
   /* public void showScenarioBetween1and2post2(){
        gm.rootManager.getChildren().removeAll(gm.scenario2.root,gm.ui.staticVbox,gm.ui.changeLeft,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
       // gm.ev2.clip.stop();
        gm.scenarioBetween1.creaScenario();
         gm.scenarioBetween1.setAction();
         gm.rootManager.getChildren().addAll(gm.scenarioBetween1.root,gm.ui.staticVbox,gm.ui.changeLeft,gm.ui.changeRight);
    }*/
    
    public void showScenario2(){
       // gm.ui.music.stop();
         gm.numeroScenario=2;
        gm.rootManager.getChildren().removeAll(gm.scenarioBetween1.root,gm.ui.staticVbox,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        //gm.ui.clip.stop();
        gm.scenario2.creaScenario();
        gm.scenario2.setAction();
        gm.rootManager.getChildren().addAll(gm.scenario2.root,gm.ui.staticVbox);
        
        
    }
    
    public void showScenario3(){
       // gm.ui.music.stop();
         gm.numeroScenario=3;
        gm.rootManager.getChildren().removeAll(gm.scenario2.root,gm.ui.staticVbox,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        //gm.ui.clip.stop();
        gm.scenario3.creaScenario();
        gm.scenario3.setAction();
        //gm.scenario2.setAction();
        gm.rootManager.getChildren().addAll(gm.scenario3.root,gm.ui.staticVbox);
    }
    
    
    public void showScenario4(){
        gm.numeroScenario=4;
        gm.rootManager.getChildren().removeAll(gm.scenario3.root,gm.ui.staticVbox,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        gm.scenario4.creaScenario();
        gm.scenario4.setAction();
       
        gm.rootManager.getChildren().addAll(gm.scenario4.root,gm.ui.staticVbox);
    }
    
     public void showScenario5(){
         gm.numeroScenario=5;
        gm.rootManager.getChildren().removeAll(gm.scenario4.root,gm.ui.staticVbox,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        gm.scenario5.creaScenario();
        gm.scenario5.setAction();
       
        gm.rootManager.getChildren().addAll(gm.scenario5.root,gm.ui.staticVbox);
    }
     
     public void showScenario6(){
         gm.numeroScenario=6;
        gm.rootManager.getChildren().removeAll(gm.scenario5.root,gm.ui.staticVbox,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        gm.scenario6.creaScenario();
        gm.scenario6.setAction();
       
        gm.rootManager.getChildren().addAll(gm.scenario6.root,gm.ui.staticVbox);
    }
     
     public void showScenario7(){
         gm.numeroScenario=7;
        gm.rootManager.getChildren().removeAll(gm.scenario6.root,gm.ui.staticVbox,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        gm.scenario7.creaScenario();
        gm.scenario7.setAction();
       
        gm.rootManager.getChildren().addAll(gm.scenario7.root,gm.ui.staticVbox);
    }
     
     public void showScenario8(){
//         gm.ui.soundEffect.stop();
         gm.numeroScenario=8;
        gm.rootManager.getChildren().removeAll(gm.scenario7.root,gm.ui.staticVbox,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        gm.scenario8.creaScenario();
        gm.scenario8.setAction();
       
        gm.rootManager.getChildren().addAll(gm.scenario8.root,gm.ui.staticVbox);
    }
     
     public void showScenario9(){
//         gm.ui.soundEffect.stop();
         gm.numeroScenario=9;
        gm.rootManager.getChildren().removeAll(gm.scenario8.root,gm.ui.staticVbox,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        gm.scenario9.creaScenario();
        gm.scenario9.setAction();
       
        gm.rootManager.getChildren().addAll(gm.scenario9.root,gm.ui.staticVbox);
    }
     
     public void showScenario10(){
//         gm.ui.soundEffect.stop();
         gm.numeroScenario=10;
        gm.rootManager.getChildren().removeAll(gm.scenario9.root,gm.ui.staticVbox,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        gm.scenario10.creaScenario();
        gm.scenario10.setAction();
       
        gm.rootManager.getChildren().addAll(gm.scenario10.root,gm.ui.staticVbox);
    }
     
     public void showScenario11(){
//         gm.ui.soundEffect.stop();
         gm.numeroScenario=11;
        gm.rootManager.getChildren().removeAll(gm.scenario10.root,gm.ui.staticVbox,gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        gm.scenario11.creaScenario();
        gm.scenario11.setAction();
       
        gm.rootManager.getChildren().addAll(gm.scenario11.root,gm.ui.staticVbox);
    }
}
