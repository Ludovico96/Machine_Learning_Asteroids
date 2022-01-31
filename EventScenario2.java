/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

/**
 *
 * @author Utente
 */
public class EventScenario2 {
    GameManager gm;
    
    public EventScenario2(GameManager gm){
        this.gm=gm;
    }
    
    public void precedeingScene(){
        gm.ui.changeLeft.setOnAction(event->{
            gm.sc.showScenario1();
        });
    }
    
    
        
    
}
