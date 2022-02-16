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
public class EventScenario7 {
    GameManager gm;
    
    
     public String oggettoScenario;
   public String[] actions;
   public String[] consequences;
    
    public int contaClick=1;
    public boolean fineDiscorso;
    
    
    public EventScenario7(GameManager gm){
        this.gm=gm;
    }
    
     public EventScenario7(String oggettoScenario,String[] actions,String[] consequences){
        this.oggettoScenario=oggettoScenario;
        this.actions=actions;
        this.consequences=consequences;
    }
     
     public void clickShip(){
         gm.rootManager.getChildren().remove(gm.ui.actionVbox);
          gm.rootManager.getChildren().remove(gm.ui.la);
          talkShip();
     }
     
     public void talkShip(){
         gm.ui.createMessage("Damn!! The weather got worse too fast \n it's not normal.. the ship will not resist too long");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.ui.createSoundEffect("C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\effettiSonori\\thunder.wav");
         fineDiscorso=true;
     }
     
     public void followinScene(){
         gm.ui.changeRight.setOnAction(event->{
             if(fineDiscorso==true){
//                 gm.ui.music.stop();
             gm.sc.showScenario8();
             }
         });
     }
     
   
}
