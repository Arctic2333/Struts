/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BookDao;
import dao.BookDaoImpl;
import db.DBConnection;
import java.util.List;
import pojo.Book;

/**
 *
 * @author admin
 */
public class BookService implements BookDao {

    DBConnection dbc = null;
    BookDao dao = null;

    public BookService() {
        dbc = new DBConnection();
        dao = new BookDaoImpl(dbc.getConn());
    }

    @Override
    public List<Book> findAll() throws Exception {
        List<Book> books = null;
        try {

            books = dao.findAll();
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close();
        }
        return books;
    }

    @Override
    public Book findByISBN(String isbn) throws Exception {
        Book book = null;
        try {
            book = dao.findByISBN(isbn);
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close();
        }
        return book;
    }

    @Override
    public boolean delete(String isbn) throws Exception {
        boolean flag = false;
        try {
            if (dao.findByISBN(isbn) != null) {
                flag = dao.delete(isbn);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close();
        }
        return flag;
    }

    @Override
    public boolean add(Book book) throws Exception {
        boolean flag = false;
        try {
            if (dao.findByISBN(book.getIsbn()) == null) {
                flag = dao.add(book);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close();
        }
        return flag;
    }

    @Override
    public boolean edit(Book book) throws Exception {
        boolean flag = false;
        try {
            if (dao.findByISBN(book.getIsbn()) != null) {
                flag = dao.edit(book);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            dbc.close();
        }
        return flag;
    }

}
