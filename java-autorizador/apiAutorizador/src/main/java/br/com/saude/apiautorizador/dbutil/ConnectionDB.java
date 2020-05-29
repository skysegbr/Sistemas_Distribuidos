
package br.com.saude.apiautorizador.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilo Segura
 */
public class ConnectionDB {

    private final String drive = "oracle.jdbc.driver.OracleDriver";
    private final String url = "jdbc:oracle:thin:@//localhost:1521/ORCLCDB"; 
    private Connection con;

    public ConnectionDB() {
        try {
            System.setProperty("oracle.net.tns_admin","C:\\Oracle\\product\\12.2.0\\client_1\\network\\admin"); 
            Class.forName(drive);
        }catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Erro class - " + ex);        
        }
    }
    
    public Connection getConnection(){
        try { 
            con = DriverManager.getConnection(url,"c##tux","tux");
            con.setAutoCommit(false);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Erro GetCon - "+ex);
        }
        
        return null;
    }
    
    public void comita(){
        try {            
            con.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Erro comita - "+ex);
        }
    }
    
    public void desconectaDB(){
        try {
            con.close();
            con = null;
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Erro Descon - "+ex);
        }
    }
    
}
