/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcTest.model.bo;

import java.util.List;
import mvcTest.model.dao.PessoaDAO;
import mvcTest.model.vo.PessoaVO;

/**
 *
 * @author bruno
 */
public class PessoaBO {

    public void save(PessoaVO p) throws MyException {
        new PessoaDAO().save(p);
    }

    public void list() {
        //new PessoaDAO().list();
    }

    public List<PessoaVO> lista() throws MyException {
        List<PessoaVO> lst = new PessoaDAO().listar();
        return lst;
    }

    public List<PessoaVO> lista(String sSearch) throws MyException {
        List<PessoaVO> lst = new PessoaDAO().listar(sSearch);
        return lst;
    }
}
