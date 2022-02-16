/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

/**
 *
 * @author Utente
 */
public class EventScenario9 {
     GameManager gm;
    
    
     public String oggettoScenario;
   public String[] actions;
   public String[] consequences;
    
    public int contaClick=1;
    public int contaViteSqualo=6;
    public int attacchiCasuali;
    public boolean morteSqualo;
    public boolean nearBarrelExploded;
    public boolean farBarrelExploded;
    
    
    public EventScenario9(GameManager gm){
        this.gm=gm;
    }
    
     public EventScenario9(String oggettoScenario,String[] actions,String[] consequences){
        this.oggettoScenario=oggettoScenario;
        this.actions=actions;
        this.consequences=consequences;
    }
     
     
     
     
     public void clickShark(){
        gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.rootManager.getChildren().remove(gm.ui.la);
        if(contaClick==1){
        gm.ui.createMessage("Fuck... the shark is too near \n i must found a way to fight it \n i have to hurry i can't resist to much underwater");
        gm.rootManager.getChildren().add(gm.ui.la);
        contaClick++;
        } else if(contaClick==2){
            gm.ui.createMessage("My weapon.. they are fall into the water \n when th ship is exploded \n i must recover them in some way");
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
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             attackShark();
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingShark();
             
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
         gm.ui.createMessage("I can't fight with my hand, \n i must recover my weapon");
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
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             useNearBarrel();
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingNearBarrel();
             
        });
     
    }
    
    public void lookNearBarrel(){
        gm.ui.createMessage("The barrel that are into the ship \n it's full of gunpowder");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void useNearBarrel(){
        if(gm.user.possiediFionda==false && nearBarrelExploded==false){
        gm.ui.createMessage("I throw the bomb...AHHHHHH \n  i can't throw the bomb to far underwater\n it exploded too near to me");
        gm.user.elimina3Vita();
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\barrelExplosion.wav");
        }
        
        if(gm.user.possiediFionda==true && nearBarrelExploded==false){
        gm.ui.createMessage("I throw the bomb with my sling \n perfect the barrel exploded and \n the shark is hurted and temporarily escaped \n this is a good moment to recover my equipment");
        nearBarrelExploded=true;
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\barrelExplosion.wav");
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
        gm.ui.createMessage("A barrel, maybe i can use it in some way \n i can't stay too much underWater");
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
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             useFarBarrel();
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingFarBarrel();
             
        });
     
    }
    
    public void lookFarBarrel(){
        gm.ui.createMessage("The barrel that are into the ship \n it's full of gunpowder");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void useFarBarrel(){
        if(gm.user.possiediFionda==false && farBarrelExploded==false){
        gm.ui.createMessage("I throw the bomb...AHHHHHH \n  i can't throw the bomb to far underwater\n it exploded too near to me");
        gm.user.elimina3Vita();
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\barrelExplosion.wav");
        }else if(gm.user.possiediFionda==true && farBarrelExploded==false){
        gm.ui.createMessage("I throw the bomb with my sling \n perfect the barrel exploded and \n the shark is hurted and temporarily escaped \n this is a good moment to recover my equipment");
        farBarrelExploded=true;
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\barrelExplosion.wav");
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
        gm.ui.createMessage("A barrel, maybe i can use it in some way \n i can't stay too much underWater");
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
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             takeSling();
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingSling();
             
        });
     
    }
    
    public void lookSling(){
        gm.ui.createMessage("It's my sling it is too near , i try to take him");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void takeSling(){
        gm.ui.createMessage("you take the sling");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.hasSling();
    }
    
    public void doNothingSling(){
        gm.ui.createMessage("i can't stay too much underWater");
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
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             takeSword();
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingSword();
             
        });
     
    }
    
    public void lookSword(){
        gm.ui.createMessage("It's my sword it is too far , i try to take him");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void takeSword(){
        if(farBarrelExploded==false){
        gm.ui.createMessage("AHHHHHH, the shark attack me \n it is too fast and the sword is too far \n i can't take it in this way");
        gm.user.elimina2Vita();
        gm.rootManager.getChildren().add(gm.ui.la);
        
        }else{
        gm.ui.createMessage("I take my sword, finally i can fight");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.hasSword();
        }
        
    }
    
    public void doNothingSword(){
        gm.ui.createMessage("i can't stay too much underWater");
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
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             takeShield();
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingShield();
             
        });
     
    }
    
    public void lookShield(){
        gm.ui.createMessage("It's my shield it is too near , i try to take him");
        gm.rootManager.getChildren().add(gm.ui.la);
    }
    
    public void takeShield(){
        if(nearBarrelExploded==false){
        gm.ui.createMessage("AHHHHHH, the shark attack me \n it is too fast and the sword is too far \n i can't take it in this way");
        gm.user.elimina2Vita();
        gm.rootManager.getChildren().add(gm.ui.la);
        
        }else{
        gm.ui.createMessage("I take my shield, finally i can defend myself");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.hasShield();
        }
        
    }
    
    public void doNothingShield(){
        gm.ui.createMessage("i can't stay too much underWater");
        gm.rootManager.getChildren().add(gm.ui.la);
        gm.user.eliminaVita();
    }
    
    public void followingScene(){
//        gm.ui.music.stop();
        gm.ui.changeRight.setOnAction(event->{
            if(morteSqualo==true){
                gm.sc.showScenario10();
            }
        });
    }
}
