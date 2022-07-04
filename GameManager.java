
package progettovideogioco;



import java.util.Date;
import javafx.application.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//Classe che proietta la scena
public class GameManager extends Application{
   
    UI ui=new UI(this);
    User user=new User(this);
    SceneChanger sc=new SceneChanger(this);
    private final connessioneDatabase cdb=new connessioneDatabase(this);
    Group rootManager=new Group();
    AzioniInGame azioniInGame=new AzioniInGame(this);
    inviaAzioniSocket inviaAzioni=new inviaAzioniSocket(this);
    private scenarioXML scenarioxml=new scenarioXML();
    TimerTable timerGioco=new TimerTable();
    Label timer=new Label("0:00:00.0");
    Cronometro cronometro=new Cronometro(timer);
    int numeroScenario;
    boolean iniziaNuovaPartita;
    
    
   
     
    
    public void start(Stage stage){
        
        //crea il primo scenario
        
        
        
       
   
        ui.createButtonChangeScene();
        ui.createStaticMenu();
        ui.creaStart();
        
        timerGioco.mostraTempo();
        
        
        
         menuScenario menuscenario=new menuScenario(this);
         menuscenario.creaScenario();
       
       
        //setta il caricamento dei parametri dell'utente dal db o tramite cache a seconda se il nome utente
        //sia già presente nel db o no
        ui.startGame.setOnAction(event->{
           
          
            
           String nickName=ui.insertNickname.getText();
           
           //carica da cache se i nomi sono uguali
           
           scenarioxml=scenarioxml.deserializzaXML();
          
           
           if(nickName.equals(scenarioxml.user)){
              numeroScenario=scenarioxml.scenario;
              user.numeroVite=scenarioxml.vita;
              user.possiediSpada=scenarioxml.spada;
              user.possiediScudo=scenarioxml.scudo;
              user.possiediTorcia=scenarioxml.torcia;
              user.possiediFionda=scenarioxml.fionda;
              user.possiediBomba=scenarioxml.bomba;
              user.possiediBarriera=scenarioxml.magia;
              System.out.println("caricato da cache");
           } else{
               
           
               //carica da db altrimenti
           cdb.caricaUtenti();
           for(int i=0;i<cdb.listaUtenti.size();i++){
               if(cdb.listaUtenti.get(i).equals(nickName)){
                   iniziaNuovaPartita=false;
                   cdb.caricaParametriUtente(nickName);
              numeroScenario=cdb.listaParametri.get(0).getScenario();
              user.numeroVite=cdb.listaParametri.get(0).getVita();
              user.possiediSpada=cdb.listaParametri.get(0).getSpada();
              user.possiediScudo=cdb.listaParametri.get(0).getScudo();
              user.possiediTorcia=cdb.listaParametri.get(0).getTorcia();
              user.possiediFionda=cdb.listaParametri.get(0).getFionda();
              user.possiediBomba=cdb.listaParametri.get(0).getBomba();
              user.possiediBarriera=cdb.listaParametri.get(0).getMagia();
               }else{
               cdb.inizializzaParametriUtente(nickName);
               iniziaNuovaPartita=true;
               cdb.caricaParametriUtente(nickName);
              numeroScenario=cdb.listaParametri.get(0).getScenario();
              user.numeroVite=cdb.listaParametri.get(0).getVita();
              user.possiediSpada=cdb.listaParametri.get(0).getSpada();
              user.possiediScudo=cdb.listaParametri.get(0).getScudo();
              user.possiediTorcia=cdb.listaParametri.get(0).getTorcia();
              user.possiediFionda=cdb.listaParametri.get(0).getFionda();
              user.possiediBomba=cdb.listaParametri.get(0).getBomba();
              user.possiediBarriera=cdb.listaParametri.get(0).getMagia();
               
           }
               
             
                   
           }
           System.out.println("caricato da db");
          
           }
           
           //carica i dati del tempo di gioco
           
           timerGioco.caricaUtentiTimer();
           for(int i=0;i<timerGioco.listaUtentiTimer.size();i++){
               if(timerGioco.listaUtentiTimer.get(i).equals(nickName)){
                   timerGioco.caricaParametriUtente(nickName);
                   cronometro.setDiffTemp(timerGioco.listaParametriTimer.get(0).getTimeMS());
                   cronometro.t.start();
                   
                 
    
               System.out.println("caricato time");
           }else{
                   timerGioco.inizializzaParametriUtente(ui.insertNickname.getText(), "0:00:00.0",0);
                  cronometro.t.start();
               }
              
               
           }
           
               
           //carica lo scenario corrispondente all'utente che gioca
           ui.caricaScenario();
          
               
           azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"startGame");
           inviaAzioni.serializzaAzioniXML(azioniInGame);
          
           rootManager.getChildren().remove(timerGioco.vbox);
         
       });
       
      
       
        
       
       rootManager.getChildren().addAll(menuscenario.root,ui.staticVbox,ui.insertNickname,ui.startGame,timerGioco.vbox);
      
      
      //richieste di chiusura programma
       stage.setOnCloseRequest(event->{
           azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"exitGame");
           inviaAzioni.serializzaAzioniXML(azioniInGame);
           
           
           
           scenarioxml.user=ui.insertNickname.getText();
           scenarioxml.scenario=numeroScenario;
           scenarioxml.vita=user.numeroVite;
           scenarioxml.spada=user.possiediSpada;
           scenarioxml.scudo=user.possiediScudo;
           scenarioxml.torcia=user.possiediTorcia;
           scenarioxml.fionda=user.possiediFionda;
           scenarioxml.bomba=user.possiediBomba;
           scenarioxml.magia=user.possiediBarriera;
           scenarioxml.serializzaXML(scenarioxml);
        
           
           
           cdb.settaParametriUtente(ui.insertNickname.getText(), numeroScenario, user.numeroVite, user.possiediSpada, user.possiediScudo, user.possiediTorcia, user.possiediFionda, user.possiediBomba, user.possiediBarriera);
           
           
           timerGioco.settaParametriUtente(ui.insertNickname.getText(), cronometro.s,cronometro.diffTempo);
           cronometro.Ferma();
       }); 
       
        
       
        Scene scene=new Scene(rootManager,1000,1000,Color.BLACK);     
        stage.setTitle("Medieval Adventures");
        stage.setScene(scene);
        stage.show();
        
        
    }
    
   

    
   
}
