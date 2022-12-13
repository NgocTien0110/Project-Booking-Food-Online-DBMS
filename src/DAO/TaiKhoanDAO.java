package DAO;

import Model.TaiKhoanModel;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class TaiKhoanDAO implements DAOInterface<TaiKhoanModel>{
    public static TaiKhoanDAO getInstance() {
        return new TaiKhoanDAO();
    }
    @Override
    public ArrayList<TaiKhoanModel> selectAll() {
        ArrayList<TaiKhoanModel> ketQua = new ArrayList<TaiKhoanModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM TaiKhoan";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaTaiKhoan = rs.getString("MaTaiKhoan");
                String TenTaiKhoan = rs.getString("TenTaiKhoan");
                String HoVaTen = rs.getString("HoVaTen");
                String SoDienThoai = rs.getString("SoDienThoai");
                String DCTaiKhoan = rs.getString("DCTaiKhoan");
                String Email = rs.getString("Email");

                TaiKhoanModel taiKhoanModel = new TaiKhoanModel(MaTaiKhoan, TenTaiKhoan, HoVaTen, SoDienThoai,
                        DCTaiKhoan, Email);
                ketQua.add(taiKhoanModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public TaiKhoanModel selectById(TaiKhoanModel taiKhoanModel) {
        TaiKhoanModel ketQua = null;

        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM TaiKhoan where MaTaiKhoan=?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, taiKhoanModel.getMaTaiKhoan());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaTaiKhoan = rs.getString("MaTaiKhoan");
                String TenTaiKhoan = rs.getString("TenTaiKhoan");
                String HoVaTen = rs.getString("HoVaTen");
                String SoDienThoai = rs.getString("SoDienThoai");
                String DCTaiKhoan = rs.getString("DCTaiKhoan");
                String Email = rs.getString("Email");

                ketQua = new TaiKhoanModel(MaTaiKhoan, TenTaiKhoan, HoVaTen, SoDienThoai,
                        DCTaiKhoan, Email);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<TaiKhoanModel> selectByCondition(String condition) {
        ArrayList<TaiKhoanModel> ketQua = new ArrayList<TaiKhoanModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM TaiKhoan" + condition;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaTaiKhoan = rs.getString("MaTaiKhoan");
                String TenTaiKhoan = rs.getString("TenTaiKhoan");
                String HoVaTen = rs.getString("HoVaTen");
                String SoDienThoai = rs.getString("SoDienThoai");
                String DCTaiKhoan = rs.getString("DCTaiKhoan");
                String Email = rs.getString("Email");

                TaiKhoanModel taiKhoanModel = new TaiKhoanModel(MaTaiKhoan, TenTaiKhoan, HoVaTen, SoDienThoai,
                        DCTaiKhoan, Email);
                ketQua.add(taiKhoanModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
