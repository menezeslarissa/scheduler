/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import dao.HoraLivreDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import modelo.HoraLivre;

/**
 *
 * @author Vitor Furtado de Oliveira
 */
public class ControleHoraLivre {
    private HoraLivre horalivre;
    private List<HoraLivre> listaHoraLivre = new ArrayList<>();
    private final HoraLivreDAO horalivreDAO = new HoraLivreDAO();
    
    public List<HoraLivre> listar(Integer pDia, Integer pID_Sala) throws ParseException, SQLException
    {
       this.listaHoraLivre = horalivreDAO.listarHorarioLivre(pDia,pID_Sala);
       return this.listaHoraLivre;
    }
    
    public void setHorarioLivre(HoraLivre horalivre)
    {
        this.horalivre = horalivre;
    }
   
    public HoraLivre getHorarioLivre()
    {
        return this.horalivre;
    }
    
    public List<HoraLivre> listarHorarioPorSala(Integer id){
        return this.horalivreDAO.listarHorarioPorSala(id);
    }
    
    public List<HoraLivre> listarTodos(){
        return this.horalivreDAO.listarTodos();
    }
    
    public boolean salvar(HoraLivre h){
       return this.horalivreDAO.salvar(h);
    }
}
