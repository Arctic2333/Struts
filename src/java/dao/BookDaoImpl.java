/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pojo.Book;

/**
 *
 * @author admin
 */
public class BookDaoImpl implements BookDao {

    private Connection conn = null;
    private PreparedStatement pstms = null;

    public BookDaoImpl(Connection connection) {
        this.conn = connection;
    }

    @Override
    public List<Book> findAll() throws Exception {
        List<Book> books = new ArrayList<>();

        String sql = "select * from book";
        pstms = conn.prepareStatement(sql);
        ResultSet rs = pstms.executeQuery();
        Book book = null;
        while (rs.next()) {
            book = new Book();
            book.setIsbn(rs.getString(1));
            book.setTitle(rs.getString(2));
            book.setPrice(rs.getDouble(3));
            books.add(book);
        }
        pstms.close();
        return books;
    }

    @Override
    public Book findByISBN(String isbn) throws Exception {
        Book book = null;
        String sql = "select * from book where isbn = ?";

        pstms = conn.prepareStatement(sql);
        pstms.setString(1, isbn);
        ResultSet rs = pstms.executeQuery();
        if (rs.next()) {
            book = new Book();
            book.setIsbn(rs.getString(1));
            book.setTitle(rs.getString(2));
            book.setPrice(rs.getDouble(3));
        }

        pstms.close();
        return book;
    }

    @Override
    public boolean delete(String isbn) throws Exception {
        boolean flag = false;
        String sql = "delete from book where isbn = ?";

        pstms = conn.prepareStatement(sql);
        pstms.setString(1, isbn);
        if (pstms.executeUpdate() > 0) {
            flag = true;

            pstms.close();
        }
        return flag;
    }

    @Override
    public boolean add(Book book) throws Exception {
        boolean flag = false;
        String sql = "insert into book (isbn,title,price)values(?,?,?)";

        pstms = conn.prepareStatement(sql);
        pstms.setString(1, book.getIsbn());
        pstms.setString(2, book.getTitle());
        pstms.setDouble(3, book.getPrice());
        if (pstms.executeUpdate() > 0) {
            flag = true;
        }

        pstms.close();

        return flag;
    }

    @Override
    public boolean edit(Book book) throws Exception {
        boolean flag = false;
        String sql = "update book set title=?,price=? where isbn = ?";

        pstms = conn.prepareStatement(sql);
        pstms.setString(3, book.getIsbn());
        pstms.setString(1, book.getTitle());
        pstms.setDouble(2, book.getPrice());
        if (pstms.executeUpdate() > 0) {
            flag = true;
        }

        pstms.close();

        return flag;
    }

}
