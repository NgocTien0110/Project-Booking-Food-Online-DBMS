package StoredProcedure;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * StoredProcedure
 * Create by Đặng Ngọc Tiến
 * Date 12/14/2022 - 11:06 PM
 * Description: ...
 */
public class XEM_MON_AN {
    private Connection con;

    public XEM_MON_AN() {
        con = database.JDBCUtil.getConnection();
    }

    public int KH_XEM_MON_AN(DefaultTableModel model, String maDoiTac, String maChiNhanh) {
        try {
            PreparedStatement pst = con.prepareStatement("{call KH_XEM_MON_AN(?,?)}");
            pst.setString(1, maDoiTac);
            pst.setString(2, maChiNhanh);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String MaMonAn = rs.getString("MaMonAn");
                String TenMonAn = rs.getString("TenMonAn");
                String TenChiNhanh = rs.getString("TenChiNhanh");
                String SLMonAn = rs.getString("SLMonAn");
                double Gia = rs.getDouble("Gia");
                String MoTa = rs.getString("MieuTa");
                model.addRow(new Object[]{MaMonAn, TenChiNhanh, TenMonAn, MoTa, SLMonAn, Gia});
                System.out.println(MaMonAn + " " + TenMonAn + " " + TenChiNhanh + " " + SLMonAn + " " + Gia + " " + MoTa);
            }
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
