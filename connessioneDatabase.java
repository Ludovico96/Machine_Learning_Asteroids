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

/**
 *
 * @author Utente
 */
public class connessioneDatabase {
    
    public static void caricaAzioniOggetto(String nomeOggetto){
        try(Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogame","root","");
                PreparedStatement ps=co.prepareStatement("SELECT menuAzioni FROM scenario WHERE oggettoScenario= ?");
                        ){
            ps.setString(1, nomeOggetto);
            ResultSet rs=ps.executeQuery();
            
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public static void aggiornaAzioni(String menuAzione,String nomeOggetto){
        try(Connection co=DriverManager.getConnection("jdbc:mysql://localhost:3306/videogame","root","");
                PreparedStatement ps=co.prepareStatement("UPDATE scenario SET menuAzioni= ? WHERE oggettoScenario= ?");
                ){
            ps.setString(1, menuAzione);ps.setString(2, nomeOggetto);
            ps.executeUpdate();
            System.out.println("rows affected" +ps.executeUpdate());
        }catch(SQLException e){
            e.getMessage();
        }
    }
    
    
    public static void main(String[] args){
        caricaAzioniOggetto("casa");
        aggiornaAzioni("a","casa");
    }
}
