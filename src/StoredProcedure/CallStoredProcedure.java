package StoredProcedure;

import database.JDBCUtil;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class CallStoredProcedure {
    private Connection con;

    public CallStoredProcedure() {
        con = database.JDBCUtil.getConnection();
    }

    public int ESP_XemDanhSachDoiTacUser(DefaultTableModel model) {
        try {
            PreparedStatement pst = con.prepareStatement("{call ESP_XemDanhSachDoiTac()}");
            ResultSet rs = pst.executeQuery();
            boolean check = false;
            while (rs.next()) {
                String MaDoiTac = rs.getString("MaDoiTac");
                String TenDoiTac = rs.getString("TenDoiTac");
                int SLChiNhanh = rs.getInt("SLChiNhanh");
                String DCDoiTac = rs.getString("DCDoiTac");
                String EmailDT = rs.getString("EmailDT");
                String SoDienThoaiDT = rs.getString("SoDienThoaiDT");
                model.addRow(new Object[]{MaDoiTac, TenDoiTac, SLChiNhanh, EmailDT, SoDienThoaiDT, DCDoiTac});
            }
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public int ESP_XemDanhSachDoiTacAdmin(DefaultTableModel model) {
        try {
            PreparedStatement pst = con.prepareStatement("{call ESP_XemDanhSachDoiTac()}");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaDoiTac = rs.getString("MaDoiTac");
                String TenDoiTac = rs.getString("TenDoiTac");
                int SLChiNhanh = rs.getInt("SLChiNhanh");
                String DCDoiTac = rs.getString("DCDoiTac");
                int SLDonMoiNgay = rs.getInt("SLDonMoiNgay");
                String MaSoThue = rs.getString("MaSoThue");
                String EmailDT = rs.getString("EmailDT");
                String SoDienThoaiDT = rs.getString("SoDienThoaiDT");
                double DoanhThuThang = rs.getDouble("DoanhThuThang");
                model.addRow(new Object[]{MaDoiTac, TenDoiTac, SLChiNhanh, SLDonMoiNgay, MaSoThue, EmailDT, SoDienThoaiDT, DCDoiTac, DoanhThuThang});
            }
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

