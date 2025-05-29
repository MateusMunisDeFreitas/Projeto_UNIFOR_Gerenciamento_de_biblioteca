package DAO;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class ExcluirAlunoDAO {
    public void excluirAluno(String matricula, int dia, int mes, int ano){
        Connection conn = new ConexaoDAO().conectaDB();
        LocalDate data = LocalDate.of(ano, mes, dia);
        Date dataSql = Date.valueOf(data);
        String sql = "SELECT * FROM alunos";
        String deleteSql = "DELETE FROM alunos WHERE id_aluno = ?";

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()){
                // Verificar se o nome e data de nascimento existe no BD
                if(resultSet.getDate("data_nascimento").equals(dataSql)){
                    if(resultSet.getString("matricula").equals(matricula)){
                        int idAluno = resultSet.getInt("id_aluno");

                        PreparedStatement chamadaExclusao = conn.prepareStatement(deleteSql);
                        chamadaExclusao.setInt(1, idAluno);
                        chamadaExclusao.executeUpdate();
                        chamadaExclusao.close();
                        stmt.close();
                        conn.close();

                        JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
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
