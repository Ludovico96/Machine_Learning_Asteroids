
package progettovideogioco;

import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class UI {
    
    GameManager gm;
    VBox staticVbox;
    VBox actionVbox;
    Button menu;
    Button la1;
    Button la2;
    Button la3;
    Button bu1;
    Button bu2;
    Button bu3;
    Label la;
    Button changeLeft;
    Button changeRight;
    Button startGame;
    Clip music;
   // private Clip soundEffect;
    TextField insertNickname;
    
    
    public UI(GameManager gm){
        this.gm=gm;
    }
    
    
    //metodi per la creazione di oggetti di scena
    public void creaStart(){
          insertNickname=new TextField("InsertNickname");
          insertNickname.setLayoutX(300);
          insertNickname.setLayoutY(0);
          startGame=new Button("START");
          startGame.setLayoutX(500);
          startGame.setLayoutY(0);
          
    }
    
    
    
    
    public ImageView creatScenario(String imagePath){
       ImageView  im=new ImageView(imagePath);
        im.setFitHeight(650);
        im.setFitWidth(1000);
        im.setLayoutY(50);
       return im;
    }
    
    public void createMessage(String message){
        la=new Label(message);
        la.setLayoutX(370);
        la.setLayoutY(800);
        la.setStyle("-fx-font-size: 25px; -fx-background-color:black; -fx-text-fill: white");
    }
    
    
    
    public ImageView creatObject(String objectPath,int height,int width,int x,int y){
       ImageView  im=new ImageView(objectPath);
        im.setFitHeight(height);
        im.setFitWidth(width);
        im.setLayoutX(x);
        im.setLayoutY(y);
        return im;
        
    }
    
    public void createStaticMenu(){
    menu =new Button("Action Menu");
    la1=new Button("Action 1");
    la2=new Button("Action 2");
    la3=new Button("Action 3");    
    menu.setStyle("-fx-font-size: 40px; -fx-background-color:black; -fx-text-fill: white; ");
    la1.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    la2.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    la3.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    staticVbox=new VBox();
    staticVbox.getChildren().add(menu);
    staticVbox.getChildren().add(la1);
    staticVbox.getChildren().add(la2);
    staticVbox.getChildren().add(la3);
    staticVbox.setLayoutX(0);
    staticVbox.setLayoutY(700);
    
    }
    
   
    
    public void createObjectMenu(String bu1Action,String bu2Action,String bu3Action){
    bu1=new Button(bu1Action);
    bu2=new Button(bu2Action);
    bu3=new Button(bu3Action);
    bu1.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    bu2.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    bu3.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    actionVbox=new VBox();
    actionVbox.setLayoutX(150);
    actionVbox.setLayoutY(786);
    actionVbox.getChildren().add(bu1);
    actionVbox.getChildren().add(bu2);
    actionVbox.getChildren().add(bu3);
    }
    
    public void createButtonChangeScene(){
        changeLeft=new Button();
         changeRight=new Button();
         changeLeft.setLayoutX(0);
         changeLeft.setLayoutY(300);
         changeRight.setLayoutX(980);
         changeRight.setLayoutY(300);
    }
    
   //metodi creazione file audio
    public void createMusic(String path){
       
       try {File file=new File(path);
        AudioInputStream audioStream=AudioSystem.getAudioInputStream(file);
         music=AudioSystem.getClip();
        music.open(audioStream);
        music.start();
       
       } catch(Exception e){
           System.out.println("impossibile prelevare effetto sonoro");
           System.out.println(e.getMessage());
       }
       
      
    }
    
    public Clip createSoundEffect(String path){
       
       try {File file=new File(path);
        AudioInputStream audioStream=AudioSystem.getAudioInputStream(file);
        Clip soundEffect;
          soundEffect=AudioSystem.getClip();
        soundEffect.open(audioStream);
        soundEffect.start();
         return soundEffect;
        
       } catch(Exception e){
           System.out.println("impossibile prelevare effetto sonoro");
           System.out.println(e.getMessage());
           return null;
       }
        
       
      
    }
    
    //carica lo scenario e l'equipaggiamento corrispondente
    public void caricaScenario(){
        if(gm.numeroScenario==1){
            gm.sc.showScenario1();
        }else if(gm.numeroScenario==3){
            gm.sc.showScenario3();
        }else if(gm.numeroScenario==4){
            gm.sc.showScenario4();
        }else if(gm.numeroScenario==5){
            gm.sc.showScenario5();
        }else if(gm.numeroScenario==6){
            gm.sc.showScenario6();
        }else if(gm.numeroScenario==7){
            gm.sc.showScenario7();
        }else if(gm.numeroScenario==8){
            gm.sc.showScenario8();
        }else if(gm.numeroScenario==9){
            gm.sc.showScenario9();
        }else if(gm.numeroScenario==10){
            gm.sc.showScenario10();
        }else if(gm.numeroScenario==12){
            gm.sc.showScenario12();
        }else if(gm.numeroScenario==13){
            gm.sc.showScenario13();
        }else if(gm.numeroScenario==14){
            gm.sc.showUltimoScenario();
        }
        if(gm.user.possiediSpada==true){
            gm.user.hasSword();
        }
        if(gm.user.possiediScudo==true){
            gm.user.hasShield();
        }
        if(gm.user.possiediTorcia==true){
            gm.user.hasTorch();
        }
        if(gm.user.possiediFionda==true){
            gm.user.hasSling();
        }
        if(gm.user.possiediBomba==true){
            gm.user.hasBomb();
        }
        if(gm.user.possiediBarriera==true){
            gm.user.hasMagic();
        }
        
        gm.user.loadLife();
    }
    
    
    
    
}
