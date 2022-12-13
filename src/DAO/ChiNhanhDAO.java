package DAO;

import Model.ChiNhanhModel;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

public class ChiNhanhDAO implements DAOInterface<ChiNhanhModel> {
    public static ChiNhanhDAO getInstance() {
        return new ChiNhanhDAO();
    }

    @Override
    public ArrayList<ChiNhanhModel> selectAll() {
        ArrayList<ChiNhanhModel> ketQua = new ArrayList<ChiNhanhModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM ChiNhanh";
            ResultSet rs = st.executeQuery(sql);

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

                ChiNhanhModel chiNhanhModel = new ChiNhanhModel(MaChiNhanh, MaDoiTac, TenChiNhanh, DCChiNhanh,
                        TinhTrangHoatDong, ThoiGianMoCua, DoanhThuThang, ThoiGianDongCua, TenNganHang, SoTaiKhoan);
                ketQua.add(chiNhanhModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ChiNhanhModel selectById(ChiNhanhModel chiNhanhModel) {
        ChiNhanhModel ketQua = null;
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            String sql = "SELECT * FROM ChiNhanh where MaChiNhanh=? and MaDoiTac=?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, chiNhanhModel.getMaChiNhanh());
            pst.setString(2, chiNhanhModel.getMaDoiTac());

            //Bước 3: Thực thi câu lệnh SQL
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

                ketQua = new ChiNhanhModel(MaChiNhanh, MaDoiTac, TenChiNhanh, DCChiNhanh,
                        TinhTrangHoatDong, ThoiGianMoCua, DoanhThuThang, ThoiGianDongCua, TenNganHang, SoTaiKhoan);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<ChiNhanhModel> selectByCondition(String condition){
        ArrayList<ChiNhanhModel> ketQua = new ArrayList<ChiNhanhModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM ChiNhanh where " + condition;
            ResultSet rs = st.executeQuery(sql);

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

                ChiNhanhModel chiNhanhModel = new ChiNhanhModel(MaChiNhanh, MaDoiTac, TenChiNhanh, DCChiNhanh,
                        TinhTrangHoatDong, ThoiGianMoCua, DoanhThuThang, ThoiGianDongCua, TenNganHang, SoTaiKhoan);
                ketQua.add(chiNhanhModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
