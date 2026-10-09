package controllers;

import play.mvc.Before;
import play.mvc.Controller;

public class Secure extends Controller {

    @Before(unless = {"Pessoas.form", "Pessoas.salvar"})
    static void verificar() {

        if (!session.contains("usuarioLogado")) {
            flash.error("Deve-se estar logado antes!");
            Application.index();
        }
    }

    @Before(only = {"Turmas.form", "Turmas.salvar", "Turmas.remover"})
    static void verificarAdm() {

        if (!session.contains("adm")) {
            flash.error("Apenas para ADMs do sistema!");
            Application.index();
        }
    }

}
