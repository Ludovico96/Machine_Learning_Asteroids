
package progettovideogioco;



import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;


public class TimerGame {
    final SimpleStringProperty user;
    final SimpleStringProperty time;
    SimpleLongProperty timeMS;
    
    public TimerGame(String u,String t,long tMS){
        user=new SimpleStringProperty(u);
        time=new SimpleStringProperty(t);
        timeMS=new SimpleLongProperty(tMS);
    }
    
    public String getUser(){
        return user.get();
    }
    public String getTime(){
        return  time.get();
    }
    public long getTimeMS(){
        return timeMS.get();
    }
}
