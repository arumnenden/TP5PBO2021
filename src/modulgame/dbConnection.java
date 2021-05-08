/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulgame;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nenden
 */
public class dbConnection {
    public static Connection con;
    public static Statement stm;
    
    public void connect(){//untuk membuka koneksi ke database
        try {
            String url ="jdbc:mysql://localhost/db_gamepbo";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();
            System.out.println("koneksi berhasil;");
        } catch (Exception e) {
            System.err.println("koneksi gagal" +e.getMessage());
        }
    }
    
    public DefaultTableModel readTable(){
        
        DefaultTableModel dataTabel = null;
        try{
            Object[] column = {"No", "Username", "Score"};
            connect();
            dataTabel = new DefaultTableModel(null, column);
            String sql = "SELECT * FROM highscore ORDER BY Score DESC";
            ResultSet res = stm.executeQuery(sql);
            
            int no = 1;
            while(res.next()){
                Object[] hasil = new Object[3];
                hasil[0] = no;
                hasil[1] = res.getString("Username");
                hasil[2] = res.getString("Score");
                no++;
                dataTabel.addRow(hasil);
            }
        }catch(Exception e){
            System.err.println("Read gagal " +e.getMessage());
        }
        
        return dataTabel;
    }
    
    int addData(String user, int score){
        connect();
        String query = "INSERT INTO highscore" + " (Username, Score) VALUES ('" + user + "', '" + score + "');";
        try {
            int ex = stm.executeUpdate(query);
            return ex;
        } catch (SQLException ex1) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex1);
        }
        return 0;
    }
}
