/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.IConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class JdbcConnectionFactory implements IConnectionFactory {
    private Connection conn = null;
    @Override
    public Connection createConnection() {
        String connectionUrl = "jdbc:derby://localhost:1527/jeesample";
        String className = "org.apache.derby.jdbc.ClientDriver";
        String user = "root";
        String password = "root";
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(connectionUrl, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    @Override
    public void close() throws Exception {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
