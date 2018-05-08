/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcTest.controller;

import java.util.List;
import mvcTest.model.bo.MyException;
import mvcTest.model.bo.PessoaBO;
import mvcTest.model.vo.PessoaVO;

/**
 *
 * @author bruno
 */
public class PessoaController2 {

    public PessoaController2() {

    }

    public void send(PessoaVO p) throws MyException {
        new PessoaBO().save(p);

    }

    public List<PessoaVO> lista() {
        return new PessoaBO().lista();

    }

}
