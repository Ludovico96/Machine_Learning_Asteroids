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
public class Scenario7 {
    public GameManager gm;
    //public UI ui=new UI(gm);
   
    public Group root;
    public ImageView mare;
    public ImageView nave;
    public ImageView nuvola;
    public ImageView nuvola1;
    public ImageView nuvola2;
    public ImageView nuvola3;
     public ImageView nuvola4;
    
    
    public String scenaPrincipale;
    public EventScenario7[] event7;
    
   
    
    public Scenario7(GameManager gm){
        this.gm=gm;
    }
    
     public Scenario7(String scenario,EventScenario7[] event7){
         this.scenaPrincipale=scenario;
         this.event7=event7;
     }
    
    public void creaScenario(){
        gm.numeroScenario=7;
        mare=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\mare2.jpg");
        nave=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nave.png", 450, 450, 350, 150);
        nuvola=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nuvolaReale.png", 500, 500, -80, -100);
        nuvola1=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nuvolaReale.png", 500, 500, 160, -100);
        nuvola2=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nuvolaReale.png", 500, 500, 320, -100);
        nuvola3=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nuvolaReale.png", 500, 500, 540, -100);
        nuvola4=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\nuvolaReale.png", 500, 500, 720, -100);
        //gm.ui.createMusic("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\stormSea1.wav");
        
        gm.ui.createButtonChangeScene();
        
        root=new Group(mare,nuvola,nuvola1,nuvola2,nuvola3,nuvola4,nave,gm.ui.changeRight);
       
    }
    
    public void setAction(){
        
        nave.setOnMouseClicked(event->{
           gm.ev7.clickShip();
        });
        
        gm.ev7.followinScene();
       
    }
    
    public void conservaScenario7(){
         String controllaScena=Integer.toString(gm.numeroScenario);
        try{
           // Files.write(Paths.get("./myscenario/scenario.txt"),toString().getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
           
            
        } catch(IOException e){
            System.out.println("Impossibile conservare scenario");
        }
    }
   
   public void prelevaScenario7(){
       try{
          // scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String controllaScena=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           gm.numeroScenario=Integer.parseInt(controllaScena);
           if(gm.numeroScenario==7){
          
               gm.sc.showScenario7();
           
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare scenario");
       }
   } 
    
}
