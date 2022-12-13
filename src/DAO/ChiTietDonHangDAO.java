package DAO;

import Model.ChiNhanhModel;
import Model.ChiTietDonHangModel;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHangModel>{
    public static ChiTietDonHangDAO getInstance() {
        return new ChiTietDonHangDAO();
    }

    @Override
    public ArrayList<ChiTietDonHangModel> selectAll() {
        ArrayList<ChiTietDonHangModel> ketQua = new ArrayList<ChiTietDonHangModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM ChiTietDonHang";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaDonHang = rs.getString("MaDonHang");
                String MaChiNhanh = rs.getString("MaChiNhanh");
                String MaDoiTac = rs.getString("MaDoiTac");
                String MaMonAn = rs.getString("MaMonAn");
                int SLMon = rs.getInt("SLMon");
                String TuyChon = rs.getString("TuyChon");

                ChiTietDonHangModel chiTietDonHangModel = new ChiTietDonHangModel(MaDonHang, MaChiNhanh, MaDoiTac, MaMonAn, SLMon, TuyChon);
                ketQua.add(chiTietDonHangModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ChiTietDonHangModel selectById(ChiTietDonHangModel chiTietDonHangModel) {
        ChiTietDonHangModel ketQua = null;
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM ChiTietHopDong where MaDonHang=? and MaChiNhanh=? and MaDoiTac=? and MaMonAn=?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, chiTietDonHangModel.getMaDonHang());
            pst.setString(2, chiTietDonHangModel.getMaChiNhanh());
            pst.setString(3, chiTietDonHangModel.getMaDoiTac());
            pst.setString(4, chiTietDonHangModel.getMaMonAn());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaDonHang = rs.getString("MaDonHang");
                String MaChiNhanh = rs.getString("MaChiNhanh");
                String MaDoiTac = rs.getString("MaDoiTac");
                String MaMonAn = rs.getString("MaMonAn");
                int SLMon = rs.getInt("TinhTrangHoatDong");
                String TuyChon = rs.getString("TuyChon");

                ketQua = new ChiTietDonHangModel(MaDonHang, MaChiNhanh, MaDoiTac, MaMonAn, SLMon, TuyChon);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<ChiTietDonHangModel> selectByCondition(String condition) {
        ArrayList<ChiTietDonHangModel> ketQua = new ArrayList<ChiTietDonHangModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM ChiTietDonHang" + condition;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaDonHang = rs.getString("MaDonHang");
                String MaChiNhanh = rs.getString("MaChiNhanh");
                String MaDoiTac = rs.getString("MaDoiTac");
                String MaMonAn = rs.getString("MaMonAn");
                int SLMon = rs.getInt("TinhTrangHoatDong");
                String TuyChon = rs.getString("TuyChon");

                ChiTietDonHangModel chiTietDonHangModel = new ChiTietDonHangModel(MaDonHang, MaChiNhanh, MaDoiTac, MaMonAn, SLMon, TuyChon);
                ketQua.add(chiTietDonHangModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
