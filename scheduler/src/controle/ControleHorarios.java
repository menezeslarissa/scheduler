/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.HorariosDAO;
import java.util.List;

/**
 *
 * @author laris
 */
public class ControleHorarios {
    private HorariosDAO horariosDAO = new HorariosDAO();
    //listra os horarios de inicio e fim
    public List<String> listarHorariosInicio(){
        return this.horariosDAO.listarInicio();
    }
    
    public List<String> listarHorariosFim(){
        return this.horariosDAO.listarFim();
    }
}
