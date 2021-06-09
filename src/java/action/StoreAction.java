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
public class StoreAction extends ActionSupport {

    private Book book = new Book();

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String execute() throws Exception {
        if (GetServiceFactory.getService().findByISBN(book.getIsbn()) != null) {
            GetServiceFactory.getService().edit(book);
        } else {
            GetServiceFactory.getService().add(book);
        }
        return SUCCESS;
    }

    @Override
    public void validate() {
       if(getBook().getTitle().length() == 0 || getBook().getTitle() == null){
           addFieldError("Title", "Title Can not Empty!");
       }
        if(getBook().getIsbn().length() == 0 || getBook().getIsbn() == null){
           addFieldError("Isbn", "Isbn Can not Empty!");
       }
        if(String.valueOf(getBook().getPrice())==null){
            addFieldError("Price", "Price Can not Empty!");
        }
    } 
}
