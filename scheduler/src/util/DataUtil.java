/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author laris
 */
public class DataUtil {
    public static String ConverterDataEmTexto(Calendar dataCalendar){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = dataCalendar;
        return formatador.format(c.getTime());
    }
    
    public static Calendar ConverterTextoEmData(String dataRecebida) throws ParseException{
        //definindo o formato esperado
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
       //convertendo string para date
       Date dataFormatada = formato.parse(dataRecebida);
       //saída com o formato desejado
       Calendar dataCalendar = Calendar.getInstance();
       dataCalendar.setTime(dataFormatada);
       return dataCalendar;
    }

    
}
