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
public class EventScenario6 {
    GameManager gm;
    
    
     public String oggettoScenario;
   public String[] actions;
   public String[] consequences;
    
    public int contaClick=1;
    public boolean fineDiscorso;
    
    
    public EventScenario6(GameManager gm){
        this.gm=gm;
    }
    
     public EventScenario6(String oggettoScenario,String[] actions,String[] consequences){
        this.oggettoScenario=oggettoScenario;
        this.actions=actions;
        this.consequences=consequences;
    }
     public void clickElf(){
          gm.rootManager.getChildren().remove(gm.ui.actionVbox);
          gm.rootManager.getChildren().remove(gm.ui.la);
          if(contaClick==1){
              talkElf();
          }else if(contaClick==2){
              talkElf2();
          }else if(contaClick>2){
              talkElf3();
          }
          
          
     }
     
     public void talkElf(){
         if(contaClick==1){
         gm.ui.createMessage("So, we arrive, the port is near \n follow the river, a ship \n bring you near to the island \n where the volcano is located");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
         }
     }
     
      public void talkElf2(){
         if(contaClick==2){
         gm.ui.createMessage("(Thank you, really, i hope you forgive \n your sister, i know she take care about you)");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
         }
     }
      
       public void talkElf3(){
         if(contaClick==3){
         gm.ui.createMessage("... i want give you something, take this magic fire-bomb \n to use with this sling \n they help you in every dangerous moment \n farewell");
         gm.rootManager.getChildren().add(gm.ui.la);
         contaClick++;
         gm.user.hasBomb();
         gm.user.hasSling();
         fineDiscorso=true;
         }
     }
       
       public void followingScene(){
           gm.ui.changeRight.setOnAction(event->{
               if(fineDiscorso==true){
                   gm.sc.showScenario7();
               }
           });
       }
     
     
}
