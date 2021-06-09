/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import factory.GetServiceFactory;
import pojo.Book;

/**
 *
 * @author admin
 */
public class LoadAction extends ActionSupport {

    private Book book = new Book();
    private String isbn;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String execute() throws Exception {
        book = GetServiceFactory.getService().findByISBN(isbn);
        return SUCCESS;
    }
    
}
