/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

/**
 *
 * @author Utente
 */
public class Scenario3 {
     public GameManager gm;
    //public UI ui=new UI(gm);
   
    public Group root;
    public ImageView cavernaInterno;
    public ImageView lupo;
    public ImageView corpo;
    
    
    public String scenaPrincipale;
    public EventScenario3[] event3;
    
   
    
    public Scenario3(GameManager gm){
        this.gm=gm;
    }
    
     public Scenario3(String scenario,EventScenario3[] event3){
         this.scenaPrincipale=scenario;
         this.event3=event3;
     }
    
    public void creaScenario(){
        //gm.numeroScenario=3;
        cavernaInterno=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cavernaInterno.png");
        lupo=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\lupo.png", 300, 300, 400, 400);
        corpo=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\corpo2.png", 200, 200, 800, 350);
        gm.ui.createButtonChangeScene();
        
        root=new Group(cavernaInterno,lupo,corpo,gm.ui.changeRight);
       
    }
    
    public void setAction(){
        lupo.setOnMouseClicked(event->{
            gm.ev3.clickWolf();
        });
        
        corpo.setOnMouseClicked(event->{
            gm.ev3.clickBody();
        });
        
         cavernaInterno.setOnMouseClicked(event->{
            gm.rootManager.getChildren().removeAll(gm.ui.actionVbox,gm.ui.la);
            

        });
         
         gm.ev3.followingScene();
         
    }
    
     public void conservaScenario3(){
         String controllaScena=Integer.toString(gm.numeroScenario);
         String controllaMorteLupo=Boolean.toString(gm.ev3.deathWolf);
        try{
            Files.write(Paths.get("./myscenario/morteLupo.txt"),controllaMorteLupo.getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
           
            
        } catch(IOException e){
            System.out.println("Impossibile conservare scenario");
        }
    }
   
   public void prelevaScenario3(){
       try{
          // scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String controllaScena=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           String controllaMorteLupo=new String(Files.readAllBytes(Paths.get("./myscenario/morteLupo.txt")));
           gm.numeroScenario=Integer.parseInt(controllaScena);
           gm.ev3.deathWolf=Boolean.parseBoolean(controllaMorteLupo);
           if(gm.numeroScenario==3 && gm.ev3.deathWolf==true){
               
           
               gm.sc.showScenario3();
           
           } else if(gm.numeroScenario==3 && gm.ev3.deathWolf==false){
               gm.sc.showScenario2();
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare scenario");
       }
   }
   
    
    
    
    
    
}
