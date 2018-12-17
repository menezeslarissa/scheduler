
package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Login;
import util.JPAUtil;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class LoginDAO {
    private String queryText = "select l from Login l";
    
    /*
    public List<Login> listarLogin(String pDesc)
    {
        /*
        EntityManager manager = new JPAUtil().getEntityManager();
        
        if (pDesc != ""){
            queryText = "Select l from Login l Where l.usuario = :pUsuario And l.senha = :pSenha";   
        }
        
        Query query = manager.createQuery(queryText); 
    
        query.setParameter("pDesc", "%" + pDesc + "%");   
       
        List<Aluno> listaAluno = query.getResultList();
        manager.close();

        return listaAluno;
     }  

*/
    
    public Login buscarLogin(String pUsuario, String pSenha){

        EntityManager manager = new JPAUtil().getEntityManager();
       
        queryText = "Select l from Login l Where l.usuario = :pUsuario And l.senha = :pSenha";   
        Query query = manager.createQuery(queryText); 
        query.setParameter("pUsuario", pUsuario );   
        query.setParameter("pSenha", pSenha);  
        
        Login login = (Login) query.getResultList().get(0);
        manager.close();

        return login;
    }
    
    /*
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
*/
}
