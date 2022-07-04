
package progettovideogioco;

import java.util.Date;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class TredicesimoScenario {
    GameManager gm;
    
   
    Group root;
    private ImageView volcano;
    private ImageView dragoon;
    private ImageView light;
    private ImageView princess;
    private ImageView vortex;
    private ImageView stalattiti;
    private ImageView womanElf;
    private ImageView fire;
    
    
    private int contaClick=1;
    private int contaClick2=1;
    private int contaClickElf=1;
    private int contaClickPrincess=1;
    private int timerApparizioneAlleati=1;
    private boolean fineDiscorso;
    private int usiMagia=1;
    
   
    
    private int attacchiCasuali;
    private boolean deathDragon;
    private boolean flyDragon;
    private boolean scratchDragon;
    private boolean fireDragon;
    private boolean barrieraMagica;
    private boolean rockFallen;
    private int contaViteDrago=10;
    
    
    
    public TredicesimoScenario(GameManager gm){
        this.gm=gm;
    }
    
     
    //Creazione scenario
    public void creaScenario(){
        gm.numeroScenario=13;
        volcano=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\volcano.jpg");
        dragoon=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\dragoon.png", 600, 600, 200, 130);
        light=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\bianco.png");
        princess=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\princessRisveglio.png", 300, 300, 400, 300);
        vortex=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\spirale.png", 500, 500, 200, 300);
        stalattiti=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\stalattiti.png", 200, 200, 300, 20);
        womanElf=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\elf.png", 200, 200, 800, 500);
        fire=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\fireDragon.png", 400, 400, 200, 410);
        
        gm.ui.createButtonChangeScene();
        
        root=new Group(volcano,dragoon,princess,fire,vortex,stalattiti,womanElf,light,gm.ui.changeRight);
        dragoon.setVisible(false);
        light.setVisible(false);
        princess.setVisible(false);
       vortex.setVisible(false);
       womanElf.setVisible(false);
       fire.setVisible(false);
       
       if(gm.iniziaNuovaPartita==true){
            contaClick=1;
     contaClick2=1;
     contaClickElf=1;
     contaClickPrincess=1;
     timerApparizioneAlleati=1;
     usiMagia=1;
    
    fire.setVisible(false);
    deathDragon=false;
     flyDragon=false;
     scratchDragon=false;
     fireDragon=false;
    barrieraMagica=false;
     rockFallen=false;
     contaViteDrago=10;
       }
    }
    
    //Settaggio azioni
    public void setAction(){
        if(deathDragon==true){
            gm.ui.music.stop();
        }
        
      volcano.setOnMouseClicked(event->{
          clickVolcano();
      });
      
      dragoon.setOnMouseClicked(event->{
          clickDragon();
      });
      
      stalattiti.setOnMouseClicked(event->{
         clickStalactites();
      });
      
      womanElf.setOnMouseClicked(event->{
          clickElf();
      });
      
      light.setOnMouseClicked(event->{
          clickPrincess();
      });
      
     followingScene();
    }
    
    //Specifica azioni
     public void clickVolcano(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
          gm.rootManager.getChildren().remove(gm.ui.la);
          if(contaClick==1){
              lookVolcano();
          } else if(contaClick==2){
               lookVolcano2();
          }else if(contaClick==3){
               lookVolcano3();
          }
         
           gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookVolcano");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
     }
     
      public void lookVolcano(){
         gm.ui.createMessage("Me:Finally i arrive, Aryaaa where are you?");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
     }
      
       public void lookVolcano2(){
         gm.ui.createMessage("You hear a growl \n Me:This sound... the dragoon, but now i'm ready \n FIGHTTT MEEE!!!");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
     }
       
        public void lookVolcano3(){
         
         dragoon.setVisible(true);
         contaClick++;
     }
        
        public void clickDragon(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("Look", "Attack", "UseMagic");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookDragon();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookDragon");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
        });
        
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            attackDragon();
            timerApparizioneAlleati++;
            appearElf();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"attackDragon");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
        });
        
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            doMagicDragon();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doMagicDragon");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
        });
     }
        
        public void lookDragon(){
            if(deathDragon==false){
            gm.ui.createMessage("Me:Finally i can defeat you and save the princess");
             gm.rootManager.getChildren().add(gm.ui.la);
            }
             
        }
        
        public void attackDragon(){
            if(deathDragon==false){
                attacchiCasuali=(int) (Math.random()*6);
                if(flyDragon==false){
                if(attacchiCasuali<=1){
                    scratchDragon();
                    if(gm.user.possiediSpada==true&&gm.user.possiediScudo==false){
                        if(contaViteDrago==1){
                            defeatDragon();
                        }else{
                        gm.rootManager.getChildren().remove(gm.ui.la);
                        gm.ui.createMessage("You hurt the dragon \n the dragon scratch you");
                        gm.rootManager.getChildren().add(gm.ui.la);
                        contaViteDrago--;
                      gm.user.elimina2Vita();
                        }
                    }else if(gm.user.possiediSpada==true&&gm.user.possiediScudo==true){
                       if(contaViteDrago==1){
                            defeatDragon();
                        }else{
                        gm.rootManager.getChildren().remove(gm.ui.la);
                        gm.ui.createMessage("You hurt the dragon \n you parry the dragon");
                        contaViteDrago--;
                        gm.rootManager.getChildren().add(gm.ui.la);
                       }
                    }
                }else if(attacchiCasuali>1&&attacchiCasuali<4){
                    flyDragon();
                    gm.rootManager.getChildren().remove(gm.ui.la);
                        gm.ui.createMessage("The dragon fly i can't attack");
                        gm.rootManager.getChildren().add(gm.ui.la);
                }else if(attacchiCasuali>4){
                    dragonFire();
                    fire.setVisible(true);
                      FadeTransition fadeTransition2 = 
            new FadeTransition(Duration.millis(4000), fire);
        fadeTransition2.setFromValue(1.0f);
        fadeTransition2.setToValue(0.0f);
        fadeTransition2.setCycleCount(1);
        fadeTransition2.setAutoReverse(true);
        fadeTransition2.play();
                    if(barrieraMagica==false&&gm.user.possiediScudo==false){
                        gm.rootManager.getChildren().remove(gm.ui.la);
                        gm.ui.createMessage("The dragon breathing fire");
                        gm.rootManager.getChildren().add(gm.ui.la);
                        gm.user.elimina3Vita();
                    }else if(barrieraMagica==false&&gm.user.possiediScudo==true){
                        gm.rootManager.getChildren().remove(gm.ui.la);
                        gm.ui.createMessage("The dragon breathing fire \n you parry the magic fire");
                        gm.rootManager.getChildren().add(gm.ui.la);
                        gm.user.elimina2Vita();
                    }else if(barrieraMagica==true){
                          FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(3000), vortex);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
       barrieraMagica=false;
                        if(contaViteDrago<=3){
                            defeatDragon();
                        }else{
                        gm.rootManager.getChildren().remove(gm.ui.la);
                        gm.ui.createMessage("The Magic mirror refects the dragon's \n attack and send back the fire \n against it ");
                        gm.rootManager.getChildren().add(gm.ui.la);
                        contaViteDrago=contaViteDrago-3;
                        }
                    }
                }
                }else if(flyDragon==true){
                    dragonLand();
                    if(barrieraMagica==true ){
                    FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(3000), vortex);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
         barrieraMagica=false;
         gm.rootManager.getChildren().remove(gm.ui.la);
                        gm.ui.createMessage("The dragon land destroy my magic ");
                        gm.rootManager.getChildren().add(gm.ui.la);
                    }
                       else{
                            gm.rootManager.getChildren().remove(gm.ui.la);
                        gm.ui.createMessage("The dragon arrive in fligth against me \n you dodge the attack");
                        gm.rootManager.getChildren().add(gm.ui.la);
                        }
                }
            }
            
        
        }
        
        public void doMagicDragon(){
            if(deathDragon==false && usiMagia<3){
            barrieraMagica=true;
             gm.ui.createMessage("i create this magic shield");
             vortex.setVisible(true);
             usiMagia++;
             FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(3000), vortex);
        fadeTransition.setFromValue(0.0f);
        fadeTransition.setToValue(1.0f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(true);
       
        
        RotateTransition rotateTransition = 
            new RotateTransition(Duration.millis(3000), vortex);
        rotateTransition.setByAngle(1000000f);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                
                rotateTransition
                
        );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();
            }else{
                gm.ui.createMessage("i can't create the magic shield");
                gm.rootManager.getChildren().add(gm.ui.la);
            }
        }
       
        public void flyDragon(){
            flyDragon=true;
             TranslateTransition translateTransition =
            new TranslateTransition(Duration.millis(200), dragoon);
        translateTransition.setFromY(130);
        translateTransition.setToY(-800);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
        }
        
        public void dragonLand(){
            TranslateTransition translateTransition =
            new TranslateTransition(Duration.millis(200), dragoon);
        translateTransition.setFromY(-800);
        translateTransition.setToY(20);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
            flyDragon=false;
        }
        
        public void dragonFire(){
        }
        
        public void scratchDragon(){
            scratchDragon=true;
        }
        
        
        public void defeatDragon(){
            vortex.setVisible(false);
            deathDragon=true;
            gm.rootManager.getChildren().remove(gm.ui.la);
            gm.ui.createMessage("you defeat the dragon");
            gm.rootManager.getChildren().add(gm.ui.la);
            light.setVisible(true);
            FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(5000), light);
        fadeTransition.setFromValue(0.0f);
        fadeTransition.setToValue(1.0f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
        
        FadeTransition fadeTransition2 = 
            new FadeTransition(Duration.millis(4000), dragoon);
        fadeTransition2.setFromValue(1.0f);
        fadeTransition2.setToValue(0.0f);
        fadeTransition2.setCycleCount(1);
        fadeTransition2.setAutoReverse(true);
        fadeTransition2.play();
        
        princess.setVisible(true);
        FadeTransition fadeTransition3 = 
            new FadeTransition(Duration.millis(10000),princess);
        fadeTransition3.setFromValue(0.0f);
        fadeTransition3.setToValue(1.0f);
        fadeTransition3.setCycleCount(1);
        fadeTransition3.setAutoReverse(true);
        fadeTransition3.play();
        }
        
        
         public void clickStalactites(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("Look", "throwBomb", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookRock();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookRock");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
        });
        
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            bombRock();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"bombRock");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
        });
        
         gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingRock();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingRock");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
        });
     }
         
         public void lookRock(){
             gm.ui.createMessage("maybe i can...destroy it");
             gm.rootManager.getChildren().remove(gm.ui.la);
         }
         
         public void bombRock(){
             if(gm.user.possiediFionda==true && rockFallen==false){
                 rockFallen=true;
                 gm.ui.createMessage("you destroy the rock \n and hurt the dragon ");
             gm.rootManager.getChildren().remove(gm.ui.la);
             TranslateTransition translateTransition =
            new TranslateTransition(Duration.millis(2000), stalattiti);
        translateTransition.setFromY(20);
        translateTransition.setToY(20000);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
        if(flyDragon==false){
            if(contaViteDrago<=2){
                defeatDragon();
            }else{
        contaViteDrago=contaViteDrago-2;
            }
        }
             }
             
         }
         public void doNothingRock(){
             gm.ui.createMessage("(it seems fragile..)");
             gm.rootManager.getChildren().add(gm.ui.la);
         }
         
         
         public void appearElf(){
             if(timerApparizioneAlleati>4){
                womanElf.setVisible(true);
             }
         }
     
         public void clickElf(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
         gm.rootManager.getChildren().remove(gm.ui.la);
         System.out.println(contaClickElf);
          if(contaClickElf==1){
              talkElf();
          }else if(contaClickElf==2){
              talkElf2();
          }else if(contaClickElf==3){
              talkElf3();
          }else if(contaClickElf==4){
              talkElf4();
          }else if(contaClickElf==5){
              talkElf5();
          }else if(contaClickElf>5){
              gm.ui.createObjectMenu("Look", "order", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
          
          
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookElf();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"lookElf");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
        });
        
        gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            orderElf();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"orderElf");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
        });
        
         gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            doNothingElf();
             gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"doNothingElf");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
            
        });
          }
     }
         
         
         
          public void talkElf(){
             gm.ui.createMessage("Me:what are you doing here? \n don't you see the dragon?");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickElf++;
         }
          
          public void talkElf2(){
             gm.ui.createMessage("Temeria:Yes but i don't care about it ");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickElf++;
         }
          
          public void talkElf3(){
             gm.ui.createMessage("Me:How you arrive here?");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickElf++;
         }
          
          public void talkElf4(){
             gm.ui.createMessage("Temeria:Your magician friends think that \n you need help, and he was not wrong \n as i see");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickElf++;
         }
          
          public void talkElf5(){
             gm.ui.createMessage("Temeria:and..even i didn't forgive her \n i tried to save her..\n but now no more words let's fight\n i offer you my bow ");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickElf++;
         }
          
          
          
          public void lookElf(){
              gm.ui.createMessage("(maybe i can use this bow when..)");
             gm.rootManager.getChildren().add(gm.ui.la);
          }
          
          public void orderElf(){
              gm.ui.createMessage("Me:shot the dragon now!!!");
             gm.rootManager.getChildren().add(gm.ui.la);
             if(flyDragon==true){
                 gm.rootManager.getChildren().remove(gm.ui.la);
                  gm.ui.createMessage("the arrow hurt the dragon and it \n made him fall to the ground");
                  if(contaViteDrago==1){
                      defeatDragon();
                  }else{
                  contaViteDrago=contaViteDrago-1;
             gm.rootManager.getChildren().add(gm.ui.la);
             
             dragonLand();
                  }
             }else{
                 gm.rootManager.getChildren().remove(gm.ui.la);
                  gm.ui.createMessage("the dragon parry the shot");
                  gm.rootManager.getChildren().add(gm.ui.la);
             }
          }
          
          public void doNothingElf(){
              
          }
          
          public void clickPrincess(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
         gm.rootManager.getChildren().remove(gm.ui.la);
         
         System.out.println(fineDiscorso);
         
          if(contaClickPrincess==1){
              talkPrincess();
          }else if(contaClickPrincess==2){
              talkPrincess2();
          }else if(contaClickPrincess==3){
              talkPrincess3();
          }else if(contaClickPrincess==4){
              talkPrincess4();
          }else if(contaClickPrincess==5){
              talkPrincess5();
          }else if(contaClickPrincess==6){
              talkPrincess6();
          }else if(contaClickPrincess==7){
              talkPrincess7();
          }else if(contaClickPrincess==8){
              talkPrincess8();
          }else if(contaClickPrincess==9){
              talkPrincess9();
          }else if(contaClickPrincess==10){
              talkPrincess10();
          }else if(contaClickPrincess==11){
              talkPrincess11();
          }else if(contaClickPrincess==12){
              talkPrincess12();
          }else if(contaClickPrincess==13){
              talkPrincess13();
          }else if(contaClickPrincess==14){
              talkPrincess14();
          }else if(contaClickPrincess==15){
              talkPrincess15();
          }else if(contaClickPrincess==16){
              talkPrincess16();
          }else if(contaClickPrincess==17){
              talkPrincess17();
          }else if(contaClickPrincess==18){
              talkPrincess18();
          }else if(contaClickPrincess==19){
              talkPrincess19();
          }else if(contaClickPrincess>19){
              talkPrincess20();
          }
        }
          
          public void talkPrincess(){
              gm.ui.createMessage("Me:Arya..are you alive.. ");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
          
          public void talkPrincess2(){
              gm.ui.createMessage("Arya:thank you my friend..you free me \n from my prison");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
          
          public void talkPrincess3(){
              gm.ui.createMessage("Me:but what happened? you materialized yourself \n in front of me");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
          
          public void talkPrincess4(){
              gm.ui.createMessage("Arya:...");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
          
           public void talkPrincess5(){
              gm.ui.createMessage("Me:Arya talk to me!!!");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
           
           public void talkPrincess6(){
              gm.ui.createMessage("Arya:As i say tou free me from my prison..\n my flesh prison..");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
           
           public void talkPrincess7(){
              gm.ui.createMessage("As i say tou free me from my prison..\n my flesh prison..");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
           
           public void talkPrincess8(){
              gm.ui.createMessage("Me:What is mean? the dragon..are you? ");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
           
           public void talkPrincess9(){
              gm.ui.createMessage("Arya:i'm been cursed when i was child \n for all my life the curse was under \n control, thanks to the magician \n who send you here");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
           
           public void talkPrincess10(){
              gm.ui.createMessage("Arya:but sometimes the beast inside manifested\n itself.Do you remember Temeria \n when bring you away from me?");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
           
           public void talkPrincess11(){
              gm.ui.createMessage("Temeria:Yes i remember very well that day \n it influence all my life \n but what does it means? \n We have been separeted because of you?");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
           
           public void talkPrincess12(){
              gm.ui.createMessage("Arya:i apologize you Temeria, i'm not been \n a good sister i know, but \n all i'v done, i've done to pretect you");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
           
           public void talkPrincess13(){
              gm.ui.createMessage("Temeria:Arya...sister, if i had know \n i can help you \n i apologize for all accumuleted \n hanger against you");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
           
           public void talkPrincess14(){
              gm.ui.createMessage("Arya:don't worry my sister now everything will be ok, \n i apologize also with you,  miss the times when \n we used to play in that valley,\n I will always carry those memories with me");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
           
           public void talkPrincess15(){
             gm. ui.createMessage("Arya:now i must go, i used \n my last energy to say farawell");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
          }
           
            public void talkPrincess16(){
              gm.ui.createMessage("Temeria:nooooooo... Aryaaa \n Me:Aryaaa");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
             FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(3500), light);
        fadeTransition.setFromValue(0.0f);
        fadeTransition.setToValue(1.0f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
        
        
        FadeTransition fadeTransition2 = 
            new FadeTransition(Duration.millis(3500), princess);
        fadeTransition2.setFromValue(1.0f);
        fadeTransition2.setToValue(0.0f);
        fadeTransition2.setCycleCount(1);
        fadeTransition2.setAutoReverse(true);
        fadeTransition2.play();
      }
            
            public void talkPrincess17(){
             gm. ui.createMessage("Temeria:Aryaaa.. she's gone...why? This \n not make sense..");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
            }
            
             public void talkPrincess18(){
             gm. ui.createMessage("Me:She protected us");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
            }
             
              public void talkPrincess19(){
             gm. ui.createMessage("Temeria:Eh?..");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClickPrincess++;
            }
              
               public void talkPrincess20(){
             gm. ui.createMessage("Me:she sacrificed herself to protect \n the kigdom and us.. \n we ca't do anythig at this point \n we should go back home");
             gm.rootManager.getChildren().add(gm.ui.la);
             fineDiscorso=true;
            }
            
             public void followingScene(){
                  gm.ui.changeRight.setOnAction(event->{
            if(fineDiscorso==true){
               contaClick=1;
    contaClick2=1;
     contaClickElf=1;
    contaClickPrincess=1;
     timerApparizioneAlleati=1;
     fineDiscorso=false;
     deathDragon=false;
     flyDragon=false;
     fireDragon=false;
    barrieraMagica=false;
     rockFallen=false;
    contaViteDrago=10;
           gm.rootManager.getChildren().remove(root);
                 gm.azioniInGame=new AzioniInGame(new Date(System.currentTimeMillis()),"showScenario14");
           gm.inviaAzioni.serializzaAzioniXML(gm.azioniInGame);
                gm.sc.showUltimoScenario();
            }
        });
    }
             
            
            
           
}
