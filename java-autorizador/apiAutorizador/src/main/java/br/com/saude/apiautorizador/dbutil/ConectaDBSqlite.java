package br.com.saude.apiautorizador.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Danilo Segura
 */

public class ConectaDBSqlite {
    private final String drive = "org.sqlite.JDBC";
    private final String url = "jdbc:sqlite:C:\\DB_TICKET\\DB_TICKET.db";  
    private Connection con;

    public ConectaDBSqlite() {
        try {
            Class.forName(drive);
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro class - "+ex);        
        }
    }
    
    public Connection getConnection(){
        try { 
            con = DriverManager.getConnection(url);
            con.setAutoCommit(false);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
            return con;                
        } catch (SQLException ex) {                
            JOptionPane.showMessageDialog(null, "Erro GetCon - "+ex);
        }
        
        return null;
    }
    
    public void comita(){
        try {            
            con.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro comita - "+ex);
        }
    }
    
    public void desconectaDB(){
        try {
            con.close();
            con = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Descon - "+ex);
        }
    }
}
