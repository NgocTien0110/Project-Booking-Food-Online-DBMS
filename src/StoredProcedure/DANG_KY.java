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

    public int DANG_KY_KH(String TaiKhoan, String MatKhau, String DC, String email_kh) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call ESP_DangKiKhachHang(?,?,?,?,?,?)}");
            pst.setString(1, TaiKhoan);
            pst.setString(2, MatKhau);
            pst.setString(3, null);
            pst.setString(4, null);
            pst.setString(5, DC);
            pst.setString(6, email_kh);
            ResultSet rs = pst.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int DANG_KY_DT() {
        // thở hết nổi gòi. để mai làm tiếp
        return 0;
    }
}

