/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basepoomysql.pojos;

/**
 *
 * @author luk0s
 */
public class Book {
    private String Isdn, Name, Bookshelf;
    private Integer Pages;

    public Book(String Isdn, String Name, String Bookshelf, Integer Pages) {
        this.Isdn = Isdn;
        this.Name = Name;
        this.Bookshelf = Bookshelf;
        this.Pages = Pages;
    }

    public String getIsdn() {
        return Isdn;
    }

    public void setIsdn(String Isdn) {
        this.Isdn = Isdn;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBookshelf() {
        return Bookshelf;
    }

    public void setBookshelf(String Bookshelf) {
        this.Bookshelf = Bookshelf;
    }

    public Integer getPages() {
        return Pages;
    }

    public void setPages(Integer Pages) {
        this.Pages = Pages;
    }

    @Override
    public String toString() {
        return "Book{" + "Isdn=" + Isdn + ", Name=" + Name + ", Bookshelf=" + Bookshelf + ", Pages=" + Pages + '}';
    }
    
    
}
