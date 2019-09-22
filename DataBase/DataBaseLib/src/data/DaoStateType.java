/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
//se que este código esta súper chancho pero es para hacer pruebas

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.State;
import logic.Type;

/**
 *
 * @author djnane
 */
public class DaoStateType {

    private DBConnection db;
    private static DaoStateType dao = null;

    private static final String CMD_LIST_STATE
            = "SELECT ID, DESCRIPTION "
            + "FROM KRONOS.T_STATE ORDER BY ID ";

    private DaoStateType() {
        this.db = new DBConnection();

    }

    public static DaoStateType getDao() {
        if (dao == null) {
            return new DaoStateType();
        } else {
            return dao;
        }

    }

    public List<State> listAllState() {
        List<State> r = new ArrayList<>();

        try {
            try (Connection cnx = db.getConnection();
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(CMD_LIST_STATE)) {

                while (rs.next()) {
                    r.add(new State(
                            rs.getInt("ID"),
                            rs.getString("DESCRIPTION")
                    ));
                }

            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        }

        return r;

    }
}
