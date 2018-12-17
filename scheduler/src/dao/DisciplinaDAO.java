/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Disciplina;
import util.JPAUtil;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class DisciplinaDAO {

    private String queryText = "select d from Disciplina d";

    public List<Disciplina> listarDisciplinas(String pDesc) {
        EntityManager manager = new JPAUtil().getEntityManager();

        if (pDesc != "") {
            queryText = "Select d from Disciplina d Where d.resumo like :pDesc";
        }

        Query query = manager.createQuery(queryText);

        if (pDesc != "") {
            query.setParameter("pDesc", "%" + pDesc + "%");
        }

        List<Disciplina> listaDisciplina = query.getResultList();
        manager.close();

        return listaDisciplina;
    }

    public Disciplina procurarPorId(Integer id) {

        EntityManager manager = new JPAUtil().getEntityManager();
        Disciplina d = manager.find(Disciplina.class, id);
        manager.close();
        return d;
    }

    public void salvar(Disciplina d) {
        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();
        manager.persist(d);
        manager.getTransaction().commit();
        manager.close();
    }

    public void update(Disciplina d) {
        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();
        manager.merge(d);
        manager.getTransaction().commit();
        manager.close();
    }

}
