package DAO;

import DTO.LivroDTO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastrarLivroDAO {
    public void cadastrarLivros(LivroDTO livro) {
        Connection conn = new ConexaoDAO().conectaDB();

        String verifarLivro = "SELECT * FROM livros WHERE titulo = ?";
        String cadastrarLivro = "INSERT INTO livros(titulo, autor, ano_publicacao, quantidade_estoque) VALUES (?,?,?,?)";

        try {
            PreparedStatement verificar = conn.prepareStatement(verifarLivro);
            verificar.setString(1, livro.getTitulo());
            ResultSet resultado = verificar.executeQuery();

            if (resultado.next()) {
                JOptionPane.showMessageDialog(null, "Livro já cadastrado!");
                return;
            }

            verificar.close();

            PreparedStatement cadastrar = conn.prepareStatement(cadastrarLivro);
            cadastrar.setString(1, livro.getTitulo());
            cadastrar.setString(2, livro.getAutor());
            cadastrar.setInt(3, livro.getAno_publicacao());
            cadastrar.setInt(4, livro.getQuantidade_estoque());
            cadastrar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Livro cadastrado!");
            cadastrar.close();
            conn.close();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
}
