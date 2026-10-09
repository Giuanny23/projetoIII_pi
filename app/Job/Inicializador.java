package Job;

import models.Papel;
import models.Pessoa;
import models.Turma;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

    @Override
    public void doJob() throws Exception {
        if (Turma.count() == 0) {
            Turma t1 = new Turma();
            t1.nome = "TURMA1";
            t1.save();

            Turma t2 = new Turma();
            t2.nome = "TURMA2";
            t2.save();

            Turma t3 = new Turma();
            t3.nome = "TURMA3";
            t3.save();

            Pessoa adm = new Pessoa();
            adm.nome = "adm";
            adm.email = "adm@adm";
            adm.senha = "adm";
            adm.matricula = "0";
            adm.papel = Papel.ADMINISTRADOR;
            adm.save();
        }
    }


}
