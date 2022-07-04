
package progettovideogioco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class connessioneDatabase {
    
   GameManager gm;
   List<parametriUtente> listaParametri;
   List<String> listaUtenti;
   
   public connessioneDatabase(GameManager gm){
       this.gm=gm;
   }
    
    
    //inizializza nel db i parametri se l'utente non esisite
    public void inizializzaParametriUtente(String utente){
        try(Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogame","root","");
                PreparedStatement ps=co.prepareStatement("INSERT INTO userstatus VALUES(?,?,?,?,?,?,?,?,?)");
                ){
            ps.setString(1, utente);ps.setInt(2, 1);ps.setInt(3, 3);ps.setBoolean(4, false);
            ps.setBoolean(5, false);ps.setBoolean(6, false);ps.setBoolean(7, false);ps.setBoolean(8, false);
            ps.setBoolean(9, false);
            
            System.out.println("rows affected" +ps.executeUpdate());
        }catch(SQLException e){
            e.getMessage();
        }
    }
    //setta i parametri dell'utente
    public void settaParametriUtente(String utente,int scenario,int vita,boolean spada,boolean scudo,boolean torcia,boolean fionda,boolean bomba,boolean magia){
        try(Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogame","root","");
                PreparedStatement ps=co.prepareStatement("UPDATE userstatus SET scenario=?,vita=?,spada=?,scudo=?,torcia=?,fionda=?,bomba=?,magia=? WHERE user=?");
                ){
            ps.setInt(1, scenario);ps.setInt(2, vita);ps.setBoolean(3, spada);ps.setBoolean(4, scudo);
            ps.setBoolean(5, torcia);ps.setBoolean(6, fionda);ps.setBoolean(7, bomba);ps.setBoolean(8, magia);
            ps.setString(9, utente);
            
            System.out.println("rows affected" +ps.executeUpdate());
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    //ricarica i parametri dell'utente
   public void caricaParametriUtente(String utente){
        listaParametri=new ArrayList<>();
       try(Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogame","root","");
                PreparedStatement ps=co.prepareStatement("SELECT * FROM userstatus WHERE user= ?");
                        ){
           ps.setString(1,utente);
           ResultSet rs=ps.executeQuery();
           while(rs.next())
               listaParametri.add(new parametriUtente(rs.getString("user"),rs.getInt("scenario"),rs.getInt("vita"),
                       rs.getBoolean("spada"),rs.getBoolean("scudo"),rs.getBoolean("torcia"),rs.getBoolean("fionda"),
                       rs.getBoolean("bomba"),rs.getBoolean("magia")));
           
       }catch(SQLException e){
            System.out.println("impossibile trovare utente nel datatbase");
       }
       
      
   }
   
   //carica la lista degli utenti
   public void caricaUtenti(){
       listaUtenti=new ArrayList<>();
    try(Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogame","root","");
            Statement st=co.createStatement();
            ){
        ResultSet rs=st.executeQuery("SELECT user FROM userstatus");
        while(rs.next()){
            listaUtenti.add(new String(rs.getString("user")));
        } 
    } catch(SQLException e){
        e.getMessage();
    }
   
}
   
    
   
   
}
