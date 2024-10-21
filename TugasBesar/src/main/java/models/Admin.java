package models;

import java.sql.Timestamp;

public class Admin extends Pengguna {
    private String username = "a";
    private String password = "a";

    public Admin() {
    }
    
    public Admin(int idUSer,String tipePengguna){
    }

    public boolean isValidAdmin(String enteredUsername, String enteredPassword) {
    return enteredUsername.equals(username) && enteredPassword.equals(password);
    }

    public Admin(int idUser, String nama, String noHP, String email, String password, Timestamp tanggalDaftar, String tipePengguna) {
        super(idUser, nama, noHP, email, password, tanggalDaftar, tipePengguna);
    }
 
    
}
