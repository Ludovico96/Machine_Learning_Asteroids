/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;



import java.awt.image.RenderedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

/**
 *
 * @author Utente
 */
public class Scenario2 implements Serializable{
     public GameManager gm;
    //public UI ui=new UI(gm);
   
    public Group root;
    public ImageView boscoCaverna;
    public ImageView vecchio;
    public ImageView caverna;
    public ImageView fuoco;
    
    public String scenaPrincipale;
    public EventScenario2[] event2;
    
   
    
    public Scenario2(GameManager gm){
        this.gm=gm;
    }
    
     public Scenario2(String scenario,EventScenario2[] event2){
         this.scenaPrincipale=scenario;
         this.event2=event2;
     }
    
    public void creaScenario(){
        gm.numeroScenario=2;
        boscoCaverna=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\boscoCaverna.jpg");
        caverna=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\caverna.png", 600, 550, 600, 130);
        vecchio=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\vecchio.png", 320, 320, 100, 395);
        fuoco=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\fuoco.png", 200,200, 300, 500);
        gm.ui.createButtonChangeScene();
        
        root=new Group(boscoCaverna,caverna,vecchio,fuoco,gm.ui.changeRight);
       
    }
    
    public void setAction(){
        gm.scenario2.vecchio.setOnMouseClicked(event->{
            gm.ev2.clickOld();
        });
        
         gm.scenario2.caverna.setOnMouseClicked(event->{
            gm.ev2.clickCavern();
        });
        
         gm.scenario2.fuoco.setOnMouseClicked(event->{
             gm.ev2.clickFire();
         });
        //gm.ev2.precedeingScene();
        
        
         boscoCaverna.setOnMouseClicked(event->{
            gm.rootManager.getChildren().removeAll(gm.ui.actionVbox,gm.ui.la);
            

        });
         
         //gm.ev2.musicScenario();
        // gm.ui.createMusic("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\musica\\musicaProva2.wav");
    }
    
    public String toString(){
        scenaPrincipale="mare";
        return scenaPrincipale;
    }
    
   public void conservaScenario2(){
         String controllaScena=Integer.toString(gm.numeroScenario);
        try{
           // Files.write(Paths.get("./myscenario/scenario.txt"),toString().getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),controllaScena.getBytes());
           
            
        } catch(IOException e){
            System.out.println("Impossibile conservare scenario");
        }
    }
   
   public void prelevaScenario2(){
       try{
          // scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String controllaScena=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           gm.numeroScenario=Integer.parseInt(controllaScena);
           if(gm.numeroScenario==2){
          
               gm.sc.showScenario2();
           
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare scenario");
       }
   }
   
  
   
  
    
    /*public  void conservaScenario2() {
        
          imageMare=mare.getImage();
          
            
            try{
        //oos.writeObject();
             ImageIO.write(SwingFXUtils.fromFXImage(imageMare, null), "jpg", file);
             
        } catch(IOException e){
            System.out.println("Impossibile conservare");
        }
            
           
    }
    
    public void caricaScenario2(){
        
        try {
            imageMare=SwingFXUtils.toFXImage(ImageIO.read(file), null);
            mare.setImage(imageMare);
            gm.scenario1.root.getChildren().add(mare);
        } catch(IOException e){
            System.out.println("Impossibile estrarre");
    }
    
    
    
    }*/
    
}
