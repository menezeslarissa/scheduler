/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Aluno;
import util.JPAUtil;

/**
 *
 * @author Laris
 * Alterado por Vitor Furtado de Oliveira em 02-10-2018
 */
public class AlunoDAO {
    private String queryText = "select a from Aluno a";
    
    public List<Aluno> listarAlunos(String pDesc)
    {
        EntityManager manager = new JPAUtil().getEntityManager();
        
        if (pDesc != ""){
            queryText = "Select a from Aluno a Where a.nome like :pDesc";   
        }
        
        Query query = manager.createQuery(queryText); 
        
        if (pDesc != ""){
            query.setParameter("pDesc", "%" + pDesc + "%");   
        }
                   
        List<Aluno> listaAluno = query.getResultList();
        manager.close();

        return listaAluno;
     }      
    
    public Aluno procurarPorId(Integer id){

        EntityManager manager = new JPAUtil().getEntityManager();
        Aluno a = manager.find(Aluno.class, id);
        manager.close();
        return a;
    }
    
    public Aluno procurarPorMatricula(String pmatricula){
        EntityManager manager = new JPAUtil().getEntityManager();
       
        queryText = "Select a from Aluno a Where a.matricula = :pMatricula";   
        Query query = manager.createQuery(queryText); 
        query.setParameter("pMatricula", pmatricula );   
        
        Aluno aluno = (Aluno) query.getResultList().get(0);
        manager.close();

        return aluno;
    }
    
    public void salvar(Aluno a){
        EntityManager manager = new JPAUtil().getEntityManager();
        
        manager.getTransaction().begin();
        manager.persist(a);
        manager.getTransaction().commit();
        manager.close();
    }
    
     public void update(Aluno a){
        EntityManager manager = new JPAUtil().getEntityManager();
        
        manager.getTransaction().begin();
        manager.merge(a);
        manager.getTransaction().commit();
        manager.close();
    }
}
