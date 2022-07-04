
package progettovideogioco;


import java.util.Date;
import javafx.scene.Group;
import javafx.scene.image.ImageView;


public class SettimoScenario {
    GameManager gm;
    
   
    Group root;
    private ImageView fiume;
    private ImageView womanElf;
    
    
    private int contaClick=1;
    private boolean fineDiscorso;
    
   
    
    public SettimoScenario(GameManager gm){
        this.gm=gm;
    }
    
    //Creazione scenario
    public void creaScenario(){
        gm.numeroScenario=7;
        fiume=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\fiume.png");
        womanElf=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\womanBust.png", 400, 400, 0, 300);
        gm.ui.createButtonChangeScene();
        
        root=new Group(fiume,womanElf,gm.ui.changeRight);
       
         if(gm.iniziaNuovaPartita==true){
           contaClick=1;
           fineDiscorso=false;
       }
    }
    
    //Settaggio azioni
    public void setAction(){
        
        womanElf.setOnMouseClicked(event->{
          clickElf();
        });
       
        followingScene();
    }
    
    //SPecifica azioni
    public void clickElf(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
          gm.rootManager.getChildren().remove(gm.ui.la);
          if(contaClick==1){
              talkElf();
          }else if(contaClick==2){
              talkElf2();
          }else if(contaClick==3){
              talkElf3();
          }else if(contaClick>3){
              talkElf4();
          }
           gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"talkElf");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
          
          
     }
     
     public void talkElf(){
         if(contaClick==1){
         gm.ui.createMessage("Elf:So, we arrive, the port is near \n follow the river, a ship \n bring you near to the island \n where the volcano is located");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
         }
     }
     
      public void talkElf2(){
         if(contaClick==2){
         gm.ui.createMessage("Me:Thank you, really ehmm...");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
         }
     }
      
       public void talkElf3(){
         if(contaClick==3){
         gm.ui.createMessage("Elf:Temeria..my name... .I want give you something,\n take this magic fire-bomb to use with this sling \n they help you in every dangerous moment\n farewell");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
         gm.user.hasBomb();
         gm.user.hasSling();
        
         }
       }
       public void talkElf4(){
         if(contaClick==4){
         gm.ui.createMessage("Me:Temeria.. i hope you forgive your sister one day,\n i know her and i'm sure she never hurt you");
         gm.rootManager.getChildren().add(gm.ui.la);
        
         fineDiscorso=true;
         }
     }
         
         
       
       public void followingScene(){
           gm.ui.changeRight.setOnAction(event->{
               if(fineDiscorso==true){
                   gm.rootManager.getChildren().remove(root);
                   contaClick=1;
                   fineDiscorso=false;
                    gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario8");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
                   gm.sc.showScenario8();
               }
           });
       }
     
    
}
