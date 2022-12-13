package DAO;

import Model.DoiTacModel;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

public class DoiTacDAO implements DAOInterface<DoiTacModel>{
    public static DoiTacDAO getInstance() {
        return new DoiTacDAO();
    }

    @Override
    public ArrayList<DoiTacModel> selectAll() {
        ArrayList<DoiTacModel> ketQua = new ArrayList<DoiTacModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM DoiTac";
            ResultSet rs = st.executeQuery(sql);

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

                DoiTacModel doiTacModel = new DoiTacModel(MaDoiTac, TenDoiTac, SLChiNhanh, DCDoiTac, SLDonMoiNgay,
                        MaSoThue, EmailDT, SoDienThoaiDT, DoanhThuThang);
                ketQua.add(doiTacModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public DoiTacModel selectById(DoiTacModel doiTacModel) {
        DoiTacModel ketQua = null;
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM DoiTac where MaDoiTac=?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, doiTacModel.getMaDoiTac());
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

                ketQua = new DoiTacModel(MaDoiTac, TenDoiTac, SLChiNhanh, DCDoiTac, SLDonMoiNgay,
                        MaSoThue, EmailDT, SoDienThoaiDT, DoanhThuThang);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<DoiTacModel> selectByCondition(String condition) {
        ArrayList<DoiTacModel> ketQua = new ArrayList<DoiTacModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM DoiTac" + condition;
            ResultSet rs = st.executeQuery(sql);

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

                DoiTacModel doiTacModel = new DoiTacModel(MaDoiTac, TenDoiTac, SLChiNhanh, DCDoiTac, SLDonMoiNgay,
                        MaSoThue, EmailDT, SoDienThoaiDT, DoanhThuThang);
                ketQua.add(doiTacModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
