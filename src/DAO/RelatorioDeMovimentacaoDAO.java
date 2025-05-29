package DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class RelatorioDeMovimentacaoDAO {
    public void relatoriodeMovimentacao() {
        Connection conn = new ConexaoDAO().conectaDB();
        HashMap<Integer, String> listaAlunos = new HashMap<>();
        HashMap<Integer, String> listaLivros = new HashMap<>();
        String sqlAlunos = "SELECT * FROM alunos";
        String sqlLivros = "SELECT * FROM livros";
        String sqlEmprestimo = "SELECT * FROM emprestimos";
        String texto = "";

        try {//Lista de alunos
            PreparedStatement chamadaAluno = conn.prepareStatement(sqlAlunos);
            ResultSet resultSetAlunos = chamadaAluno.executeQuery();

            while (resultSetAlunos.next()) {
                listaAlunos.put(resultSetAlunos.getInt("id_aluno"), resultSetAlunos.getString("nome_aluno"));
            }

            //Lista de livros
            PreparedStatement chamadaLivro = conn.prepareStatement(sqlLivros);
            ResultSet resultSetLivros = chamadaLivro.executeQuery();

            while (resultSetLivros.next()) {
                listaLivros.put(resultSetLivros.getInt("id_livro"), resultSetLivros.getString("titulo"));
            }
            // Criacao do texto
            PreparedStatement chamadaEmprestimo = conn.prepareStatement(sqlEmprestimo);
            ResultSet resultSetEmprestimo = chamadaEmprestimo.executeQuery();

            while (resultSetEmprestimo.next()) {
                texto += "Nome do requisitante: " + listaAlunos.get(resultSetEmprestimo.getInt("id_aluno")) + ", Titulo do livro: " + listaLivros.get(resultSetEmprestimo.getInt("id_livro")) + ", data de devolução: " + resultSetEmprestimo.getDate("data_devolucao") + "\n";
            }
            JOptionPane.showMessageDialog(null, texto);

            chamadaEmprestimo.close();
            chamadaAluno.close();
            chamadaLivro.close();
            conn.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
}
