package StoredProcedure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContractProcedure {
    private Connection con;
    public ContractProcedure() {
        con = database.JDBCUtil.getConnection();
    }

    public int SP_DLCapNhatThoiGianHLHopDong(String maHopDong, int thoiGianHL) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call sp_CapNhatThoiGianHLHopDongDL(?,?)}");
            pst.setString(1, maHopDong);
            pst.setInt(2, thoiGianHL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;

        } catch (SQLException e) {
            e.printStackTrace();
            return check;
        }
    }
    public int SP_LUCapNhatThoiGianHLHopDong(String maHopDong, int thoiGianHL) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call sp_CapNhatThoiGianHLHopDongLostUpdate(?,?)}");
            pst.setString(1, maHopDong);
            pst.setInt(2, thoiGianHL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;

        } catch (SQLException e) {
            e.printStackTrace();
            return check;
        }
    }
    public int SP_CapNhatThoiGianHLHopDongXuLyLu(String maHopDong, int thoiGianHL) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call sp_CapNhatThoiGianHLHopDongXuLyLu(?,?)}");
            pst.setString(1, maHopDong);
            pst.setInt(2, thoiGianHL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;

        } catch (SQLException e) {
            e.printStackTrace();
            return check;
        }
    }
    public int SP_CapNhatThoiGianHLHopDongXuLyDL(String maHopDong, int thoiGianHL) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call sp_CapNhatThoiGianHLHopDongXuLyDL(?,?)}");
            pst.setString(1, maHopDong);
            pst.setInt(2, thoiGianHL);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                check = rs.getInt(1);
            }
            return check;

        } catch (SQLException e) {
            e.printStackTrace();
            return check;
        }
    }
}
