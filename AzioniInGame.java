
package progettovideogioco;

import java.io.Serializable;
import java.util.Date;

// classe con i parametri che descrivono le azioni dell'utente sull'interfaccia grafica 
// e che vengono serializzati spedendoli a un socket in remoto,e ad un file di testo in modo incrementale
public class AzioniInGame implements Serializable{
     GameManager gm;
    
     final String nomeApplicazione="Medieval Adventures";
     final String indirizzoIP="localhost";
     Date data;
     String nomeEvento;
    
    public AzioniInGame(GameManager gm){
        this.gm=gm;
    }
    
    public AzioniInGame(Date data,String nomeEvento){
        this.data=data;
        this.nomeEvento=nomeEvento;
    }
    
}
