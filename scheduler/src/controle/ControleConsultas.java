/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ConsultasDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Consulta1;
import modelo.Consulta2;

/**
 *
 * @author laris
 */
public class ControleConsultas {
   private ConsultasDAO dao = new ConsultasDAO();
    private List<Consulta1> lista1 = new ArrayList<>();
    private List<Consulta2> lista2 = new ArrayList<>();

    public List<Consulta1> listar(Integer idPeriodo){
        this.lista1 = dao.consulta1(idPeriodo);
        return lista1;
    }
    
    public List<Consulta2> listar2(Integer idPeriodo){
        this.lista2 = dao.consulta2(idPeriodo);
        return lista2;
    }
}
