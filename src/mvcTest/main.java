/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcTest;


import mvcTest.view.PessoaView2;

/**
 *
 * @author bruno
 */
public class main {

    public static void main(String[] args) {
        /*
        PessoaView tela = new PessoaView();
        new PessoaController(tela);
        */
        
        PessoaView2 tela = new PessoaView2();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
        
        
    }

}