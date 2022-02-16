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
public class EventScenario8 {
    GameManager gm;
    
    
     public String oggettoScenario;
   public String[] actions;
   public String[] consequences;
    
    public int contaClick=1;
    public boolean fineDiscorso;
    
    
    public EventScenario8(GameManager gm){
        this.gm=gm;
    }
    
     public EventScenario8(String oggettoScenario,String[] actions,String[] consequences){
        this.oggettoScenario=oggettoScenario;
        this.actions=actions;
        this.consequences=consequences;
    }
     
     
     public void lostWeapon(){
         gm.user.possiediFionda=false;
         gm.user.possiediScudo=false;
         gm.user.possiediSpada=false;
         gm.user.possiediTorcia=false;
         gm.rootManager.getChildren().removeAll(gm.user.spada,gm.user.scudo,gm.user.torcia,gm.user.fionda);
     }
     
     public void clickUnderWater(){
         gm.rootManager.getChildren().remove(gm.ui.actionVbox);
          gm.rootManager.getChildren().remove(gm.ui.la);
          if(contaClick==1){
              talkUnderWater();
          }else if(contaClick==2){
              talkUnderWater2();
          }else if(contaClick==3){
              talkUnderWater3();
          }else if(contaClick==4){
              talkUnderWater4();
          }else if(contaClick>4){
              talkUnderWater5();
          }
     }
     
     public void talkUnderWater(){
         gm.ui.createMessage("I'm drowning damn after everything \n I've been through really ends like this? ");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
     }
     
     public void talkUnderWater2(){
         gm.ui.createMessage("Arya.. , where are you?  ");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
     }
     
     public void talkUnderWater3(){
         gm.ui.createMessage("It seems at the end i don't have \n the strength to save you ");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
     }
     
     public void talkUnderWater4(){
         gm.ui.createMessage("No, i must fight, i can't surrender \n i will arrive Arya wait for me \n i'm really near");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
     }
     
     public void talkUnderWater5(){
         gm.ui.createMessage("But first..i'm thinking about these shark");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
         fineDiscorso=true;
     }
     
     public void followingScene(){
         gm.ui.changeRight.setOnAction(event->{
             if(fineDiscorso==true){
//                 gm.ui.music.stop();
                 gm.sc.showScenario9();
             }
         });
     }
     
}
