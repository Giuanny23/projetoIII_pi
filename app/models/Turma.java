package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Turma extends Model {

    public String nome;
}
