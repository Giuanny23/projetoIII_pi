package controllers;

import models.Papel;
import models.Pessoa;
import play.mvc.Controller;

public class Login extends Controller {

    public static void form() {
        render();
    }


    public static void login(String email, String senha) {

        Pessoa pessoa = Pessoa.find("email = ?1 and senha = ?2", email, senha).first();

        if (pessoa == null) {
            flash.error("Credenciais inválidas!");
            form();
        }

        if (pessoa.papel == Papel.ADMINISTRADOR) {
            session.put("adm", true);
        }

        flash.success("login realizado com sucesso!   ");
        session.put("usuarioLogado", pessoa.id);

        Application.index();
    }

    public static void logout() {
        session.clear();

        Application.index();
    }


}
