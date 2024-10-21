package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import models.Kontraktor;
import static utils.BaseDAO.conn;

public class KontraktorDAO extends BaseDAO {
    
    public List<Kontraktor> getSemuaKontraktor(){
        List<Kontraktor> kontraktors = new ArrayList<>();
        String query = "SELECT * FROM revisi.pengguna WHERE tipePengguna='Kontraktor'";
        try (PreparedStatement pS = conn.prepareStatement(query);
             ResultSet resultSet = pS.executeQuery()) {
             
            while(resultSet.next()){
                int idUser = resultSet.getInt("idUser");
                String nama = resultSet.getString("nama");
                String noHP = resultSet.getString("noHP");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Timestamp tanggalDaftar = resultSet.getTimestamp("tanggalDaftar");
                String link = resultSet.getString("link");
                Kontraktor kontraktor = new Kontraktor(idUser, nama, noHP, email, password, tanggalDaftar, "Kontraktor",link);
                kontraktors.add(kontraktor);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal mengambil data kontraktor: " + e.getMessage());
        }
        return kontraktors;
    }
    
    public List<Kontraktor> getidUserKontraktor(){
        List<Kontraktor> idKontraktor = new ArrayList<>();
        String query = "SELECT * FROM revisi.pengguna WHERE tipePengguna='Pembeli'";
        try (PreparedStatement pS = conn.prepareStatement(query);
             ResultSet resultSet = pS.executeQuery()) {
             
            while(resultSet.next()){
                int idUser = resultSet.getInt("idUser");
                Kontraktor idK = new Kontraktor(idUser);
                idKontraktor.add(idK);
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal mengambil data pembeli: " + e.getMessage());
        }
        return null;
    }
 
    public void tambahKontraktor(Kontraktor kontraktor) {
        String query = "INSERT INTO revisi.pengguna (nama, noHP, email, password, tipePengguna) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pS = conn.prepareStatement(query)) {
            pS.setString(1, kontraktor.getNama());
            pS.setString(2, kontraktor.getNoHP());
            pS.setString(3, kontraktor.getEmail());
            pS.setString(4, kontraktor.getPassword());
            //pS.setTimestamp(5, kontraktor.getTanggalDaftar());
            //pS.setString(6, kontraktor.getLink());
            pS.setString(5, "Kontraktor");

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dimasukkan ke tabel kontraktor.");
            } else {
                System.out.println("Gagal memasukkan data ke tabel kontraktor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memasukkan data ke tabel kontraktor: " + e.getMessage());
        }
    }

    public void updateKontraktor(Kontraktor kontraktor) {
        String query = "UPDATE revisi.kontraktor SET nama=?, noHP=?, email=?, password=?, tanggalDaftar=?, link=?, tipePengguna=? WHERE idUser=?";
        try (PreparedStatement pS = conn.prepareStatement(query)) {
            pS.setString(1, kontraktor.getNama());
            pS.setString(2, kontraktor.getNoHP());
            pS.setString(3, kontraktor.getEmail());
            pS.setString(4, kontraktor.getPassword());
            pS.setTimestamp(5, kontraktor.getTanggalDaftar());
            pS.setString(6, kontraktor.getLink());
            pS.setString(7, kontraktor.getTipePengguna());
            pS.setInt(8, kontraktor.getIdUser());

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data kontraktor berhasil diperbarui.");
            } else {
                System.out.println("Gagal memperbarui data kontraktor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memperbarui data kontraktor: " + e.getMessage());
        }
    }
    
    public void hapusKontraktor(int idUser) {
        String query = "DELETE FROM revisi.kontraktor WHERE idUser = ?";
        try (PreparedStatement pS = conn.prepareStatement(query)) {
            pS.setInt(1, idUser);

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dihapus dari tabel kontraktor.");
            } else {
                System.out.println("Gagal menghapus data dari tabel kontraktor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal menghapus data dari tabel kontraktor: " + e.getMessage());
        }
    }
    
    
}
