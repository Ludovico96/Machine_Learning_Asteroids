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
public class EventScenario11 {
    GameManager gm;
    
    
     public String oggettoScenario;
   public String[] actions;
   public String[] consequences;
    
    public int contaClick=1;
    public boolean fineDiscorso;
    
    
    public EventScenario11(GameManager gm){
        this.gm=gm;
    }
    
     public EventScenario11(String oggettoScenario,String[] actions,String[] consequences){
        this.oggettoScenario=oggettoScenario;
        this.actions=actions;
        this.consequences=consequences;
    }
     
     public void clickVolcano(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
          gm.rootManager.getChildren().remove(gm.ui.la);
          lookVolcano();
     }
     
     public void lookVolcano(){
         gm.ui.createMessage("Finally i see the Volcano \n Arya must be breinged there \n i must move there is still \n a long way to go");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
     
     public void clickMagician(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "talk", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookMagician();
        });
        
       gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            if(contaClick==1){
            talkMagician();
            }else if(contaClick==2){
            talkMagician2();
            }else if(contaClick==3){
            talkMagician3();
            }else if(contaClick==4){
            talkMagician4();
            }else if(contaClick==5){
            talkMagician5();
            }else if(contaClick==6){
            talkMagician6();
            }else if(contaClick==7){
            talkMagician7();
            }else if(contaClick>7){
            talkMagician8();
            }
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
           doNothingMagician();
        });
     }
     
     public void lookMagician(){
         gm.ui.createMessage("And now???..Who is this old man?");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
     public void talkMagician(){
         gm.ui.createMessage("prepare yourself!!");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\magicSpell.wav");
         contaClick++;
     }
      public void talkMagician2(){
         gm.ui.createMessage("wait!!! what???");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\magicSpell.wav");
         contaClick++;
     }
      
       public void talkMagician3(){
         gm.ui.createMessage("SHIELD UPPPP!!!!");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\fireSpell.wav");
         
         contaClick++;
         gm.user.elimina2Vita();
     }
        public void talkMagician4(){
         gm.ui.createMessage("So...how i can exspect your shield \n can't resiste to the the magic of fire \n but you survived and that's is enough");
         gm.rootManager.getChildren().add(gm.ui.la);
         
         contaClick++;
     }
        
         public void talkMagician5(){
         gm.ui.createMessage("What are you saying \n you are crazy old man \n i kill you now \n i don't have any time, i must...");
         gm.rootManager.getChildren().add(gm.ui.la);
         
         contaClick++;
     }
         
         public void talkMagician6(){
         gm.ui.createMessage("save the princess.. i know \n but i test your preparation and you \n are not ready for what attend you \n in these volcano");
         gm.rootManager.getChildren().add(gm.ui.la);
         
         contaClick++;
     }
         
         public void talkMagician7(){
         gm.ui.createMessage("Take this magic formula \n is the only thing that could save you \n against the fire magic");
         gm.rootManager.getChildren().add(gm.ui.la);
         
         contaClick++;
     }
         
          public void talkMagician8(){
         gm.ui.createMessage("I want to help you the princess is necessary to \n the kingdom. I bring you directly to the Volcano \n enter in this magic portal");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.rootManager.getChildren().add(gm.scenario11.magicPortal);
         gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\magicPortal.wav");
         gm.ui.soundEffect.loop(10);
         contaClick++;
     }
         
         
     
     
     public void doNothingMagician(){
         gm.ui.createMessage("...");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
     
     public void clickPortal(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "enter", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookPortal();
        });
        
       gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            enterPortal();
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
           doNothingPortal();
        });
     }
     
     public void lookPortal(){
         gm.ui.createMessage("wow..really a magic portal? \n really i can arrive to the volcano in this way? ");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
     public void enterPortal(){
         gm.ui.createMessage(" .... let's do this \n Arya wait me.. i'm here!");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
     
     public void doNothingPortal(){
         gm.ui.createMessage("Should i trust the magician?");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
}
