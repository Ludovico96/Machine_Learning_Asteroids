
package progettovideogioco;


import java.util.Date;
import javafx.scene.Group;
import javafx.scene.image.ImageView;


public class QuintoScenario {
    GameManager gm;
   
   
    Group root;
    private ImageView forestaIntera;
    private ImageView caverna;
    
    private int contaClick=1;
    private boolean frecciaScoccata;
    
   
    
   
    public QuintoScenario(GameManager gm){
        this.gm=gm;
    }
    
    
     //Creazione scenario
    public void creaScenario(){
        gm.numeroScenario=5;
        forestaIntera=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\forestaIntera.jpg");
        caverna=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\caverna.png", 250, 250, -10, 470);
        gm.ui.createButtonChangeScene();
        
        root=new Group(forestaIntera,caverna,gm.ui.changeRight);
       
        if(gm.iniziaNuovaPartita==true){
           contaClick=1;
           frecciaScoccata=false;
       }
    }
    
      //Settaggio azioni
    public void setAction(){
        forestaIntera.setOnMouseClicked(event->{
            clickForest();
        });
        
        followingScene();
    }
    
    //Specifica azioni
    public void clickForest(){
         gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("listen", "Parry/Talk", "Roll");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             listenForest();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"listenForest");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoSomethingForest();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"parry/talkForest");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoNothingForest();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"rollForest");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
     }
     
     public void listenForest(){
         frecciaScoccata=true;
         if(contaClick==1){
         gm.ui.createMessage("Me:Finally, i am out of the cavern \n This forest is so amazing and so giant \n it seems like a dream but...\n what is this sound? \n it's like a hiss");
         gm.rootManager.getChildren().add(gm.ui.la);
         
         
         }else if(contaClick>1){
             gm.rootManager.getChildren().remove(gm.ui.la);
             gm.ui.createMessage("(another time? The same sound..)");
              gm.rootManager.getChildren().add(gm.ui.la);
             
         }
     }
     
     public void DoSomethingForest(){
         if(gm.user.possiediScudo==true){
         if(frecciaScoccata==true ){
             
         gm.ui.createMessage("(SHIELD UP!!!!) \n you parry the shot");
          gm.rootManager.getChildren().add(gm.ui.la);
          frecciaScoccata=false;
          contaClick++;
         } else if( contaClick>2){
             gm.rootManager.getChildren().remove(gm.ui.la);
             gm.ui.createMessage("Me:Who are you, i just want to talk, \n show yourself i do not want to fight!");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClick++;
        }
       }else{
             if(frecciaScoccata==true ){
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.user.eliminaVita();
         frecciaScoccata=false;
             }
         }
     }
     
     public void DoNothingForest(){
         if(frecciaScoccata==true){
         gm.ui.createMessage("An arrow hurt you \n Me:AHHHHH something hurt me");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.user.eliminaVita();
         frecciaScoccata=false;
         contaClick++;
         
         }
     }
     
     public void followingScene(){
         gm.ui.changeRight.setOnAction(event->{
             if(contaClick>3){
                 gm.rootManager.getChildren().remove(root);
                 contaClick=1;
                  gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario6");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
                 gm.sc.showScenario6();
             }
             
         });
     }
   
}
