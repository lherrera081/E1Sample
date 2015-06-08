/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.actions.impl;

import edu.uan.fis.jeesample.actions.CommandResult;
import edu.uan.fis.jeesample.actions.ICommand;
import edu.uan.fis.jeesample.dao.CustomerDao;
import edu.uan.fis.jeesample.dao.impl.CustomerDaoJdbc;
import edu.uan.fis.jeesample.dto.Customer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Herrera
 */
public class GetCategory implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
         CommandResult result = new CommandResult();
        try {
            
            Integer categoryId = 0;
            if(request.getParameter("categoryId") != null){
                categoryId = Integer.parseInt(request.getParameter("categoryId")); 
                CustomerDao dao = new CustomerDaoJdbc();
                Customer entity = dao.findById(categoryId);
                if(entity!=null){
                    request.setAttribute("category", entity);
                }
            }
            result.setResult("insertCategory");
        } catch (Exception e) {
            Logger.getLogger(ListProducts.class.getName()).log(Level.WARNING, null, e);
            result.setErrorCode("ERR");
            result.setErrorMessage(e.getMessage());
            result.setResult("error");
        }
        request.setAttribute("commandResult", result);
        return result;
    }
    
}
