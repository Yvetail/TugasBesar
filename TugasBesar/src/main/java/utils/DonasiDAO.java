/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author usama
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Donasi;
import static utils.BaseDAO.conn;


public class DonasiDAO extends BaseDAO {
    public void tambahDonasi(Donasi donasi) {
        String query = "INSERT INTO revisi.donasi (nominalDonasi, waktuDonasi, idUser) VALUES (?, ?, ?)";
        try (PreparedStatement pS = conn.prepareStatement(query)) {
            pS.setInt(1, donasi.getNominalDonasi());
            pS.setTimestamp(2, donasi.getWaktuDonasi());
            pS.setInt(3, donasi.getIdUser());

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dimasukkan ke tabel donasi.");
            } else {
                System.out.println("Gagal memasukkan data ke tabel donasi.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memasukkan data ke tabel donasi: " + e.getMessage());
        }
    }
}
