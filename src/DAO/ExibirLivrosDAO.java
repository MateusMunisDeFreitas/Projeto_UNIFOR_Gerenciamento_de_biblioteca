package DAO;

import DTO.LivroDTO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExibirLivrosDAO {

    public void exibirLivros() {
        ArrayList<LivroDTO> listaLivros = new ArrayList();
        Connection conn = new ConexaoDAO().conectaDB();
        String sql = "SELECT * FROM livros";
        String texto = "";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String titulo, autor;
                int ano_publicacao, quantidade;

                titulo = resultSet.getString("titulo");
                autor = resultSet.getString("autor");
                ano_publicacao = resultSet.getInt("ano_publicacao");
                quantidade = resultSet.getInt("quantidade_estoque");

                texto += "Titulo: "+titulo+", Autor: "+autor+", Ano de publicação: "+", Quantidade em estoque: "+quantidade+"\n";

            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }

        JOptionPane.showMessageDialog(null, texto);
    }

    public void exibirLivrosDisponiveis() {
        Connection conn = new ConexaoDAO().conectaDB();
        String sql = "SELECT * FROM livros WHERE quantidade_estoque > 0";
        String texto = "";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {

                texto += resultSet.getString("titulo")+", Quantidade: "+resultSet.getInt("quantidade_estoque")+";"+"\n";

            };

            JTextArea textArea = new JTextArea(texto);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setBackground(null);
            textArea.setBorder(null);

            JOptionPane.showMessageDialog(null, textArea, "Livros disponiveis para emprestimo", JOptionPane.INFORMATION_MESSAGE);

//            JOptionPane.showMessageDialog(null, texto);

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
}
