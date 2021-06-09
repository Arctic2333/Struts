/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import service.BookService;

/**
 *
 * @author admin
 */
public class GetServiceFactory {
    public static BookService getService(){
        return new BookService();
    }
    
    private GetServiceFactory(){
        throw new UnsupportedOperationException("Factory Can Not Be  New");
    }
}
