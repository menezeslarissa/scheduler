/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.TempConsultasDisciplinaDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.TempConsultasDisciplina;

/**
 *
 * @author laris
 */
public class ControleTempConsultasDisciplina {
    private TempConsultasDisciplina tempConsultasDisciplina;
    private List<TempConsultasDisciplina> lista = new ArrayList<>();
    private TempConsultasDisciplinaDAO dao = new TempConsultasDisciplinaDAO();
    
    public List<TempConsultasDisciplina> listar(Integer pId){
        this.lista = dao.listar(pId);
        return this.lista;
    }
}
