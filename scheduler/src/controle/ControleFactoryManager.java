/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vitor
 */
public class ControleFactoryManager {
    
    private EntityManager manager;
    
    public void criarFactoryManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_Scheduler");
        this.manager = factory.createEntityManager();
    }
    
    public EntityManager getFactoryManager()
    {
        return this.manager;
    }

}
