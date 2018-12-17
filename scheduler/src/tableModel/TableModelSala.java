/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import controle.ControleHoraLivre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.HoraLivre;
import modelo.Sala;
import util.DataUtil;

/**
 *
 * @author laris
 */
public class TableModelSala extends AbstractTableModel{
    private Sala sala;
    private List<Sala> listaSalas;
    private ControleHoraLivre controleHoraLivre = new ControleHoraLivre();
   
    
    public TableModelSala(List<Sala> listaSalas){
        this.listaSalas = listaSalas;
    }
    
    @Override
    public int getRowCount() {
        return listaSalas.size();
       
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        sala = listaSalas.get(linha);
        List<HoraLivre> lista = this.controleHoraLivre.listarTodos();
        String hora = null;
        String data = null;
        for(HoraLivre h : lista){
            if(sala.getId() == h.getSala().getId()){
                hora = h.getHorario();
                data = DataUtil.ConverterDataEmTexto(h.getData());
            }
        }
        switch(coluna){
            case 0: return sala.getDescricao();
            case 1: return hora;
            case 2: return data;
         
        }
        
        return null;
    }
     
    public String getColumnName(int coluna)
    {
        switch(coluna)
        {
            case 0 : return "Descrição";  
            case 1 : return "Horário Livre";  
            case 2 : return "Data";  
        }
        return null;
    }
}
