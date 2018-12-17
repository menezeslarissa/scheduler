/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.ConsultasDAO;

/**
 *
 * @author laris
 */
public class Teste {
    public static void main(String[] args) {
        ConsultasDAO consultasDAO = new ConsultasDAO();
       consultasDAO.consulta1(2);
    }
}
