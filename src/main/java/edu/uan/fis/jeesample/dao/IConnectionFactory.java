/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao;

import java.sql.Connection;

/**
 *
 * @author Luis Herrera
 */
public interface IConnectionFactory extends AutoCloseable {
    
    /**
     * Create a database SQL connection with JDBC
     * @return Connection to SQL database
     */
    Connection createConnection();
    
}
