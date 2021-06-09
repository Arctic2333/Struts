/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pojo.Book;

/**
 *
 * @author admin
 */
public interface BookDao {

    public List<Book> findAll() throws Exception;

    public Book findByISBN(String isbn) throws Exception;

    public boolean delete(String isbn) throws Exception;

    public boolean add(Book book) throws Exception;

    public boolean edit(Book book) throws Exception;
}
