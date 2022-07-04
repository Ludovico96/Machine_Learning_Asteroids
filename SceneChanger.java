
package progettovideogioco;


public class SceneChanger {
    GameManager gm;
    
    SceneChanger(GameManager gm){
        this.gm=gm;
    }
    
    public void showGameOver(){
        ScenarioGameOver scenarioEnd=new ScenarioGameOver(gm);
        gm.rootManager.getChildren().clear();
        scenarioEnd.creaScenario();
        gm.rootManager.getChildren().add(scenarioEnd.root);
        scenarioEnd.setAction();
        scenarioEnd.restartGame();
        
    }
    
    public void showScenario1PostGameOver(){
        PrimoScenario scenario1=new PrimoScenario(gm);
   
       gm.numeroScenario=1;
       gm.rootManager.getChildren().clear();
       scenario1.creaScenario();
       scenario1.setAction();
       gm.rootManager.getChildren().addAll(scenario1.root,gm.ui.staticVbox,gm.ui.insertNickname,gm.ui.startGame);
       gm.user.LifePlayer();
    }
    
    public void showScenario1(){
        PrimoScenario scenario1=new PrimoScenario(gm);
   
        gm.rootManager.getChildren().clear();
        scenario1.creaScenario();
        gm.rootManager.getChildren().addAll(scenario1.root,gm.ui.staticVbox,gm.ui.insertNickname,gm.ui.startGame);
        scenario1.setAction();
    }
    
    
   
  
    public void showScenario3(){
        TerzoScenario scenario3=new TerzoScenario(gm);
        gm.rootManager.getChildren().removeAll(gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        scenario3.creaScenario();
        scenario3.setAction();
        gm.rootManager.getChildren().addAll(scenario3.root);
        
        
    }
    
    public void showScenario4(){
        QuartoScenario scenario4=new QuartoScenario(gm);
        gm.rootManager.getChildren().removeAll(gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        scenario4.creaScenario();
        scenario4.setAction();
        gm.rootManager.getChildren().addAll(scenario4.root);
    }
    
    
    public void showScenario5(){
        QuintoScenario scenario5=new QuintoScenario(gm);
        gm.rootManager.getChildren().removeAll(gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        scenario5.creaScenario();
        scenario5.setAction();
        gm.rootManager.getChildren().addAll(scenario5.root);
    }
    
     public void showScenario6(){
         SestoScenario scenario6=new SestoScenario(gm);
        gm.rootManager.getChildren().removeAll(gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        scenario6.creaScenario();
        scenario6.setAction();
        gm.rootManager.getChildren().addAll(scenario6.root);
    }
     
     public void showScenario7(){
         SettimoScenario scenario7=new SettimoScenario(gm);
        gm.rootManager.getChildren().removeAll(gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        scenario7.creaScenario();
        scenario7.setAction();
        gm.rootManager.getChildren().addAll(scenario7.root);
    }
     
     public void showScenario8(){
         OttavoScenario scenario8=new OttavoScenario(gm);
        gm.rootManager.getChildren().removeAll(gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        scenario8.creaScenario();
        scenario8.setAction();
        gm.rootManager.getChildren().addAll(scenario8.root);
    }
     
     public void showScenario9(){
         NonoScenario scenario9=new NonoScenario(gm);
        gm.rootManager.getChildren().removeAll(gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        scenario9.creaScenario();
        scenario9.setAction();
        gm.rootManager.getChildren().addAll(scenario9.root);
    }
     
     public void showScenario10(){
         DecimoScenario scenario10=new DecimoScenario(gm);
        gm.rootManager.getChildren().removeAll(gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        scenario10.creaScenario();
        scenario10.setAction();
        gm.rootManager.getChildren().addAll(scenario10.root);
    }
     
    
     
     public void showScenario12(){
          DodicesimoScenario scenario12=new DodicesimoScenario(gm);
        gm.rootManager.getChildren().removeAll(gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        scenario12.creaScenario();
        scenario12.setAction();
        gm.rootManager.getChildren().addAll(scenario12.root);
    }
     
     public void showScenario13(){
          TredicesimoScenario scenario13=new TredicesimoScenario(gm);
        gm.rootManager.getChildren().removeAll(gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
        scenario13.creaScenario();
        scenario13.setAction();
        gm.rootManager.getChildren().addAll(scenario13.root);
    }
     
      public void showUltimoScenario(){
         UltimoScenario ultimoscenario=new UltimoScenario(gm);
         gm.rootManager.getChildren().removeAll(gm.ui.changeRight,gm.ui.actionVbox,gm.ui.la);
         ultimoscenario.creaScenario();
         ultimoscenario.setAction();
         gm.rootManager.getChildren().add(ultimoscenario.root);
    }
}
