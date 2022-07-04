
package progettovideogioco;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class User {
    GameManager gm;
    private ImageView cuore;
    private List<ImageView> listaCuore;
    private HBox vita;
    private int contaVite;
    int numeroVite;
    ImageView spada;
    ImageView scudo;
    ImageView torcia;
    ImageView bomba;
    ImageView fionda;
    ImageView barriera;
    boolean possiediSpada;
    boolean possiediScudo;
    boolean possiediTorcia;
    boolean possiediBomba;
    boolean possiediFionda;
    boolean possiediBarriera;
    boolean startGame;
    
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
        if(numeroVite==5){
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("vita MAX");
            gm.rootManager.getChildren().add(gm.ui.la);
        } else{
        vita.getChildren().add(listaCuore.get(numeroVite));
        numeroVite++;
        }
       
          
    }
    
    public void aggiungi2Vita(){
        if(numeroVite==4){
             aggiungiVita();
        }else if(numeroVite==5){
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("vita MAX");
            gm.rootManager.getChildren().add(gm.ui.la);
        }
        else{
        vita.getChildren().addAll(listaCuore.get(numeroVite),listaCuore.get(numeroVite+1));
        numeroVite=numeroVite+2;
        }
          
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
    
}
