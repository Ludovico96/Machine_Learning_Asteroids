/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
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
    public List<ImageView> listaCuore;
    public HBox vita;
    public int contaVite;
    public int numeroVite;
    public ImageView spada;
    public ImageView scudo;
    public ImageView torcia;
    public ImageView bomba;
    public ImageView fionda;
    public ImageView barriera;
    public boolean possiediSpada;
    public boolean possiediScudo;
    public boolean possiediTorcia;
    public boolean possiediBomba;
    public boolean possiediFionda;
    public boolean possiediBarriera;
    public boolean startGame;
    
    public User(GameManager gm){
        this.gm=gm;
    }
    
    public void LifePlayer(){
        startGame=true;
       vita=new HBox();
       listaCuore=new ArrayList<>();
        
        for(int i=0;i<5;i++){
        cuore=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cuore.png", 50, 50, 0, 0);
        listaCuore.add(cuore);
        }
        
        for(int i=0;i<3;i++){
            vita.getChildren().add(listaCuore.get(i));
            numeroVite=3;
        }
        
        gm.rootManager.getChildren().add(vita);
      }
    
    public void loadLife(){
        gm.rootManager.getChildren().remove(vita);
        vita=new HBox();
       listaCuore=new ArrayList<>();
       
        
        
        for(int i=0;i<5;i++){
        cuore=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cuore.png", 50, 50, 0, 0);
        listaCuore.add(cuore);
        }
        
        for(int i=0;i<numeroVite;i++){
            vita.getChildren().add(listaCuore.get(i));
           
        }
         gm.rootManager.getChildren().add(vita);
    }
    
    public void aggiungiVita(){
       // cuore=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cuore.png", 50, 50, 0, 0);
        if(numeroVite==5){
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("vita MAX");
            gm.rootManager.getChildren().add(gm.ui.la);
        } else{
        vita.getChildren().add(listaCuore.get(numeroVite));
        numeroVite++;
        }
        /*cuore=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\cuore.png", 50, 50, 0, 0);
          vita.getChildren().add(cuore);*/
          
    }
    public void eliminaVita(){
        if(numeroVite==1){
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showGameOver");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            gm.sc.showGameOver();
            
            
        }
        vita.getChildren().remove(listaCuore.get(numeroVite-1));
        numeroVite--;
    }
    
    public void elimina2Vita(){
        if(numeroVite>0 && numeroVite<=2){
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showGameOver");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            gm.sc.showGameOver();
            
            
        }else{
        vita.getChildren().removeAll(listaCuore.get(numeroVite-1),listaCuore.get(numeroVite-2));
        //vita.getChildren().remove(listaCuore.get(numeroVite-1));
        numeroVite=numeroVite-2;
        }
    }
    
     public void elimina3Vita(){
        if(numeroVite>0 && numeroVite<=3){
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showGameOver");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            gm.sc.showGameOver();
            
            
        }else{
        vita.getChildren().removeAll(listaCuore.get(numeroVite-1),listaCuore.get(numeroVite-2),listaCuore.get(numeroVite-3));
        //vita.getChildren().remove(listaCuore.get(numeroVite-1));
        numeroVite=numeroVite-3;
        }
    }
   
    
    public void hasSword(){
        spada= gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\spada.png",50,50,950,0);
        gm.rootManager.getChildren().add(spada);
        possiediSpada=true;
         
    }
    
    public void hasShield(){
        scudo=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\scudo.png",50,50,890,0);
        gm.rootManager.getChildren().add(scudo);
        possiediScudo=true;
         
    }
    
    public void hasTorch(){
        torcia=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\torcia.png",50,50,830,0);
        gm.rootManager.getChildren().add(torcia);
        possiediTorcia=true;
         
    }
    
    public void hasBomb(){
        bomba=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\bomb.png",50,50,770,0);
        gm.rootManager.getChildren().add(bomba);
        possiediBomba=true;
         
    }
    
    public void hasSling(){
        fionda=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\fionda.png",50,50,710,0);
        gm.rootManager.getChildren().add(fionda);
        possiediFionda=true;
         
    }
    
    public void hasMagic(){
        barriera=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\magicBarrier.png",50,50,650,0);
        gm.rootManager.getChildren().add(barriera);
        possiediBarriera=true;
         
    }
    
    
    public void conservaArmi(){
        String controllaSpada=Boolean.toString(possiediSpada);
        String controllaScudo=Boolean.toString(possiediScudo);
         String controllaTorcia=Boolean.toString(possiediTorcia);
         String controllaPozione=Boolean.toString(possiediBomba);
         String controllaFionda=Boolean.toString(possiediFionda);
        try{
            Files.write(Paths.get("./myscenario/armiOttenute.txt"),controllaSpada.getBytes());
            Files.write(Paths.get("./myscenario/armiOttenute2.txt"),controllaScudo.getBytes());
            Files.write(Paths.get("./myscenario/armiOttenute3.txt"),controllaTorcia.getBytes());
            Files.write(Paths.get("./myscenario/armiOttenute4.txt"),controllaPozione.getBytes());
            Files.write(Paths.get("./myscenario/armiOttenute5.txt"),controllaFionda.getBytes());
        } catch(IOException e){
            System.out.println("impossibile conservare arma");
        }
    }
    
    public void prelevaArmi(){
        try{
        String controllaSpada=new String(Files.readAllBytes(Paths.get("./myscenario/armiOttenute.txt")));
        String controllaScudo=new String(Files.readAllBytes(Paths.get("./myscenario/armiOttenute2.txt")));
        String controllaTorcia=new String(Files.readAllBytes(Paths.get("./myscenario/armiOttenute3.txt")));
        String controllaPozione=new String(Files.readAllBytes(Paths.get("./myscenario/armiOttenute4.txt")));
        String controllaFionda=new String(Files.readAllBytes(Paths.get("./myscenario/armiOttenute5.txt")));
        possiediSpada=Boolean.parseBoolean(controllaSpada);
        possiediScudo=Boolean.parseBoolean(controllaScudo);
        possiediTorcia=Boolean.parseBoolean(controllaTorcia);
        possiediBomba=Boolean.parseBoolean(controllaPozione);
        possiediFionda=Boolean.parseBoolean(controllaFionda);
        if(possiediSpada==true){
            hasSword();
        } 
        if(possiediScudo==true){
            hasShield();
        }
        if(possiediTorcia==true){
            hasTorch();
        }
        if(possiediBomba==true){
            hasBomb();
        }
        if(possiediFionda==true){
            hasSling();
        }
       
      } catch(IOException e){
          System.out.println("impossibile prelevare arma");
      }
    }
    
    
    public void conservaVita(){
        String controllaVita=Integer.toString(numeroVite);
        String controllaStartGame=Boolean.toString(startGame);
        try{
            Files.write(Paths.get("./myscenario/numeroVite.txt"),controllaVita.getBytes());
            Files.write(Paths.get("./myscenario/startGame.txt"),controllaStartGame.getBytes());
        } catch(IOException e){
            System.out.println("Impossibile conservare vita");
        }
    }
    
    public void prelevaVita(){
        try{
            String controllaVita=new String(Files.readAllBytes(Paths.get("./myscenario/numeroVite.txt")));
            String controllaStartGame=new String(Files.readAllBytes(Paths.get("./myscenario/startGame.txt")));
            numeroVite=Integer.parseInt(controllaVita);
            startGame=Boolean.parseBoolean(controllaStartGame);
            if(startGame==true){
            loadLife();
            } else{
                LifePlayer();
            }
        } catch(IOException e){
            System.out.println("Impossibile prelevare vita");
        }
    }
}
