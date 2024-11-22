/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basepoomysql.repository;

import basepoomysql.pojos.Book;
import java.sql.ResultSet;

/**
 *
 * @author luk0s
 */
public class BookRepository {

    public static boolean SaveBook(Book newBook) {
        DBHandler dbh = new DBHandler();
        try {
            dbh.connect();
            dbh.executePreparedUpdate(
                "INSERT INTO libreria.books (isdn, name, bookshelf, pages) VALUES (?, ?, ?, ?)",
                newBook.getIsdn(), newBook.getName(), newBook.getBookshelf(), newBook.getPages()
            );
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public static boolean UpdateBook(Book newBook) {
        DBHandler dbh = new DBHandler();
        try {
            dbh.connect();
            dbh.executePreparedUpdate(
                "UPDATE libreria.books SET name = ?, bookshelf = ?, pages = ? WHERE isdn = ?",
                newBook.getName(), newBook.getBookshelf(), newBook.getPages(), newBook.getIsdn()
            );
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public static boolean DeleteBook(String isdn) {
        DBHandler dbh = new DBHandler();
        try {
            dbh.connect();
            dbh.executePreparedUpdate(
                "DELETE FROM libreria.books WHERE isdn = ?",
                isdn
            );
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static ResultSet GetBooks() {
        DBHandler dbh = new DBHandler();
        try {
            dbh.connect();
            return dbh.executePreparedQuery("SELECT * FROM libreria.books");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
