/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.helpers;

import edu.uan.fis.jeesample.actions.ICommand;
import edu.uan.fis.jeesample.actions.impl.CreateCategory;
import edu.uan.fis.jeesample.actions.impl.CreateCustomer;
import edu.uan.fis.jeesample.actions.impl.CreateProduct;
import edu.uan.fis.jeesample.actions.impl.DeleteCategory;
import edu.uan.fis.jeesample.actions.impl.DeleteCustomer;
import edu.uan.fis.jeesample.actions.impl.DeleteProduct;
import edu.uan.fis.jeesample.actions.impl.GetCategory;
import edu.uan.fis.jeesample.actions.impl.GetCustomer;
import edu.uan.fis.jeesample.actions.impl.GetProduct;
import edu.uan.fis.jeesample.actions.impl.ListCategories;
import edu.uan.fis.jeesample.actions.impl.ListCustomers;
import edu.uan.fis.jeesample.actions.impl.ListProducts;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Luis Herrera
 */
public class CommandHelper {
    
    private HttpServletRequest request;
    public CommandHelper(HttpServletRequest request){
        this.request= request;
    }
    public ICommand GetCommand(){
        String desiredAction = request.getServletPath();        
        ICommand command;
        // TODO: read the cases from a configuration file. Extra points!!!
        switch (desiredAction) {
            case "/listProducts.do":
                command = new ListProducts();
                break;
            case "/insertProduct.do":
                command = new GetProduct();    
                break;
            case "/editProduct.do":
                command = new CreateProduct();
                break;
            case "/deleteProduct.do":
                command = new DeleteProduct();
                break;
            case "/listCustomers.do":
                command = new ListCustomers();
                break;
            case "/insertCustomer.do":
                command = new GetCustomer();    
                break;
            case "/editCustomer.do":
                command = new CreateCustomer();
                break;
            case "/deleteCustomer.do":
                command = new DeleteCustomer();
                break;
            case "/listCategories.do":
                command = new ListCategories();
                break;
            case "/insertCategory.do":
                command = new GetCategory();
                break;
            case "/editCategory.do":
                command = new CreateCategory();
                break;
            case "/deleteCategory.do":
                command = new DeleteCategory();
                break;       
            case "home.do":
            default:
                command = null;
                break;
        }
        return command;
    }
}
