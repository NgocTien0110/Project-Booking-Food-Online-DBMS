package DAO;

import Model.DonHangModel;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DonHangDAO implements DAOInterface<DonHangModel>{
    public static DonHangDAO getInstance() {
        return new DonHangDAO();
    }
    @Override
    public ArrayList<DonHangModel> selectAll() {
        ArrayList<DonHangModel> ketQua = new ArrayList<DonHangModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM DonHang";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaDonHang = rs.getString("MaDonHang");
                String TinhTrangDonHang = rs.getString("TinhTrangDonHang");
                double PhiDonHang = rs.getDouble("PhiDonHang");
                String HinhThucThanhToan = rs.getString("HinhThucThanhToan");
                String DCGiaoHang = rs.getString("DCGiaoHang");
                float PhiVanChuyen = rs.getFloat("PhiVanChuyen");
                Date NgayTaoDon = rs.getDate("NgayTaoDon");
                String MaTaiKhoanTX = rs.getString("MaTaiKhoanTX");
                String MaTaiKhoanKH = rs.getString("MaTaiKhoanKH");
                String MaKhuVuc = rs.getString("MaKhuVuc");

                DonHangModel donHangModel = new DonHangModel(MaDonHang, TinhTrangDonHang, PhiDonHang, HinhThucThanhToan, DCGiaoHang,
                        PhiVanChuyen, NgayTaoDon, MaTaiKhoanTX, MaTaiKhoanKH,MaKhuVuc);
                ketQua.add(donHangModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public DonHangModel selectById(DonHangModel donHangModel) {
        DonHangModel ketQua = null;
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM DonHang where MaDonHang=?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, donHangModel.getMaDonHang());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaDonHang = rs.getString("MaDonHang");
                String TinhTrangDonHang = rs.getString("TinhTrangDonHang");
                double PhiDonHang = rs.getDouble("PhiDonHang");
                String HinhThucThanhToan = rs.getString("HinhThucThanhToan");
                String DCGiaoHang = rs.getString("DCGiaoHang");
                float PhiVanChuyen = rs.getFloat("PhiVanChuyen");
                Date NgayTaoDon = rs.getDate("NgayTaoDon");
                String MaTaiKhoanTX = rs.getString("MaTaiKhoanTX");
                String MaTaiKhoanKH = rs.getString("MaTaiKhoanKH");
                String MaKhuVuc = rs.getString("MaKhuVuc");

                ketQua = new DonHangModel(MaDonHang, TinhTrangDonHang, PhiDonHang, HinhThucThanhToan, DCGiaoHang,
                        PhiVanChuyen, NgayTaoDon, MaTaiKhoanTX, MaTaiKhoanKH,MaKhuVuc);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<DonHangModel> selectByCondition(String condition) {
        ArrayList<DonHangModel> ketQua = new ArrayList<DonHangModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM DonHang" + condition;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaDonHang = rs.getString("MaDonHang");
                String TinhTrangDonHang = rs.getString("TinhTrangDonHang");
                double PhiDonHang = rs.getDouble("PhiDonHang");
                String HinhThucThanhToan = rs.getString("HinhThucThanhToan");
                String DCGiaoHang = rs.getString("DCGiaoHang");
                float PhiVanChuyen = rs.getFloat("PhiVanChuyen");
                Date NgayTaoDon = rs.getDate("NgayTaoDon");
                String MaTaiKhoanTX = rs.getString("MaTaiKhoanTX");
                String MaTaiKhoanKH = rs.getString("MaTaiKhoanKH");
                String MaKhuVuc = rs.getString("MaKhuVuc");

                DonHangModel donHangModel = new DonHangModel(MaDonHang, TinhTrangDonHang, PhiDonHang, HinhThucThanhToan, DCGiaoHang,
                        PhiVanChuyen, NgayTaoDon, MaTaiKhoanTX, MaTaiKhoanKH,MaKhuVuc);
                ketQua.add(donHangModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
