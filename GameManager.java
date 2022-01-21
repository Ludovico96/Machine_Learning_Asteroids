/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;


import java.io.FileOutputStream;
import javafx.application.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Utente
 */
public class GameManager extends Application{
    public Scenario1 scenario1=new Scenario1(this);
    public Scenario2 scenario2=new Scenario2(this);
    public ScenarioGameOver scenarioEnd=new ScenarioGameOver(this);
    public EventScenario1 ev1=new EventScenario1(this);
    public UI ui=new UI(this);
    public User user=new User(this);
    public SceneChanger sc=new SceneChanger(this);
    public Group rootManager=new Group();
    
    
    public void start(Stage stage){
         ui.createButtonChangeScene();
       ui.createStaticMenu();
        scenario1.creaScenario();
        scenario1.setAction();
        
       
       scenario1.root.getChildren().addAll(ui.staticVbox,ui.changeLeft,ui.changeRight);
       user.LifePlayer();
      
       //ev1.followingScene();
       
        
        
        Scene scene=new Scene(scenario1.root,1000,1000,Color.BLACK);     
        stage.setTitle("Medieval Adventures");
        stage.setScene(scene);
        stage.show();
    }
    
    
    
   
}
