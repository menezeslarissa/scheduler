/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Consulta1;
import modelo.Consulta2;
import util.JPAUtil;

/**
 *
 * @author laris
 */
public class ConsultasDAO {

   private List<Consulta1> lista1 = new ArrayList<>();
    private List<Consulta2> lista2 = new ArrayList<>();
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "qtde,descricao,periodo";

    //disciplinas mais procuras
    public List<Consulta1> consulta1(Integer pId) {
        EntityManager manager = new JPAUtil().getEntityManager();

        String queryText = "select count(*) as qtde, d.descricao as descricao, p.periodo as periodo "
                + "from horario_reservado as hr "
                + "inner join horario_agenda_aluno as hg on hr.id = hg.id "
                + "inner join disciplina as d on hr.iddisc = d.iddisc "
                + "inner join periodo as p on p.id = hr.periodo "
                + "where hr.periodo = :pId "
                + "group by descricao "
                + "order by qtde desc ";
        Query query = manager.createNativeQuery(queryText, "consulta1");
        query.setParameter("pId", pId);
        lista1 = query.getResultList();
        //writing cvs file
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("disciplinas_mais_procuradas");
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Consulta1 c : lista1) {
                fileWriter.append(String.valueOf(c.getQtde()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getDisciplina());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(c.getPeriodo());
                fileWriter.append(COMMA_DELIMITER);
            }
            System.out.println("CSV file was created successfully !!!");

        } catch (IOException ex) {
            System.out.println("Error in CsvFileWriter !!!");
            Logger.getLogger(ConsultasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
            }
        }
        return lista1;
    }

    public List<Consulta2> consulta2(Integer idPeriodo) {
        EntityManager manager = new JPAUtil().getEntityManager();

        String queryText = "select sum(qtd_alunos) as qtde, d.descricao as descricao, p.periodo as periodo "
                + "from horario_reservado as hr "
                + "inner join disciplina as d on d.iddisc = hr.iddisc "
                + "inner join periodo as p on p.id = hr.periodo "
                + "where hr.periodo = :pId "
                + "group by d.descricao "
                + "order by qtde desc ";
        Query query = manager.createNativeQuery(queryText, "consulta2");
        query.setParameter("pId", idPeriodo);
        lista2 = query.getResultList();
        return lista2;
    }

}
