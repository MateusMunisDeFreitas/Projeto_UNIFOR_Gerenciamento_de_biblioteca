package DAO;

import DTO.AlunoDTO;
import DTO.LivroDTO;

public class mainDAO {
    public static void main(String[] args) {
        new CadastrarLivroDAO().cadastrarLivros(new LivroDTO("Código Limpo", "Robert C. Martin", 2009, 3));
        new CadastrarLivroDAO().cadastrarLivros(new LivroDTO("O Programador Pragmático", "Andrew Hunt", 1999, 2));
        new CadastrarLivroDAO().cadastrarLivros(new LivroDTO("Estruturas de Dados e Algoritmos em Java", "Robert Lafore", 2002, 4));
        new CadastrarLivroDAO().cadastrarLivros(new LivroDTO("Refatoração: Aperfeiçoando o Design de Códigos Existentes", "Martin Fowler", 2018, 1));
        new CadastrarLivroDAO().cadastrarLivros(new LivroDTO("Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", 1994, 5));
        new CadastrarLivroDAO().cadastrarLivros(new LivroDTO("Algoritmos: Teoria e Prática", "Thomas H. Cormen", 2009, 3));
        new CadastrarLivroDAO().cadastrarLivros(new LivroDTO("Java: Como Programar", "Paul Deitel", 2015, 2));


    }
}
