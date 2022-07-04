/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;


import java.util.Date;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class ScenarioGameOver {
    GameManager gm;
    public Button retry;
    public Label died;
    public Group root;
    
            
    public ScenarioGameOver(GameManager gm){
        this.gm=gm;
    }

   public void creaScenario(){
       gm.numeroScenario=1;
       retry=new Button("Retry Game");
       died=new Label("You Died");
       died.setLayoutX(300);
       died.setLayoutY(400);
       died.setStyle("-fx-font-size: 100px; -fx-background-color:black; -fx-text-fill: red; ");
       retry.setLayoutX(450);
       retry.setLayoutY(550);
       root=new Group(died,retry);
      
       
   }
   
   public void setAction(){
      retry.setOnAction(event->{
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario1");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
           gm.sc.showScenario1PostGameOver();
           
            
       });
       
    
   }
   
   
   
  public void restartGame(){
       retry.setOnAction(event->{
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario1");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
           gm.sc.showScenario1PostGameOver();
           
           
           gm.user.possiediSpada=false;
           gm.user.possiediScudo=false;
           gm.user.possiediTorcia=false;
           gm.user.possiediFionda=false;
           gm.user.possiediBomba=false;
           gm.user.possiediBarriera=false;
           
           
           gm.numeroScenario=1;
           
          
       
       
       });
         
       
   }
    
}
