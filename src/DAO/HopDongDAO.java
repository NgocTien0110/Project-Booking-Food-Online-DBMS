package DAO;

import Model.DonHangModel;
import Model.HopDongModel;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class HopDongDAO implements DAOInterface<HopDongModel>{
    public static HopDongDAO getInstance() {
        return new HopDongDAO();
    }
    @Override
    public ArrayList<HopDongModel> selectAll() {
        ArrayList<HopDongModel> ketQua = new ArrayList<HopDongModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM HopDong";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaHopDong = rs.getString("MaHopDong");
                Date NgayKi = rs.getDate("NgayKi");
                int ThoiGianHieuLuc = rs.getInt("ThoiGianHieuLuc");
                float PhamTramHoaHong = rs.getFloat("PhamTramHoaHong");
                double PhiHoaHong = rs.getDouble("PhiHoaHong");
                String MaTaiKhoanDD = rs.getString("MaTaiKhoanDD");
                String MaDoiTac = rs.getString("MaDoiTac");
                String MaTaiKhoanNV = rs.getString("MaTaiKhoanNV");

                HopDongModel hopDongModel = new HopDongModel(MaHopDong, NgayKi, ThoiGianHieuLuc, PhamTramHoaHong, PhiHoaHong,
                        MaTaiKhoanDD, MaDoiTac, MaTaiKhoanNV);
                ketQua.add(hopDongModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public HopDongModel selectById(HopDongModel hopDongModel) {
        HopDongModel ketQua = null;
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM HopDong where MaHopDong=?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, hopDongModel.getMaHopDong());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaHopDong = rs.getString("MaHopDong");
                Date NgayKi = rs.getDate("NgayKi");
                int ThoiGianHieuLuc = rs.getInt("ThoiGianHieuLuc");
                float PhamTramHoaHong = rs.getFloat("PhamTramHoaHong");
                double PhiHoaHong = rs.getDouble("PhiHoaHong");
                String MaTaiKhoanDD = rs.getString("MaTaiKhoanDD");
                String MaDoiTac = rs.getString("MaDoiTac");
                String MaTaiKhoanNV = rs.getString("MaTaiKhoanNV");

                ketQua = new HopDongModel(MaHopDong, NgayKi, ThoiGianHieuLuc, PhamTramHoaHong, PhiHoaHong,
                        MaTaiKhoanDD, MaDoiTac, MaTaiKhoanNV);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<HopDongModel> selectByCondition(String condition) {
        ArrayList<HopDongModel> ketQua = new ArrayList<HopDongModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM HopDong" + condition;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaHopDong = rs.getString("MaHopDong");
                Date NgayKi = rs.getDate("NgayKi");
                int ThoiGianHieuLuc = rs.getInt("ThoiGianHieuLuc");
                float PhamTramHoaHong = rs.getFloat("PhamTramHoaHong");
                double PhiHoaHong = rs.getDouble("PhiHoaHong");
                String MaTaiKhoanDD = rs.getString("MaTaiKhoanDD");
                String MaDoiTac = rs.getString("MaDoiTac");
                String MaTaiKhoanNV = rs.getString("MaTaiKhoanNV");

                HopDongModel hopDongModel = new HopDongModel(MaHopDong, NgayKi, ThoiGianHieuLuc, PhamTramHoaHong, PhiHoaHong,
                        MaTaiKhoanDD, MaDoiTac, MaTaiKhoanNV);
                ketQua.add(hopDongModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
