
package dao;

import java.text.ParseException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Monitor;
import util.JPAUtil;

/**
 *
 * @author laris
 * Alterado por Vitor Furtado de Oliveira
 */
public class MonitorDAO {
    private String queryText = "select m from Monitor m";
    
    public Monitor procurarPorMatricula(String pmatricula){
        EntityManager manager = new JPAUtil().getEntityManager();
       
        queryText = "Select m from Monitor m Where m.matricula = :pMatricula";   
        Query query = manager.createQuery(queryText); 
        query.setParameter("pMatricula", pmatricula );   
        
        Monitor monitor = (Monitor) query.getResultList().get(0);
        manager.close();

        return monitor;
    }
    
    public Monitor procurarPorId(Integer id){
        EntityManager manager = new JPAUtil().getEntityManager();
       
        queryText = "Select m from Monitor m Where m.id = :id";   
        Query query = manager.createQuery(queryText); 
        query.setParameter("pMatricula", id );   
        
        Monitor monitor = (Monitor) query.getResultList().get(0);
        manager.close();

        return monitor;
    }
    public List<Monitor> listarMonitores(String pDesc) {
        EntityManager manager = new JPAUtil().getEntityManager();
        
        if (pDesc != ""){
            queryText = "Select m from Monitor m Where m.nome like :pDesc";   
        }
        
        Query query = manager.createQuery(queryText); 
        
        if (pDesc != ""){
            query.setParameter("pDesc", "%" + pDesc + "%");   
        }
        
        List<Monitor> listaMonitor = query.getResultList();
        manager.close();
        return listaMonitor;
    }
    
    public boolean salvar(Monitor m) throws ParseException {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        
        manager.persist(m);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
}
