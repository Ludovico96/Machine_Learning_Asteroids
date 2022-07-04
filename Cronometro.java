
package progettovideogioco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.Label;
import javax.swing.Timer;


public class Cronometro {
    
    GameManager gm;
    long tempoInizio;
    Label lblTempo;
    Timer t;
    String s;
    long diffTempo;
   
    public Cronometro(GameManager gm){
       this.gm=gm;
   }
    
    
    public Cronometro(Label l){
        lblTempo=l;
        
        //ogni 100 milliecondi vengono chiamate queste istruzioni
        t=new Timer(100,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              
                diffTempo=diffTempo+100;
                   
                int decimiSec=(int) ((diffTempo % 1000 )/100);
                int secondi=(int) ((diffTempo / 1000 )% 60);
                int minuti=(int) ((diffTempo / 60000 )% 60);
                int ore=(int) (diffTempo / 36000000 );

                s=String.format("%d:%02d:%02d.%d", ore,minuti,secondi,decimiSec);
                lblTempo.setText(s);
                 
                 
                 
            }
        });
    }
    
    public void setDiffTemp(long t){
       this.diffTempo=t;
       
   }
    
    public void Ferma(){
        t.stop();
        System.out.println( s);
        
    }
    
     
}
