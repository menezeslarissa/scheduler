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
import modelo.HoraLivre;
import util.JPAUtil;

/**
 *
 * @author Vitor Furtado de Oliveira
 */


public class HoraLivreDAO {
private String queryText = "";
    
    public List<HoraLivre> listarHorarioLivre(Integer pDia,Integer pID_Sala)
    {
        EntityManager manager = new JPAUtil().getEntityManager();
        queryText = "select hl from HoraLivre hl " + 
                    "Where hl.dia_semana = :pdia_semana " +
                    "and hl.sala.id = :pid_sala " +
                    "and hl.horario not in (select hr.horario from HorarioReservado hr where hr.dia_semana = :pdia_semana and hr.idsala.id = :pid_sala) " + 
                    "order by hl.horario ";                  

        Query query = manager
                .createQuery(queryText);
        
        query.setParameter("pdia_semana", pDia);
        query.setParameter("pid_sala", pID_Sala);
       
        List<HoraLivre> listaHorarioLivre = query.getResultList();
        manager.close();

        return listaHorarioLivre;
     }
    
    public List<HoraLivre> listarHorarioPorSala(Integer idSala){
        EntityManager manager = new JPAUtil().getEntityManager();
        queryText = "select hl from HoraLivre hl " +
                        "where hl.sala.id = :p_idsala ";                 

        Query query = manager
                .createQuery(queryText);
        
     
        query.setParameter("p_idsala", idSala);
       
        List<HoraLivre> listaHorarioLivre = query.getResultList();
        manager.close();

        return listaHorarioLivre;
    }
    
       public List<HoraLivre> listarTodos(){
        EntityManager manager = new JPAUtil().getEntityManager();
        queryText = "select hl from HoraLivre hl ";                

        Query query = manager
                .createQuery(queryText);
         
        List<HoraLivre> listaHorarioLivre = query.getResultList();
        manager.close();

        return listaHorarioLivre;
    }
       
    public boolean salvar(HoraLivre hl) {
        boolean vres;

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        StoredProcedureQuery query = manager.createNamedStoredProcedureQuery("validacao_inserir_horalivre");
        query.setParameter("p_horario", hl.getHorario());
        query.setParameter("p_dia_semana", hl.getDia_semana());
        query.setParameter("p_sala", hl.getSala().getId());
        query.setParameter("p_idperiodo",hl.getPeriodo().getId());
        query.execute();

        manager.getTransaction().commit();

        if (query.getOutputParameterValue("mensagem").equals("conflito")) {
            vres = false;
        } else {
            vres = true;
        }
        manager.close();

        return vres;
    }
}
