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
        
        gm.rootManager[gm.numeroScenario].setVisible(false);
        gm.scenarioEnd.creaScenario();
        gm.rootManager[0].getChildren().add(gm.scenarioEnd.root);
        gm.rootManager[0].setVisible(true);
        gm.scenarioEnd.restartGame();
        

    }
    
    public void showScenario1(){
       gm.rootManager[gm.numeroScenario].setVisible(false);
       gm.rootManager[1].setVisible(true);
        
    }
    
    public void showScenario2(){
        
       gm.rootManager[gm.numeroScenario].setVisible(false);
        gm.scenario2.creaScenario();
        gm.scenario2.setAction();
        gm.rootManager[2].getChildren().addAll(gm.scenario2.root,gm.ui.staticVbox,gm.ui.changeLeft,gm.ui.changeRight);
        gm.rootManager[2].setVisible(true);
        
    }
}
