/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import javafx.scene.layout.VBox;

/**
 *
 * @author Utente
 */
public class EventScenario1 {
    
   public GameManager gm;
    
    public EventScenario1(GameManager gm){
        this.gm=gm;
    }
    
    public void clickHouse(){
        gm.rootManager[1].getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "takeWeapon", "takeFood");
        gm.rootManager[1].getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager[1].getChildren().remove(gm.ui.la);
            lookHouse();
        });
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager[1].getChildren().remove(gm.ui.la);
            takeHouse();
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager[1].getChildren().remove(gm.ui.la);
           doNothingHouse();
        });
        
    }
    
    public void lookHouse(){
        gm.ui.createMessage("It's your home"); 
        gm.rootManager[1].getChildren().add(gm.ui.la);
    }
    
    public void takeHouse(){
        gm.ui.createMessage("Take a sword ");
        gm.rootManager[1].getChildren().add(gm.ui.la);
        
    }
    
    public void doNothingHouse(){
        gm.ui.createMessage("you eat and your \n life recoverd");
        gm.rootManager[1].getChildren().add(gm.ui.la);
        gm.user.aggiungiVita();
    }
    
    public void clickKnight(){
       
       gm.rootManager[1].getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("Look", "Talk", "Attack");
         gm.rootManager[1].getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager[1].getChildren().remove(gm.ui.la);
            lookKnight();
        });
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager[1].getChildren().remove(gm.ui.la);
            talkKnight();
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager[1].getChildren().remove(gm.ui.la);
           attackKnight();
        });
    }
    
    public void lookKnight(){
       gm.ui.createMessage("It's a knight"); 
        gm.rootManager[1].getChildren().add(gm.ui.la);
    }
    
    public void talkKnight(){
        gm.ui.createMessage("Hello stranger"); 
        gm.rootManager[1].getChildren().add(gm.ui.la);
    }
    
    public void attackKnight(){
        gm.ui.createMessage("You fool!"); 
        gm.rootManager[1].getChildren().add(gm.ui.la);
        gm.user.eliminaVita();
        
                
    }
    
    public void followingScene(){
        gm.ui.changeRight.setOnAction(event->{
            gm.sc.showScenario2();
        });
    }
    
    public void precedeingScene(){
        gm.ui.changeLeft.setOnAction(event->{
            gm.sc.showScenario1();
        });
    }
}
