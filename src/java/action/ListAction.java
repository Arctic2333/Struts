/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import factory.GetServiceFactory;
import java.util.ArrayList;
import java.util.List;
import pojo.Book;

/**
 *
 * @author admin
 */
public class ListAction {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public String execute() throws Exception{
        books = GetServiceFactory.getService().findAll();
        return "success";
    }
}
