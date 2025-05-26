package DTO;

public class LivroDTO {
    private String titulo, autor;
    private Integer ano_publicacao, quantidade_estoque;

    public LivroDTO(String titulo_livro, String autor_livro, Integer ano_publicacao_livro, Integer quantidade_estoque_livro){
        titulo = titulo_livro;
        autor = autor_livro;
        ano_publicacao = ano_publicacao_livro;
        quantidade_estoque = quantidade_estoque_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(Integer ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public Integer getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(Integer quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
}
