package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import models.Pembeli;
import static utils.BaseDAO.conn;

public class PembeliDAO extends BaseDAO{
    
    public List<Pembeli> getSemuaPembeli(){
        List<Pembeli> pembelis = new ArrayList<>();
        String query = "SELECT * FROM revisi.pengguna WHERE tipePengguna='Pembeli'";
        try (PreparedStatement pS = conn.prepareStatement(query);
             ResultSet resultSet = pS.executeQuery()) {
             
            while(resultSet.next()){
                int idUser = resultSet.getInt("idUser");
                String nama = resultSet.getString("nama");
                String noHP = resultSet.getString("noHP");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Timestamp tanggalDaftar = resultSet.getTimestamp("tanggalDaftar");
                int jumlahTerbeli = resultSet.getInt("jumlahTerbeli");
                int favorit = resultSet.getInt("favorit");
                Pembeli pembeli = new Pembeli(idUser, nama, noHP, email, password, tanggalDaftar, "Pembeli", jumlahTerbeli, favorit);
                pembelis.add(pembeli);
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal mengambil data pembeli: " + e.getMessage());
        }
        return null;
    }
    
    public List<Pembeli> getidUserPembeli(){
        List<Pembeli> idPembeli = new ArrayList<>();
        String query = "SELECT * FROM revisi.pengguna WHERE tipePengguna='Pembeli'";
        try (PreparedStatement pS = conn.prepareStatement(query);
             ResultSet resultSet = pS.executeQuery()) {
             
            while(resultSet.next()){
                int idUser = resultSet.getInt("idUser");
                Pembeli idP = new Pembeli(idUser);
                idPembeli.add(idP);
            }
            
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal mengambil data pembeli: " + e.getMessage());
        }
        return null;
    }
 
    public void tambahPembeli(Pembeli pembeli) {
        String query = "INSERT INTO revisi.pengguna (nama, noHP, email, password, jumlahTerbeli, favorit, tipePengguna) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pS = conn.prepareStatement(query)) {
            pS.setString(1, pembeli.getNama());
            pS.setString(2, pembeli.getNoHP());
            pS.setString(3, pembeli.getEmail());
            pS.setString(4, pembeli.getPassword());
            //pS.setTimestamp(5, pembeli.getTanggalDaftar());
            pS.setInt(5, 0);
            pS.setInt(6, 0);
            pS.setString(7, "Pembeli");

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dimasukkan ke tabel pembeli.");
            } else {
                System.out.println("Gagal memasukkan data ke tabel pembeli.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memasukkan data ke tabel pembeli: " + e.getMessage());
        }
        
    }
    
    
    public Pembeli infoAkun(int idAkun) throws SQLException {
        Pembeli akun = null;
        String query = "Select * FROM pengguna WHERE idUser='%d'";
        query = String.format(query, idAkun);
        st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        if (rs.next()) {
            akun = new Pembeli(
                    rs.getInt("idUSer"),
                    rs.getString("nama"),
                    rs.getString("noHP"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getTimestamp("tanggalDaftar"),
                    rs.getString("tipePengguna")){};
        } else {
            System.out.println("Data tidak ditemukan");
        }
        return akun;
    }

    public void updatePembeli(Pembeli pembeli) {
        String query = "UPDATE revisi.pengguna SET nama=?, noHP=?, email=?, password=? WHERE idUser=?";
        try (PreparedStatement pS = conn.prepareStatement(query)) {
            pS.setString(1, pembeli.getNama());
            pS.setString(2, pembeli.getNoHP());
            pS.setString(3, pembeli.getEmail());
            pS.setString(4, pembeli.getPassword());
            //pS.setTimestamp(5, pembeli.getTanggalDaftar());
//            pS.setInt(6, pembeli.getJumlahTerbeli());
//            pS.setInt(7, pembeli.getFavorit());
            pS.setInt(5, pembeli.getIdUser());

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data pembeli berhasil diperbarui.");
            } else {
                System.out.println("Gagal memperbarui data pembeli.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal memperbarui data pembeli: " + e.getMessage());
        }
    }
    
    public void hapusPembeli(int idUser) {
        String query = "DELETE FROM revisi.pembeli WHERE idUser = ?";
        try (PreparedStatement pS = conn.prepareStatement(query)) {
            pS.setInt(1, idUser);

            int rowsAffected = pS.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil dihapus dari tabel pembeli.");
            } else {
                System.out.println("Gagal menghapus data dari tabel pembeli.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Gagal menghapus data dari tabel pembeli: " + e.getMessage());
        }
    }
    
}
