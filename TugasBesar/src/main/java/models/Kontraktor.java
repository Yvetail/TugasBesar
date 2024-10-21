package models;

import java.sql.Timestamp;

public class Kontraktor extends Pengguna {
    private String link;

    public Kontraktor(int idUser, String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String tipePengguna,String link) {
        super(idUser, nama, noHP, email, password, tanggalDaftar, "Kontraktor");
        this.link = link;
    }

    public Kontraktor(int idUser) {
        super(idUser);
    }
    
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
        
    }

    public Kontraktor() {
    }
    
    public boolean isValidKontraktor(String enteredUsername, String enteredPassword) {
    return enteredUsername.equals(email) && enteredPassword.equals(password);
    }
    
}
