package StoredProcedure;

import java.sql.*;

public class DatDonHangProcedure {
    private Connection con;
    public DatDonHangProcedure() {
        con = database.JDBCUtil.getConnection();
    }

    public int SP_LUDatDonHang(String tinhTrangDonHang, double phiDonHang, String hinhThucPayment, String DCGiaoHang,
                               float phiVanChuyen, Date ngayTaoDon, String maChiNhanh, String maDoiTac, int SLMonDat,
                               String tuyChon, String maMonAn) {
        int check = 0;
        try {
            PreparedStatement pst = con.prepareStatement("{call sp_DatDonHangMonAn(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            pst.setString(1, tinhTrangDonHang);
            pst.setDouble(2, phiDonHang);
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
}
