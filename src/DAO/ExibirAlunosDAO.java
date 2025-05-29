package DAO;

import DTO.AlunoDTO;
import DTO.LivroDTO;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ExibirAlunosDAO {

    public void exibirAlunos() {
        ArrayList<LivroDTO> listaAlunos = new ArrayList();
        Connection conn = new ConexaoDAO().conectaDB();
        String sql = "SELECT * FROM alunos";
        String texto = "";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String nomeAluno, matricula;
                Date dataNascimento;

                nomeAluno = resultSet.getString("nome_aluno");
                matricula = resultSet.getString("matricula");
                dataNascimento = resultSet.getDate("data_nascimento");

                texto += "Nome: " + nomeAluno + ", Matricula: " + matricula + ", Data de nascimento: " + dataNascimento+"\n";

            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        JOptionPane.showMessageDialog(null, texto);
    }
}