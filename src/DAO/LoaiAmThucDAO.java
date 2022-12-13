package DAO;

import Model.LoaiAmThucModel;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class LoaiAmThucDAO implements DAOInterface<LoaiAmThucModel>{
    public static LoaiAmThucDAO getInstance() {
        return new LoaiAmThucDAO();
    }
    @Override
    public ArrayList<LoaiAmThucModel> selectAll() {
        ArrayList<LoaiAmThucModel> ketQua = new ArrayList<LoaiAmThucModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM LoaiAmThuc";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String TenLoaiAmThuc = rs.getString("TenLoaiAmThuc");
                String MaDoiTac = rs.getString("MaDoiTac");

                LoaiAmThucModel loaiAmThucModel = new LoaiAmThucModel(TenLoaiAmThuc, MaDoiTac);
                ketQua.add(loaiAmThucModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public LoaiAmThucModel selectById(LoaiAmThucModel loaiAmThucModel) {
        LoaiAmThucModel ketQua = null;
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM LoaiAmThuc where MaDoiTac=? and TenLoaiAmThuc=?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, loaiAmThucModel.getMaDoiTac());
            pst.setString(2, loaiAmThucModel.getTenLoaiAmThuc());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String TenLoaiAmThuc = rs.getString("TenLoaiAmThuc");
                String MaDoiTac = rs.getString("MaDoiTac");

                ketQua = new LoaiAmThucModel(TenLoaiAmThuc, MaDoiTac);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<LoaiAmThucModel> selectByCondition(String condition) {
        ArrayList<LoaiAmThucModel> ketQua = new ArrayList<LoaiAmThucModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM LoaiAmThuc" + condition;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String TenLoaiAmThuc = rs.getString("TenLoaiAmThuc");
                String MaDoiTac = rs.getString("MaDoiTac");

                LoaiAmThucModel loaiAmThucModel = new LoaiAmThucModel(TenLoaiAmThuc, MaDoiTac);
                ketQua.add(loaiAmThucModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
