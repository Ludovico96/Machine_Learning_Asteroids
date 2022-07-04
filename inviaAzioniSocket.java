
package progettovideogioco;

import com.thoughtworks.xstream.XStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;



public class inviaAzioniSocket {
    
    GameManager gm;
    
    public inviaAzioniSocket(GameManager gm){ 
        this.gm=gm;
    }
    
    
    //serializza le azioni in XML e le invia ad un socket ad ogni azione
    public void serializzaAzioniXML(AzioniInGame azioni){
        XStream xs=new XStream();
       
        String x=xs.toXML(azioni);
        
        try{
               Files.write(Paths.get("./myscenario/azioni.xml"), x.getBytes());
           } catch(Exception e){System.out.println("Impossibile salvare azione in xml");}
        
        try(
                DataOutputStream dout=new DataOutputStream((new Socket("localhost",8080)).getOutputStream());
                DataOutputStream dout2=new DataOutputStream((new Socket("localhost",8080)).getOutputStream());
                ){
            dout.writeUTF(x);
            dout2.writeUTF(x);
        } catch(Exception e){
            e.printStackTrace();
        } 
            
    }
    
 
    
}
