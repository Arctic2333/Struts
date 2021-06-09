/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import factory.GetServiceFactory;

/**
 *
 * @author admin
 */
public class RemoveAction extends ActionSupport {

    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String execute() throws Exception {
        boolean flag = GetServiceFactory.getService().delete(isbn);
        if (flag) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
