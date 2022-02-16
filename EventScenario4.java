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
public class EventScenario4 {
    GameManager gm;
    
    
     public String oggettoScenario;
   public String[] actions;
   public String[] consequences;
    
    public int contaClick=1;
    public boolean frecciaScoccata;
    
    
    public EventScenario4(GameManager gm){
        this.gm=gm;
    }
    
     public EventScenario4(String oggettoScenario,String[] actions,String[] consequences){
        this.oggettoScenario=oggettoScenario;
        this.actions=actions;
        this.consequences=consequences;
    }
     
     public void clickForest(){
         gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("listen", "Parry/Talk", "Roll");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             listenForest();
             
             
        });
        
         gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoSomethingForest();
             
        });
         
          gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
             gm.rootManager.getChildren().remove(gm.ui.la);
             DoNothingForest();
             
        });
     }
     
     public void listenForest(){
         frecciaScoccata=true;
         if(contaClick==1){
         gm.ui.createMessage("Finally, i am out of the cavern \n This forest is so amazing and so big \n it seems like a dream but...\n waht is this sound?");
         gm.rootManager.getChildren().add(gm.ui.la);
         
         
         gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\arrow2.wav");
         }else if(contaClick>1){
             gm.rootManager.getChildren().remove(gm.ui.la);
             gm.ui.createMessage("another time? The same sound..");
              gm.rootManager.getChildren().add(gm.ui.la);
             gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\arrow2.wav");
             
         }
     }
     
     public void DoSomethingForest(){
         if(gm.user.possiediScudo==true){
         if(frecciaScoccata==true ){
             
         gm.ui.createMessage("(SHIELD UP!!!!)");
          gm.rootManager.getChildren().add(gm.ui.la);
          frecciaScoccata=false;
          contaClick++;
          gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\shieldParry.wav");
         } else if( contaClick>2){
             gm.rootManager.getChildren().remove(gm.ui.la);
             gm.ui.createMessage("(Who are you, i just want to talk, \n show yourself i don't wonna fight!)");
             gm.rootManager.getChildren().add(gm.ui.la);
             contaClick++;
        }
       }else{
             if(frecciaScoccata==true ){
                 gm.ui.createMessage("An arrow hurt you \n (AHHHHH something hurt me)");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.user.eliminaVita();
         frecciaScoccata=false;
         gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\arrow1.wav");
             }
         }
     }
     
     public void DoNothingForest(){
         if(frecciaScoccata==true){
         gm.ui.createMessage("An arrow hurt you \n (AHHHHH something hurt me)");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.user.eliminaVita();
         frecciaScoccata=false;
         gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\arrow1.wav");
         contaClick++;
         
         }
     }
     
     public void followingScene(){
         gm.ui.changeRight.setOnAction(event->{
             if(contaClick>3){
                 gm.sc.showScenario5();
             }
             
         });
     }
    
    
    
}
