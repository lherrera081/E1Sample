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
public class CreateCustomer implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
       CommandResult result = new CommandResult();
        try {
            Integer customerId = Integer.parseInt(request.getParameter("customerId")); 
            String name = request.getParameter("name"); 
            String lastName = request.getParameter("lastName"); 
            Integer city = Integer.parseInt(request.getParameter("cityId"));
            Integer state = Integer.parseInt(request.getParameter("stateId"));
            CustomerDao dao = new CustomerDaoJdbc();
            Customer entity = dao.findById(customerId);
            if(entity==null){
                entity = new Customer();
                entity.setCustomerId(customerId);
                entity.setName(name);                
                entity.setLastName(lastName);
                entity.setCityId(city);
                entity.setStateId(state);
                dao.create(entity);
            }else{
                entity.setName(name);                
                entity.setLastName(lastName);
                entity.setCityId(city);
                entity.setStateId(state);
                dao.update(entity);
            }
            // store the products in the request, so them can be painted in the view
//            request.setAttribute("productList", products);
            // 3. Finally, returns the command result
            result = new ListCustomers().execute(request, response);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, null, e);
            result.setErrorCode("ERR");
            result.setErrorMessage(e.toString());
            result.setResult("error");
        }
        request.setAttribute("commandResult", result);
        return result;
    
    }
}
