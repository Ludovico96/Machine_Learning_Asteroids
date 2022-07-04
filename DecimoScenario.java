
package progettovideogioco;


import java.util.Date;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;



public class DecimoScenario {
    
    GameManager gm;
    
    Group root;
    private ImageView underWaterShark;
    private ImageView nearBarrel;
    private ImageView farBarrel;
    private ImageView spadaReale;
    private ImageView scudoReale;
    private ImageView fiondaReale;
    private ImageView farBolle;
    private ImageView nearBolle;
    private ImageView farExplosion;
    private ImageView nearExplosion;
   
    private int contaClick=1;
    private int contaViteSqualo=6;
    private int attacchiCasuali;
    private boolean morteSqualo;
    private boolean nearBarrelExploded;
    private boolean farBarrelExploded;
    
   
    public DecimoScenario(GameManager gm){
        this.gm=gm;
    }
    
    //Creazione scenario
    public void creaScenario(){
        gm.numeroScenario=10;
        underWaterShark=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\underWaterShark.png");
        nearBarrel=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\barrel.png", 300, 280, 720, 420);
        farBarrel=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\barrel.png", 150, 150, 50, 100);
        spadaReale=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\spadaReale.png", 150, 150, 200, 80);
        scudoReale=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\scudoReale.png", 200, 200, 750, 250);
        fiondaReale=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\fiondaReale.png", 200, 200, 50, 400);
        nearExplosion=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\explosion.png", 350, 350, 720, 420);
        farExplosion=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\explosion.png", 200, 200, 50, 100);
        nearBolle=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\bolle.png", 200, 200, 720, 420);
        farBolle=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\bolle.png", 100, 100, 50, 100);
        
        gm.ui.createButtonChangeScene();
        
        root=new Group(underWaterShark,nearBarrel,nearExplosion,farBarrel,farExplosion,spadaReale,scudoReale,fiondaReale,nearBolle,farBolle,gm.ui.changeRight);
       
        nearExplosion.setVisible(false);
        farExplosion.setVisible(false);
        
        animationBolle();
        
         if(gm.iniziaNuovaPartita==true){
            contaClick=1;
            contaViteSqualo=6;
            morteSqualo=false;
            nearBarrelExploded=false;
            farBarrelExploded=false;
       }
    }
    
    //Settaggio azioni
    public void setAction(){
        underWaterShark.setOnMouseClicked(event->{
           clickShark();
        });
        
        fiondaReale.setOnMouseClicked(event->{
           clickSling();
        });
        
        nearBarrel.setOnMouseClicked(event->{
            clicknearBarrel();
        });
        
        farBarrel.setOnMouseClicked(event->{
           clickFarBarrel();
        });
        
        spadaReale.setOnMouseClicked(event->{
            clickSword();
        });
        
        scudoReale.setOnMouseClicked(event->{
            clickShield();
        });
        
        followingScene();
    }
    
    //Specifica azioni
    public void clickShark(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.rootManager.getChildren().remove(gm.ui.la);
        if(contaClick==1){
        gm.ui.createMessage("(Fuck... the shark is too near \n i must found a way to fight it \n i have to hurry i can't resist to much underwater)");
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
        } else if(contaClick==2){
            gm.ui.createMessage("(My weapon.. they are fall into the water \n when th ship is exploded \n i must recover them in some way)");
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
        } else if(contaClick>2){
         gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.rootManager.getChildren().remove(gm.ui.la);
        gm.ui.createObjectMenu("look", "Attack", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookShark();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookShark");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             attackShark();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"attackShark");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingShark();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingShark");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        }
     }
     
     
     public void lookShark(){
         if(morteSqualo==true){
        gm.ui.createMessage("The shark is dead");
        gm.rootManager.getChildren().add(gm.ui.la);
         }else{
        gm.ui.createMessage("So face to face, i can't lose this challenge");
        gm.rootManager.getChildren().add(gm.ui.la);
         }
        
        
     }
     public void attackShark(){
         if(morteSqualo==true){
        gm.ui.createMessage("The shark is dead");
        gm.rootManager.getChildren().add(gm.ui.la);
         }else{
         attacchiCasuali=(int) (Math.random()*4);
         if(gm.user.possiediSpada==false && gm.user.possiediScudo==false){
         gm.ui.createMessage("(I can't fight with my hand, \n i must recover my weapon)");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.elimina2Vita();
         } else if(gm.user.possiediSpada==true && gm.user.possiediScudo==false){
        gm.ui.createMessage("you hurt the shark \n the shark hurt you");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.elimina2Vita();
        if(contaViteSqualo==1){
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("You defeat the shark");
            gm.rootManager.getChildren().add(gm.ui.la);
            morteSqualo=true;
        }else {
            contaViteSqualo--;
        }
        
         }else if(gm.user.possiediSpada==false && gm.user.possiediScudo==true){
             if(attacchiCasuali<2){
                 gm.ui.createMessage("The shark hurt you");
                 gm.rootManager.getChildren().add(gm.ui.la);
                 gm.user.eliminaVita();
             } else if(attacchiCasuali>=2){
                 gm.ui.createMessage("You parry the shark attack");
                 gm.rootManager.getChildren().add(gm.ui.la);
             }
             
         }else if(gm.user.possiediSpada==true && gm.user.possiediScudo==true){
             if(attacchiCasuali<2){
                 gm.ui.createMessage("you hurt the shark \n the shark hurt you");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.eliminaVita();
        if(contaViteSqualo==1){
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("You defeat the shark");
            gm.rootManager.getChildren().add(gm.ui.la);
            morteSqualo=true;
        }else {
            contaViteSqualo--;
        }
             }else if(attacchiCasuali>=2){
                 gm.ui.createMessage("you hurt the shark \n you parry the shark attack");
        gm.rootManager.getChildren().add(gm.ui.la);
       
        if(contaViteSqualo==1){
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("You defeat the shark");
            gm.rootManager.getChildren().add(gm.ui.la);
            morteSqualo=true;
        }else {
            contaViteSqualo--;
        }
             }
         }
         }
     }
     public void doNothingShark(){
         if(morteSqualo==true){
        gm.ui.createMessage("The shark is dead");
        gm.rootManager.getChildren().add(gm.ui.la);
         }else{
         gm.ui.createMessage("i must defeat the shark \n i can't stay too much underWater");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.eliminaVita();
         }
     }
     
    
     public void clicknearBarrel(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.rootManager.getChildren().remove(gm.ui.la);
         gm.ui.createObjectMenu("look", "ThrowBomb", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookNearBarrel();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookNearBarrel");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             useNearBarrel();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"useNearBarrel");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingNearBarrel();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothngNearBarrel");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
     
    }
    
    public void lookNearBarrel(){
        gm.ui.createMessage("(The barrel that are into the ship \n it's full of gunpowder)");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void useNearBarrel(){
        if(gm.user.possiediFionda==false && nearBarrelExploded==false){
        gm.ui.createMessage("(I throw the bomb...AHHHHHH \n  i can't throw the bomb too far underwater\n it is exploded near to me)");
        gm.user.elimina3Vita();
        nearBarrelExploded=true;
        gm.rootManager.getChildren().add(gm.ui.la);
         animationNearBarrel();
        }
        
        if(gm.user.possiediFionda==true && nearBarrelExploded==false){
        gm.ui.createMessage("(I throw the bomb with my sling \n perfect the barrel exploded and \n the shark is hurted and temporarily escaped \n this is a good moment to recover my equipment)");
        nearBarrelExploded=true;
        gm.rootManager.getChildren().add(gm.ui.la);
        animationNearBarrel();
 
        if(contaViteSqualo==1){
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("You defeat the shark");
            gm.rootManager.getChildren().add(gm.ui.la);
            morteSqualo=true;
        }else {
            contaViteSqualo=contaViteSqualo-2;;
        }
        
        }
    }
    
    public void doNothingNearBarrel(){
        gm.ui.createMessage("(A barrel, maybe i can use it in some way \n i can't stay too much underWater)");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.eliminaVita();
    }
    
    
     public void clickFarBarrel(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.rootManager.getChildren().remove(gm.ui.la);
         gm.ui.createObjectMenu("look", "ThrowBomb", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookFarBarrel();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookFarBarrel");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             useFarBarrel();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"useFarBarrel");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingFarBarrel();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingFarBarrel");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
     
    }
    
    public void lookFarBarrel(){
        gm.ui.createMessage("(The barrel that are into the ship \n it's full of gunpowder)");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void useFarBarrel(){
        if(gm.user.possiediFionda==false && farBarrelExploded==false){
        gm.ui.createMessage("(I throw the bomb...AHHHHHH \n  i can't throw the bomb to far underwater\n it exploded too near to me)");
        gm.user.elimina3Vita();
        farBarrelExploded=true;
        gm.rootManager.getChildren().add(gm.ui.la);
      animationFarBarrel();
        }else if(gm.user.possiediFionda==true && farBarrelExploded==false){
        gm.ui.createMessage("(I throw the bomb with my sling \n perfect the barrel exploded and \n the shark is hurted and temporarily escaped \n this is a good moment to recover my equipment)");
        farBarrelExploded=true;
        gm.rootManager.getChildren().add(gm.ui.la);
         animationFarBarrel();
        if(contaViteSqualo==1){
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("You defeat the shark");
            gm.rootManager.getChildren().add(gm.ui.la);
            morteSqualo=true;
        }else {
            contaViteSqualo--;
        }
        }
    }
    
    public void doNothingFarBarrel(){
        gm.ui.createMessage("(A barrel, maybe i can use it in some way \n i can't stay too much underWater)");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.eliminaVita();
    }
     
    public void clickSling(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.rootManager.getChildren().remove(gm.ui.la);
         gm.ui.createObjectMenu("look", "take", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookSling();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookSling");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             takeSling();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"takeSling");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingSling();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingSling");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
     
    }
    
    public void lookSling(){
        gm.ui.createMessage("(It's my sling it is too near , i try to take him)");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void takeSling(){
        gm.ui.createMessage("you take the sling");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.hasSling();
        fiondaReale.setVisible(false);
    }
    
    public void doNothingSling(){
        gm.ui.createMessage("(i can't stay too much underWater)");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.eliminaVita();
    }
    
    
    public void clickSword(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.rootManager.getChildren().remove(gm.ui.la);
         gm.ui.createObjectMenu("look", "take", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookSword();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookSword");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             takeSword();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"takeSword");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingSword();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingSword");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
     
    }
    
    public void lookSword(){
        gm.ui.createMessage("(It's my sword it is too far , i try to take him)");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void takeSword(){
        if(farBarrelExploded==false){
        gm.ui.createMessage("(AHHHHHH, the shark attack me \n it is too fast and the sword is too far \n i can't take it in this way)");
        gm.user.elimina2Vita();
        gm.rootManager.getChildren().add(gm.ui.la);
        
        }else{
        gm.ui.createMessage("(I take my sword, finally i can fight)");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.hasSword();
        spadaReale.setVisible(false);
        }
        
    }
    
    public void doNothingSword(){
        gm.ui.createMessage("(i can't stay too much underWater)");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.eliminaVita();
    }
    
    public void clickShield(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.rootManager.getChildren().remove(gm.ui.la);
         gm.ui.createObjectMenu("look", "take", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             lookShield();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookShield");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             takeShield();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"takeShield");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingShield();
              gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingShield");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
        });
     
    }
    
    public void lookShield(){
        gm.ui.createMessage("(It's my shield it is too near , i try to take him)");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void takeShield(){
        if(nearBarrelExploded==false){
        gm.ui.createMessage("(AHHHHHH, the shark attack me \n it is too fast and the sword is too far \n i can't take it in this way)");
        gm.user.elimina2Vita();
        gm.rootManager.getChildren().add(gm.ui.la);
        
        }else{
        gm.ui.createMessage("(I take my shield, finally i can defend myself)");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.hasShield();
        scudoReale.setVisible(false);
        }
        
    }
    
    public void doNothingShield(){
        gm.ui.createMessage("(i can't stay too much underWater)");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.eliminaVita();
    }
    
    public void animationFarBarrel(){
        farExplosion.setVisible(true);
        FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(2000), farExplosion);
        fadeTransition.setFromValue(0.0f);
        fadeTransition.setToValue(1.0f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        
        
        farBarrel.setVisible(false);
        FadeTransition fadeTransition2 = 
            new FadeTransition(Duration.millis(3000), farBarrel);
        fadeTransition2.setFromValue(01.0f);
        fadeTransition2.setToValue(0.0f);
        fadeTransition2.setCycleCount(1);
        fadeTransition2.setAutoReverse(true);
        
        
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                fadeTransition2
        );
        parallelTransition.setCycleCount(1);
        parallelTransition.play();
    }
    
    public void animationNearBarrel(){
        nearExplosion.setVisible(true);
        FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(2000), nearExplosion);
        fadeTransition.setFromValue(0.0f);
        fadeTransition.setToValue(1.0f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        
        
        nearBarrel.setVisible(false);
        FadeTransition fadeTransition2 = 
            new FadeTransition(Duration.millis(3000), nearBarrel);
        fadeTransition2.setFromValue(01.0f);
        fadeTransition2.setToValue(0.0f);
        fadeTransition2.setCycleCount(1);
        fadeTransition2.setAutoReverse(true);
        
        
         ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                fadeTransition2
        );
        parallelTransition.setCycleCount(1);
        parallelTransition.play();
    }
    
    public void animationBolle(){
                TranslateTransition translateTransition =
            new TranslateTransition(Duration.millis(2000), nearBolle);
        translateTransition.setFromY(0);
        translateTransition.setToY(-600);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        
        FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(1000), nearBolle);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
        
     SequentialTransition   sequentialTransition = new SequentialTransition();
sequentialTransition.getChildren().addAll(
       
        translateTransition,
        fadeTransition
       );
sequentialTransition.setCycleCount(Timeline.INDEFINITE);
sequentialTransition.setAutoReverse(true);

sequentialTransition.play();

TranslateTransition translateTransition2 =
            new TranslateTransition(Duration.millis(2000), farBolle);
        translateTransition2.setFromY(600);
        translateTransition2.setToY(-100);
        translateTransition2.setCycleCount(1);
        translateTransition2.setAutoReverse(true);
        
        FadeTransition fadeTransition2 = 
            new FadeTransition(Duration.millis(1000), farBolle);
        fadeTransition2.setFromValue(1.0f);
        fadeTransition2.setToValue(0.0f);
        fadeTransition2.setCycleCount(1);
        fadeTransition2.setAutoReverse(true);
        
     SequentialTransition   sequentialTransition2 = new SequentialTransition();
sequentialTransition2.getChildren().addAll(
        
        translateTransition2,
        fadeTransition2
       );
sequentialTransition2.setCycleCount(Timeline.INDEFINITE);
sequentialTransition2.setAutoReverse(true);

sequentialTransition2.play();
    }
    
    public void followingScene(){

        gm.ui.changeRight.setOnAction(event->{
            if(morteSqualo==true){
                contaClick=1;
           contaViteSqualo=6;
           morteSqualo=false;
           farBarrelExploded=false;
           nearBarrelExploded=false;
           gm.rootManager.getChildren().remove(root);
                 gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario12");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
                gm.sc.showScenario12();
            }
        });
    }
}
