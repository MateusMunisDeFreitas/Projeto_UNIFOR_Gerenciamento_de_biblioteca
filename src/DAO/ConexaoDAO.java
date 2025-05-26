package DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

    public Connection conectaDB(){
        Connection conn = null;
        try{
            String url = "jdbc:mysql://localhost:3306/biblioteca?user=root&password=root";
            conn = DriverManager.getConnection(url);

        }catch (SQLException err){
            JOptionPane.showMessageDialog(null,"Erro de conexão: "+ err.getMessage());
        }
        return conn;
    }
}
