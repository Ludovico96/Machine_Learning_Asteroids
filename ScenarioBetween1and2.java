/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

/**
 *
 * @author Utente
 */
public class ScenarioBetween1and2 {
    public GameManager gm;
    
   
    public Group root;
    public ImageView valle;
    
  
    

    
    
    public ScenarioBetween1and2(GameManager gm){
        this.gm=gm;
    }
    
    public void creaScenario(){
       // gm.numeroScenario=1;
        valle=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\valle.jpg");
        gm.ui.createButtonChangeScene();
        
        
        root=new Group(valle,gm.ui.changeRight);
        
    }
    
    public void setAction(){
        valle.setOnMouseClicked(event->{
            gm.ev12.clickValle();
        });
        
        gm.ev12.followingScene();
        
        //gm.ev12.precedingScene();
        
      //  gm.ui.createMusic("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\ambientForest.wav");
        //gm.ev12.musicScenario();
    }
}
