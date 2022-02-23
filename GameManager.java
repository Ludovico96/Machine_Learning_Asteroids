/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;


import com.thoughtworks.xstream.XStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import javafx.application.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Utente
 */
public class GameManager extends Application{
    public Scenario1 scenario1=new Scenario1(this);
    public ScenarioBetween1and2 scenarioBetween1=new ScenarioBetween1and2(this);
    public Scenario2 scenario2=new Scenario2(this);
    public Scenario3 scenario3=new Scenario3(this);
    public Scenario4 scenario4=new Scenario4(this);
    public Scenario5 scenario5=new Scenario5(this);
    public Scenario6 scenario6=new Scenario6(this);
    public Scenario7 scenario7=new Scenario7(this);
    public Scenario8 scenario8=new Scenario8(this);
    public Scenario9 scenario9=new Scenario9(this);
     public Scenario10 scenario10=new Scenario10(this);
     public Scenario11 scenario11=new Scenario11(this);
    public ScenarioGameOver scenarioEnd=new ScenarioGameOver(this);
    public EventScenario1 ev1=new EventScenario1(this);
    public EventScenarioBetween1and2 ev12=new EventScenarioBetween1and2(this);
    public EventScenario2 ev2=new EventScenario2(this);
    public EventScenario3 ev3=new EventScenario3(this);
    public EventScenario4 ev4=new EventScenario4(this);
    public EventScenario5 ev5=new EventScenario5(this);
    public EventScenario6 ev6=new EventScenario6(this);
    public EventScenario7 ev7=new EventScenario7(this);
    public EventScenario8 ev8=new EventScenario8(this);
    public EventScenario9 ev9=new EventScenario9(this);
    public EventScenario10 ev10=new EventScenario10(this);
    public EventScenario11 ev11=new EventScenario11(this);
    public EventScenarioGameOver evgo=new EventScenarioGameOver(this);
    public UI ui=new UI(this);
    public User user=new User(this);
    public SceneChanger sc=new SceneChanger(this);
    public connessioneDatabase cdb=new connessioneDatabase(this);
    public Group rootManager=new Group();
    public inviaAzioniSocket ias=new inviaAzioniSocket(this);
    public AzioniInGame azioniInGame=new AzioniInGame(this);
    public inviaAzioniSocket inviaAzioni=new inviaAzioniSocket(this);
    public scenarioXML scenarioxml=new scenarioXML();
   
    
    public int numeroScenario;
    
    
    //public Button restart=new Button("Restart");
    
    public void start(Stage stage){
        ui.createButtonChangeScene();
       ui.createStaticMenu();
       ui.creaStart();
       
       
       
       ui.startGame.setOnAction(event->{
           
           azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"startGame");
           inviaAzioni.serializzaAzioniXML(azioniInGame);
           
           String nickName=ui.insertNickname.getText();
           
        System.out.println(scenarioxml.user);
          
           
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
           
           cdb.caricaUtenti();
           for(int i=0;i<cdb.listaUtenti.size();i++){
               if(cdb.listaUtenti.get(i).equals(nickName)){
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
               cdb.caricaParametriUtente(nickName);
                numeroScenario=cdb.listaParametri.get(0).getScenario();
              user.numeroVite=cdb.listaParametri.get(0).getVita();
              user.possiediSpada=cdb.listaParametri.get(0).getSpada();
              user.possiediScudo=cdb.listaParametri.get(0).getScudo();
              user.possiediTorcia=cdb.listaParametri.get(0).getTorcia();
              user.possiediFionda=cdb.listaParametri.get(0).getFionda();
              user.possiediBomba=cdb.listaParametri.get(0).getBomba();
              user.possiediBarriera=cdb.listaParametri.get(0).getMagia();
               //sc.showScenario1PostGameOver();
           }
               
             
                   
           }
           System.out.println("caricato da db");
          
           }
           ui.caricaScenario();
               
           
          /* cdb.caricaParametriUtente(nickName);
           if(ui.insertNickname.getText().equals(cdb.listaParametri.get(0).getUser())){
              numeroScenario=cdb.listaParametri.get(0).getScenario();
              user.numeroVite=cdb.listaParametri.get(0).getVita();
              user.possiediSpada=cdb.listaParametri.get(0).getSpada();
              user.possiediScudo=cdb.listaParametri.get(0).getScudo();
              user.possiediTorcia=cdb.listaParametri.get(0).getTorcia();
              user.possiediFionda=cdb.listaParametri.get(0).getFionda();
              user.possiediBomba=cdb.listaParametri.get(0).getBomba();
              user.possiediBarriera=cdb.listaParametri.get(0).getMagia();
           }*/
          
       });
       
        scenario1.creaScenario();
        scenario1.setAction();
       
        
        
     /* restart.setLayoutX(500);
      restart.setLayoutY(0);
      restart.setOnAction(event->{
          sc.showScenario1PostGameOver();
      });*/
      
        
       
        
       rootManager.getChildren().addAll(scenario1.root,ui.staticVbox,ui.changeRight,ui.insertNickname,ui.startGame);
       /*if(user.startGame==false){
       user.LifePlayer();
       } else{
           user.prelevaVita();
       }*/
       user.prelevaVita();
      
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
         scenarioxml=scenarioxml.serializzaXML(scenarioxml);
           
           
           cdb.settaParametriUtente(ui.insertNickname.getText(), numeroScenario, user.numeroVite, user.possiediSpada, user.possiediScudo, user.possiediTorcia, user.possiediFionda, user.possiediBomba, user.possiediBarriera);
           
         /*  scenario1.conservaScenario1();
           scenario2.conservaScenario2();
           scenario3.conservaScenario3();
           scenario4.conservaScenario4();
           scenario5.conservaScenario5();
           scenario6.conservaScenario6();
           scenario7.conservaScenario7();
           scenario8.conservaScenario8();
           scenario9.conservaScenario9();
           scenario10.conservaScenario10();
           scenario11.conservaScenario11();
           user.conservaArmi();
           user.conservaVita();*/
           ev1.contaClick=1;
           ev2.contaClick=1;
       }); 
        /*scenario1.prelevaScenario1();
        scenario2.prelevaScenario2();
        scenario3.prelevaScenario3();
        scenario4.prelevaScenario4();
        scenario5.prelevaScenario5();
        scenario6.prelevaScenario6();
        scenario7.prelevaScenario7();
        scenario8.prelevaScenario8();
        scenario9.prelevaScenario9();
        scenario10.prelevaScenario10();
        scenario11.prelevaScenario11();
        user.prelevaArmi();*/
        //user.prelevaVita();
        
       
        Scene scene=new Scene(rootManager,1000,1000,Color.BLACK);     
        stage.setTitle("Medieval Adventures");
        stage.setScene(scene);
        stage.show();
        
        
    }
    
   

    
   
}
