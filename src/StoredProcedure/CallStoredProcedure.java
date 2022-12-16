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
    public int ESP_DangNhap(String TenTaiKhoan, String MatKhau) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call ESP_DangNhap(?,?)}");
            pst.setString(1, TenTaiKhoan);
            pst.setString(2, MatKhau);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;

        } catch (SQLException e) {
            e.printStackTrace();
            return check;
        }
    }
    public int sp_TimKiemChiNhanhHD(DefaultTableModel model,String maDT,String status)
    {
        try {
            PreparedStatement pst = con.prepareStatement("{call sp_TimKiemChiNhanhHD(?,?)}");
            pst.setString(1,maDT);
            pst.setString(2,status);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaChiNhanh = rs.getString("MaChiNhanh");
                String MaDoiTac = rs.getString("MaDoiTac");
                String TenChiNhanh = rs.getString("TenChiNhanh");
                String DCChiNhanh = rs.getString("DCChiNhanh");
                String TinhTrangHoatDong = rs.getString("TinhTrangHoatDong");
                Time ThoiGianMoCua = rs.getTime("ThoiGianMoCua");
                Time ThoiGianDongCua = rs.getTime("ThoiGianDongCua");
                model.addRow(new Object[]{MaChiNhanh,TenChiNhanh,MaDoiTac, DCChiNhanh, ThoiGianMoCua, ThoiGianDongCua,TinhTrangHoatDong});

            }
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int xuly_TimKiemChiNhanhHD(DefaultTableModel model,String maDT,String status)
    {
        try {
            PreparedStatement pst = con.prepareStatement("{call xuly_TimKiemChiNhanhHD(?,?)}");
            pst.setString(1,maDT);
            pst.setString(2,status);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaChiNhanh = rs.getString("MaChiNhanh");
                String MaDoiTac = rs.getString("MaDoiTac");
                String TenChiNhanh = rs.getString("TenChiNhanh");
                String DCChiNhanh = rs.getString("DCChiNhanh");
                String TinhTrangHoatDong = rs.getString("TinhTrangHoatDong");
                Time ThoiGianMoCua = rs.getTime("ThoiGianMoCua");
                Time ThoiGianDongCua = rs.getTime("ThoiGianDongCua");
                model.addRow(new Object[]{MaChiNhanh,TenChiNhanh,MaDoiTac, DCChiNhanh, ThoiGianMoCua, ThoiGianDongCua,TinhTrangHoatDong});

            }
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int ESP_XemDanhSachChiNhanhUser(DefaultTableModel model,String maDT)
    {
        try {
            PreparedStatement pst = con.prepareStatement("select * from ChiNhanh where MaDoiTac ='"+maDT+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaChiNhanh=rs.getString("MaChiNhanh");

                String MaDoiTac = rs.getString("MaDoiTac");
                String TenChiNhanh = rs.getString("TenChiNhanh");
                String DCChiNhanh = rs.getString("DCChiNhanh");
                String TinhTrangHoatDong = rs.getString("TinhTrangHoatDong");
                Time ThoiGianMoCua = rs.getTime("ThoiGianMoCua");
                Time ThoiGianDongCua = rs.getTime("ThoiGianDongCua");
                model.addRow(new Object[]{MaChiNhanh,TenChiNhanh,MaDoiTac, DCChiNhanh, ThoiGianMoCua, ThoiGianDongCua,TinhTrangHoatDong});

            }
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int ESP_XemDanhSachChiNhanhAdmin(DefaultTableModel model,String maDT)
    {
        try {
            PreparedStatement pst = con.prepareStatement("select * from ChiNhanh where MaDoiTac ='"+maDT+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaChiNhanh = rs.getString("MaChiNhanh");
                String MaDoiTac = rs.getString("MaDoiTac");
                String TenChiNhanh = rs.getString("TenChiNhanh");
                String DCChiNhanh = rs.getString("DCChiNhanh");
                String TinhTrangHoatDong = rs.getString("TinhTrangHoatDong");
                Time ThoiGianMoCua = rs.getTime("ThoiGianMoCua");
                double DoanhThuThang = rs.getDouble("DoanhThuThang");
                Time ThoiGianDongCua = rs.getTime("ThoiGianDongCua");
                String TenNganHang = rs.getString("TenNganHang");
                String SoTaiKhoan = rs.getString("SoTaiKhoan");
                model.addRow(new Object[]{MaChiNhanh,MaDoiTac, TenChiNhanh, DCChiNhanh, ThoiGianMoCua, ThoiGianDongCua,TinhTrangHoatDong,TenNganHang,SoTaiKhoan,DoanhThuThang});
            }
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int sp_CapNhatTinhTrangCN(String maDT,String maCN,String status)
    {
        try {
            PreparedStatement pst = con.prepareStatement("{call sp_CapNhatTinhTrangCN(?,?,?)}");
            pst.setString(1,maDT);
            pst.setString(2,maCN);
            pst.setString(3,status);
            pst.executeUpdate();
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}


