/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basepoomysql.repository;

import basepoomysql.pojos.Book;

/**
 *
 * @author luk0s
 */
public class BookRepository {
    public static boolean SaveBook(Book newBook) {
        DBHandler dbh = new DBHandler();
        try {
            dbh.connect();
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
