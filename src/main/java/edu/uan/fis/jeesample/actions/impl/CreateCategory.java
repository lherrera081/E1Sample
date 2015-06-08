/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.actions.impl;

import edu.uan.fis.jeesample.actions.CommandResult;
import edu.uan.fis.jeesample.actions.ICommand;
import edu.uan.fis.jeesample.dao.CategoryDao;
import edu.uan.fis.jeesample.dao.ProductDao;
import edu.uan.fis.jeesample.dao.impl.CategoryDaoJdbc;
import edu.uan.fis.jeesample.dao.impl.ProductDaoJdbc;
import edu.uan.fis.jeesample.dto.Category;
import edu.uan.fis.jeesample.dto.Product;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis Herrera
 */
public class CreateCategory implements ICommand {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        CommandResult result = new CommandResult();
        try {
            Integer categoryId = Integer.parseInt(request.getParameter("categoryId")); 
            String name = request.getParameter("name"); 
            CategoryDao dao = new CategoryDaoJdbc();
            Category category = dao.findById(categoryId);
            if(category==null){
                category = new Category();
                category.setCategoryId(categoryId);
                category.setName(name);
                dao.create(category);
            }else{
                category.setName(name);
                dao.update(category);
            }
            // store the products in the request, so them can be painted in the view
//            request.setAttribute("productList", products);
            // 3. Finally, returns the command result
            result = new ListCategories().execute(request, response);
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
