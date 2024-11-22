/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basepoomysql.services;

import basepoomysql.pojos.Book;
import basepoomysql.repository.BookRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luk0s
 */
public class BookService {

    public static String AddBook(String isdn, String name, String bookShelf, String pages) {
        // VALIDACIONES
        // 1) No pueden existir campos vacíos
        if (isdn.isBlank() || name.isBlank() || bookShelf.isBlank() || pages.isBlank()) {
            return "Todos los campos son requeridos";
        } else {
            // 2) pages debe ser numérico
            try {
                Integer numPages = Integer.valueOf(pages);
                // ENVÍO DE DATOS A REPOSITORIO
                Boolean status = BookRepository.SaveBook(new Book(isdn, name, bookShelf, numPages));
                if (status) {
                    return "ok";
                }
            } catch (NumberFormatException ex) {
                return "El campo 'Páginas' debe ser numérico";
            }
        }
        return "Algo salió mal. Revise log de errores";
    }
    
    public static String UpdateBook(String isdn, String name, String bookShelf, String pages) {
        // VALIDACIONES
        // 1) No pueden existir campos vacíos
        if (isdn.isBlank() || name.isBlank() || bookShelf.isBlank() || pages.isBlank()) {
            return "Todos los campos son requeridos";
        } else {
            // 2) pages debe ser numérico
            try {
                Integer numPages = Integer.valueOf(pages);
                // ENVÍO DE DATOS A REPOSITORIO
                Boolean status = BookRepository.UpdateBook(new Book(isdn, name, bookShelf, numPages));
                if (status) {
                    return "ok";
                }
            } catch (NumberFormatException ex) {
                return "El campo 'Páginas' debe ser numérico";
            }
        }
        return "Algo salió mal. Revise log de errores";
    }
    
    public static String DeleteBook(String isdn) {
        // VALIDACIONES
        // 1) ISDN debe tener algo
        if (isdn.isBlank()) {
            return "Debe ingresar un Identificador";
        } else {
            Boolean status = BookRepository.DeleteBook(isdn);
            if (status) {
                return "ok";
            }
        }
        return "Algo salió mal. Revise log de errores";
    }

    public static ArrayList<Book> GetBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            ResultSet data = BookRepository.GetBooks();
            if (data != null) {
                while (data.next()) {
                    books.add(
                        new Book(
                            data.getString("isdn"),
                            data.getString("name"),
                            data.getString("bookshelf"),
                            data.getInt("pages")
                        )
                    );
                }
                return books;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
