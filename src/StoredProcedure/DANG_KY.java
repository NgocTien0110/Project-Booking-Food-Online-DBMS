package StoredProcedure;
import java.sql.*;

/**
 * StoredProcedure
 * Create by Đặng Ngọc Tiến
 * Date 12/15/2022 - 1:59 PM
 * Description: ...
 */
public class DANG_KY {
    private Connection con;

    public DANG_KY() {
        con = database.JDBCUtil.getConnection();
    }

    public int DANG_KY_KH(String TaiKhoan, String MatKhau,String HoVaTen, String SDT,String DC, String email_kh) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call ESP_DangKiKhachHang(?,?,?,?,?,?)}");
            pst.setString(1, TaiKhoan);
            pst.setString(2, MatKhau);
            pst.setString(3, HoVaTen);
            pst.setString(4, SDT);
            pst.setString(5, DC);
            pst.setString(6, email_kh);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int DANG_KY_TX(String TaiKhoan, String MatKhau,String HoVaTen, String SDT,String DC, String email_kh) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call ESP_DangKiTaiXe(?,?,?,?,?,?)}");
            pst.setString(1, TaiKhoan);
            pst.setString(2, MatKhau);
            pst.setString(3, HoVaTen);
            pst.setString(4, SDT);
            pst.setString(5, DC);
            pst.setString(6, email_kh);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int DANG_KY_DT(String TaiKhoan, String MatKhau,String HoVaTen, String SDT,String DC, String email_kh) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call ESP_DangKiDoiTac(?,?,?,?,?,?)}");
            pst.setString(1, TaiKhoan);
            pst.setString(2, MatKhau);
            pst.setString(3, HoVaTen);
            pst.setString(4, SDT);
            pst.setString(5, DC);
            pst.setString(6, email_kh);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

