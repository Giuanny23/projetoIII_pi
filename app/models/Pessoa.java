package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class Pessoa extends Model {

    public String nome;
    public String senha;
    public String email;
    public String matricula;


    @Enumerated(EnumType.STRING)
    public Papel papel;

    @ManyToOne
    public Turma turma;

    public Pessoa() {
        this.papel = Papel.ALUNO;
        this.status = Status.ATIVO;
    }

    @Enumerated(EnumType.STRING)
    public Status status;
}