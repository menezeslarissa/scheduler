/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.SalaDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import modelo.Disciplina;
import modelo.Sala;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class ControleSala {
    private Sala sala;
    private List<Sala> listaSala = new ArrayList<>();
    private final SalaDAO salaDAO = new SalaDAO();
    
    public List<Sala> listar(String pDesc) throws ParseException, SQLException
    {
       this.listaSala = salaDAO.listarSalas(pDesc);
       return this.listaSala;
    }   
    public List<Sala> listarTudo(String pDesc){
        this.listaSala = salaDAO.listarTudo(pDesc);
        return this.listaSala;
    }
    public Sala pesquisarPorId(Integer id ){
        this.sala = salaDAO.pesquisarPorId(id);
        return this.sala;
    }
     public List<Sala> listarPorDisciplina(Integer pDisc) throws ParseException, SQLException
    {
       this.listaSala = this.salaDAO.listaSalaPorDisciplina(pDisc);
       return listaSala;
    }
    public void salvar(Sala s)throws ParseException{
        this.salaDAO.salvar(s);
    }
    
    public void remover(Integer id){
        this.salaDAO.remover(id);
    }
    
    public void update(Sala s){
        this.salaDAO.update(sala);
    }
    
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Sala getSala() {
        return this.sala;
    }
}
