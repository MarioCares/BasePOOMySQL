/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basepoomysql.pojos;

/**
 *
 * @author luk0s
 */
public class User {
    private Integer Run;
    private String Name, Email;

    public User(Integer Run, String Name, String Email) {
        this.Run = Run;
        this.Name = Name;
        this.Email = Email;
    }

    public Integer getRun() {
        return Run;
    }

    public void setRun(Integer Run) {
        this.Run = Run;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "User{" + "Run=" + Run + ", Name=" + Name + ", Email=" + Email + '}';
    }
    
    
}
