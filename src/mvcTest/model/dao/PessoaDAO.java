/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcTest.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvcTest.model.bo.MyException;
import mvcTest.model.vo.PessoaVO;

/**
 *
 * @author bruno
 */
public class PessoaDAO extends ConectionDatabaseDAO {

    public PessoaDAO() throws MyException {

    }

    public void save(PessoaVO p) {

        try {
            Cmd = Con.prepareStatement("INSERT INTO pessoa values(null,?,?);");
            Cmd.setString(1, p.getsName());
            Cmd.setInt(0, p.getiLuckyNumber());
            Cmd.execute();
            System.out.println("Nome: " + p.getsName()
                    + "\nNumero da sorte: " + p.getiLuckyNumber());
        } catch (SQLException ex) {
            setbHasFail(true);
            setsFailMessage(Arrays.toString(ex.getStackTrace()));
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void list() {
        try {
            Res = Stm.executeQuery("SELECT * FROM pessoa;");

            while (Res.next()) {
                System.out.println(
                        Res.getObject("id").toString() + " - "
                        + Res.getObject("name").toString() + " - "
                        + Res.getObject("luckyNumber").toString());
            }

        } catch (Exception e) {
        }
    }

    public List<PessoaVO> lista() {
        List<PessoaVO> lst = new ArrayList<>();
        try {
            Res = Stm.executeQuery("SELECT * FROM pessoa;");

            while (Res.next()) {
                lst.add(new PessoaVO(Integer.parseInt(Res.getString("id")),
                        Res.getObject("name").toString(),
                        Integer.parseInt(Res.getObject("luckyNumber").toString())));
            }
        } catch (SQLException ex) {
            setbHasFail(true);
            setsFailMessage(Arrays.toString(ex.getStackTrace()));
        }
        return lst;
    }
}
