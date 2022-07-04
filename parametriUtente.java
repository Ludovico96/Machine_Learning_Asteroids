
package progettovideogioco;

import javafx.beans.property.*;

//classe che si interfaccia coi parametri utente del database
public class parametriUtente {
    private final SimpleStringProperty user;
    private final SimpleIntegerProperty scenario;
    private final SimpleIntegerProperty vita;
    private final SimpleBooleanProperty spada;
    private final SimpleBooleanProperty scudo;
    private final SimpleBooleanProperty torcia;
    private final SimpleBooleanProperty fionda;
    private final SimpleBooleanProperty bomba;
    private final SimpleBooleanProperty magia;
    
    public parametriUtente(String u,int s,int v,boolean sp,boolean sc,
            boolean t, boolean f,boolean b,boolean m){
        user=new SimpleStringProperty(u);
        scenario=new SimpleIntegerProperty(s);
        vita=new SimpleIntegerProperty(v);
        spada=new SimpleBooleanProperty(sp);
        scudo=new SimpleBooleanProperty(sc);
        torcia=new SimpleBooleanProperty(t);
        fionda=new SimpleBooleanProperty(f);
        bomba=new SimpleBooleanProperty(b);
        magia=new SimpleBooleanProperty(m);
    }
    
    public String getUser(){
        return user.get();
    }
    public int getScenario(){
        return scenario.get();
    }
    public int getVita(){
        return vita.get();
    }
    public boolean getSpada(){
        return spada.get();
    }
    public boolean getScudo(){
        return scudo.get();
    }
    public boolean getTorcia(){
        return torcia.get();
    }
    public boolean getFionda(){
        return fionda.get();
    }
    public boolean getBomba(){
        return bomba.get();
    }
    public boolean getMagia(){
        return magia.get();
    }
}
