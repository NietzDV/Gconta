/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import persistencia.Conexão;

/**
 *
 * @author Aluno
 */
public class Principal {
    public static void main(String[] args) {
        Conexão b = new Conexão();
        b.conecta();
        b.desconecta();
    }
}
