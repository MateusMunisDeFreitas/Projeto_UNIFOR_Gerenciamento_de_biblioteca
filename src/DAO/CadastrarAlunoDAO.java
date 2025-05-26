package DAO;

import DTO.AlunoDTO;

import javax.swing.*;
import java.sql.*;

public class CadastrarAlunoDAO {
    public void cadastrarAluno(AlunoDTO aluno){
        Connection conn = new ConexaoDAO().conectaDB();

        String verficarMatricula = "SELECT * FROM alunos WHERE matricula = ?";
        String sql = "INSERT INTO alunos (nome_aluno, matricula, data_nascimento) VALUES (?, ?, ?)";

        try {
            PreparedStatement verficar = conn.prepareStatement(verficarMatricula);
            verficar.setString(1, aluno.getMatricula_aluno());
            ResultSet resultado = verficar.executeQuery();

            if (resultado.next()) {
                JOptionPane.showMessageDialog(null, "Matricula já castrada!");
                return;
            }

            verficar.close();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome_aluno());
            stmt.setString(2, aluno.getMatricula_aluno());
            stmt.setDate(3, aluno.getData_nascimento());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            stmt.close();
            conn.close();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
}
