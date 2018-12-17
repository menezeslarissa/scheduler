/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

/**
 *
 * @author laris
 */
public class HorariosDAO {
    public List<String> listarInicio(){
        String queryText = "select horainicio from hora_inicio";
        EntityManager manager = new JPAUtil().getEntityManager();
        Query query = manager.createNativeQuery(queryText);
                        
        List<String> listaHoras = query.getResultList();
       
        manager.close();
        return listaHoras;
     }   
    
     public List<String> listarFim(){
        String queryText = "select horafim from hora_fim";
        EntityManager manager = new JPAUtil().getEntityManager();
        Query query = manager.createNativeQuery(queryText);
                        
        List<String> listaHoras = query.getResultList();
       
        manager.close();
        return listaHoras;
     }   
    
}
