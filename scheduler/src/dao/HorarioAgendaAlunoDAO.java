package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import modelo.HorarioAgendaAluno;
import util.JPAUtil;

/**
 *
 * @author laris 
 * Alterado por Vitor Furtado de Oliveira em 03/10/2018
 */
public class HorarioAgendaAlunoDAO {

    private String queryText = "";
    private String vres = null;

    public void salvar(HorarioAgendaAluno h) {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.persist(h);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
    }

    public List<HorarioAgendaAluno> listarHorarioAgendaAluno(String pMatricula) {
        EntityManager manager = new JPAUtil().getEntityManager();

        queryText = "Select ag from HorarioAgendaAluno ag "
                + " Where ag.aluno.matricula = :pMatricula "
                + " Order by ag.horarioReservado.data , ag.horarioReservado.horario ";

        Query query = manager.createQuery(queryText);
        query.setParameter("pMatricula", pMatricula);

        List<HorarioAgendaAluno> listaHorarioAgendaAluno = query.getResultList();
        manager.close();

        return listaHorarioAgendaAluno;
    }
    
    public List<HorarioAgendaAluno> listarAlunosMatriculados(Integer pId) {
        EntityManager manager = new JPAUtil().getEntityManager();

        queryText = "Select ag from HorarioAgendaAluno ag "
                + " Where ag.horarioReservado.id = :pId ";

        Query query = manager.createQuery(queryText);
        query.setParameter("pId", pId);

        List<HorarioAgendaAluno> listaHorarioAgendaAluno = query.getResultList();
        manager.close();

        return listaHorarioAgendaAluno;
    }
    
    public List<HorarioAgendaAluno> listarPorId(Integer pId) {
        EntityManager manager = new JPAUtil().getEntityManager();

        queryText = "Select ag from HorarioAgendaAluno ag "
                + " Where ag.id = :pId ";

        Query query = manager.createQuery(queryText);
        query.setParameter("pId", pId);

        List<HorarioAgendaAluno> listaHorarioAgendaAluno = query.getResultList();
        manager.close();

        return listaHorarioAgendaAluno;
    }

    public String salvar(String p_matricula_aluno, Integer p_id_horarioreservado) {

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        StoredProcedureQuery query = manager.createNamedStoredProcedureQuery("validacao_agendamento");
        query.setParameter("p_matricula", p_matricula_aluno);
        query.setParameter("p_id_horarioreservado", p_id_horarioreservado);
        query.execute();

        manager.getTransaction().commit();
        System.out.println(query.getOutputParameterValue("mensagem"));
        if (query.getOutputParameterValue("mensagem").equals("conflito monitor")) {

            vres = "conflito monitor";
        }
        if (query.getOutputParameterValue("mensagem").equals("conflito aluno")) {
            vres = "conflito aluno";
        } else {
            vres = "ok";
        }
        manager.close();

        return vres;
    }

}
