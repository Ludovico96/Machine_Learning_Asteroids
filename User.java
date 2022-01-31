/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Utente
 */
public class User {
    GameManager gm;
    public ImageView cuore;
    public List<ImageView> listaCuore=new ArrayList<>();
    public HBox vita=new HBox();
    public int contaVite;
    public int numeroVite;
    
    public User(GameManager gm){
        this.gm=gm;
    }
    
    public void LifePlayer(){
       
     
        
        for(int i=0;i<5;i++){
        cuore=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cuore.png", 50, 50, 0, 0);
        listaCuore.add(cuore);
        }
        
        for(int i=0;i<3;i++){
            vita.getChildren().add(listaCuore.get(i));
            numeroVite=3;
        }
        
       // gm.scenario1.root.getChildren().add(vita);
        gm.rootManager[1].getChildren().add(vita);
        
          
        
        
        /*for(int i=0;i<3;i++){
            cuore=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cuore.png", 50, 50, 0, 0);
          vita.getChildren().add(cuore);
        }*/
        
        //gm.scenario1.root.getChildren().add(vita);
    }
    
    public void aggiungiVita(){
       // cuore=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cuore.png", 50, 50, 0, 0);
        if(numeroVite==5){
            gm.rootManager[gm.numeroScenario].getChildren().remove(gm.ui.la);
            gm.ui.createMessage("vita MAX");
            gm.rootManager[gm.numeroScenario].getChildren().add(gm.ui.la);
        } else{
        vita.getChildren().add(listaCuore.get(numeroVite));
        numeroVite++;
        }
        /*cuore=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cuore.png", 50, 50, 0, 0);
          vita.getChildren().add(cuore);*/
          
    }
    public void eliminaVita(){
        if(numeroVite==1){
            gm.sc.showGameOver();
            
            
        }
        vita.getChildren().remove(listaCuore.get(numeroVite-1));
        numeroVite--;
    }
   
}
