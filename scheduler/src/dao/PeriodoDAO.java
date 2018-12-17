
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import modelo.Periodo;

import util.JPAUtil;

/**
 *
 * @author Vitor Furtado de Oliveira    
 */
public class PeriodoDAO {
    private String queryText = "select p from Periodo p";
    
    public List<Periodo> listarPeriodos()
    {
        EntityManager manager = new JPAUtil().getEntityManager();
        Query query = manager.createQuery(queryText); 
        List<Periodo> listaPeriodo = query.getResultList();
        manager.close();

        return listaPeriodo;
     }      
    
    public Periodo buscarUltimoPeriodo(){
        EntityManager manager = new JPAUtil().getEntityManager();
       
        queryText = "Select p from Periodo p Order by p.id desc";   
        Query query = manager.createQuery(queryText); 
        Periodo periodo = (Periodo) query.getResultList().get(0);
        manager.close();

        return periodo;
    }
    
    public boolean salvar(Periodo p) {
        boolean vres;

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        StoredProcedureQuery query = manager.createNamedStoredProcedureQuery("validacao_inserir_periodo");
        query.setParameter("p_periodo", p.getPeriodo());
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
