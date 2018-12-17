package dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Sala;
import util.JPAUtil;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class SalaDAO {

    private String queryText = "select s from Sala s";
    private List<Sala> salas = new ArrayList<>();

    public List<Sala> listarSalas(String pDesc) {
        EntityManager manager = new JPAUtil().getEntityManager();

        if (pDesc != "") {
            queryText = "Select s from Sala s Where s.descricao like :pDesc order by s.descricao";
        }

        Query query = manager.createQuery(queryText);

        if (pDesc != "") {
            query.setParameter("pDesc", "%" + pDesc + "%");
        }

        List<Sala> listaSala = query.getResultList();
        manager.close();
        return listaSala;
    }

    public Sala pesquisarPorId(Integer id) {
        EntityManager manager = new JPAUtil().getEntityManager();
        Sala s = manager.find(Sala.class, id);
        manager.close();
        return s;
    }

    public List<Sala> listarTudo(String pDesc) {
        EntityManager manager = new JPAUtil().getEntityManager();
        if (pDesc != "") {
            queryText = "select s from Sala s "
                + "where s.idsala in (select hr.idsala from HorarioReservado hr where hr.iddisc.descricao= :pDesc) ";
        }

        Query query = manager.createQuery(queryText);

        if (pDesc != "") {
            query.setParameter("pDesc", "%" + pDesc + "%");
        }

      
        List<Sala> listaSala = query.getResultList();
        manager.close();
        return listaSala;
    }

    public void update(Sala sala) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Sala s = manager.find(Sala.class, sala.getId());
        s.setDescricao(sala.getDescricao());
        s.setLocal(sala.getLocal());
        s.setStatus(sala.getStatus());
        manager.getTransaction().begin();
        manager.merge(s);
        manager.getTransaction().commit();
        manager.close();
    }

    public void remover(Integer idSala) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Sala s = manager.find(Sala.class, idSala);
        manager.remove(this);
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
    }

    public boolean salvar(Sala s) throws ParseException {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    public List<Sala> listaSalaPorDisciplina(Integer id) {
        EntityManager manager = new JPAUtil().getEntityManager();
        // if (pDisc == null) {
        //   listaSala = listarSalas("");
        //}/
        //if (pDisc != null) {
        queryText = "select s from Sala s "
                + "where s.idsala in (select hr.idsala from HorarioReservado hr where hr.iddisc.iddisc = :pDisc) ";

        //}
        Query query = manager.createQuery(queryText);
        query.setParameter("pDisc", id);

        // if (pDisc != null) {
        //}
        this.salas = query.getResultList();
        manager.close();

        return this.salas;
    }
}
