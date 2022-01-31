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
    public ImageView mare;
    ;public String scenaPrincipale;
   
    //public Image imageMare;
    //public File file=new File("scenario.jpg");
    
   
    
    public Scenario2(GameManager gm){
        this.gm=gm;
    }
    
    public void creaScenario(){
        gm.numeroScenario=2;
        mare=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\mare.jpg");
        
        root=new Group(mare,gm.ui.changeLeft,gm.ui.changeRight);
      
    }
    
    public void setAction(){
         gm.ev2.precedeingScene();
        
    }
    
    public String toString(){
        scenaPrincipale="mare";
        return scenaPrincipale;
    }
    
   public void conservaScenario2(){
         String x=Integer.toString(gm.numeroScenario);
        try{
            Files.write(Paths.get("./myscenario/scenario.txt"),toString().getBytes());
            Files.write(Paths.get("./myscenario/numeroscenario.txt"),x.getBytes());
        } catch(IOException e){
            System.out.println("Impossibile conservare");
        }
    }
   
   public void prelevaScenario2(){
       try{
           scenaPrincipale=new String(Files.readAllBytes(Paths.get("./myscenario/scenario.txt")));
           String x=new String(Files.readAllBytes(Paths.get("./myscenario/numeroscenario.txt")));
           gm.numeroScenario=Integer.parseInt(x);
           if(gm.numeroScenario==2){
           if(scenaPrincipale.equals("mare")){
               gm.sc.showScenario2();
           }
           }
       } catch (IOException e){
           System.out.println("impossibile prelevare");
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
