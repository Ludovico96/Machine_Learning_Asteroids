
package progettovideogioco;


import javafx.scene.Group;
import javafx.scene.image.ImageView;



public class menuScenario {
    private GameManager gm;
    private ImageView sfondo;
    private ImageView spada;
    private ImageView drago;
    private ImageView scudo;
    
    
   
    Group root;
    
    public menuScenario(GameManager gm){
        this.gm=gm;
    }
    
    public void creaScenario(){
        sfondo=gm.ui.creatScenario("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\sfondoFuoco2.jpg");
        drago=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\dragoMenu.png", 
                600, 700, 270, 100);
      scudo=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\scudoMenu.png", 
                300, 300, 350, 300);
        spada=gm.ui.creatObject("File:\\C:\\prg\\myapps\\ProgettoVideogioco\\src\\progettovideogioco\\ImmaginiScenario1\\spadaMenu.png", 400, 300, 350, 300);
        
        
        root=new Group(sfondo,drago,scudo,spada);
        
        
        
      

    }
}
