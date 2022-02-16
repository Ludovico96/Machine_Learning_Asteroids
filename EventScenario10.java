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
public class EventScenario10 {
    GameManager gm;
    
    
     public String oggettoScenario;
   public String[] actions;
   public String[] consequences;
    
    public int contaClick=1;
    public boolean fineDiscorso;
    
    
    public EventScenario10(GameManager gm){
        this.gm=gm;
    }
    
     public EventScenario10(String oggettoScenario,String[] actions,String[] consequences){
        this.oggettoScenario=oggettoScenario;
        this.actions=actions;
        this.consequences=consequences;
    }
     
     public void clickIsland(){
         gm.rootManager.getChildren().remove(gm.ui.actionVbox);
          gm.rootManager.getChildren().remove(gm.ui.la);
          talkIsland();
     }
     
     public void talkIsland(){
         gm.ui.createMessage("Finally i escape from the shark \n and i arrive to the beach ");
         gm.rootManager.getChildren().add(gm.ui.la);
         }
     
     public void clickPalm(){
         gm.rootManager.getChildren().remove(gm.ui.actionVbox);
        gm.ui.createObjectMenu("look", "take", "doNothing");
        gm.rootManager.getChildren().add(gm.ui.actionVbox);
        gm.ui.actionVbox.getChildren().get(0).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            lookPalm();
        });
        
       gm.ui.actionVbox.getChildren().get(1).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
            takePalm();
        });
        gm.ui.actionVbox.getChildren().get(2).setOnMouseClicked(event->{
            gm.rootManager.getChildren().remove(gm.ui.la);
           doNothingPalm();
        });
        
     }
     
     public void lookPalm(){
         gm.ui.createMessage("It's a palm tree");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
     
     public void takePalm(){
          gm.ui.createMessage("ahhh a coconut..glu glu...glu glu");
         gm.rootManager.getChildren().add(gm.ui.la);
         gm.user.aggiungiVita();
     }
     
     public void doNothingPalm(){
          gm.ui.createMessage("Maybe i can restore my wealthy \n i must recover the strenght after the battle");
         gm.rootManager.getChildren().add(gm.ui.la);
     }
     
     public void restoreWeapon(){
         if(gm.user.possiediFionda=false){
             gm.user.possiediFionda=true;
             gm.rootManager.getChildren().add(gm.user.fionda);
         }
         if(gm.user.possiediScudo=false){
             gm.user.possiediScudo=true;
             gm.rootManager.getChildren().add(gm.user.scudo);
         }
         if(gm.user.possiediSpada=false){
             gm.user.possiediSpada=true;
             gm.rootManager.getChildren().add(gm.user.spada);
         }
         
         
     }
     
     public void followingScene(){
         gm.ui.changeRight.setOnAction(event->{
             gm.sc.showScenario11();
         });
     }
}
