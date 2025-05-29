package View;

import DAO.*;
import DTO.AlunoDTO;
import DTO.LivroDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class View extends JFrame {
    public void janelaPrincipal(){
        setTitle("Biblioteca");
        setSize(430, 230);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
//        janelaCadastrarAluno(false);
        LinkedList<String> lista = new LinkedList<>();
        lista.add("Um");
        lista.add("Dois");
        lista.add("tres");

        // Componentes
        JLabel titulo = new JLabel("Pedir livro emprestado");
        JLabel labelMatricula = new JLabel("Matricula do aluno:");
        JLabel labelNomeLivro = new JLabel("Nome do livro:");
        JTextField inputMatricula = new JTextField();
        JButton buttonRelatorioMovimentacao = new JButton("Relatorio de movimentação");
        JButton buttonExibirLivrosDisponiveies = new JButton("Exibir livros Dispon.");
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JTextField inputTituloLivro = new JTextField();
        JButton buttonSolicitarEmprest = new JButton("Solicitar Emprestimo");
        JMenu alunoMenu = new JMenu("Aluno");
        JMenu livroMenu = new JMenu("Livro");
        menuBar.add(alunoMenu);
        menuBar.add(livroMenu);

        //Menu aluno
        JMenuItem exibirAlunos = new JMenuItem("Exibir");
        JMenuItem cadastrarAluno = new JMenuItem("Cadastrar");
        JMenuItem excluirAluno = new JMenuItem("Excluir");
        alunoMenu.add(exibirAlunos);
        alunoMenu.add(cadastrarAluno);
        alunoMenu.add(excluirAluno);

        exibirAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExibirAlunosDAO().exibirAlunos();
            }
        });
        cadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janelaCadastrarAluno = new JFrame("Cadastro de aluno");
                janelaCadastrarAluno.setSize(300, 230);
                janelaCadastrarAluno.setLocationRelativeTo(null);
                janelaCadastrarAluno.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                janelaCadastrarAluno.setLayout(null);

                //Componentes
                JLabel labelNome = new JLabel("Nome:");
                JTextField inputNome = new JTextField();
                JLabel labelMatricula = new JLabel("Matricula:");
                JTextField inputMatricula = new JTextField();
                JLabel labelDataNAscimento = new JLabel("Data de nascimento");
                JLabel labelDia = new JLabel("Dia:");
                JTextField inputDia = new JTextField();
                JLabel labelMes = new JLabel("Mês:");
                JTextField inputMes = new JTextField();
                JLabel labelAno = new JLabel("Ano:");
                JTextField inputAno = new JTextField();
                JButton buttonCadastrar = new JButton("Cadastrar");
                //Fontes
                labelNome.setFont(new Font("Arial", Font.PLAIN, 20));
                inputNome.setFont(new Font("Arial", Font.PLAIN, 14));
                labelMatricula.setFont(new Font("Arial", Font.PLAIN, 20));
                inputMatricula.setFont(new Font("Arial", Font.PLAIN, 14));
                labelDataNAscimento.setFont(new Font("Arial", Font.PLAIN, 20));
                labelDia.setFont(new Font("Arial", Font.PLAIN, 20));
                inputDia.setFont(new Font("Arial", Font.PLAIN, 14));
                labelMes.setFont(new Font("Arial", Font.PLAIN, 20));
                inputMes.setFont(new Font("Arial", Font.PLAIN, 14));
                labelAno.setFont(new Font("Arial", Font.PLAIN, 20));
                inputAno.setFont(new Font("Arial", Font.PLAIN, 14));
                //Posicionar
                labelNome.setBounds(5, 10, 60, 25);
                inputNome.setBounds(70, 12, 200, 25);
                labelMatricula.setBounds(5, 50, 100, 25);
                inputMatricula.setBounds(95, 50, 150, 25);
                labelDataNAscimento.setBounds(35, 85, 200, 25);
                labelDia.setBounds(10, 120, 50, 25);
                inputDia.setBounds(50, 120, 25, 25);
                labelMes.setBounds(90, 120, 50, 25);
                inputMes.setBounds(135, 120, 25, 25);
                labelAno.setBounds(170, 120, 50, 25);
                inputAno.setBounds(215, 120, 40, 25);
                buttonCadastrar.setBounds(100, 160, 100, 25);

                janelaCadastrarAluno.add(labelNome);
                janelaCadastrarAluno.add(inputNome);
                janelaCadastrarAluno.add(labelMatricula);
                janelaCadastrarAluno.add(inputMatricula);
                janelaCadastrarAluno.add(labelDataNAscimento);
                janelaCadastrarAluno.add(labelDia);
                janelaCadastrarAluno.add(inputDia);
                janelaCadastrarAluno.add(labelMes);
                janelaCadastrarAluno.add(inputMes);
                janelaCadastrarAluno.add(labelAno);
                janelaCadastrarAluno.add(inputAno);
                janelaCadastrarAluno.add(buttonCadastrar);

                buttonCadastrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AlunoDTO aluno = new AlunoDTO(inputNome.getText(), inputMatricula.getText(), Integer.parseInt(inputDia.getText()), Integer.parseInt(inputMes.getText()), Integer.parseInt(inputAno.getText()));
                        System.out.println(aluno);
                        new CadastrarAlunoDAO().cadastrarAluno(aluno);
                    }
                });

                janelaCadastrarAluno.setVisible(true);
            }
        });
        excluirAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janelaExcluirAluno = new JFrame("Excluir aluno");
                janelaExcluirAluno.setSize(300, 200);
                janelaExcluirAluno.setLocationRelativeTo(null);
                janelaExcluirAluno.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                janelaExcluirAluno.setLayout(null);

                //Componentes
                JLabel labelMatricula = new JLabel("Matricula:");
                JTextField inputMatricula = new JTextField();
                JLabel labelDataNAscimento = new JLabel("Data de nascimento");
                JLabel labelDia = new JLabel("Dia:");
                JTextField inputDia = new JTextField();
                JLabel labelMes = new JLabel("Mês:");
                JTextField inputMes = new JTextField();
                JLabel labelAno = new JLabel("Ano:");
                JTextField inputAno = new JTextField();
                JButton buttonExcluir = new JButton("Excluir");
                //Fontes
                labelMatricula.setFont(new Font("Arial", Font.PLAIN, 20));
                inputMatricula.setFont(new Font("Arial", Font.PLAIN, 14));
                labelDataNAscimento.setFont(new Font("Arial", Font.PLAIN, 20));
                labelDia.setFont(new Font("Arial", Font.PLAIN, 20));
                inputDia.setFont(new Font("Arial", Font.PLAIN, 14));
                labelMes.setFont(new Font("Arial", Font.PLAIN, 20));
                inputMes.setFont(new Font("Arial", Font.PLAIN, 14));
                labelAno.setFont(new Font("Arial", Font.PLAIN, 20));
                inputAno.setFont(new Font("Arial", Font.PLAIN, 14));
                //Posicionar
                labelMatricula.setBounds(5, 10, 100, 25);
                inputMatricula.setBounds(95, 10, 150, 25);
                labelDataNAscimento.setBounds(35, 45, 200, 25);
                labelDia.setBounds(10, 85, 50, 25);
                inputDia.setBounds(50, 85, 25, 25);
                labelMes.setBounds(90, 85, 50, 25);
                inputMes.setBounds(135, 85, 25, 25);
                labelAno.setBounds(170, 85, 50, 25);
                inputAno.setBounds(215, 85, 40, 25);
                buttonExcluir.setBounds(95, 120, 100, 25);

                janelaExcluirAluno.add(labelMatricula);
                janelaExcluirAluno.add(inputMatricula);
                janelaExcluirAluno.add(labelDataNAscimento);
                janelaExcluirAluno.add(labelDia);
                janelaExcluirAluno.add(inputDia);
                janelaExcluirAluno.add(labelMes);
                janelaExcluirAluno.add(inputMes);
                janelaExcluirAluno.add(labelAno);
                janelaExcluirAluno.add(inputAno);
                janelaExcluirAluno.add(buttonExcluir);

                buttonExcluir.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ExcluirAlunoDAO().excluirAluno(inputMatricula.getText(), Integer.parseInt(inputDia.getText()), Integer.parseInt(inputMes.getText()), Integer.parseInt(inputAno.getText()));
                    }
                });

                janelaExcluirAluno.setVisible(true);
            }
        });
        //Menu livro
        JMenuItem exbirLivros = new JMenuItem("Exibir");
        JMenuItem cadastrarLivro = new JMenuItem("Cadastrar");
        JMenuItem excluirLirvos = new JMenuItem("Excluir");
        livroMenu.add(exbirLivros);
        livroMenu.add(cadastrarLivro);
        livroMenu.add(excluirLirvos);

        exbirLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExibirLivrosDAO().exibirLivros();
            }
        });
        cadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janelaCadastrarLivro = new JFrame("Cadastro de livro");
                janelaCadastrarLivro.setSize(400, 220);
                janelaCadastrarLivro.setLocationRelativeTo(null);
                janelaCadastrarLivro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                janelaCadastrarLivro.setLayout(null);

                //Componentes
                JLabel labelTitulo = new JLabel("Titulo:");
                JTextField inputTitulo = new JTextField();
                JLabel labelAutor = new JLabel("Autor:");
                JTextField inputAutor = new JTextField();
                JLabel labeAnoPublicacao = new JLabel("Ano de publicação:");
                JTextField inputAnoPublicacao = new JTextField();
                JLabel labelQuantidade = new JLabel("Quantidade no estoque:");
                JTextField inputQuantidadeLivro = new JTextField();
                JButton buttonCadastrar = new JButton("Cadastrar");
                //Fontes
                labelTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
                inputTitulo.setFont(new Font("Arial", Font.PLAIN, 14));
                labelAutor.setFont(new Font("Arial", Font.PLAIN, 20));
                inputAutor.setFont(new Font("Arial", Font.PLAIN, 14));
                labeAnoPublicacao.setFont(new Font("Arial", Font.PLAIN, 20));
                inputAnoPublicacao.setFont(new Font("Arial", Font.PLAIN, 14));
                labelQuantidade.setFont(new Font("Arial", Font.PLAIN, 20));
                //Posicionar
                labelTitulo.setBounds(5, 10, 100, 25);
                inputTitulo.setBounds(70, 12, 290, 25);
                labelAutor.setBounds(5, 50, 70, 25);
                inputAutor.setBounds(70, 50, 290, 25);
                labeAnoPublicacao.setBounds(5, 85, 250, 25);
                inputAnoPublicacao.setBounds(180, 85, 50, 25);
                labelQuantidade.setBounds(5, 115, 250, 25);
                inputQuantidadeLivro.setBounds(220, 115, 30 , 25);
                buttonCadastrar.setBounds(130, 150, 110, 25);

                janelaCadastrarLivro.add(labelTitulo);
                janelaCadastrarLivro.add(inputTitulo);
                janelaCadastrarLivro.add(labelAutor);
                janelaCadastrarLivro.add(inputAutor);
                janelaCadastrarLivro.add(labeAnoPublicacao);
                janelaCadastrarLivro.add(inputAnoPublicacao);
                janelaCadastrarLivro.add(labelQuantidade);
                janelaCadastrarLivro.add(inputQuantidadeLivro);
                janelaCadastrarLivro.add(buttonCadastrar);

                buttonCadastrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LivroDTO livro = new LivroDTO(inputTitulo.getText(), inputAutor.getText(), Integer.parseInt(inputAnoPublicacao.getText()), Integer.parseInt(inputQuantidadeLivro.getText()));
                        new CadastrarLivroDAO().cadastrarLivros(livro);
                    }
                });

                janelaCadastrarLivro.setVisible(true);
            }
        });

        excluirLirvos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame janelaExcluirLivro = new JFrame("Cadastro de livro");
                janelaExcluirLivro.setSize(400, 170);
                janelaExcluirLivro.setLocationRelativeTo(null);
                janelaExcluirLivro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                janelaExcluirLivro.setLayout(null);

                //Componentes
                JLabel labelTitulo = new JLabel("Titulo:");
                JTextField inputTitulo = new JTextField();
                JLabel labelAutor = new JLabel("Autor:");
                JTextField inputAutor = new JTextField();
                JButton buttonExcluir = new JButton("Excluir");
                //Fontes
                labelTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
                inputTitulo.setFont(new Font("Arial", Font.PLAIN, 14));
                labelAutor.setFont(new Font("Arial", Font.PLAIN, 20));
                inputAutor.setFont(new Font("Arial", Font.PLAIN, 14));
                //Posicionar
                labelTitulo.setBounds(5, 10, 100, 25);
                inputTitulo.setBounds(70, 12, 290, 25);
                labelAutor.setBounds(5, 50, 70, 25);
                inputAutor.setBounds(70, 50, 290, 25);
                buttonExcluir.setBounds(130, 90, 110, 25);

                janelaExcluirLivro.add(labelTitulo);
                janelaExcluirLivro.add(inputTitulo);
                janelaExcluirLivro.add(labelAutor);
                janelaExcluirLivro.add(inputAutor);;
                janelaExcluirLivro.add(buttonExcluir);

                buttonExcluir.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ExcluirLivroDAO().excluirLivro(inputTitulo.getText(), inputAutor.getText());
                    }
                });

                janelaExcluirLivro.setVisible(true);
            }
        });

        // Acao para o botao
        buttonSolicitarEmprest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExibirLivrosDAO().exibirLivros();
            }
        });


        // Ajuste dos componentes
        titulo.setBounds(10, 5, 250, 30);
        labelMatricula.setBounds(10, 35, 170, 30);
        inputMatricula.setBounds(180, 37, 50, 25);
        labelNomeLivro.setBounds(10, 65, 160, 25);
        inputTituloLivro.setBounds(150, 65, 250, 25);
        buttonSolicitarEmprest.setBounds(240, 100, 160, 25);
        buttonRelatorioMovimentacao.setBounds(10, 100, 200, 25);
        buttonExibirLivrosDisponiveies.setBounds(120, 130, 220, 25);
        // Fonte
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        labelMatricula.setFont(new Font("Arial", Font.PLAIN, 20));
        inputMatricula.setFont(new Font("Arial", Font.PLAIN, 14));
        labelNomeLivro.setFont(new Font("Arial", Font.PLAIN, 20));

        // Adicionar a janela
        add(titulo);
        add(labelMatricula);
        add(inputMatricula);
        add(labelNomeLivro);
        add(inputTituloLivro);
        add(buttonSolicitarEmprest);
        add(buttonRelatorioMovimentacao);
        add(buttonExibirLivrosDisponiveies);

        //Acoes butoes janela principal
        buttonRelatorioMovimentacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RelatorioDeMovimentacaoDAO().relatoriodeMovimentacao();
            }
        });
        buttonExibirLivrosDisponiveies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExibirLivrosDAO().exibirLivrosDisponiveis();
            }
        });
        buttonSolicitarEmprest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmprestimoDAO().solicitarEmprestimo(inputMatricula.getText(), inputTituloLivro.getText());
            }
        });

        setVisible(true);
    }
}
