package DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExcluirLivroDAO {
    public void excluirLivro(String titulo, String autor){
        Connection conn = new ConexaoDAO().conectaDB();
        String sql = "SELECT * FROM livros";
        String exclurSql = "DELETE FROM livros WHERE id_livro = ?";

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                if(resultSet.getString("titulo").equals(titulo)){
                    if(resultSet.getString("autor").equals(autor)){
                        int idLivro = resultSet.getInt("id_livro");

                        PreparedStatement chamadaExclusao = conn.prepareStatement(exclurSql);
                        chamadaExclusao.setInt(1, idLivro);
                        chamadaExclusao.executeUpdate();
                        chamadaExclusao.close();
                        stmt.close();
                        conn.close();

                        JOptionPane.showMessageDialog(null, "Livro excluido com sucesso!");
                        return;
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Algo deu errado!");
            stmt.close();
            conn.close();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
}
