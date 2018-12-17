/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DisciplinaDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import modelo.Disciplina;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class ControleDisciplina {
    private Disciplina disciplina;
    private List<Disciplina> listaDisciplina = new ArrayList<>();
    private final DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    
    public List<Disciplina> listar(String pDesc) throws ParseException, SQLException
    {
       this.listaDisciplina = disciplinaDAO.listarDisciplinas(pDesc);
       return this.listaDisciplina;
    }
   
    
    public Disciplina procurarPorId(Integer id){
        this.disciplina = this.disciplinaDAO.procurarPorId(id);
        
        return this.disciplina;
        
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public void salvar(Disciplina d){
        this.disciplinaDAO.salvar(d);
    }
    
    public void update(Disciplina d){
        this.disciplinaDAO.update(d);
    }
}
