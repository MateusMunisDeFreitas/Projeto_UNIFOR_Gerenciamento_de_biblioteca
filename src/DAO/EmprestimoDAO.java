package DAO;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class EmprestimoDAO {

    public void solicitarEmprestimo(String matriculaAluno, String tituloLivro){
        Connection conn = new ConexaoDAO().conectaDB();

        String verificarMatricula = "SELECT * FROM alunos WHERE matricula = ?";
        String verificarLivro = "SELECT * FROM livros WHERE titulo = ?";
        int id_aluno, id_livro;

        try{
            //Verificar se a MATRICULA do aluno esta cadastrada no DB
            PreparedStatement verificMatricula = conn.prepareStatement(verificarMatricula);
            verificMatricula.setString(1, matriculaAluno);
            ResultSet resultMatricula = verificMatricula.executeQuery();

            if(!resultMatricula.next()){
                JOptionPane.showMessageDialog(null, "Matricula não existe!");
                return;
            }
            id_aluno = resultMatricula.getInt("id_aluno");
            verificMatricula.close();
            //Verificar se o LIVRO esta cadastrado no DB
            PreparedStatement verificLivro = conn.prepareStatement(verificarLivro);
            verificLivro.setString(1, tituloLivro);
            ResultSet resultLivro = verificLivro.executeQuery();

            if(!resultLivro.next()){
                JOptionPane.showMessageDialog(null, "Livro não existe!");
                return;
            }
            id_livro = resultLivro.getInt("id_livro");
            verificLivro.close();

            registrarEmprestimo(id_aluno,id_livro);

        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }

    }

    public void delvolverEmprestimo (int idAluno , int idLivro ) {
        Connection conn = new ConexaoDAO().conectaDB();
        // Verifica estoque disponivel
        String verificaEstoque = " SELECT quantidade_estoque FROM Livros WHERE id_livro = ?";
        // Atualiza estoque
        String atualizaEstoque = "UPDATE livros SET quantidade_estoque = quantidade_estoque + 1 WHERE id_livro = ?";
        // Registra emprestimo
        String sqlRegistrarEmprestimo = "INSERT INTO emprestimos (id_aluno , id_livro ,data_devolucao ) VALUES (?, ?, ?)";

        try{
            //Verifica se a livro disponivel no estoque
            PreparedStatement verificEstoque = conn.prepareStatement(verificaEstoque);
            verificEstoque.setInt(1, idLivro);
            ResultSet resultadoEstoque = verificEstoque.executeQuery();

            if(resultadoEstoque.next()){
                if(resultadoEstoque.getInt("quantidade_estoque") == 0){
                    JOptionPane.showMessageDialog(null, "Livro não esta disponivel para emprestimo!");
                    return;
                }
            }
            resultadoEstoque.close();
            //Registrar o emprestimo do livro
            PreparedStatement regristaEmprestimo = conn.prepareStatement(sqlRegistrarEmprestimo);
            regristaEmprestimo.setInt(1, idAluno);
            regristaEmprestimo.setInt(2, idLivro);
            regristaEmprestimo.setDate(3, Date.valueOf(LocalDate.now().plusDays(7)));
            regristaEmprestimo.executeUpdate();
            System.out.println("completo");
            regristaEmprestimo.close();
            //Atualizar o estoque do livro
            PreparedStatement atualizarEstoque = conn.prepareStatement(atualizaEstoque);
            atualizarEstoque.setInt(1, idLivro);
            atualizarEstoque.executeUpdate();
            atualizarEstoque.close();
            conn.close();

            System.out.println("Livro emprestado com sucesso!");
            JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso!");

        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            System.out.println(err.getMessage());
        }
    }

    public void registrarEmprestimo (int idAluno , int idLivro ) {
        Connection conn = new ConexaoDAO().conectaDB();
        // Verifica estoque disponivel
        String verificaEstoque = " SELECT quantidade_estoque FROM Livros WHERE id_livro = ?";
        // Atualiza estoque
        String atualizaEstoque = "UPDATE livros SET quantidade_estoque = quantidade_estoque - 1 WHERE id_livro = ?";
        // Registra emprestimo
        String sqlRegistrarEmprestimo = "INSERT INTO emprestimos (id_aluno , id_livro ,data_devolucao ) VALUES (?, ?, ?)";

        try{
            //Verifica se a livro disponivel no estoque
            PreparedStatement verificEstoque = conn.prepareStatement(verificaEstoque);
            verificEstoque.setInt(1, idLivro);
            ResultSet resultadoEstoque = verificEstoque.executeQuery();

            if(resultadoEstoque.next()){
                if(resultadoEstoque.getInt("quantidade_estoque") == 0){
                    JOptionPane.showMessageDialog(null, "Livro não esta disponivel para emprestimo!");
                    return;
                }
            }
            resultadoEstoque.close();
            //Registrar o emprestimo do livro
            PreparedStatement regristaEmprestimo = conn.prepareStatement(sqlRegistrarEmprestimo);
            regristaEmprestimo.setInt(1, idAluno);
            regristaEmprestimo.setInt(2, idLivro);
            regristaEmprestimo.setDate(3, Date.valueOf(LocalDate.now().plusDays(7)));
            regristaEmprestimo.executeUpdate();
            System.out.println("completo");
            regristaEmprestimo.close();
            //Atualizar o estoque do livro
            PreparedStatement atualizarEstoque = conn.prepareStatement(atualizaEstoque);
            atualizarEstoque.setInt(1, idLivro);
            atualizarEstoque.executeUpdate();
            atualizarEstoque.close();
            conn.close();

            System.out.println("Livro emprestado com sucesso!");
            JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso!");

        }catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            System.out.println(err.getMessage());
        }
    }
}
