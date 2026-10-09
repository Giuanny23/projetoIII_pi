package controllers;

import models.Pessoa;
import models.Turma;
import play.mvc.Controller;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
public class Turmas extends Controller {

    public static void form() {

        render();
    }

    public static void salvar(Turma t) {

        t.save();

        flash.success("Turma salva com sucesso!");
        Application.index();
    }

    public static void detalhar(Long id) {
        Turma turma = Turma.findById(id);

        List<Pessoa> lista = Pessoa.find("turma = ?1", turma).fetch();
        String nomeTurma = turma.nome;
        render(lista, nomeTurma);
    }

    public static void listar() {
        List<Turma> turmas = Turma.findAll();
        render(turmas);
    }

    public static void remover(Long id) {
        Turma t = Turma.findById(id);

        t.delete();
        listar();
    }
}
