/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.HorarioReservadoDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import modelo.Disciplina;
import modelo.HoraLivre;
import modelo.HorarioReservado;
import modelo.Monitor;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class ControleHorarioReservado {
     private HorarioReservado horarioreservado;
    private List<HorarioReservado> listaHorarioReservado = new ArrayList<>();
    private final HorarioReservadoDAO horarioReservadoDAO = new HorarioReservadoDAO();
    
    public void setHorarioReservado(HorarioReservado horarioreservado)
    {
        this.horarioreservado = horarioreservado;
    }
   
    public HorarioReservado getHorarioReservado()
    {
        return this.horarioreservado;
    }
    
    public List<HorarioReservado> listar(Integer pDia,Integer pID_Disciplina,Integer pID_Sala,String pMatricula) throws ParseException, SQLException
    {
       this.listaHorarioReservado = horarioReservadoDAO.listarHorariosReservados(pDia,pID_Disciplina,pID_Sala,pMatricula);
       return this.listaHorarioReservado;
    }
    
     public List<HorarioReservado> listarTudo(Integer id) throws ParseException, SQLException
    {
       this.listaHorarioReservado = horarioReservadoDAO.listarTudo(id);
       return this.listaHorarioReservado;
    }
    
    public List<HorarioReservado> listarHorarioMonitor(Integer pID_Monitor, char pStatus){
       this.listaHorarioReservado = horarioReservadoDAO.listarHorariosMonitor(pID_Monitor,pStatus);
       return this.listaHorarioReservado;
    }
    
    public boolean salvar(HoraLivre h, String p_data, Disciplina pID_Disciplina, Monitor pID_Monitor, Integer p_ID_Sala){
        return horarioReservadoDAO.salvar(h, p_data, pID_Disciplina, pID_Monitor, p_ID_Sala);
    }

    public void atualizarStatus(Integer idmon){
        this.horarioReservadoDAO.atualizarStatus(idmon);
    }
}
