
package progettovideogioco;




import java.util.Date;
import javafx.scene.Group;
import javafx.scene.image.ImageView;



public class TerzoScenario {
    GameManager gm;
    
   
    Group root;
    private ImageView boscoCaverna;
    private ImageView vecchio;
    private ImageView caverna;
    private ImageView fuoco;
    
    
    
     private int contaClick=1;
    
    
    public TerzoScenario(GameManager gm){
        this.gm=gm;
    }
    
    //Crea scenario
    public void creaScenario(){
        gm.numeroScenario=3;
        boscoCaverna=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\boscoCaverna.jpg");
        caverna=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\caverna.png", 600, 550, 600, 130);
        vecchio=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\vecchio.png", 320, 320, 100, 395);
        fuoco=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\fuoco.png", 200,200, 300, 500);
        gm.ui.createButtonChangeScene();
        
        root=new Group(boscoCaverna,caverna,vecchio,fuoco,gm.ui.changeRight);
       if(gm.iniziaNuovaPartita==true){
           contaClick=1;
       }
       

    }
    
    //Settaggio azioni
    public void setAction(){
       vecchio.setOnMouseClicked(event->{
           clickOld();
        });
        
        caverna.setOnMouseClicked(event->{
           clickCavern();
        });
        
        fuoco.setOnMouseClicked(event->{
            clickFire();
         });
        
        
        
         boscoCaverna.setOnMouseClicked(event->{
            gm.rootManager.getChildren().removeAll(gm.ui.actionVbox,gm.ui.la);
            

        });
         
    }
    
    //Specifica azioni
   public void clickOld(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "talk", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookOld();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookOld");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             if(contaClick==1){
             talkOld();
             contaClick++;
             }else if(contaClick==2){
             talkOld2();
             }
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"talkOld");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoNothingOld();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingOld");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        
    }
    
    public void lookOld(){
        gm.ui.createMessage("It's an old man"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void talkOld(){
        gm.ui.createMessage("Hello my boy, \n do you want to help me?"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void talkOld2(){
         gm.ui.createMessage("Old man:I must enter in the cavern \n to find an erb to cure \n my sick daughter...please help me"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void DoNothingOld(){
        gm.ui.createMessage("Old man:Hy boy"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    
    public void clickCavern(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "enter", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookCavern();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookCavern");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             enterCavern();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"enterCavern");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoNothingCavern();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingCavern");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
    }
    
    
    public void lookCavern(){
        gm.ui.createMessage("it's a dark cavern"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void enterCavern(){
        if(gm.user.possiediTorcia==true){
            followingScene();
        }else{
        gm.ui.createMessage("(the cavern is too dark to enter)"); 
        gm.rootManager.getChildren().add(gm.ui.la);
        }
    }
    
    public void DoNothingCavern(){
        gm.ui.createMessage("fiuuuuuuuu......fiuuuuu...."); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    
    public void clickFire(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "Take", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookFire();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookFire");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             takeFire();
             gm.user.hasTorch();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"takeFire");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoNothingFire();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingFire");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
    }
    
    
    public void lookFire(){
        gm.ui.createMessage("it's a Bonfire"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void takeFire(){
        
        gm.ui.createMessage("You obtein a torch"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void DoNothingFire(){
        gm.ui.createMessage("(maybe i can light up the cavern)"); 
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    
    
    
    
    
    
    public void followingScene(){
           
        contaClick=1;
         gm.rootManager.getChildren().remove(root);
            gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario4");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
           gm.sc.showScenario4();
         
           
    
            
      
      
        
    }    
   }
   
  
