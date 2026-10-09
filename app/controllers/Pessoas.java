package controllers;

import models.Papel;
import models.Pessoa;
import models.Status;
import models.Turma;
import play.mvc.Controller;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
public class Pessoas extends Controller {

    public static void form() {
//        List<Turmas> lista = findAll

        List<Turma> lista = Turma.findAll();


        render(lista);
    }

    public static void salvar(Pessoa p) {
        p.save();
        flash.success("  Cadastro concluído, realize o login!");


        Application.index();
    }

    public static void listar(String termo) {
        List<Pessoa> alunos;

        if (termo == null || termo.trim().isEmpty()) {
            alunos = Pessoa.find("status = ?1", Status.ATIVO).fetch();

        } else {

            alunos = Pessoa.find("lower(nome) like ?1 and status = ?2", "%" + termo.toLowerCase() + "%", Status.ATIVO).fetch();
        }

        render(alunos);
    }

    public static void editar(Long id) {
        Pessoa p = Pessoa.findById(id);

        renderTemplate("Pessoas/form.html", p);
    }

    public static void remover(Long id) {
        Pessoa usu = Pessoa.findById(Long.parseLong(session.get("usuarioLogado")));

        if (usu.papel != Papel.ADMINISTRADOR && usu.id != id) {
            flash.error("O usuário não tem permissão para isso!");
            listar(null);
        }


        Pessoa p = Pessoa.findById(id);

        p.status = Status.INATIVO;
        p.save();
        flash.success("Cadastro removido com   sucesso!");
        listar(null);
    }
}
