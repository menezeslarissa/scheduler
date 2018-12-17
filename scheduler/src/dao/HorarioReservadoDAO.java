/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import modelo.Disciplina;
import modelo.HoraLivre;
import modelo.HorarioReservado;
import modelo.Monitor;
import util.JPAUtil;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class HorarioReservadoDAO {

    private String queryText = "";

    public List<HorarioReservado> listarHorariosReservados(Integer pDia, Integer pID_Disciplina, Integer pID_Sala, String pMatricula) {
       
        EntityManager manager = new JPAUtil().getEntityManager();
        
        queryText = "select hr from HorarioReservado hr "
                + "Where hr.dia_semana = :pdia_semana "
                + "and hr.iddisc.iddisc = :pid_disciplina "
                + "and hr.idsala.idsala = :pid_sala "
                + "and hr.id not in (select ag.horarioReservado.id from HorarioAgendaAluno ag Where ag.aluno.matricula =:pMatricula) "
                + "and hr.qtd_alunos < 12 "
                + "and hr.status = 'F'"
                + "order by hr.horario ";

        Query query = manager.createQuery(queryText);
        query.setParameter("pdia_semana", pDia);
        query.setParameter("pid_disciplina", pID_Disciplina);
        query.setParameter("pid_sala", pID_Sala);
        query.setParameter("pMatricula", pMatricula);
        
        List<HorarioReservado> listaHorarioReservado = query.getResultList();
        manager.close();

        return listaHorarioReservado;
    }

     public List<HorarioReservado> listarTudo(Integer id) {

        EntityManager manager = new JPAUtil().getEntityManager();

        queryText = "select hr from HorarioReservado hr where hr.periodo.id = :pId";

        Query query = manager
                .createQuery(queryText);

        query.setParameter("pId", id);

        List<HorarioReservado> listaHorarioReservado = query.getResultList();
        manager.close();

        return listaHorarioReservado;
    }
    public List<HorarioReservado> listarHorariosMonitor(Integer pID_Monitor, char pStatus ) {

        EntityManager manager = new JPAUtil().getEntityManager();

        queryText = "select hr from HorarioReservado hr "
                + "Where hr.idmon.id = :pid_monitor "
                + "and hr.status = :pstatus "
                + "order by hr.horario ";

        Query query = manager
                .createQuery(queryText);

        query.setParameter("pid_monitor", pID_Monitor);
        query.setParameter("pstatus", pStatus);

        List<HorarioReservado> listaHorarioReservado = query.getResultList();
        manager.close();

        return listaHorarioReservado;
    }

    public boolean salvar(HoraLivre h, String p_data, Disciplina pID_Disciplina, Monitor pID_Monitor, Integer p_ID_Sala) {
        boolean vres;
        
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        StoredProcedureQuery query = manager.createNamedStoredProcedureQuery("validacao_inserir");
        query.setParameter("p_data", p_data);
        query.setParameter("p_horario", h.getHorario());
        query.setParameter("p_dia_semana", h.getDia_semana());
        query.setParameter("p_iddisc", pID_Disciplina.getIddisc());
        query.setParameter("p_idmon", pID_Monitor.getId());
        query.setParameter("p_idsala", p_ID_Sala);
        query.execute();
        
        manager.getTransaction().commit();
        
        if (query.getOutputParameterValue("mensagem").equals("conflito")){
            vres = false;
        }
        else
        {
            vres = true;
        }
        manager.close();
        
        return vres;
    }

    public void atualizarStatus(Integer idmon) {

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        String hql = "UPDATE HorarioReservado as hr set hr.status = 'F'"
                  + " WHERE hr.idmon.id = :p_idmon";
        Query query = manager.createQuery(hql);
        query.setParameter("p_idmon", idmon);
        int result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        manager.getTransaction().commit();
        manager.close();
    }
}
