/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.helpers;

import edu.uan.fis.jeesample.actions.CommandResult;

/**
 *
 * @author Luis Herrera
 */
public class ResultHelper {
    private CommandResult result;
    public ResultHelper(CommandResult result){
        this.result= result;
    }
    
    public String GetDestination(){
        String destination;
        switch (result.getResult()) {
            case "error":
                destination = "/error.jsp";
                break;
            case "listProducts":
                destination = "/catalog/listProducts.jsp";
                break;
            case "insertProduct":
                destination = "/catalog/insertProduct.jsp";
                break;
             case "listCustomers":
                destination = "/catalog/listCustomers.jsp";
                break;
            case "insertCustomer":
                destination = "/catalog/insertCustomer.jsp";
                break;
            case "listCategories":
                destination = "/catalog/listCategories.jsp";
                break;
            case "insertCategory":
                destination = "/catalog/insertCategory.jsp";
                break;
            case "home":
            default:
                destination = "/index.jsp";
        }
        return destination;
    }
}
