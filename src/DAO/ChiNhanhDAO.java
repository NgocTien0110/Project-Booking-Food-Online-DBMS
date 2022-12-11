package DAO;

import Model.ChiNhanhModel;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class ChiNhanhDAO implements DAOInterface<ChiNhanhModel>{

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

            while(rs.next()) {
                String MaChiNhanh = rs.getString("MaChiNhanh");
                String MaDoiTac = rs.getString("MaDoiTac");
                String TenChiNhanh = rs.getString("TenChiNhanh");
                String DCChiNhanh = rs.getString("DCChiNhanh");
                String TinhTrangHoatDong = rs.getString("TinhTrangHoatDong");
                Time ThoiGianMoCua = rs.getTime("ThoiGianMoCua");
                String DoanhThuThang = rs.getString("DoanhThuThang");
                Time ThoiGianDongCua = rs.getTime("ThoiGianDongCua");
                String TenNganHang = rs.getString("TenNganHang");
                String SoTaiKhoan = rs.getString("SoTaiKhoan");

            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int selectById(ChiNhanhModel chiNhanhModel) {
        return 0;
    }

    @Override
    public ArrayList<ChiNhanhModel> selectByCondition(String condition) {
        return null;
    }
}
