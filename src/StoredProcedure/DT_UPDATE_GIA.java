package StoredProcedure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * StoredProcedure
 * Create by Đặng Ngọc Tiến
 * Date 12/15/2022 - 10:48 AM
 * Description: ...
 */
public class DT_UPDATE_GIA {
    private Connection con;

    public DT_UPDATE_GIA() {
        con = database.JDBCUtil.getConnection();
    }

    public int DT_UPDATE_GIA(String maDoiTac, String maMonAn, String gia) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call DT_UPDATE_GIA(?,?,?)}");
            pst.setString(1, maDoiTac);
            pst.setString(2, maMonAn);
            pst.setString(3, gia);
            ResultSet rs = pst.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
            return check;
        }
    }

//    public int getKetQua() {
//        try {
//            PreparedStatement pst = con.prepareStatement("{call DT_UPDATE_GIA(?,?,?)}");
//            ResultSet rs = pst.executeQuery();
//            if (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
}
