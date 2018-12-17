/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.TempConsultasDisciplina;
import util.JPAUtil;

/**
 *
 * @author laris
 */
public class TempConsultasDisciplinaDAO {
    
    private List<TempConsultasDisciplina> lista = new ArrayList<>();
    
    public List<TempConsultasDisciplina> listar(Integer pId){
        
        EntityManager manager = new JPAUtil().getEntityManager();
        
        String queryText = "select hr.iddisc.descricao, hr.periodo.periodo from HorarioReservado as hr " +
                            "inner join hr.iddisc " +
                            "inner join hr.periodo " +
                            "where p.periodo.id = :pId " +
                            "group by hr.iddisc.descricao " ;//+
                           // "order by max(hr.qtd_alunos) desc";
        Query query = manager.createNamedQuery(queryText);
        query.setParameter("pId", pId);
        
        this.lista=query.getResultList();
        manager.close();
        
        
        return this.lista;
    }
    
}
