/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;



import java.io.Serializable;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Utente
 */
public class Scenario1 implements Serializable{
    
    public GameManager gm;
    //public UI ui=new UI(gm);
   
    public Group root;
    public ImageView bosco;
    public ImageView casa;
    public ImageView cavaliere;
  
    
    
    public Scenario1(GameManager gm){
        this.gm=gm;
    }
    
    
    
    
    public void creaScenario(){
        gm.numeroScenario=1;
        bosco=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\scenario1.png");
        casa=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\casa.png", 
                400, 400, 250, 300);
        cavaliere=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cavaliere.png", 170, 170, 660, 500);
        
        root=new Group(bosco,casa,cavaliere);
        
    }
    
    public void setAction(){
        
        
        casa.setOnMouseClicked(event->{
            gm.ev1.clickHouse();
           
        });
        
        cavaliere.setOnMouseClicked(event->{
            gm.ev1.clickKnight(); 
        });
        
        
       gm.ev1.followingScene();
        
       
        
        bosco.setOnMouseClicked(event->{
            gm.rootManager[1].getChildren().removeAll(gm.ui.actionVbox,gm.ui.la);
            

        });
        
        
        
        
        
        
    }
}
    
        
    
    
    
    
    
            

