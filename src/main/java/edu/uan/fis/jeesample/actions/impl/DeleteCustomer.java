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
public class DeleteCustomer implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        CommandResult result = new CommandResult();
        try {
            Integer customerId = Integer.parseInt(request.getParameter("customerId")); 
            CustomerDao dao = new CustomerDaoJdbc();
            Customer entity = dao.findById(customerId);
            if(entity!=null){
                dao.delete(entity);
            }
            result = new ListCustomers().execute(request, response);
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
