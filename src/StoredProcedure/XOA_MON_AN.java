package StoredProcedure;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * StoredProcedure
 * Create by Đặng Ngọc Tiến
 * Date 12/15/2022 - 1:41 PM
 * Description: ...
 */
public class XOA_MON_AN {
    private Connection con;

    public XOA_MON_AN() {
        con = database.JDBCUtil.getConnection();
    }

    public int XOA_MON_AN(String maDoiTac, String maMonAn, String maChiNhanh) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call ESP_XoaMonAnThucDon(?,?,?)}");
            pst.setString(1, maDoiTac);
            pst.setString(2, maMonAn);
            pst.setString(3, maChiNhanh);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                check = rs.getInt(1);
            }
            return check;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
