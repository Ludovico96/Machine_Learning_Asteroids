/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Utente
 */
public class AzioniInGame implements Serializable{
    public GameManager gm;
    
    public final String nomeApplicazione="Mediaval Adventures";
    public final String indirizzoIP="131.114.50.255";
    public Date data;
    public String nomeEvento;
    
    public AzioniInGame(GameManager gm){
        this.gm=gm;
    }
    
    public AzioniInGame(Date data,String nomeEvento){
        this.data=data;
        this.nomeEvento=nomeEvento;
    }
    
}
