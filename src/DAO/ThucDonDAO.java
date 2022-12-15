package DAO;

import Model.ThucDonModel;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ThucDonDAO implements DAOInterface<ThucDonModel>{
    public static ThucDonDAO getInstance() {
        return new ThucDonDAO();
    }
    @Override
    public ArrayList<ThucDonModel> selectAll() {
        ArrayList<ThucDonModel> ketQua = new ArrayList<ThucDonModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM ThucDon";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaChiNhanh = rs.getString("MaChiNhanh");
                String MaDoiTac = rs.getString("MaDoiTac");
                String MaMonAn = rs.getString("MaMonAn");
                String TinhTrangMonAn = rs.getString("TinhTrangMonAn");
                float Gia = rs.getFloat("Gia");
                int SLMonAn = rs.getInt("SLMonAn");
                float TrungBinhSLSao = rs.getFloat("TrungBinhSLSao");
                int TongSLLike = rs.getInt("TongSLLike");
                int TongSLDislike = rs.getInt("TongSLDislike");

                ThucDonModel thucDonModel = new ThucDonModel(MaChiNhanh, MaDoiTac, MaMonAn, TinhTrangMonAn, Gia,
                        SLMonAn, TrungBinhSLSao, TongSLLike, TongSLDislike);
                ketQua.add(thucDonModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ThucDonModel selectById(ThucDonModel thucDonModel) {
        ThucDonModel ketQua = null;
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            String sql = "SELECT * FROM ThucDon where MaChiNhanh=? and MaDoiTac=? and MaMonAn=?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, thucDonModel.getMaChiNhanh());
            pst.setString(2, thucDonModel.getMaDoiTac());
            pst.setString(3, thucDonModel.getMaMonAn());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String MaChiNhanh = rs.getString("MaChiNhanh");
                String MaDoiTac = rs.getString("MaDoiTac");
                String MaMonAn = rs.getString("MaMonAn");
                String TinhTrangMonAn = rs.getString("TinhTrangMonAn");
                float Gia = rs.getFloat("Gia");
                int SLMonAn = rs.getInt("SLMonAn");
                float TrungBinhSLSao = rs.getFloat("TrungBinhSLSao");
                int TongSLLike = rs.getInt("TongSLLike");
                int TongSLDislike = rs.getInt("TongSLDislike");

                ketQua = new ThucDonModel(MaChiNhanh, MaDoiTac, MaMonAn, TinhTrangMonAn, Gia,
                        SLMonAn, TrungBinhSLSao, TongSLLike, TongSLDislike);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public ArrayList<ThucDonModel> selectByCondition(String condition) {
        ArrayList<ThucDonModel> ketQua = new ArrayList<ThucDonModel>();
        try {
            //Bước 1: Tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            //Bước 2: Tạo ra đối tượng statement
            Statement st = con.createStatement();

            //Bước 3: Thực thi câu lệnh SQL
            String sql = "SELECT * FROM ThucDon" + condition;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String MaChiNhanh = rs.getString("MaChiNhanh");
                String MaDoiTac = rs.getString("MaDoiTac");
                String MaMonAn = rs.getString("MaMonAn");
                String TinhTrangMonAn = rs.getString("TinhTrangMonAn");
                float Gia = rs.getFloat("Gia");
                int SLMonAn = rs.getInt("SLMonAn");
                float TrungBinhSLSao = rs.getFloat("TrungBinhSLSao");
                int TongSLLike = rs.getInt("TongSLLike");
                int TongSLDislike = rs.getInt("TongSLDislike");

                ThucDonModel thucDonModel = new ThucDonModel(MaChiNhanh, MaDoiTac, MaMonAn, TinhTrangMonAn, Gia,
                        SLMonAn, TrungBinhSLSao, TongSLLike, TongSLDislike);
                ketQua.add(thucDonModel);
            }

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ketQua;
    }
}
