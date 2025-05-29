package DTO;

import java.time.LocalDate;
import java.sql.Date;

public class AlunoDTO {
    private String nome_aluno, matricula_aluno;
    private Date data_nascimento;

    @Override
    public String toString() {
        return "AlunoDTO{" +
                "nome_aluno='" + nome_aluno + '\'' +
                ", matricula_aluno='" + matricula_aluno + '\'' +
                ", data_nascimento=" + data_nascimento +
                '}';
    }

    public AlunoDTO(String nome, String matricula, int dia, int mes, int ano){
        LocalDate localDate = LocalDate.of(ano, mes, dia);
        nome_aluno = nome;
        matricula_aluno = matricula;
        data_nascimento = java.sql.Date.valueOf(localDate);
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getMatricula_aluno() {
        return matricula_aluno;
    }

    public void setMatricula_aluno(String matricula_aluno) {
        this.matricula_aluno = matricula_aluno;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
