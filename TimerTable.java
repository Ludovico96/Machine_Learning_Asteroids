/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;



public class TimerTable {
    TableView<TimerGame> tb=new TableView<>();
    ObservableList<TimerGame> ol;
     
    List<TimerGame> listaParametriTimer;
    List<String> listaUtentiTimer;
    
    VBox vbox=new VBox();
    
    
    public void mostraTempo() {
       TableColumn userCol=new TableColumn("User");
       userCol.setCellValueFactory(new PropertyValueFactory<>("user"));
       TableColumn timeCol=new TableColumn("Time");
       timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
       TableColumn timeMSCol=new TableColumn("TimeMS");
       timeMSCol.setCellValueFactory(new PropertyValueFactory<>("timeMS"));
       
       tb.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       
       caricaUtentiTimerAsc();
       
       tb.setItems(ol);
       tb.getColumns().addAll(userCol,timeCol);
       
        vbox=new VBox();
       vbox.getChildren().add(tb);
       
        vbox.setLayoutX(750);
        vbox.setLayoutY(700);
        
    }
    
    //carica tutti gli utenti in listaUtentiTimer
     public  void caricaUtentiTimer(){
         listaUtentiTimer=new ArrayList<>();
       ol=FXCollections.observableArrayList();
    try(Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogame","root","");
            Statement st=co.createStatement();
            ){
        ResultSet rs=st.executeQuery("SELECT * FROM timer");
        while(rs.next()){
           ol.add(new TimerGame(rs.getString("user"),rs.getString("time"),rs.getLong("timeMS")));
           listaUtentiTimer.add(new String(rs.getString("user")));
        } 
    } catch(SQLException e){
        e.getMessage();
    }
     }
     
     public  void caricaUtentiTimerAsc(){
         listaUtentiTimer=new ArrayList<>();
       ol=FXCollections.observableArrayList();
    try(Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogame","root","");
            Statement st=co.createStatement();
            ){
        ResultSet rs=st.executeQuery("SELECT * FROM videogame.timer ORDER BY time ASC");
        while(rs.next()){
           ol.add(new TimerGame(rs.getString("user"),rs.getString("time"),rs.getLong("timeMS")));
           listaUtentiTimer.add(new String(rs.getString("user")));
        } 
    } catch(SQLException e){
        e.getMessage();
    }
     }
     
     
     //carica i parametri dell'utente in ListaParametriTimer
      public void caricaParametriUtente(String user){
        listaParametriTimer=new ArrayList<>();
       try(Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogame","root","");
                PreparedStatement ps=co.prepareStatement("SELECT * FROM timer WHERE user= ?");
                        ){
           ps.setString(1,user);
           ResultSet rs=ps.executeQuery();
           while(rs.next())
               listaParametriTimer.add(new TimerGame(rs.getString("user"),rs.getString("time"),rs.getLong("timeMS")));
           
       }catch(SQLException e){
            System.out.println("impossibile trovare utente nel datatbase");
       }
       
      
   }
    //inizializza i parametri dell'utente quando viene premuto start
    public void inizializzaParametriUtente(String user,String time,long timeMS){
        ol=FXCollections.observableArrayList();
        try(Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogame","root","");
                PreparedStatement ps=co.prepareStatement("INSERT INTO timer VALUES(?,?,?)");
                ){
            ps.setString(1, user); ps.setString(2, time);ps.setLong(3, timeMS);
            
            System.out.println("rows affected" +ps.executeUpdate());
            caricaUtentiTimer();
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    //setta i parametri dell'utente alla chiusura dell'applicazione
     public void settaParametriUtente(String user,String time,long timeMS){
         ol=FXCollections.observableArrayList();
        try(Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogame","root","");
                PreparedStatement ps=co.prepareStatement("UPDATE timer SET time=?,timeMS=? WHERE user=?");
                ){
            ps.setString(1, time);ps.setLong(2, timeMS);ps.setString(3, user);
             caricaUtentiTimer();
            System.out.println("rows affected" +ps.executeUpdate());
        }catch(SQLException e){
            e.getMessage();
        }
    }
     
}
