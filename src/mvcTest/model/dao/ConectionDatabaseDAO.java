package mvcTest.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import mvcTest.model.bo.MyException;

public class ConectionDatabaseDAO {

    public Connection Con = null;
    public Statement Stm = null;
    public ResultSet Res = null;
    public PreparedStatement Cmd = null;

    private boolean bHasFail = false;
    private String sFailMessage = "";

    public ConectionDatabaseDAO() throws MyException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

            Stm = Con.createStatement();
            bHasFail = false;
            sFailMessage = "";
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            throw new MyException("Não foi possivel conectar no banco");
            /*
            JOptionPane.showMessageDialog(null, e.getStackTrace(), "Não foi possivel conectar ao banco", JOptionPane.ERROR_MESSAGE);
            bHasFail = true;
            sFailMessage = Arrays.toString(e.getStackTrace());
*/
        }
    }

    public boolean isbHasFail() {
        return bHasFail;
    }

    public String getsFailMessage() {
        return sFailMessage;
    }

    public void setbHasFail(boolean bHasFail) {
        this.bHasFail = bHasFail;
    }

    public void setsFailMessage(String sFailMessage) {
        this.sFailMessage = sFailMessage;
    }
}
