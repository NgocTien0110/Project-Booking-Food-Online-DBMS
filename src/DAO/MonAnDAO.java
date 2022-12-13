package DAO;

import Model.MonAnModel;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class MonAnDAO implements DAOInterface<MonAnModel>{
    public static MonAnDAO getInstance() {
        return new MonAnDAO();
    }
    @Override
    public ArrayList<MonAnModel> selectAll() {
        ArrayList<MonAnModel> ketQua = new ArrayList<MonAnModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM MonAn";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaMonAn = rs.getString("MaMonAn");
                String TenMonAn = rs.getString("TenMonAn");
                String MieuTa = rs.getString("MieuTa");

                MonAnModel monAnModel = new MonAnModel(MaMonAn, TenMonAn, MieuTa);
                ketQua.add(monAnModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public MonAnModel selectById(MonAnModel monAnModel) {
        MonAnModel ketQua = null;
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM MonAn where MaMonAn=?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, monAnModel.getMaMonAn());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaMonAn = rs.getString("MaMonAn");
                String TenMonAn = rs.getString("TenMonAn");
                String MieuTa = rs.getString("MieuTa");

                ketQua = new MonAnModel(MaMonAn, TenMonAn, MieuTa);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<MonAnModel> selectByCondition(String condition) {
        ArrayList<MonAnModel> ketQua = new ArrayList<MonAnModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM MonAn" + condition;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaMonAn = rs.getString("MaMonAn");
                String TenMonAn = rs.getString("TenMonAn");
                String MieuTa = rs.getString("MieuTa");

                MonAnModel monAnModel = new MonAnModel(MaMonAn, TenMonAn, MieuTa);
                ketQua.add(monAnModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
