/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Utente
 */
public class Scenario9 {
    public GameManager gm;
    //public UI ui=new UI(gm);
   
    public Group root;
    public ImageView underWaterShark;
    public ImageView nearBarrel;
    public ImageView farBarrel;
    public ImageView sword;
    public ImageView shield;
    public ImageView shark;
    public ImageView spadaReale;
    public ImageView scudoReale;
    public ImageView fiondaReale;
   
    
    public String scenaPrincipale;
    public EventScenario9[] event9;
    
   
    
    public Scenario9(GameManager gm){
        this.gm=gm;
    }
    
     public Scenario9(String scenario,EventScenario9[] event9){
         this.scenaPrincipale=scenario;
         this.event9=event9;
     }
    
    public void creaScenario(){
        //gm.numeroScenario=8;
        underWaterShark=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\underWaterShark.png");
        nearBarrel=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\barrel.png", 300, 280, 720, 420);
        farBarrel=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\barrel.png", 150, 150, 50, 100);
        //shark=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\shark.png", 500, 950, 50, 100);
        spadaReale=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\spadaReale.png", 150, 150, 700, 80);
        scudoReale=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\scudoReale.png", 150, 150, 200, 200);
        fiondaReale=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\fiondaReale.png", 200, 200, 50, 400);
        
        gm.ui.createButtonChangeScene();
        
        root=new Group(underWaterShark,nearBarrel,farBarrel,spadaReale,scudoReale,fiondaReale,gm.ui.changeRight);
       
    }
    
    public void setAction(){
        underWaterShark.setOnMouseClicked(event->{
            gm.ev9.clickShark();
        });
        
        fiondaReale.setOnMouseClicked(event->{
            gm.ev9.clickSling();
        });
        
        nearBarrel.setOnMouseClicked(event->{
            gm.ev9.clicknearBarrel();
        });
        
        farBarrel.setOnMouseClicked(event->{
            gm.ev9.clickFarBarrel();
        });
        
        spadaReale.setOnMouseClicked(event->{
            gm.ev9.clickSword();
        });
        
        scudoReale.setOnMouseClicked(event->{
            gm.ev9.clickShield();
        });
        
        gm.ev9.followingScene();
    }
    
    public void conservaScenario9(){
         String controllaScena=Integer.toString(gm.numeroScenario);
         String controllaMorteSqualo=Boolean.toString(gm.ev9.morteSqualo);
        try{
           // Files.write(Paths.get("./myscenario/scenario.txt"),toString().getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
            Files.write(Paths.get("./myscenario/morteSqualo.txt"),controllaMorteSqualo.getBytes());
           
            
        } catch(IOException e){
            System.out.println("Impossibile conservare scenario");
        }
    }
   
   public void prelevaScenario9(){
       try{
          // scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String controllaScena=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           String controllaMorteSqualo=new String(Files.readAllBytes(Paths.get("./myscenario/morteSqualo.txt")));
           gm.numeroScenario=Integer.parseInt(controllaScena);
           gm.ev9.morteSqualo=Boolean.parseBoolean(controllaMorteSqualo);
           if(gm.numeroScenario==9 && gm.ev9.morteSqualo==true){
          
               gm.sc.showScenario9();
           
           } else if(gm.numeroScenario==9 && gm.ev9.morteSqualo==false){
               gm.sc.showScenario8();
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare scenario");
       }
   } 
}
